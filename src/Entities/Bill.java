/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.util.Date;

/**
 *
 * @author admin
 */
public class Bill {

    private int id;
    private float totalPrice;
    private int discount;
    private float moneyCustomer;
    private float moneyReturn;
    private Date date;
    private int customer_id;
    private int account_id;

    public Bill() {
    }

    public Bill(int id, float totalPrice, int discount, float moneyCustomer, float moneyReturn, Date date, int customer_id, int account_id) {
        this.id = id;
        this.totalPrice = totalPrice;
        this.discount = discount;
        this.moneyCustomer = moneyCustomer;
        this.moneyReturn = moneyReturn;
        this.date = date;
        this.customer_id = customer_id;
        this.account_id = account_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(float totalPrice) {
        this.totalPrice = totalPrice;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public float getMoneyCustomer() {
        return moneyCustomer;
    }

    public void setMoneyCustomer(float moneyCustomer) {
        this.moneyCustomer = moneyCustomer;
    }

    public float getMoneyReturn() {
        return moneyReturn;
    }

    public void setMoneyReturn(float moneyReturn) {
        this.moneyReturn = moneyReturn;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public int getAccount_id() {
        return account_id;
    }

    public void setAccount_id(int account_id) {
        this.account_id = account_id;
    }

    
}
