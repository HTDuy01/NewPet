/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entities.Product;
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
public class ProductDAO {
    public static List<Product> finAll() throws SQLException {
        List<Product> productList = new ArrayList<>();
        
        Connection conn = null;
        Statement statement = null;
        try {
            conn = ConnectDB.getConnection();
            String sql = "SELECT product.id, product.name, product.price, product.descript, product.quantity, supplier.name, accountinfo.fullname "
                    + "from product "
                    + "join supplier on product.supplier_id = supplier.id "
                    + "join accountinfo on product.account_id = accountinfo.id";
            statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                Product product = new Product(resultSet.getString(1), 
                        resultSet.getString(2), 
                        resultSet.getString(3), 
                        resultSet.getString(4), 
                        resultSet.getString(5), 
                        resultSet.getString(6), 
                        resultSet.getString(7));
                productList.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if (conn != null) {
                conn.close();
            }
            if (statement != null) {
                statement.close();
            }
            return productList;
        }
    }
    public static void insertProduct(Product prod) {
        Connection conn = null;
        PreparedStatement preparedStatement = null;

        try {
            conn = ConnectDB.getConnection();
            String sql = "Insert into Product (id, name, price, descript, quantity, supplier_id, account_id)"
                    + "VALUES (?, ?, ?, ?, ?, (select id from Supplier where name like N'%?%'), (select id from accountInfo where userName like N'%?%'))";
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, prod.getId());
            preparedStatement.setString(2, prod.getName());
            preparedStatement.setString(3, prod.getPrice());
            preparedStatement.setString(4, prod.getDescript());
            preparedStatement.setString(5, prod.getQuantity());
            preparedStatement.setString(6, prod.getSupName());
            preparedStatement.setString(7, prod.getAccName());
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

    public static void updateProduct(Product prod) {
        Connection conn = null;
        PreparedStatement preparedStatement = null;

        try {
            conn = ConnectDB.getConnection();
            String sql = "Update Product "
                    + "Set name = ?, "
                    + "price = ?, "
                    + "descript = ?, "
                    + "quantity = ?, "
                    + "supplier_id = (select id from Supplier where name like N'%?%'), "
                    + "account_id =  (select id from accountInfo where userName like N'%?%') "
                    + "Where id = ? ";
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, prod.getName());
            preparedStatement.setString(2, prod.getPrice());
            preparedStatement.setString(3, prod.getDescript());
            preparedStatement.setString(4, prod.getQuantity());
            preparedStatement.setString(5, prod.getSupName());
            preparedStatement.setString(6, prod.getAccName());
            preparedStatement.setString(7, prod.getId());
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

    public static void deleteProduct(String id) {
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        try {
            conn = ConnectDB.getConnection();
            String sql = "Delete from Product where id = ?";
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

    public static List<Product> searchProduct(String line) throws SQLException {
        List<Product> productList = new ArrayList<>();
        productList.clear();
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        Statement statement = null;
        try {
            conn = ConnectDB.getConnection();
            statement = conn.createStatement();
            String sql = "SELECT product.id, product.name, product.price, product.descript, product.quantity, supplier.name, accountinfo.fullname "
                    + "from product "
                    + "join supplier on product.supplier_id = supplier.id "
                    + "join accountinfo on product.account_id = accountinfo.id"
                    + "where "
                    + "id like N'" + line + "' or "
                    + "name like N'%" + line + "%' or "
                    + "price like N'%" + line + "%' or "
                    + "descript like N'%" + line + "%' or "
                    + "quantity like N'%" + line + "%' or " 
                    + "supplier.name like N'%" + line + "%' or"
                    + "accountinfo.fullname like N'%"+ line + "%'";

            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                Product product = new Product(resultSet.getString(1), 
                        resultSet.getString(2), 
                        resultSet.getString(3), 
                        resultSet.getString(4), 
                        resultSet.getString(5), 
                        resultSet.getString(6), 
                        resultSet.getString(7));
                productList.add(product);
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

            return productList;
        }
    }
}
