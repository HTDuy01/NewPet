/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entities.Bill;
import connection.ConnectDB;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author admin
 */
public class BillDAO {

    public static void addBill(Bill bill) {
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        try {
            conn = ConnectDB.getConnection();
            String sql = "Set dateformat DMY insert into Bill (id, totalPrice, discount, moneyCustomer, moneyReturn, date, customer_id, account_id)"
                    + "values(?,?,?,?,?,?,?,?) ";
            preparedStatement = conn.prepareStatement(sql);

            preparedStatement.setInt(1, bill.getId());
            preparedStatement.setFloat(2, bill.getTotalPrice());
            preparedStatement.setInt(3, bill.getDiscount());
            preparedStatement.setFloat(4, bill.getMoneyCustomer());
            preparedStatement.setFloat(5, bill.getMoneyReturn());
            preparedStatement.setDate(6, (Date) bill.getDate());
            preparedStatement.setInt(7, bill.getCustomer_id());
            preparedStatement.setInt(8, bill.getAccount_id());
            
            preparedStatement.executeUpdate();
        } catch (Exception e) {
        }
    }
}
