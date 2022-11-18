/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

/**
 *
 * @author 01
 */
public class CustomerComboBox {
    Object values;
    Object text;

    public CustomerComboBox() {
    }

    public CustomerComboBox(Object values, Object text) {
        this.values = values;
        this.text = text;
    }

    public Object getValues() {
        return values;
    }

    public void setValues(Object values) {
        this.values = values;
    }

    public Object getText() {
        return text;
    }

    public void setText(Object text) {
        this.text = text;
    }
    
    
}
