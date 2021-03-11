package hoaitq.order;


import hoaitq.untilities.DBHelpers;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.naming.NamingException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author QH
 */
public class tblOrderDAO implements Serializable {

    public int insertOrder(String name, int phone, String address, String date, float price) throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement pst = null;
        int rs = 0;

        try {
            con = DBHelpers.getConnection();
            if (con != null) {
                String sql = "insert into tblOrder(nameCus, phoneNum, address, total, date) "
                        + "values(?,?,?,?,?) ";
                pst = con.prepareStatement(sql);
                pst.setString(1, name);
                pst.setInt(2, phone);
                pst.setString(3, address);
                pst.setFloat(4, price);
                pst.setString(5, date);
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

    public int insertOrderDetai(int idOrder, int idFood, String foodName, int quantity) throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement pst = null;
        int rs = 0;

        try {
            con = DBHelpers.getConnection();
            if (con != null) {
                String sql = "insert into tblOrder_detail(orderID, foodID, foodName, quantity) "
                        + "values(?,?,?,?) ";
                pst = con.prepareStatement(sql);
                pst.setInt(1, idOrder);
                pst.setInt(2, idFood);
                pst.setString(3, foodName);
                pst.setInt(4, quantity);
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

    public int getIDOrder() throws NamingException, SQLException {
        int id = 0;
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            con = DBHelpers.getConnection();
            if (con != null) {
                String sql = "select orderID "
                        + "from tblOrder "
                        + "Where orderID >= All(select orderID from tblOrder) ";
                pst = con.prepareStatement(sql);
                rs = pst.executeQuery();
                if (rs.next()) {
                    id = rs.getInt("orderID");
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
        return id;
    }

}
