/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entities.Staff;
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
public class StaffDAO {

    public static List<Staff> finAll() throws SQLException {
        List<Staff> staffList = new ArrayList<>();

        staffList.clear();

        Connection conn = null;
        Statement statement = null;
        try {
            conn = ConnectDB.getConnection();
            String sql = "Select * from AccountInfo";
            statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                Staff staff = new Staff(resultSet.getString(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getString(5),
                        resultSet.getString(6),
                        resultSet.getString(7),
                        resultSet.getString(8));
                staffList.add(staff);
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
            return staffList;
        }
    }

    public static void insertStaff(Staff staff) {

        Connection conn = null;
        PreparedStatement preparedStatement = null;

        try {
            conn = ConnectDB.getConnection();
            String sql = "INSERT into AccountInfo (id, fullName, age, username, password,  address, phone ,position) "
                    + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, staff.getId());
            preparedStatement.setString(2, staff.getFullName());
            preparedStatement.setString(3, staff.getAge());
            preparedStatement.setString(4, staff.getUsername());
            preparedStatement.setString(5, staff.getPassword());
            preparedStatement.setString(6, staff.getAddress());
            preparedStatement.setString(7, staff.getPhone());
            preparedStatement.setString(8, staff.getPosition());
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

    public static void updateStaff(Staff staff) {
        Connection conn = null;
        PreparedStatement preparedStatement = null;

        try {
            conn = ConnectDB.getConnection();
            String sql = "Update AccountInfo Set fullname = ?, age = ?, username = ?, password = ?, address = ?, phone = ?, position = ? Where id = ? ";
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, staff.getFullName());
            preparedStatement.setString(2, staff.getAge());
            preparedStatement.setString(3, staff.getUsername());
            preparedStatement.setString(4, staff.getPassword());
            preparedStatement.setString(5, staff.getAddress());
            preparedStatement.setString(6, staff.getPhone());
            preparedStatement.setString(7, staff.getPosition());
            preparedStatement.setString(8, staff.getId());

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
            String sql = "Delete from AccountInfo where id = ?";
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

    public static List<Staff> searchStaff(String line) throws SQLException {
        List<Staff> staffList = new ArrayList<>();
        staffList.clear();
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        Statement statement = null;
        try {
            conn = ConnectDB.getConnection();
            statement = conn.createStatement();
            String sql = "Select * "
                    + "from Customer "
                    + "where "
                    + "id like N'" + line + "' or "
                    + "fullname like N'%" + line + "%' or "
                    + "age like N'%" + line + "%' or "
                    + "username like N'%" + line + "%' or "
                    + "password like N'%" + line + "%' or "
                    + "address like N'%" + line + "%' or "
                    + "phone like N'%" + line + "%' or "
                    + "position like N'%" + line + "%'";

            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Staff staff = new Staff(resultSet.getString(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getString(5),
                        resultSet.getString(6),
                        resultSet.getString(7),
                        resultSet.getString(8));
                staffList.add(staff);
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

            return staffList;
        }
    }
    public static Staff staffLogin(String userName, String pass) {
        try {
            
        } catch (Exception e) {
        }
        
        return  null;
    }
}
