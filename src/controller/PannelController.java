/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import bean.DanhMucBean;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Panel;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JPanel;
import form.SupplierPanel;
import form.HoaDonPanel;
import form.KhachHangPanel;
import form.ServicePannel;
import form.NhanVienPanel;
import form.ProductPannel;
import form.PetPannel;
import form.TrangChuPanel;

/**
 *
 * @author mac
 */
public class PannelController {

    private JPanel jpnRoot;
    private String kindSelected;
    private List<DanhMucBean> listItem = null;

    public PannelController(JPanel jpnRoot) {
        this.jpnRoot = jpnRoot;
    }

    public void setView(JPanel jpnItem, JLabel jlbItem) {
        kindSelected = "TrangChinh";
//        jpnItem.setBackground(new Color(153,204,255));
//        jlbItem.setBackground(new Color(153,204,255));
//       JPanel node = new TrangChinhJPanel();
        jpnRoot.removeAll();
        jpnRoot.setLayout(new BorderLayout());
        jpnRoot.add(new TrangChuPanel());
        jpnRoot.validate();
        jpnRoot.repaint();
    }

    public void setEvent(List<DanhMucBean> listItem) {
        this.listItem = listItem;
        for (DanhMucBean item : listItem) {
            item.getJlb().addMouseListener(new lableEvent(item.getKind(), item.getJpn(), item.getJlb()));
        }

    }

    class lableEvent implements MouseListener {

        private JPanel node;

        private String kind;
        private JPanel jpnItem;
        private JLabel jlbItem;

        public lableEvent(String kind, JPanel jpnItem, JLabel jlbItem) {
            this.kind = kind;
            this.jpnItem = jpnItem;
            this.jlbItem = jlbItem;
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            try {
                switch (kind) {
                    case "Home":
                        node = new TrangChuPanel();
                        break;
                    case "HoaDon":
                        node = new HoaDonPanel();
                        break;
                    case "Supplier":
                        node = new SupplierPanel();
                        break;
                    case "Service":
                        node = new ServicePannel();
                        break;
                        
                    case "SanPham":
                        node = new ProductPannel();
                        break;
                        
                    case "KhachHang":
                    {
                        try {
                            node = new KhachHangPanel();
                        } catch (SQLException ex) {
                            Logger.getLogger(PannelController.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    break;
                    
                    case "ThongKe":
                        node = new PetPannel();
                        break;
                    case "NhanVien":
                        node = new NhanVienPanel();
                        break;
                    default:
                        break;
                }
                jpnRoot.removeAll();
                jpnRoot.setLayout(new BorderLayout());
                jpnRoot.add(node);
                jpnRoot.validate();
                jpnRoot.repaint();
                setChangeBackgroud(kind);
            } catch (SQLException ex) {
                Logger.getLogger(PannelController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        @Override
        public void mousePressed(MouseEvent e) {
            kindSelected = kind;
            jpnItem.setBackground(new Color(153,204,255));
            jlbItem.setBackground(new Color(153,204,255));
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            jpnItem.setBackground(new Color(153,204,255));
            jlbItem.setBackground(new Color(153,204,255));
        }

        @Override
        public void mouseExited(MouseEvent e) {
            if (!kindSelected.equalsIgnoreCase(kind)) {
                jpnItem.setBackground(new Color(104,152,197));
                jlbItem.setBackground(new Color(104,152,197));
            }
        }

    }

    private void setChangeBackgroud(String kind) {
        for (DanhMucBean item : listItem) {
            if (item.getKind().equalsIgnoreCase(kind)) {
                item.getJpn().setBackground(new Color(153,204,255));
                item.getJlb().setBackground(new Color(153,204,255));
            } else {
                item.getJpn().setBackground(new Color(104,152,197));
                item.getJlb().setBackground(new Color(104,152,197));
            }
        }
    }

}
