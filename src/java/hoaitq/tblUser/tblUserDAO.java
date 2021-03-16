/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hoaitq.tblUser;

import hoaitq.untilities.DBHelpers;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.naming.NamingException;

/**
 *
 * @author QH
 */
public class tblUserDAO implements Serializable {

    public String checkLogin(String username, String password)
            throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        String fullname = "";
        try {
            con = DBHelpers.getConnection();
            if (con != null) {
                String sql = "select fullname "
                        + "from tblUser "
                        + "where userID = ? and password = ? ";
                pst = con.prepareStatement(sql);
                pst.setString(1, username);
                pst.setString(2, password);
                rs = pst.executeQuery();
                if (rs.next()) {
                    return fullname = rs.getString("fullname");
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
        return fullname;
    }

    public int checkAdmin(String username, String password)
            throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        int isAdmin = 0;
        try {
            con = DBHelpers.getConnection();
            if (con != null) {
                String sql = "select isAdmin "
                        + "from tblUser "
                        + "where userID = ? and password = ? ";
                pst = con.prepareStatement(sql);
                pst.setString(1, username);
                pst.setString(2, password);
                rs = pst.executeQuery();
                if (rs.next()) {
                    return isAdmin = rs.getInt("isAdmin");
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
        return isAdmin;
    }

    public tblUserDTO infoUser(String username) throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;

        try {
            con = DBHelpers.getConnection();
            if (con != null) {
                String sql = "select fullname, phoneNumber, Address "
                        + "from tblUser "
                        + "where userID = ? ";
                pst = con.prepareStatement(sql);
                pst.setString(1, username);
                rs = pst.executeQuery();
                if (rs.next()) {
                    String fullname = rs.getString("fullname");
                    String phoneNumber = rs.getString("phoneNumber");
                    String address = rs.getString("Address");
                    tblUserDTO dto = new tblUserDTO(username, "", fullname, phoneNumber, address, "", 0);
                    return dto;
                }
            }

        } finally {
        }

        return null;
    }

    public boolean checkUserNameDuplicate(String userName) throws NamingException, SQLException {
        boolean result = false;
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            con = DBHelpers.getConnection();
            if (con != null) {
                String sql = "select fullname "
                        + "from tblUser "
                        + "where userID = ?   ";
                pst = con.prepareStatement(sql);
                pst.setString(1, userName);
                rs = pst.executeQuery();
                if (rs.next()) {
                    result = true;
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
        return result;
    }

    public int insertUser(String userId, String fullname) throws NamingException, SQLException {
        Connection con = null;
        PreparedStatement pst = null;
        int rs = 0;
        try {
            con = DBHelpers.getConnection();
            if (con != null) {
                String sql = "insert into tblUser(userID, password, fullname, phoneNumber, Address, dob, isadmin) "
                        + "values(?,?,?,?,?,?,?) ";
                pst = con.prepareStatement(sql);
                pst.setString(1, userId);
                pst.setString(2, "");
                pst.setString(3, fullname);
                pst.setString(4, "");
                pst.setString(5, "");
                pst.setString(6, "");
                pst.setInt(7, 0);
                rs = pst.executeUpdate();
                if (rs > 0) {
                    return rs;
                }
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
