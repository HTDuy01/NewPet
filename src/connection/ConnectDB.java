/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author admin
 */
public class ConnectDB {
    public static Connection getConnection() throws SQLException{
        String url = "jdbc:mysql://localhost:3306/PetStore";
        String user = "root";
        String pass = "123456";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(url, user, pass);
           
        } catch (ClassNotFoundException ex) {
            System.out.println("Connection failure");
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
        return null;
        
        
    }
    public static void main(String[] args) throws SQLException {
        Connection conn = getConnection();
        if (conn != null) {
            System.out.println("Connection Successfully");
        }else{
            System.out.println("Connection Failure");
        }
    }
}
