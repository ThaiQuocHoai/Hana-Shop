/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hoaitq.tblFood;

import hoaitq.untilities.DBHelpers;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.naming.NamingException;

/**
 *
 * @author QH
 */
public class tblFoodDAO implements Serializable {

    private ArrayList<tblFoodDTO> listDTO;

    public ArrayList<tblFoodDTO> getListDTO() {
        return listDTO;
    }

    public void loadFood() throws NamingException, SQLException {
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            con = DBHelpers.getConnection();
            if (con != null) {
                String sql = "select foodID, foodName, image, decription, price, quantity, categoryID, createdate,invalidate ,isDelete "
                        + "from tblFood "
                        + "order by createdate desc ";
                pst = con.prepareStatement(sql);
                rs = pst.executeQuery();
                while (rs.next()) {
                    int foodID = rs.getInt("foodID");
                    String foodName = rs.getString("foodName");
                    String image = rs.getString("image");
                    String decription = rs.getString("decription");
                    float price = rs.getFloat("price");
                    int quantity = rs.getInt("quantity");
                    int categoryID = rs.getInt("categoryID");
                    int isDelete = rs.getInt("isDelete");
                    String createdate = rs.getString("createdate");
                    String invalidate = rs.getString("invalidate");

                    if (listDTO == null) {
                        listDTO = new ArrayList<>();
                    }
                    tblFoodDTO dto = new tblFoodDTO(foodID, foodName, image, decription, price, quantity, categoryID, createdate, invalidate, isDelete);
                    listDTO.add(dto);
                }
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (pst != null) {
                pst.close();
            }
            if (con != null) {
                con.close();
            }
        }
    }

    public ArrayList<String> loadCate() throws NamingException, SQLException {
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        ArrayList<String> listCate = null;
        try {
            con = DBHelpers.getConnection();
            if (con != null) {
                String sql = "select CategoryName "
                        + "from tblCategory ";
                pst = con.prepareStatement(sql);;
                rs = pst.executeQuery();
                while (rs.next()) {
                    String nameCate = rs.getString(1);
                    if (listCate == null) {
                        listCate = new ArrayList<>();
                    }
                    listCate.add(nameCate);
                }
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (pst != null) {
                pst.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return listCate;
    }

    public ArrayList<tblFoodDTO> searchDTO(String query) throws NamingException, SQLException {
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        ArrayList<tblFoodDTO> listSearch = null;
        try {
            con = DBHelpers.getConnection();
            if (con != null) {
                String sql = query;
                pst = con.prepareStatement(sql);
                rs = pst.executeQuery();
                while (rs.next()) {
                    int foodID = rs.getInt("foodID");
                    String foodName = rs.getString("foodName");
                    String image = rs.getString("image");
                    String decription = rs.getString("decription");
                    float price = rs.getFloat("price");
                    int quantity = rs.getInt("quantity");
                    int categoryID = rs.getInt("categoryID");
                    int isDelete = rs.getInt("isDelete");
                    String createdate = rs.getString("createdate");
                    String invalidate = rs.getString("invalidate");
                    if (listSearch == null) {
                        listSearch = new ArrayList<>();
                    }
                    tblFoodDTO dto = new tblFoodDTO(foodID, foodName, image, decription, price, quantity, categoryID, createdate, invalidate, isDelete);
                    listSearch.add(dto);
                }
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (pst != null) {
                pst.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return listSearch;
    }

    public int count(String query) throws NamingException, SQLException {
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        ArrayList<tblFoodDTO> listSearch = null;
        int count = 0;
        try {
            con = DBHelpers.getConnection();
            if (con != null) {
                String sql = query;
                pst = con.prepareStatement(sql);
                rs = pst.executeQuery();
                if (rs.next()) {
                    return count = rs.getInt(1);
                }
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (pst != null) {
                pst.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return count;
    }

    public tblFoodDTO getFood(String id) throws NamingException, SQLException {
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        int count = 0;
        try {
            con = DBHelpers.getConnection();
            if (con != null) {
                String sql = "select foodID, foodName, image, decription, price, quantity, categoryID, createdate, invalidate, isDelete "
                        + "from tblFood "
                        + "where foodID = ? ";
                pst = con.prepareStatement(sql);
                pst.setString(1, id);
                rs = pst.executeQuery();
                if (rs.next()) {
                    int foodID = rs.getInt("foodID");
                    String foodName = rs.getString("foodName");
                    String image = rs.getString("image");
                    String decription = rs.getString("decription");
                    float price = rs.getFloat("price");
                    int quantity = rs.getInt("quantity");
                    int categoryID = rs.getInt("categoryID");
                    int isDelete = rs.getInt("isDelete");
                    String invalidate = rs.getString("invalidate");
                    String createdate = rs.getString("createdate");
                    tblFoodDTO dto = new tblFoodDTO(foodID, foodName, image, decription, price, quantity, categoryID, createdate, invalidate, isDelete);
                    return dto;
                }
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (pst != null) {
                pst.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return null;
    }

    public void updateQuantity(int idFood, int quantity) throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement pst = null;
        int rs = 0;
        try {
            con = DBHelpers.getConnection();
            if (con != null) {
                String sql = "update tblFood set quantity=? "
                        + "where foodID = ? ";
                pst = con.prepareStatement(sql);
                pst.setInt(1, quantity);
                pst.setInt(2, idFood);
                rs = pst.executeUpdate();
            }
        } finally {
            if (pst != null) {
                pst.close();
            }
            if (con != null) {
                con.close();
            }
        }
    }

    public int updateFood(int idFood, String foodName, String image, String decription, float price, int quantity, int categoryID, String createDate, String invalidate, int isDelete) throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement pst = null;
        int rs = 0;
        try {
            con = DBHelpers.getConnection();
            if (con != null) {
                String sql = "update tblFood  "
                        + "set foodName = ? , image = ?, decription = ?, price = ?, quantity = ?, categoryID = ?, createdate = ?, invalidate = ? , isDelete = ? "
                        + "where foodID = ? ";
                pst = con.prepareStatement(sql);
                pst.setString(1, foodName);
                pst.setString(2, image);
                pst.setString(3, decription);
                pst.setFloat(4, price);
                pst.setInt(5, quantity);
                pst.setInt(6, categoryID);
                pst.setString(7, createDate);
                pst.setString(8, invalidate);
                pst.setInt(9, isDelete);
                pst.setInt(10, idFood);
                rs = pst.executeUpdate();
            }
        } finally {
            if (pst != null) {
                pst.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return rs;
    }

    public void insertManager(String userID, int foodID, int actionID) throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement pst = null;
        int rs = 0;
        try {
            con = DBHelpers.getConnection();
            if (con != null) {
                String sql = "insert into tblManager(userID, foodID, date, actionID)  "
                        + "values(?,?,GETDATE(),?) ";
                pst = con.prepareStatement(sql);
                pst.setString(1, userID);
                pst.setInt(2, foodID);
                pst.setInt(3, actionID);
                rs = pst.executeUpdate();
            }
        } finally {
            if (pst != null) {
                pst.close();
            }
            if (con != null) {
                con.close();
            }
        }
    }

    public int insertFood(String foodName, String image, String decription, float price, int quantity, int categoryID, String createDate, String invalidate, int isDelete) throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement pst = null;
        int rs = 0;
        try {
            con = DBHelpers.getConnection();
            if (con != null) {
                String sql = "insert into tblFood  "
                        + "values(?,?,?,?,?,?,?,?,?) ";
                pst = con.prepareStatement(sql);
                pst.setString(1, foodName);
                pst.setString(2, image);
                pst.setString(3, decription);
                pst.setFloat(4, price);
                pst.setInt(5, quantity);
                pst.setInt(6, categoryID);
                pst.setString(7, createDate);
                pst.setString(8, invalidate);
                pst.setInt(9, isDelete);
                rs = pst.executeUpdate();
            }
        } finally {
            if (pst != null) {
                pst.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return rs;
    }

    public int deleteFood(int foodID) throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement pst = null;
        int rs = 0;
        try {
            con = DBHelpers.getConnection();
            if (con != null) {
                String sql = "update tblFood  "
                        + "set isDelete = 1 "
                        + "where foodID = ? ";
                pst = con.prepareStatement(sql);
                pst.setInt(1, foodID);
                rs = pst.executeUpdate();
            }
        } finally {
            if (pst != null) {
                pst.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return rs;
    }

}
