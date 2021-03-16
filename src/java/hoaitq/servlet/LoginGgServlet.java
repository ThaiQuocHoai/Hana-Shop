/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hoaitq.servlet;

import hoaitq.tblUser.tblUserDAO;
import java.io.IOException;
import java.sql.SQLException;
import javax.naming.NamingException;
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
@WebServlet(name = "LoginGgServlet", urlPatterns = {"/LoginGgServlet"})
public class LoginGgServlet extends HttpServlet {

    private static final String ERROR = "error.jsp";
    private static final String SUCCESS = "SearchServlet";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        // Tao servlet login gg de check login cua nguoi dung
        HttpSession sessionScope = request.getSession();
        String url = ERROR;
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
        try {
            String email = request.getParameter("email");
            String fullName = request.getParameter("userName");
            tblUserDAO dao = new tblUserDAO();
            if (!dao.checkUserNameDuplicate(email)) {
                int rs = dao.insertUser(email, fullName);
                if (rs > 0) {
                    sessionScope.setAttribute("USERNAME", email);
                    sessionScope.setAttribute("FULLNAME", fullName);
                    url = "DispatchServlet?txtSearchValue=" + searchValue + "&btAction=Search&dropList=" + nameCate + "&txtMin=" + min + "&txtMax=" + max + "&index=" + index;
                }
            } else {
                sessionScope.setAttribute("USERNAME", email);
                sessionScope.setAttribute("FULLNAME", fullName);
                url = "DispatchServlet?txtSearchValue=" + searchValue + "&btAction=Search&dropList=" + nameCate + "&txtMin=" + min + "&txtMax=" + max + "&index=" + index;
            }
        } catch (SQLException ex) {
            log("LoginGgServlet_SQLException: " + ex.getMessage());
        } catch (NamingException ex) {
            log("LoginGgServlet_NamingException: " + ex.getMessage());
        } finally {
            response.sendRedirect(url);
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
