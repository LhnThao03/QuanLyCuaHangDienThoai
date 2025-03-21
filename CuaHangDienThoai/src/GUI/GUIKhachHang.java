/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

import BLL.BLLKhachHang;
import DTO.DTOKhachHang;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Phuc Nguyen
 */
public class GUIKhachHang extends javax.swing.JFrame {
    DefaultTableModel model;
    BLLKhachHang BLLkh = new BLLKhachHang();
    
    /**
     * Creates new form KhachHangGUI
     */
    public GUIKhachHang() {
        initComponents();
        setLocationRelativeTo(null);
        Color col = new Color(51,51,51);
        getContentPane().setBackground(col);
        loadKHList();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel6 = new javax.swing.JPanel();
        labelMaKH = new javax.swing.JLabel();
        labelHotenKH = new javax.swing.JLabel();
        labelSodienthoaiKH = new javax.swing.JLabel();
        textMaKH = new javax.swing.JTextField();
        textHotenKH = new javax.swing.JTextField();
        textSodienthoaiKH = new javax.swing.JTextField();
        jPanel8 = new javax.swing.JPanel();
        BXoaKH = new javax.swing.JButton();
        BAddKH = new javax.swing.JButton();
        updateButton = new javax.swing.JButton();
        labelDiachiKH = new javax.swing.JLabel();
        textDiachiKH = new javax.swing.JTextField();
        labelGenderKH = new javax.swing.JLabel();
        ComboBoxGenderKH = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableKH = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        textSearchMaKH = new javax.swing.JTextField();
        textSearchTenKH = new javax.swing.JTextField();
        BtnSearchKH = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        buttonHuyTim = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Quản Lý Khách Hàng");
        setBackground(new java.awt.Color(51, 51, 51));
        setLocation(new java.awt.Point(0, 0));
        setResizable(false);

        jPanel6.setBackground(new java.awt.Color(51, 51, 51));

        labelMaKH.setForeground(new java.awt.Color(255, 255, 255));
        labelMaKH.setText(" Mã Khách Hàng");

        labelHotenKH.setForeground(new java.awt.Color(255, 255, 255));
        labelHotenKH.setText("Họ Tên Khách Hàng ");

        labelSodienthoaiKH.setForeground(new java.awt.Color(255, 255, 255));
        labelSodienthoaiKH.setText("Số Điện Thoại");

        textMaKH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textMaKHActionPerformed(evt);
            }
        });

        textHotenKH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textHotenKHActionPerformed(evt);
            }
        });

        textSodienthoaiKH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textSodienthoaiKHActionPerformed(evt);
            }
        });

        jPanel8.setBackground(new java.awt.Color(51, 51, 51));

        BXoaKH.setBackground(new java.awt.Color(102, 102, 102));
        BXoaKH.setForeground(new java.awt.Color(255, 255, 255));
        BXoaKH.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/icons8_cancel_20px.png"))); // NOI18N
        BXoaKH.setText("Xóa");
        BXoaKH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BXoaKHActionPerformed(evt);
            }
        });

        BAddKH.setBackground(new java.awt.Color(102, 102, 102));
        BAddKH.setForeground(new java.awt.Color(255, 255, 255));
        BAddKH.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/icons8_add_20px.png"))); // NOI18N
        BAddKH.setText("Thêm");
        BAddKH.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        BAddKH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BAddKHActionPerformed(evt);
            }
        });

        updateButton.setBackground(new java.awt.Color(102, 102, 102));
        updateButton.setForeground(new java.awt.Color(255, 255, 255));
        updateButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/icons8_maintenance_20px.png"))); // NOI18N
        updateButton.setText("Sửa");
        updateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addComponent(BAddKH, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(84, 84, 84)
                        .addComponent(BXoaKH, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(166, 166, 166)
                        .addComponent(updateButton, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addGap(0, 11, Short.MAX_VALUE)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BXoaKH, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BAddKH, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(updateButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
        );

        labelDiachiKH.setForeground(new java.awt.Color(255, 255, 255));
        labelDiachiKH.setText("Địa Chỉ: ");

        textDiachiKH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textDiachiKHActionPerformed(evt);
            }
        });

        labelGenderKH.setForeground(new java.awt.Color(255, 255, 255));
        labelGenderKH.setText("Giới Tính");

        ComboBoxGenderKH.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nam", "Nữ" }));
        ComboBoxGenderKH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboBoxGenderKHActionPerformed(evt);
            }
        });

        tableKH.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã Khách Hàng", "Họ Tên Khách Hàng", "Địa Chỉ", "Số Điện Thoại", "Giới Tính"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tableKH.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableKHMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tableKH);
        if (tableKH.getColumnModel().getColumnCount() > 0) {
            tableKH.getColumnModel().getColumn(0).setPreferredWidth(50);
        }

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));

        textSearchMaKH.setText("Nhập mã khách hàng");
        textSearchMaKH.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                textSearchMaKHMouseClicked(evt);
            }
        });
        textSearchMaKH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textSearchMaKHActionPerformed(evt);
            }
        });

        textSearchTenKH.setText("Nhập tên khách hàng");
        textSearchTenKH.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                textSearchTenKHMouseClicked(evt);
            }
        });

        BtnSearchKH.setBackground(new java.awt.Color(102, 102, 102));
        BtnSearchKH.setForeground(new java.awt.Color(255, 255, 255));
        BtnSearchKH.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/icons8_search_20px_1.png"))); // NOI18N
        BtnSearchKH.setText("Tìm kiếm");
        BtnSearchKH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnSearchKHActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(89, 89, 89)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(textSearchTenKH, javax.swing.GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE)
                    .addComponent(textSearchMaKH))
                .addGap(57, 57, 57)
                .addComponent(BtnSearchKH)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(textSearchMaKH, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(textSearchTenKH, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(BtnSearchKH)))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(labelMaKH, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(labelGenderKH))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(textMaKH, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel6Layout.createSequentialGroup()
                                        .addComponent(labelHotenKH)
                                        .addGap(18, 18, 18)
                                        .addComponent(textHotenKH, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(textDiachiKH, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(ComboBoxGenderKH, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(textSodienthoaiKH, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(labelSodienthoaiKH, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(labelDiachiKH, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 39, Short.MAX_VALUE)))
                .addGap(32, 32, 32)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 587, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelMaKH, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textMaKH, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelHotenKH, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textHotenKH, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelDiachiKH, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textDiachiKH, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(textSodienthoaiKH, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelSodienthoaiKH, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ComboBoxGenderKH)
                            .addComponent(labelGenderKH, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 339, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("KHÁCH HÀNG");

        jButton1.setBackground(new java.awt.Color(102, 102, 102));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/backicon.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        buttonHuyTim.setBackground(new java.awt.Color(102, 102, 102));
        buttonHuyTim.setForeground(new java.awt.Color(255, 255, 255));
        buttonHuyTim.setText("Reset");
        buttonHuyTim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonHuyTimActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(391, 391, 391)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(buttonHuyTim))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(7, 7, 7)
                                .addComponent(jLabel4))
                            .addComponent(jButton1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(buttonHuyTim, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)))
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        GUITrangChu tc_gui = new GUITrangChu();
        tc_gui.setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void tableKHMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableKHMouseClicked
        // TODO add your handling code here:
        int i=tableKH.getSelectedRow();
        if (i>=0){
            textMaKH.setText(model.getValueAt(i, 0).toString().trim()); 
            textHotenKH.setText(model.getValueAt(i, 1).toString());
            textDiachiKH.setText(model.getValueAt(i, 2).toString());
            textSodienthoaiKH.setText(model.getValueAt(i, 3).toString());
            ComboBoxGenderKH.setSelectedItem(model.getValueAt(i, 4).toString());
        }
    }//GEN-LAST:event_tableKHMouseClicked

    private void ComboBoxGenderKHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboBoxGenderKHActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ComboBoxGenderKHActionPerformed

    private void textDiachiKHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textDiachiKHActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textDiachiKHActionPerformed
    
    private void BXoaKHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BXoaKHActionPerformed
        // TODO add your handling code here:
        int i=tableKH.getSelectedRow();
        DTOKhachHang kh = new DTOKhachHang();
        if (i>=0){
            kh.setMaKH(model.getValueAt(i, 0).toString()); 
            kh.setTenKH(model.getValueAt(i, 1).toString());
            kh.setDiaChi(model.getValueAt(i, 2).toString());
            kh.setSDT(model.getValueAt(i, 3).toString());
            kh.setGender(model.getValueAt(i, 4).toString());
        }
        JOptionPane.showMessageDialog(this,BLLkh.BLLxoa(kh));
        loadKHList();
        textMaKH.setText("");
        textHotenKH.setText("");
        textDiachiKH.setText("");
        textSodienthoaiKH.setText("");        
    }//GEN-LAST:event_BXoaKHActionPerformed
  
    public void loadKHList(){
        model = new DefaultTableModel();
        model.addColumn("Mã KH");
        model.addColumn("Họ tên");
        model.addColumn("Địa chỉ");
        model.addColumn("SĐT");
        model.addColumn("Giới tính");
        tableKH.setModel(model);
        ArrayList<DTOKhachHang> arr = new ArrayList<DTOKhachHang>();
        arr = BLLkh.BLLgetDL();
        for(int i = 0; i < arr.size(); i++){
            DTOKhachHang kh = arr.get(i);
            String id = kh.getMaKH();
            String name = kh.getTenKH();
            String address = kh.getDiaChi();
            String sdt = kh.getSDT();
            String gender = kh.getGender();
            Object[] row = {id,name,address,sdt,gender};
            model.addRow(row);
        }
    }
    
    private void BAddKHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BAddKHActionPerformed
        // TODO add your handling code here:
        try {
            if(textMaKH.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Mời bạn nhập mã khách hàng!");
            }
            else if(textHotenKH.getText().isEmpty()){
                JOptionPane.showMessageDialog(null, "Mời bạn nhập họ tên khách hàng!");
            }
            else if(textDiachiKH.getText().isEmpty()){
                JOptionPane.showMessageDialog(null, "Mời bạn nhập địa chỉ khách hàng!");
            }
            else if(textSodienthoaiKH.getText().isEmpty()){
                JOptionPane.showMessageDialog(null, "Mời bạn nhập số điện thoại khách hàng!");
            }
            else{
                DTOKhachHang kh = new DTOKhachHang();
                kh.setMaKH(textMaKH.getText());
                kh.setTenKH(textHotenKH.getText());
                kh.setGender((String) ComboBoxGenderKH.getSelectedItem());
                kh.setDiaChi(textDiachiKH.getText());
                kh.setSDT(textSodienthoaiKH.getText());
                JOptionPane.showMessageDialog(this,BLLkh.BLLthem(kh));
                loadKHList();
                textMaKH.setText("");
                textHotenKH.setText("");
                textDiachiKH.setText("");
                textSodienthoaiKH.setText("");
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Thông tin không hợp lệ");
        }        
    }//GEN-LAST:event_BAddKHActionPerformed

    private void textSodienthoaiKHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textSodienthoaiKHActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textSodienthoaiKHActionPerformed

    private void textHotenKHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textHotenKHActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textHotenKHActionPerformed

    private void textMaKHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textMaKHActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textMaKHActionPerformed

    private void updateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateButtonActionPerformed
        // TODO add your handling code here:
        int i=tableKH.getSelectedRow();
        DTOKhachHang kh = new DTOKhachHang();
        if (i>=0){
            kh.setMaKH(textMaKH.getText()); 
            kh.setTenKH(textHotenKH.getText());
            kh.setDiaChi(textDiachiKH.getText());
            kh.setSDT(textSodienthoaiKH.getText());
            kh.setGender(String.valueOf(ComboBoxGenderKH.getSelectedItem()));
        }  
        JOptionPane.showMessageDialog(this,BLLkh.BLLsua(kh));
        loadKHList();
        textMaKH.setText("");
        textHotenKH.setText("");
        textDiachiKH.setText("");
        textSodienthoaiKH.setText("");
    }//GEN-LAST:event_updateButtonActionPerformed

    private void textSearchMaKHMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_textSearchMaKHMouseClicked
        // TODO add your handling code here:
        textSearchMaKH.setText("");
    }//GEN-LAST:event_textSearchMaKHMouseClicked

    private void textSearchTenKHMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_textSearchTenKHMouseClicked
        // TODO add your handling code here:
        textSearchTenKH.setText("");
    }//GEN-LAST:event_textSearchTenKHMouseClicked

    private void textSearchMaKHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textSearchMaKHActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textSearchMaKHActionPerformed

    private void BtnSearchKHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnSearchKHActionPerformed
        // TODO add your handling code here:
        DTOKhachHang kh = BLLkh.BLLtim(textSearchMaKH.getText().trim());
        if (kh != null) {
            model = new DefaultTableModel();
            model.addColumn("Mã KH");
            model.addColumn("Họ tên");
            model.addColumn("Địa chỉ");
            model.addColumn("SĐT");
            model.addColumn("Giới tính");
            tableKH.setModel(model);
            Object[] row = {kh.getMaKH(),kh.getTenKH(),kh.getDiaChi(),kh.getSDT(),kh.getGender()};
            model.addRow(row);
        } else {
            JOptionPane.showMessageDialog(this, "Không tìm thấy mã khách hàng");
        }
    }//GEN-LAST:event_BtnSearchKHActionPerformed

    private void buttonHuyTimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonHuyTimActionPerformed
        // TODO add your handling code here:
        loadKHList();
    }//GEN-LAST:event_buttonHuyTimActionPerformed

    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GUIKhachHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUIKhachHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUIKhachHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUIKhachHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        GUIKhachHang kh = new GUIKhachHang();
        kh.setVisible(true);
        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new GUIKhachHang().setVisible(true);
//            }
//        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BAddKH;
    private javax.swing.JButton BXoaKH;
    private javax.swing.JButton BtnSearchKH;
    private javax.swing.JComboBox<String> ComboBoxGenderKH;
    private javax.swing.JButton buttonHuyTim;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel labelDiachiKH;
    private javax.swing.JLabel labelGenderKH;
    private javax.swing.JLabel labelHotenKH;
    private javax.swing.JLabel labelMaKH;
    private javax.swing.JLabel labelSodienthoaiKH;
    private javax.swing.JTable tableKH;
    private javax.swing.JTextField textDiachiKH;
    private javax.swing.JTextField textHotenKH;
    private javax.swing.JTextField textMaKH;
    private javax.swing.JTextField textSearchMaKH;
    private javax.swing.JTextField textSearchTenKH;
    private javax.swing.JTextField textSodienthoaiKH;
    private javax.swing.JButton updateButton;
    // End of variables declaration//GEN-END:variables
}
