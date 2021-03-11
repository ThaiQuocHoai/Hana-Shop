/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hoaitq.servlet;

import hoaitq.tblFood.tblFoodDAO;
import hoaitq.tblFood.tblFoodError;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author QH
 */
@WebServlet(name = "AddNewServlet", urlPatterns = {"/AddNewServlet"})
public class AddNewServlet extends HttpServlet {

    private final String MANAGER_PAGE = "ManagerServlet";
    private final String ADD_PAGE = "add.jsp";

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        String name = request.getParameter("txtNameAdd");
        String image = request.getParameter("txtImageAdd");
        String description = request.getParameter("txtDescriptionAdd");
        float price = 1;
        int quantity = 0;
        String url = ADD_PAGE;
        String cate = request.getParameter("dropCateAdd");
        String createDate = request.getParameter("txtCreateDateAdd");
        String invalidate = request.getParameter("txtInvaliDateAdd");
        int categoryID = 0;
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String now = dateFormat.format(new Date());
        try {
            boolean flag = false;
            tblFoodError error = new tblFoodError();
            if (request.getParameter("txtPriceAdd").isEmpty()) {
                error.setPriceError("Price is not null");
                flag = true;
            } else {
                price = Float.parseFloat(request.getParameter("txtPriceAdd"));
            }
            if (request.getParameter("txtQuantityAdd").isEmpty()) {
                error.setQuantityError("Quantity is not null");
                flag = true;
            } else {
                quantity = Integer.parseInt(request.getParameter("txtQuantityAdd"));
            }
            if (name.isEmpty()) {
                error.setNameFoodError("Name cannot be empty");
                flag = true;
            }
            if (image.isEmpty()) {
                error.setImageError("Image link cannot be empty");
                flag = true;
            }
            if (description.isEmpty()) {
                error.setDescriptionError("Description cannot be empty");
                flag = true;
            }
            if (invalidate.compareTo(now) < 0) {
                error.setInvalidDateError("Invalidate must be greater than today");
                flag = true;
            }
            if (cate.equals("Food")) {
                categoryID = 1;
            } else {
                categoryID = 2;
            }
            session.setAttribute("ERRORADD", error);
            tblFoodDAO dao = new tblFoodDAO();
            if (flag == false) {
                dao.insertFood(name, image, description, price, quantity, categoryID, now, invalidate, 0);
                url = MANAGER_PAGE;
            }
        } catch (SQLException ex) {
            log("AddNewServlet_SQLException: " + ex.getMessage());
        } catch (NamingException ex) {
            log("AddNewServlet_NamingException: " + ex.getMessage());
        } finally {
            RequestDispatcher rd = request.getRequestDispatcher(url);
            rd.forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
