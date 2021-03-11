/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hoaitq.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
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
@WebServlet(name = "AddServlet", urlPatterns = {"/AddServlet"})
public class AddServlet extends HttpServlet {

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
        String url = ADD_PAGE;

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
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String now = dateFormat.format(new Date());
            sessionScope.setAttribute("NOW", now);
            sessionScope.setAttribute("INDEXMANAGER", index);
            sessionScope.setAttribute("CATEMANAGER", nameCate);
            sessionScope.setAttribute("SEARCHVALUEMANAGER", searchValue);
            sessionScope.setAttribute("MINMANAGER", min);
            sessionScope.setAttribute("MAXMANAGER", max);
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
