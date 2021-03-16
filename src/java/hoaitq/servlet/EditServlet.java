/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hoaitq.servlet;

import hoaitq.tblFood.tblFoodDAO;
import hoaitq.tblFood.tblFoodDTO;
import java.io.IOException;
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
@WebServlet(name = "EditServlet", urlPatterns = {"/EditServlet"})
    public class EditServlet extends HttpServlet {

    private final String EDIT_PAGE = "edit.jsp";

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
        String id = request.getParameter("txtID");
        HttpSession sessionScope = request.getSession();
        String searchValue = (String) sessionScope.getAttribute("SEARCHVALUEMANAGER");
        String nameCate = (String) sessionScope.getAttribute("CATEMANAGER");
        String min = (String) sessionScope.getAttribute("MINMANAGER");
        String max = (String) sessionScope.getAttribute("MAXMANAGER");
        String index = "";
        if (searchValue == null) {
            searchValue = "";
        }
        if (nameCate == null) {
            nameCate = "All";
        }
        if (min == null) {
            min = "0";
        }
        if (max == null) {
            max = "1000000";
        }
        if (sessionScope.getAttribute("INDEXMANAGER") == null) {
            index = "1";
        } else {
            index = (String) sessionScope.getAttribute("INDEXMANAGER");
        }
        try {

            tblFoodDAO dao = new tblFoodDAO();
            tblFoodDTO dto = dao.getFood(id);
            if (dto != null) {
                sessionScope.setAttribute("DTOMANAGER", dto);
            }
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String now  = dateFormat.format(new Date());
            sessionScope.setAttribute("NOW", now);
            sessionScope.setAttribute("INDEXMANAGER", index);
            sessionScope.setAttribute("CATEMANAGER", nameCate);
            sessionScope.setAttribute("SEARCHVALUEMANAGER", searchValue);
            sessionScope.setAttribute("MINMANAGER", min);
            sessionScope.setAttribute("MAXMANAGER", max);
        } catch (SQLException ex) {
            log("EditServlet_SQLException: " + ex.getMessage());
        } catch (NamingException ex) {
            log("EditServlet_NamingException: " + ex.getMessage());
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
