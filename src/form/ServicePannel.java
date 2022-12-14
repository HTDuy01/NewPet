/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package form;

import Entities.Services;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import DAO.ServicesDAO;

/**
 *
 * @author mac
 */
public class ServicePannel extends javax.swing.JPanel {

    DefaultTableModel tableModel;
    List<Services> servicesList = new ArrayList<>();

    /**
     * Creates new form LoaiDichVuPanel
     */
    public ServicePannel() throws SQLException {
        initComponents();
        tableModel = (DefaultTableModel) tbService.getModel();
        showServices();
    }

    public void showServices() throws SQLException {
        servicesList = ServicesDAO.finALl();

        tableModel.setRowCount(0);

        servicesList.forEach(services -> {
            tableModel.addRow(new Object[]{services.getId(), services.getName(), services.getPrice(), services.getDescription()});
        });
    }
    public void resetTextField(){
        try {
            txtID.setText("");
            txtName.setText("");
            txtPrice.setText("");
            txtDesc.setText("");

        } catch (Exception e) {
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        myButton1 = new form.MyButton();
        myButton2 = new form.MyButton();
        myButton3 = new form.MyButton();
        myButton4 = new form.MyButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbService = new javax.swing.JTable();
        btnReset = new javax.swing.JButton();
        btnInsert = new form.MyButton();
        btnUpdate = new form.MyButton();
        btnDelete = new form.MyButton();
        txtSearch = new form.TextField();
        tbnSearch = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        txtID = new form.TextField();
        txtName = new form.TextField();
        txtPrice = new form.TextField();
        txtDesc = new form.TextField();

        setBackground(new java.awt.Color(184, 114, 170));
        setPreferredSize(new java.awt.Dimension(960, 722));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("Services");

        tbService.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "Name of Service", "Price", "Descript"
            }
        ));
        tbService.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbServiceMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbService);

        btnReset.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-available-updates-30.png"))); // NOI18N
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

        btnInsert.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/insert.png"))); // NOI18N
        btnInsert.setText("INSERT");
        btnInsert.setRadius(40);
        btnInsert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsertActionPerformed(evt);
            }
        });

        btnUpdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/update.png"))); // NOI18N
        btnUpdate.setText("UPDATE");
        btnUpdate.setBorderColor(new java.awt.Color(55, 147, 240));
        btnUpdate.setColorClick(new java.awt.Color(49, 138, 227));
        btnUpdate.setColorOver(new java.awt.Color(123, 181, 238));
        btnUpdate.setRadius(40);
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/remove.png"))); // NOI18N
        btnDelete.setText("DELETE");
        btnDelete.setBorderColor(new java.awt.Color(255, 51, 51));
        btnDelete.setColorClick(new java.awt.Color(237, 62, 62));
        btnDelete.setColorOver(new java.awt.Color(220, 88, 88));
        btnDelete.setRadius(40);
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        txtSearch.setLabelText("Search somthing ?");

        tbnSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-search-30.png"))); // NOI18N
        tbnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbnSearchActionPerformed(evt);
            }
        });

        txtID.setLabelText("ID");

        txtName.setLabelText("Name");

        txtPrice.setLabelText("Price");

        txtDesc.setLabelText("Description");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtID, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtPrice, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtDesc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(4, 4, 4))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDesc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 999, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnInsert, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtSearch, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(2, 2, 2)
                        .addComponent(btnReset)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tbnSearch))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 586, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnReset, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnInsert, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtSearch, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tbnSearch, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnInsertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsertActionPerformed
        // TODO add your handling code here:
        String id = txtID.getText();
        String name = txtName.getText();
        String price = txtPrice.getText();
        String desc = txtDesc.getText();

        Services ser = new Services(id, name, price, desc);
        tableModel.addRow(new String[]{id, name, price, desc});
        ServicesDAO.insertService(ser);
        try {
            showServices();
            resetTextField();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }//GEN-LAST:event_btnInsertActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        // TODO add your handling code here:
        if (tbService.getSelectedRowCount() == 1) {
            String id = txtID.getText();
            String name = txtName.getText();
            String price = txtPrice.getText();
            String desc = txtDesc.getText();

            Services ser = new Services(id, name, price, desc);
            ServicesDAO.updateService(ser);

            JOptionPane.showMessageDialog(this, "Update Successfully");
            try {
                showServices();
                resetTextField();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        } else {
            try {
                showServices();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void tbServiceMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbServiceMouseClicked
        // TODO add your handling code here:
        DefaultTableModel tblModel = (DefaultTableModel) tbService.getModel();

        String id = tblModel.getValueAt(tbService.getSelectedRow(), 0).toString();
        String name = tblModel.getValueAt(tbService.getSelectedRow(), 1).toString();
        String price = tblModel.getValueAt(tbService.getSelectedRow(), 2).toString();
        String desc = tblModel.getValueAt(tbService.getSelectedRow(), 3).toString();

        txtID.setText(id);
        txtName.setText(name);
        txtPrice.setText(price);
        txtDesc.setText(desc);

    }//GEN-LAST:event_tbServiceMouseClicked

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // TODO add your handling code here:
        int selectedIndex = tbService.getSelectedRow();
        if (selectedIndex >= 0) {
            Services ser = servicesList.get(selectedIndex);
            int option = JOptionPane.showConfirmDialog(this, "Do you want to delete this Customer Data?");
            System.out.println("Option: " + option);
            if (option == 0) {
                ServicesDAO.deleteService(ser.getId());
                try {
                    showServices();
                    resetTextField();
                } catch (SQLException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        // TODO add your handling code here:
        resetTextField();
    }//GEN-LAST:event_btnResetActionPerformed

    private void tbnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbnSearchActionPerformed
        // TODO add your handling code here:

        try {
            // TODO add your handling code here:
            servicesList = ServicesDAO.searchService(txtSearch.getText());
            tableModel.setRowCount(0);

            servicesList.forEach(service -> {
                tableModel.addRow(new Object[]{service.getId(), service.getName(), service.getPrice(), service.getDescription()});
            });
            
            resetTextField();
        } catch (SQLException ex) {
            Logger.getLogger(KhachHangPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_tbnSearchActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private form.MyButton btnDelete;
    private form.MyButton btnInsert;
    private javax.swing.JButton btnReset;
    private form.MyButton btnUpdate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private form.MyButton myButton1;
    private form.MyButton myButton2;
    private form.MyButton myButton3;
    private form.MyButton myButton4;
    private javax.swing.JTable tbService;
    private javax.swing.JButton tbnSearch;
    private form.TextField txtDesc;
    private form.TextField txtID;
    private form.TextField txtName;
    private form.TextField txtPrice;
    private form.TextField txtSearch;
    // End of variables declaration//GEN-END:variables
}
