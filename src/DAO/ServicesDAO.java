/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entities.Services;
import connection.ConnectDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author admin
 */
public class ServicesDAO {

    public static List<Services> finALl() throws SQLException {
        List<Services> servicesList = new ArrayList<>();
        //lay du lieu tu table Service
        
        servicesList.clear();
        Connection conn = null;
        Statement statement = null;
        try {
            conn = ConnectDB.getConnection();
            String sql = "Select * from Service";
            statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {                
                Services services = new Services(resultSet.getString("id"), resultSet.getString("name"), resultSet.getString("price"), resultSet.getString("descript"));
                servicesList.add(services);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if (conn != null) {
                conn.close();
            }
            if (statement != null){
                statement.close();
            }
            return servicesList;
        }
    }
    public static void insertService(Services ser) {

        Connection conn = null;
        PreparedStatement preparedStatement = null;

        try {
            conn = ConnectDB.getConnection();
            String sql = "Insert into Service (id, name, price, descript)"
                    + "Values (?,?,?,?)";
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, ser.getId());
            preparedStatement.setString(2, ser.getName());
            preparedStatement.setString(3, ser.getPrice());
            preparedStatement.setString(4, ser.getDescription());

            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
        }
    }

    public static void updateService(Services ser) {
        Connection conn = null;
        PreparedStatement preparedStatement = null;

        try {
            conn = ConnectDB.getConnection();
            String sql = "Update Service Set name = ?, price = ?, descript = ? Where id = ? ";
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, ser.getName());
            preparedStatement.setString(2, ser.getPrice());
            preparedStatement.setString(3, ser.getDescription());
            preparedStatement.setString(4, ser.getId());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
        }
    }

    public static void deleteService(String id) {
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        try {
            conn = ConnectDB.getConnection();
            String sql = "Delete from Service where id = ?";
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, id);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
        }

    }

    public static List<Services> searchService(String line) throws SQLException {
        List<Services> serviceList = new ArrayList<>();
        serviceList.clear();
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        Statement statement = null;
        try {
            conn = ConnectDB.getConnection();
            statement = conn.createStatement();
            String sql = "Select * "
                    + "from Service "
                    + "where "
                    + "id like N'" + line + "' or "
                    + "name like N'%" + line + "%' or "
                    + "price like N'%" + line + "%' or "
                    + "descript like N'%" + line + "%' ";

            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Services ser = new Services(resultSet.getString(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4));

                serviceList.add(ser);
            }
        } catch (SQLException se) {
            Logger.getLogger(CustomerDAO.class.getName()).log(Level.SEVERE, null, se);
        } finally {
            if (conn != null) {
                conn.close();
            }
            if (statement != null) {
                statement.close();
            }

            return serviceList;
        }
    }
}
