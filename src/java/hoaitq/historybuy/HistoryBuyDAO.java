/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hoaitq.historybuy;

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
public class HistoryBuyDAO implements Serializable {

    public ArrayList<HistoryBuyDTO> getHistory(String query) throws SQLException, NamingException {
        ArrayList<HistoryBuyDTO> list = null;
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            con = DBHelpers.getConnection();
            if (con != null) {
                String sql = query;
                pst = con.prepareStatement(sql);
                rs = pst.executeQuery();
                while (rs.next()) {
                    String nameCus = rs.getString(1);
                    String address = rs.getString(2);
                    String phoneNum = rs.getString(3);
                    String foodName = rs.getString(4);
                    int quantity = rs.getInt(5);
                    String date = rs.getString(6);
                    HistoryBuyDTO dto = new HistoryBuyDTO(nameCus, address, phoneNum, foodName, quantity, date);
                    if (list == null) {
                        list = new ArrayList<>();
                    }
                    list.add(dto);
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

        return list;
    }
}
