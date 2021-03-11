/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hoaitq.servlet;

import hoaitq.tblUser.tblUserDAO;
import hoaitq.tblUser.tblUserDTO;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "LoginServlet", urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {

//    private final String HOME_PAGE= "index.jsp";
    private final String LOGIN_PAGE = "login.jsp";
    private final String SHOPPING_PAGE = "SearchServlet";
    private final String MANAGER_PAGE = "ManagerServlet";

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
        String username = request.getParameter("txtUsername");
        String password = request.getParameter("txtPassword");
        String fullname = "";
        String url = LOGIN_PAGE;
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

        try {
            if (sessionScope.getAttribute("INDEX") == null) {
                index = "1";
            } else {
                index = (String) sessionScope.getAttribute("INDEX");
            }
            tblUserDAO dao = new tblUserDAO();
            fullname = dao.checkLogin(username, password);
            if (!fullname.isEmpty()) {
                tblUserDTO dto = dao.infoUser(username);
                sessionScope.setAttribute("USERNAME", username);
                sessionScope.setAttribute("FULLNAME", fullname);
                url = "DispatchServlet?txtSearchValue=" + searchValue + "&btAction=Search&dropList=" + nameCate + "&txtMin=" + min + "&txtMax=" + max + "&index=" + index;
                int isAdmin = dao.checkAdmin(username, password);
                if (isAdmin > 0) {
                    sessionScope.setAttribute("ADMIN", "admin");
                    url =MANAGER_PAGE;
                } 
                sessionScope.setAttribute("ADDRESS", dto.getAddress());
                sessionScope.setAttribute(("PHONENUM"), dto.getPhoneNum());
            } else {
                sessionScope.setAttribute("INVALID", "Invalid user or password");
            }

        } catch (SQLException se) {
            log("LoginServlet_SQLException: " + se.getMessage());
        } catch (NamingException ne) {
            log("LoginServlet_NamingException: " + ne.getMessage());
        } catch (NullPointerException ex) {
            log("LoginServlet_NullPointerException: " + ex.getMessage());
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
