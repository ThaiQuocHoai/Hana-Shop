/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hoaitq.untilities;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.SQLException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 *
 * @author QH
 */
public class DBHelpers implements Serializable{
    public static Connection getConnection() throws NamingException, SQLException{
        Context context = new InitialContext();
        Context contextServer = (Context) context.lookup("java:comp/env");
        DataSource ds = (DataSource) contextServer.lookup("Assignment1");
        Connection con = ds.getConnection();
        return con;
    }
}