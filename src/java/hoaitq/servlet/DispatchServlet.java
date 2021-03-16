/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hoaitq.servlet;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author QH
 */
public class DispatchServlet extends HttpServlet {

    private final String LOGIN_PAGE = "login.jsp";
    private final String LOGIN_CONTROLLER = "LoginServlet";
    private final String INDEX_PAGE = "index.jsp";
    private final String LOGOUT_CONTROLLER = "LogoutServlet";
    private final String SHOPPING_PAGE = "shop.jsp";
    private final String MANAGER_CONTROLLER = "ManagerServlet";
    private final String SEARCH_CONTROLLER = "SearchServlet";
    private final String DETAIL_PAGE = "DetailServlet";
    private final String ADD_TO_CART_PAGE = "AddtoCartServlet";
    private final String VIEW_CART_PAGE = "ViewCartServlet";
    private final String SAVE_ITEM_IN_CART = "SaveCartServlet";
    private final String DELETE_ITEM_IN_CART = "DeleteCartServlet";
    private final String VIEW_HISTORY_CART = "ViewHistoryServlet";
    private final String CHECK_OUT = "CheckoutServlet";
    private final String UPDATE_CONTROLLER = "UpdateServlet";
    private final String EDIT_PAGE = "EditServlet";
    private final String ADD_PAGE = "AddServlet";
    private final String ADD_CONTROLLER = "AddNewServlet";
    private final String DELETE_ITEM_CONTROLLER = "DeleteItemServlet";
    // them duong dan den loginGgServlet
    private final String LOGIN_GOOGLE_CONTROLLER = "LoginGgServlet";

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
        String button = request.getParameter("btAction");
        String url = INDEX_PAGE;
        try {
            if (button == null) {

            } else if (button.equals("Login")) {
                url = LOGIN_CONTROLLER;
            } else if (button.equals("Logout")) {
                url = LOGOUT_CONTROLLER;
            } else if (button.equals("Home")) {
                url = INDEX_PAGE;
            } else if (button.equals("login")) {
                url = LOGIN_PAGE;
            } else if (button.equals("manager")) {
                url = MANAGER_CONTROLLER;
            } else if (button.equals("Search")) {
                url = SEARCH_CONTROLLER;
            } else if (button.equals("View detail")) {
                url = DETAIL_PAGE;
            } else if (button.equals("Add to cart")) {
                url = ADD_TO_CART_PAGE;
            } else if (button.equals("View cart")) {
                url = VIEW_CART_PAGE;
            } else if (button.equals("Save")) {
                url = SAVE_ITEM_IN_CART;
            } else if (button.equals("Delete")) {
                url = DELETE_ITEM_IN_CART;
            } else if (button.equals("View history")) {
                url = VIEW_HISTORY_CART;
            } else if (button.equals("Check out")) {
                url = CHECK_OUT;
            } else if (button.equals("Search product")) {
                url = MANAGER_CONTROLLER;
            } else if (button.equals("Update")) {
                url = UPDATE_CONTROLLER;
            } else if (button.equals("Edit")) {
                url = EDIT_PAGE;
            } else if (button.equals("Add")) {
                url = ADD_PAGE;
            } else if (button.equals("Add new")) {
                url = ADD_CONTROLLER;
            } else if (button.equals("Delete items")) {
                url = DELETE_ITEM_CONTROLLER;
            } else if (button.equals("Login Google")) {
                url = LOGIN_GOOGLE_CONTROLLER;
            }

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
