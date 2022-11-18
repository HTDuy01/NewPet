/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Helper;

import com.mysql.cj.protocol.Resultset;
import connection.ConnectDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author admin
 */
public class sqlHelper {
    public static PreparedStatement preparedStatement(String sql, Object...args) throws SQLException {
        Connection conn = ConnectDB.getConnection();
        PreparedStatement preparedStatement = null;
        if(sql.trim().startsWith("{")){
            preparedStatement = conn.prepareCall(sql);
        }
        else {
            preparedStatement = conn.prepareStatement(sql);
            System.out.println(preparedStatement.toString());
        }
        for (int i = 0; i < args.length; i++) {
            preparedStatement.setObject(i+1, args[i]);
        }
        return preparedStatement;
    }
    public static void executeUpdate(String sql, Object...args) {
        try {
            PreparedStatement statement = preparedStatement(sql, args);
            System.out.println(statement.toString());
            try {
                statement.executeQuery();
            } finally  {
                statement.getConnection().close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static ResultSet executeQuerry(String sql, Object...args) {
        try {
            PreparedStatement stmt = preparedStatement(sql, args);
            return stmt.executeQuery();
            
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
            
    }
}
