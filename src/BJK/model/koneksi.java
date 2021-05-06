/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BJK.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Salman Alfarissy
 */
public class koneksi {
     public static Connection on;
    
    public static Connection getKoneksi(){
        if (on == null){
            try {
                DriverManager.registerDriver(new com.mysql.jdbc.Driver());
                on = DriverManager.getConnection("jdbc:mysql://localhost/balanjokuy", "root", "");
            } catch (Exception e){
                e.printStackTrace();
            }
        }
        return on;
    }
     public static void main(String[] args) throws SQLException {
        koneksi k = new koneksi();
        Connection conn =k.getKoneksi();
        if (!conn.isClosed()) {
            System.out.println("Connection is ok!!");
            
        }
}
}