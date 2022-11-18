/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

/**
 *
 * @author admin
 */
public class SupplierComboBox {
    Object values;
    Object text;

    public SupplierComboBox() {
    }

    public SupplierComboBox(Object values, Object text) {
        this.values = values;
        this.text = text;
    }

    @Override
    public String toString() {
        return text.toString(); //To change body of generated methods, choose Tools | Templates.
    }
    
    public int valuesInt() {
        return Integer.parseInt(values.toString());
    }
    public String valuesString() {
        return values.toString();
    }
}
