/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hoaitq.servlet;

import hoaitq.tblFood.tblFoodDAO;
import hoaitq.tblFood.tblFoodDTO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
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
@WebServlet(name = "ManagerServlet", urlPatterns = {"/ManagerServlet"})
public class ManagerServlet extends HttpServlet {

    private final String MANAGER_PAGE = "manager.jsp";

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
        String searchValue = request.getParameter("txtSearchManager");
        String min = request.getParameter("txtMinManager");
        String max = request.getParameter("txtMaxManager");
        String cate = request.getParameter("dropListManager");
        if (min == null) {
            min = "0";
        }
        if (max == null) {
            max = "1000000";
        }
        if (cate == null) {
            cate = "All";
        }
        if (searchValue == null) {
            searchValue = "";
        }

        int index = 1;
        int indexS = 0;
        int count = 0;
        String query = "";
        String querycount = "";
        String url = MANAGER_PAGE;

        try {
            if (request.getParameter("indexManager") == null) {
                index = 1;
            } else {
                index = Integer.parseInt(request.getParameter("indexManager"));
            }
            indexS = index - 1;
            String index1 = String.valueOf(index);

            if (cate.equals("All")) {
                query = "select f.foodID, f.foodName, f.image, f.decription, f.price, f.quantity, f.categoryID, f.createdate, f.invalidate, f.isDelete "
                        + "from tblFood f join tblCategory c on f.categoryID = c.CategoryID "
                        + "where foodName like '%" + searchValue + "%' and f.price >= " + min + " and f.price <= " + max
                        + "order by createdate desc "
                        + "offset " + indexS * 20 + " rows "
                        + "fetch next 20 rows only; ";
                querycount = "select count(foodID) "
                        + "from tblFood f join tblCategory c on f.categoryID = c.CategoryID "
                        + "where foodName like '%" + searchValue + "%' and f.price >= " + min + " and f.price <= " + max;
            } else {
                query = "select f.foodID, f.foodName, f.image, f.decription, f.price, f.quantity, f.categoryID, f.createdate, f.invalidate, f.isDelete "
                        + "from tblFood f join tblCategory c on f.categoryID = c.CategoryID "
                        + "where foodName like '%" + searchValue + "%' and c.CategoryName like '%"+cate+"%' and f.price >= " + min + " and f.price <= " + max
                        + "order by createdate desc "
                        + "offset " + indexS * 20 + " rows "
                        + "fetch next 20 rows only; ";
                querycount = "select count(foodID) "
                        + "from tblFood f join tblCategory c on f.categoryID = c.CategoryID "
                        + "where foodName like '%" + searchValue + "%' and c.CategoryName like '%"+cate+"%' and f.price >= " + min + " and f.price <= " + max;
            }

            tblFoodDAO dao = new tblFoodDAO();
            ArrayList<String> listCate = dao.loadCate();
            ArrayList<tblFoodDTO> listDTO = dao.searchDTO(query);
            count = dao.count(querycount);
            int endPage = count / 20;
            if (count % 20 != 0) {
                endPage++;
            }
            session.setAttribute("ENDMANAGER", endPage);
            session.setAttribute("LISTMANAGER", listDTO);
            session.setAttribute("LISTCATEMANAGER", listCate);
            session.setAttribute("CATEMANAGER", cate);
            session.setAttribute("MINMANAGER", min);
            session.setAttribute("MAXMANAGER", max);
            session.setAttribute("SEARCHVALUEMANAGER", searchValue);
            session.setAttribute("INDEXMANAGER", index1);
        } catch (SQLException ex) {
            log("ManagerServlet_SQLException: " + ex.getMessage());
        } catch (NamingException ex) {
            log("ManagerServlet_NamingException: " + ex.getMessage());
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
