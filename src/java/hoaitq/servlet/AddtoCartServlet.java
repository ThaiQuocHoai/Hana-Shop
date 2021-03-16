/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hoaitq.servlet;

import hoaitq.cart.CartDTO;
import hoaitq.cart.CartObject;
import hoaitq.tblFood.tblFoodDAO;
import hoaitq.tblFood.tblFoodDTO;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;
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
@WebServlet(name = "AddtoCartServlet", urlPatterns = {"/AddtoCartServlet"})
public class AddtoCartServlet extends HttpServlet {

    private final String DETAIL_PAGE = "detail.jsp";

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
        String foodID = request.getParameter("txtFoodID");

        int quantity = 1;

        String url = DETAIL_PAGE;
        if (request.getParameter("txtQuantity") == null) {
            quantity = 1;
        } else {
            quantity = Integer.parseInt(request.getParameter("txtQuantity"));
        }

        try {
            tblFoodDAO dao = new tblFoodDAO();
            CartObject cart = (CartObject) session.getAttribute("CART");
            if (cart == null) {
                cart = new CartObject();
            }

            tblFoodDTO dto = dao.getFood(foodID);
            String name = dto.getNameFood();
            float price = dto.getPrice();
            String image = dto.getImage();
            cart.addItem(foodID, quantity, name, price, image);
            session.setAttribute("CART", cart);
            Map<String, CartDTO> map = cart.getCart();
            if (map == null) {
                session.setAttribute("COUNTCART", 0);
            } else {
                session.setAttribute("COUNTCART", map.size());
            }
            session.setAttribute("MAP", map);
        } catch (SQLException ex) {
            log("AddtoCartServlet_SQLException: " + ex.getMessage());
        } catch (NamingException ex) {
            log("AddtoCartServlet_NamingException: " + ex.getMessage());
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
