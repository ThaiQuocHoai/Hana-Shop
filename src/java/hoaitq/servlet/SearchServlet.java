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
import java.util.ArrayList;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Date;

/**
 *
 * @author QH
 */
@WebServlet(name = "SearchServlet", urlPatterns = {"/SearchServlet"})
public class SearchServlet extends HttpServlet {

    private final String SHOPPING_PAGE = "shop.jsp";

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
        String url = SHOPPING_PAGE;

        tblFoodDAO dao = new tblFoodDAO();
        HttpSession session = request.getSession();
        String min = "0";
        String max = "1000000";
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        String now = dateFormat.format(new Date());
        String searchValue = request.getParameter("txtSearchValue");
        String cate = "All";
        String query = "";
        String queryCount = "";
        int indexS = 0;
        int count = 0;
        int index = 1;

        try {
            if(request.getParameter("txtMin") != null){
                min = request.getParameter("txtMin");
            }
            if (request.getParameter("txtMax") != null) {
                max = request.getParameter("txtMax");
            }

            if (request.getParameter("dropList") != null) {
                cate = request.getParameter("dropList");
            }

            if (request.getParameter("index") == null || request.getParameter("index").isEmpty()) {
                index = 1;
            } else {
                index = Integer.parseInt(request.getParameter("index"));
            }
            indexS = index - 1;
            String index1 = String.valueOf(indexS + 1);
            ArrayList<String> listCate = dao.loadCate();
            session.setAttribute("LISTCATE", listCate);
            if (cate.equals("All")) {
                query = "select foodID, foodName, image,decription, price, quantity, f.categoryID, createdate, invalidate, isDelete, c.CategoryName "
                        + "from tblFood f join tblCategory c on f.categoryID = c.CategoryID "
                        + "where foodName like '%" + searchValue + "%' and quantity>0 and isDelete = 0 and price >= " + min + " and price <= " + max + " and invalidate >= '" + now + "'"
                        + " order by createdate desc "
                        + " offset " + indexS * 20 + " rows "
                        + " fetch next 20 rows only; ";
                queryCount = "select count(foodID) "
                        + "from tblFood f join tblCategory c on f.categoryID = c.CategoryID "
                        + "where foodName like '%" + searchValue + "%' and quantity>0 and isDelete = 0 and price >= " + min + " and price <= " + max + " and invalidate >= '" + now + "'";
            } else {
                query = "select foodID, foodName, image,decription, price, quantity, f.categoryID, createdate, invalidate, isDelete, c.CategoryName "
                        + "from tblFood f join tblCategory c on f.categoryID = c.CategoryID "
                        + "where foodName like '%" + searchValue + "%' and quantity>0 and categoryName like '%" + cate + "%' and isDelete = 0 and price >= " + min + " and price <= " + max + " and invalidate >= '" + now + "'"
                        + " order by createdate desc "
                        + " offset " + indexS * 20 + " rows "
                        + " fetch next 20 rows only; ";
                queryCount = "select count(foodID) "
                        + "from tblFood f join tblCategory c on f.categoryID = c.CategoryID "
                        + "where foodName like '%" + searchValue + "%' and quantity>0 and categoryName like '%" + cate + "%' and isDelete = 0 and price >= " + min + " and price <= " + max + " and invalidate >= '" + now + "'";

            }
            ArrayList<tblFoodDTO> listSearch = dao.searchDTO(query);
            count = dao.count(queryCount);
            int endPage = count / 20;
            if (count % 20 != 0) {
                endPage++;
            }
            session.setAttribute("END", endPage);
            session.setAttribute("LISTSEARCH", listSearch);
            session.setAttribute("CATE", cate);
            session.setAttribute("SEARCHVALUE", searchValue);
            session.setAttribute("MIN", min);
            session.setAttribute("MAX", max);
            session.setAttribute("INDEX", index1);
        } catch (SQLException ex) {
            log("SearchServlet_SQLException: " + ex.getMessage());
        } catch (NamingException ex) {
            log("SearchServlet_NamingException: " + ex.getMessage());
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
