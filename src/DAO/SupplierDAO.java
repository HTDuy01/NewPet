/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Entities.Supplier;
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
 * @author mac
 */
public class SupplierDAO {

    public static List<Supplier> finALL() throws SQLException {
        List<Supplier> supplierList = new ArrayList<>();
        // lay du lieu tu table customer
//        supplierList.clear();
        Connection conn = null;
        Statement statement = null;
        try {
            conn = ConnectDB.getConnection();
            String sql = "select * from Supplier";
            statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                Supplier sup = new Supplier(resultSet.getString(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getString(5));
                supplierList.add(sup);
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
            return supplierList;
        }
    }

    public static void insertSupplier(Supplier sup) {
        Connection conn = null;
        PreparedStatement preparedStatement = null;

        try {
            conn = ConnectDB.getConnection();
            String sql = "Insert into Supplier (id, name, address, phone, email)"
                    + "Values (?,?,?,?,?)";
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, sup.getId());
            preparedStatement.setString(2, sup.getName());
            preparedStatement.setString(3, sup.getAddress());
            preparedStatement.setString(4, sup.getPhone());
            preparedStatement.setString(5, sup.getEmail());
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

    public static void updateSupplier(Supplier sup) {
        Connection conn = null;
        PreparedStatement preparedStatement = null;

        try {
            conn = ConnectDB.getConnection();
            String sql = "Update Supplier Set name = ?, address = ?, phone = ?, email = ? Where id = ? ";
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, sup.getName());
            preparedStatement.setString(2, sup.getAddress());
            preparedStatement.setString(3, sup.getPhone());
            preparedStatement.setString(4, sup.getEmail());
            preparedStatement.setString(5, sup.getId());

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

    public static void deleteSupplier(String id) {
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        try {
            conn = ConnectDB.getConnection();
            String sql = "Delete from Supplier where id = ?";
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

    public static List<Supplier> searchSupplier(String line) throws SQLException {
        List<Supplier> supplierList = new ArrayList<>();
        supplierList.clear();
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        Statement statement = null;
        try {
            conn = ConnectDB.getConnection();
            statement = conn.createStatement();
            String sql = "Select id, name, address, phone, email "
                    + "from Supplier "
                    + "where "
                    + "id like N'" + line + "' or "
                    + "name like N'%" + line + "%' or "
                    + "address like N'%" + line + "%' or "
                    + "phone like N'%" + line + "%' or "
                    + "email like N'%" + line + "%'";

            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Supplier sup = new Supplier(resultSet.getString(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getString(5));
                supplierList.add(sup);
            }
        } catch (SQLException se) {
            Logger.getLogger(SupplierDAO.class.getName()).log(Level.SEVERE, null, se);
        } finally {
            if (conn != null) {
                conn.close();
            }
            if (statement != null) {
                statement.close();
            }

            return supplierList;
        }
    }
}