/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entities.Customer;
import java.sql.Connection;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import connection.ConnectDB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author admin
 */
public class CustomerDAO {

    public static List<Customer> finALL() throws SQLException {
        List<Customer> customerList = new ArrayList<>();
        // lay du lieu tu table customer
        customerList.clear();
        Connection conn = null;
        Statement statement = null;
        try {
            conn = ConnectDB.getConnection();
            String sql = "select * from Customer";
            statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                Customer cus = new Customer(resultSet.getString("id"),
                        resultSet.getString("fullName"),
                        resultSet.getString("sex"),
                        resultSet.getString("address"),
                        resultSet.getString("phone"));
                customerList.add(cus);
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
            return customerList;
        }
    }

    public static void insertCustomer(Customer cus) {

        Connection conn = null;
        PreparedStatement preparedStatement = null;

        try {
            conn = ConnectDB.getConnection();
            String sql = "Insert into customer (id, fullName, sex, address, phone)"
                    + "Values (?,?,?,?,?)";
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, cus.getId());
            preparedStatement.setString(2, cus.getFullName());
            preparedStatement.setString(3, cus.getSex());
            preparedStatement.setString(4, cus.getAddress());
            preparedStatement.setString(5, cus.getPhone());
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

    public static void updateCustomer(Customer cus) {
        Connection conn = null;
        PreparedStatement preparedStatement = null;

        try {
            conn = ConnectDB.getConnection();
            String sql = "Update customer Set fullName = ?, sex = ?, address = ?, phone = ? Where id = ? ";
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, cus.getFullName());
            preparedStatement.setString(2, cus.getSex());
            preparedStatement.setString(3, cus.getAddress());
            preparedStatement.setString(4, cus.getPhone());
            preparedStatement.setString(5, cus.getId());

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

    public static void deleteCustomer(String id) {
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        try {
            conn = ConnectDB.getConnection();
            String sql = "Delete from Customer where id = ?";
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

    public static List<Customer> searchCustomer(String line) throws SQLException {
        List<Customer> customerList = new ArrayList<>();
        customerList.clear();
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        Statement statement = null;
        try {
            conn = ConnectDB.getConnection();
            statement = conn.createStatement();
            String sql = "Select id, fullName, sex, address, phone "
                    + "from Customer "
                    + "where "
                    + "id like N'" + line + "' or "
                    + "fullname like N'%" + line + "%' or "
                    + "sex like N'%" + line + "%' or "
                    + "address like N'%" + line + "%' or "
                    + "phone like N'%" + line + "%'";

            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Customer cus = new Customer(resultSet.getString("id"),
                        resultSet.getString("fullName"),
                        resultSet.getString("sex"),
                        resultSet.getString("address"),
                        resultSet.getString("phone"));
                customerList.add(cus);
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

            return customerList;
        }
    }
//    public static void main(String[] args) throws SQLException {
//        List<Customer> customerList = searchCustomer("1");
//        
//        customerList.forEach(customer -> {
//            System.out.println(customer);
//        });
//    }

}
