/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entities.Pet;
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
 * @author 01
 */
public class PetDAO {

    public static List<Pet> finAll() throws SQLException {
        List<Pet> petList = new ArrayList<>();

        Connection conn = null;
        Statement statement = null;
        try {
            conn = ConnectDB.getConnection();
            String sql = "Select pet.id, pet.name, Customer.fullName, Service.name, pet.note, pet.cage "
                    + "from pet"
                    + "join Customer on pet.ownerId = customer.id "
                    + "join Service on pet.serviceID = service.id ";
            statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Pet pet = new Pet(resultSet.getString(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getString(5),
                        resultSet.getString(6));
                petList.add(pet);
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
            return petList;
        }
    }
    public static void insertPet(Pet pet) {
        Connection conn = null;
        PreparedStatement preparedStatement = null;

        try {
            conn = ConnectDB.getConnection();
            String sql = "Insert into Pet (id, name,  ownerId, serviceID, note, cage)"
                    + "VALUES (?, ?, (Select id from Customer where fullname like N'%?%'), (Select id from Sevice where name like N'$?%'), ?, ?)";
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, pet.getId());
            preparedStatement.setString(2, pet.getName());
            preparedStatement.setString(3, pet.getOwnerName());
            preparedStatement.setString(4, pet.getServiceName());
            preparedStatement.setString(5, pet.getNote());
            preparedStatement.setString(6, pet.getCage());
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

    public static void updateProduct(Pet pet) {
        Connection conn = null;
        PreparedStatement preparedStatement = null;

        try {
            conn = ConnectDB.getConnection();
            String sql = "Update Pet "
                    + "Set name = ?, "
                    + "ownerid = (Select id from Customer where fullname like N'%?%'), "
                    + "serviceID = (Select id from Sevice where name like N'$?%'), "
                    + "note = ?, "
                    + "cage = ? ";
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, pet.getId());
            preparedStatement.setString(2, pet.getName());
            preparedStatement.setString(3, pet.getOwnerName());
            preparedStatement.setString(4, pet.getServiceName());
            preparedStatement.setString(5, pet.getNote());
            preparedStatement.setString(6, pet.getCage());
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
            String sql = "Delete from Pet where id = ?";
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

    public static List<Pet> searchProduct(String line) throws SQLException {
        List<Pet> petList = new ArrayList<>();
        petList.clear();
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        Statement statement = null;
        try {
            conn = ConnectDB.getConnection();
            statement = conn.createStatement();
            String sql = "Select pet.id, pet.name, Customer.fullName, Service.name, pet.note, pet.cage "
                    + "from pet"
                    + "join Customer on pet.ownerId = customer.id "
                    + "join Service on pet.serviceID = service.id "
                    + "where "
                    + "id like N'" + line + "' or "
                    + "name like N'%" + line + "%' or "
                    + "customer.id like N'%" + line + "%' or "
                    + "service.id like N'%" + line + "%' or "
                    + "note like N'%" + line + "%' or " 
                    + "cage like N'%" + line + "%' ";

            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Pet pet = new Pet(resultSet.getString(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getString(5),
                        resultSet.getString(6));
                petList.add(pet);
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

            return petList;
        }
    }
}
