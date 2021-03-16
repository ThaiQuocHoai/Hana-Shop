/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hoaitq.servlet;

import hoaitq.cart.CartDTO;
import hoaitq.cart.CartObject;
import hoaitq.order.tblOrderDAO;
import hoaitq.tblFood.tblFoodDAO;
import hoaitq.tblFood.tblFoodDTO;
import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
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
@WebServlet(name = "CheckoutServlet", urlPatterns = {"/CheckoutServlet"})
public class CheckoutServlet extends HttpServlet {

    private final String CHECK_OUT = "shop.jsp";
    private final String VIEW_CART = "viewCart.jsp";

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
        String error = null;
        List<String> listError = null;
        String url = VIEW_CART;
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        String now = dateFormat.format(new Date());

        try {
            tblFoodDAO dao = new tblFoodDAO();
            CartObject cart = (CartObject) session.getAttribute("CART");
            if (cart != null) {
                Map<String, CartDTO> map = cart.getCart();
                if (map != null) {
                    for (String key : map.keySet()) {
                        tblFoodDTO dto = new tblFoodDTO();
                        dto = dao.getFood(key);
                        int quantity = dto.getQuantity();
                        if (map.get(key).getQuantity() > quantity) {
                            if (listError == null) {
                                listError = new ArrayList<>();
                            }
                            error = "We only have " + quantity + " of " + dto.getNameFood();
                            listError.add(error);
                        }
                    }

                    if (listError == null) {
                        tblOrderDAO order = new tblOrderDAO();
                        String nameCus = request.getParameter("txtFullname");
                        int phone = 0;
                        if (request.getParameter("txtPhone") != null && !request.getParameter("txtPhone").isEmpty()) {
                            phone = Integer.parseInt(request.getParameter("txtPhone"));
                        }
                        float total = Float.parseFloat(request.getParameter("txtTotal"));
                        String address = request.getParameter("txtAddress");
                        if (address.isEmpty()) {
                            request.setAttribute("ERRORADDRESS", "Address cannot be empty");
                        } else {
                            session.setAttribute("FULLNAME", nameCus);
                            session.setAttribute("PHONENUM", phone);
                            session.setAttribute("ADDRESS", address);

                            int rs = order.insertOrder(nameCus, phone, address, now, total);
                            if (rs > 0) {
                                int idOrder = order.getIDOrder();
                                for (String key : map.keySet()) {
                                    tblFoodDTO dto = new tblFoodDTO();
                                    dto = dao.getFood(key);
                                    int quantity = dto.getQuantity();
                                    String nameFood = map.get(key).getName();
                                    int quantityBuy = map.get(key).getQuantity();
                                    int result = order.insertOrderDetai(idOrder, Integer.parseInt(key), nameFood, quantityBuy);
                                    if (result > 0) {
                                        dao.updateQuantity(Integer.parseInt(key), quantity - quantityBuy);
                                    }
                                }
                                cart = null;
                                map = null;
                                int count = 0;
                                request.setAttribute("SUC", "Buy successfully");
                                session.setAttribute("MAP", map);
                                session.setAttribute("CART", cart);
                                session.setAttribute("COUNTCART", count);
                                url = "DispatchServlet?txtSearchValue=&btAction=Search&dropList=All&txtMin=0&txtMax=1000000&index=1";
                            }
                        }
                    } else {
                        request.setAttribute("ERROR", listError);
                    }
                }
            }

        } catch (SQLException ex) {
            log("CheckoutServlet_SQLException: " + ex.getMessage());
        } catch (NamingException ex) {
            log("CheckoutServlet_NamingException: " + ex.getMessage());
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
