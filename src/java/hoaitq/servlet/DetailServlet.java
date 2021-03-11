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
@WebServlet(name = "DetailServlet", urlPatterns = {"/DetailServlet"})
public class DetailServlet extends HttpServlet {

    public final String DETAIL_PAGE = "detail.jsp";

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

        String quantity = request.getParameter("txtQuantity");
        String id = request.getParameter("txtID");
        HttpSession sessionScope = request.getSession();
        String searchValue = (String) sessionScope.getAttribute("SEARCHVALUE");
        String nameCate = (String) sessionScope.getAttribute("CATE");
        String min = (String) sessionScope.getAttribute("MIN");
        String max = (String) sessionScope.getAttribute("MAX");
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
        if (sessionScope.getAttribute("INDEX") == null) {
            index = "1";
        } else {
            index = (String) sessionScope.getAttribute("INDEX");
        }
        if(quantity == null){
            quantity="1";
        }
        String url = DETAIL_PAGE;
        try {

            tblFoodDAO dao = new tblFoodDAO();
            tblFoodDTO dto = dao.getFood(id);
            if (dto != null) {
                sessionScope.setAttribute("DTO", dto);
                sessionScope.setAttribute("QUANTITY", quantity);
            }
            sessionScope.setAttribute("INDEX", index);
            sessionScope.setAttribute("CATE", nameCate);
            sessionScope.setAttribute("SEARCHVALUE", searchValue);
            sessionScope.setAttribute("MIN", min);
            sessionScope.setAttribute("MAX", max);
        } catch (SQLException ex) {
            log("DetailServlet_SQLException: " + ex.getMessage());
        } catch (NamingException ex) {
            log("DetailServlet_SQLException: " + ex.getMessage());
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
