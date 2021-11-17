/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Taufik Agung Santoso
 */

public class Database {
    private Connection con;
    private Statement stmt;
    
    public Database(String host, String username, String password){
        try {
            String url = "jdbc:mysql://" + host + "/dbtubes";
            con = DriverManager.getConnection(url, username, password);
            stmt = con.createStatement();
            System.out.println("Koneksi Berhasil");
        } catch (SQLException e) {
            System.out.println("Koneksi Gagal");
        }
    }

    public ResultSet ambilData(String query){
        ResultSet data=null;
        try {
            data = stmt.executeQuery(query);
            System.out.println("Data berhasil diambil");
        } catch (SQLException e) {
            System.out.println("Data gagal diambil");
        }
        return data;
    }
    
    public void isiData(String query){
        try {
            stmt.executeUpdate(query);
            System.out.println("data berhasil disimpan");
        } catch (SQLException e) {
            System.out.println("data tidak berhasil disimpan");
        }
    }
    
    public static void main(String[] args) {
        Database testing = new Database("localhost", "root", "");
//        try {
//            String query = "SELECT * FROM admin";
//            ResultSet data = testing.ambilData(query);
//            while(data.next()){
//                System.out.println(data.getString("nama_pelanggan"));
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        String query = "INSERT INTO login (username, password) VALUES ('testing', 'testing')";
        //String query = "DELETE FROM login WHERE username = 'testing'";
        String query = "UPDATE admin SET nama_pelanggan='agung', tgl_masuk='2018-01-01', tgl_keluar='2018-01-02', berat=1, jenispakaian='jaket', harga=12000 WHERE id_laundry='1234'";
        testing.isiData(query);
    }
}


