/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tubes;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ROG GL552VX
 */


public class koneksidb {
    private static Connection con;
    private static Statement stat=null;
    
    public boolean connect (String host, String user, String pass) throws SQLException{
        try{
            Class.forName("com.mysql.jdbc.Driver");
            String connecturl = "jdbc:mysql://"
                    +host
                    +"/dbtubes?user="
                    +user
                    +"&password="
                    +pass;
            con = (Connection)DriverManager.getConnection(connecturl);
        } catch (ClassNotFoundException ex){
            Logger.getLogger(koneksidb.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }
    public Connection getConnection(){
        try {
            Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/dbtubes","root","");
            return con;
        } catch (SQLException ex) {
            Logger.getLogger(koneksidb.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public boolean connect (String host, String user) throws SQLException{
        if(connect(host, user, "")){
            return true;
        }
        return false;
    }
    
    public static void exec(String query) throws SQLException{
        stat = (Statement)con.createStatement();
        int rowEffected = stat.executeUpdate(query);
            System.out.println(rowEffected+"baris data berubah");
    }
    
    public static ResultSet DataBase(String query) throws SQLException{
        ResultSet rs = null;
        try{
        stat = (Statement)con.createStatement();
        rs = stat.executeQuery(query);
        return rs;
        }catch(Exception e){}
        return null;
    }
}