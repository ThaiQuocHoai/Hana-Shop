/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hoaitq.servlet;

import hoaitq.tblFood.tblFoodDAO;
import hoaitq.tblFood.tblFoodDTO;
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
@WebServlet(name = "UpdateServlet", urlPatterns = {"/UpdateServlet"})
public class UpdateServlet extends HttpServlet {

    private final String EDIT_PAGE = "edit.jsp";
    private final String ERROR_PAGE = "wrong.jsp";

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
        String url = EDIT_PAGE;
        HttpSession session = request.getSession();
        tblFoodDTO foodDTO = (tblFoodDTO) session.getAttribute("DTOMANAGER");
        if (foodDTO != null) {
            String id = request.getParameter("txtFoodID");
            String name = request.getParameter("txtNameUpdate");
            String image = request.getParameter("txtImageLinkUpdate");
            String description = request.getParameter("txtDescriptionUpdate");
            float price = Float.parseFloat(request.getParameter("txtPriceUpdate"));
            int quantity = Integer.parseInt(request.getParameter("txtQuantityUpdate"));
            String cate = request.getParameter("dropCateUpdate");
            String createDate = request.getParameter("txtCreateDateUpdate");
            String invalidate = request.getParameter("txtInvaliDateUpdate");
            String status = request.getParameter("dropStatusUpdate");
            int categoryID = 0;
            int isDelete = 0;
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String now = dateFormat.format(new Date());
            try {
                boolean flag = false;
                tblFoodError error = new tblFoodError();
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
                session.setAttribute("ERRORUPDATE", error);
                tblFoodDAO dao = new tblFoodDAO();
                if (status.equals("Active")) {
                    isDelete = 0;
                } else {
                    isDelete = 1;
                }

                if (cate.equals("Food")) {
                    categoryID = 1;
                } else {
                    categoryID = 2;
                }

                if (flag == false) {
                    tblFoodDTO food = (tblFoodDTO) session.getAttribute("DTOMANAGER");
                    if (name.equals(food.getNameFood()) && image.equals(food.getImage()) && description.equals(food.getDescription()) && price == food.getPrice() && quantity == food.getQuantity() && categoryID == food.getCategoryID() && invalidate.equals(food.getInvalidDate()) && isDelete == food.getIsDelete()) {
                        request.setAttribute("CHANGE", "You not change anything!!!");
                    } else {

                        int foodID = Integer.parseInt(id);
                        int rs = dao.updateFood(foodID, name, image, description, price, quantity, categoryID, createDate, invalidate, isDelete);
                        if (rs > 0) {
                            String userID = (String) session.getAttribute("USERNAME");
                            dao.insertManager(userID, foodID, 2);
                            tblFoodDTO dto = dao.getFood(id);
                            session.setAttribute("DTOMANAGER", dto);
                            request.setAttribute("SUCCESS", "Updated");
                        }
                    }
                }

            } catch (SQLException ex) {
                log("UpdateServlet_SQLException: " + ex.getMessage());
            } catch (NamingException ex) {
                log("UpdateServlet_NamingException: " + ex.getMessage());
            } finally {
                RequestDispatcher rd = request.getRequestDispatcher(url);
                rd.forward(request, response);
            }
        } else {
            url = ERROR_PAGE;
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
