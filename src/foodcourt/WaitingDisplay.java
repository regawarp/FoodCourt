/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package foodcourt;

import foodcourt.dashboard.data.Penjualan;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableModel;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author Tiara Lestari
 */
public class WaitingDisplay extends javax.swing.JFrame {

    Timer tm;
    int x = 0;
    String[] pics = {
        "1.jpg",
        "2.jpg",
        "3.jpg",
        "4.jpg",
        "5.jpg"
    };
    String[] text = {
        "Makanan siang hari",
        "Untuk sarapan enak nih",
        "Chicken wrapz",
        "Tomato soup",
        "Cheese chicken"
    };

    /**
     * Creates new form WaitingDisplay
     *
     * @throws java.io.IOException
     */
    public WaitingDisplay() throws IOException {
        initComponents();
        DisplayBill();
        SlideShow();
        PopUp.setVisible(false);
    }

    private void DisplayBill() throws FileNotFoundException, IOException {
        int total = 0;

        String nama = null;
        int qty = 0, harga = 0;

        XSSFRow row;
        FileInputStream fis;
        DefaultTableModel table = new DefaultTableModel();

        fis = new FileInputStream(new File("src//data//dataBill.xlsx"));
        try (XSSFWorkbook wb = new XSSFWorkbook(fis)) {
            XSSFSheet sheet = wb.getSheetAt(0);

            table.addColumn(" ");
            table.addColumn(" ");
            table.addColumn(" ");
            Bill.setRowHeight(20);

            Iterator< Row> rowIterator = sheet.rowIterator();
            row = (XSSFRow) rowIterator.next();
            while (rowIterator.hasNext()) {
                row = (XSSFRow) rowIterator.next();

                nama = row.getCell(1).getStringCellValue();
                qty = (int) row.getCell(2).getNumericCellValue();
                harga = (int) row.getCell(3).getNumericCellValue();

                total += harga;

                Object[] data = new Object[]{
                    nama, qty, harga
                };
                table.addRow(data);
            }
            Object[] space = new Object[]{
                " ", " ", " "
            };
            table.addRow(space);
            Object[] rowData = new Object[]{
                "Total", " ", total * 1
            };
            table.addRow(rowData);
            for (int i = 0; i < 6; i++) {
                table.addRow(space);
            }
            Bill.setModel(table);
            Bill.getColumnModel().getColumn(0).setPreferredWidth(150);
            Bill.getColumnModel().getColumn(1).setPreferredWidth(10);
            Bill.getColumnModel().getColumn(2).setPreferredWidth(50);
            Bill.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
            Bill.setBackground(Color.WHITE);
            JTableHeader header = Bill.getTableHeader();
            header.setVisible(false);
            header.setBackground(Color.WHITE);

        }
    }

    private void SlideShow() {
        Text.setBackground(new Color(26, 26, 26, 150));
        Text.setOpaque(true);
        SetImageSize(4);
        Text.setText(text[4]);

        tm = new Timer(750, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                SetImageSize(x);
                Text.setText(text[x]);
                x += 1;
                if (x >= pics.length) {
                    x = 0;
                }
            }
        });
        tm.start();
    }

    public void SetImageSize(int i) {
        ImageIcon icon = new ImageIcon("src//foodcourt//images//" + pics[i]);
        Image img = icon.getImage();
        Image newImg = img.getScaledInstance(Display.getWidth(), Display.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon newIcon = new ImageIcon(newImg);
        Display.setIcon(newIcon);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        PrintBill = new javax.swing.JButton();
        AddMenu = new javax.swing.JButton();
        Text = new javax.swing.JLabel();
        PopUp = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        Display = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        Bill = new javax.swing.JTable();
        newPanel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(26, 26, 26));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        mainPanel.setBackground(new java.awt.Color(26, 26, 26));
        mainPanel.setMinimumSize(new java.awt.Dimension(1366, 734));
        mainPanel.setPreferredSize(new java.awt.Dimension(1366, 768));
        mainPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 50)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Please Wait for Your Order");
        mainPanel.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 40, -1, -1));

        PrintBill.setBackground(new java.awt.Color(67, 1, 2));
        PrintBill.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        PrintBill.setForeground(new java.awt.Color(255, 255, 255));
        PrintBill.setText("Print Bill");
        PrintBill.setPreferredSize(new java.awt.Dimension(150, 50));
        PrintBill.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PrintBillMouseClicked(evt);
            }
        });
        PrintBill.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PrintBillActionPerformed(evt);
            }
        });
        mainPanel.add(PrintBill, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 640, -1, -1));

        AddMenu.setBackground(new java.awt.Color(67, 1, 2));
        AddMenu.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        AddMenu.setForeground(new java.awt.Color(255, 255, 255));
        AddMenu.setText("Add Menu");
        AddMenu.setPreferredSize(new java.awt.Dimension(150, 50));
        AddMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddMenuActionPerformed(evt);
            }
        });
        mainPanel.add(AddMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(1170, 640, -1, -1));

        Text.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        Text.setForeground(new java.awt.Color(255, 255, 255));
        mainPanel.add(Text, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 570, 790, 70));

        PopUp.setBackground(new java.awt.Color(67, 1, 2));
        PopUp.setForeground(new java.awt.Color(255, 255, 255));
        PopUp.setLayout(new java.awt.GridBagLayout());

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("PLEASE WAIT");
        PopUp.add(jLabel2, new java.awt.GridBagConstraints());

        mainPanel.add(PopUp, new org.netbeans.lib.awtextra.AbsoluteConstraints(433, 242, 500, 250));
        mainPanel.add(Display, new org.netbeans.lib.awtextra.AbsoluteConstraints(51, 136, 900, 550));

        jPanel1.setLayout(new java.awt.BorderLayout());

        Bill.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        Bill.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        Bill.getTableHeader().setReorderingAllowed(false);
        jPanel1.add(Bill, java.awt.BorderLayout.CENTER);

        mainPanel.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 60, 310, 550));

        getContentPane().add(mainPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1370, 800));

        newPanel.setBackground(new java.awt.Color(26, 26, 26));
        newPanel.setPreferredSize(new java.awt.Dimension(1366, 800));
        getContentPane().add(newPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void PrintBillActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PrintBillActionPerformed

    }//GEN-LAST:event_PrintBillActionPerformed

    private void AddMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddMenuActionPerformed
        new Toko().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_AddMenuActionPerformed

    private void PrintBillMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PrintBillMouseClicked
        try {
            FileInputStream fis = null;
            XSSFRow row = null;
            FileOutputStream out = null;
            Cell cell = null;

            fis = new FileInputStream(new File("src/data/dataBill.xlsx"));
            XSSFWorkbook workbook = new XSSFWorkbook(fis);
            XSSFSheet spreadsheet = workbook.getSheetAt(0);

            ArrayList<Penjualan> pj = new ArrayList<>();
            Penjualan penjualan = new Penjualan();
            int i;
            for (i = spreadsheet.getLastRowNum(); i > 0; i--) {
                row = spreadsheet.getRow(i);
                penjualan.setToko(row.getCell(0).getStringCellValue());
                penjualan.setHarga(row.getCell(3).getNumericCellValue());
                spreadsheet.removeRow(row);

                if (pj.contains(penjualan)) {
                    int j = pj.indexOf(penjualan);
                    pj.get(j).setHarga(pj.get(j).getHarga() + penjualan.getHarga());
                    System.out.println("\n"+j);
                } else {
                    pj.add(penjualan);
                }
            }

            out = new FileOutputStream(new File("src/data/dataBill.xlsx"));
            workbook.write(out);
            out.close();
            fis.close();

            /*
            Bagian menulis ke excel transaksi
             */
            for (i = 0; i < pj.size(); i++) {
                System.out.println("Harga : " + pj.get(i).getHarga() + " - " + pj.get(i).getToko());
            }

            Date today = new Date();
            fis = null;
            out = null;
            row = null;
            cell = null;
            spreadsheet = null;
            int countRow = 0;

            // GOTO LAST ROW
            fis = new FileInputStream(new File("src/data/dataTransaksi.xlsx"));
            workbook = new XSSFWorkbook(fis);
            spreadsheet = workbook.getSheet("" + (today.getYear() + 1900));
            countRow = spreadsheet.getLastRowNum();
            row = spreadsheet.getRow(countRow);
            cell = row.getCell(1);
            String id = cell.getStringCellValue();
            int idNum = Integer.parseInt(id.substring(5)) + 1;
            System.out.println("nilai idnum : " + idNum);

            countRow++;

            for (i = 0; i < pj.size(); i++) {
                row = spreadsheet.createRow(countRow++);
                cell = row.createCell(0);
                cell.setCellValue(today);
                cell = row.createCell(1);
                cell.setCellValue("#ID" + String.format("%02d", today.getDate()) + String.format("%03d", idNum));
                cell = row.createCell(2);
                cell.setCellValue(pj.get(i).getToko());
                cell = row.createCell(3);
                cell.setCellValue(pj.get(i).getHarga());
            }

            out = new FileOutputStream(new File("src/data/dataTransaksi.xlsx"));
            workbook.write(out);
            out.close();
            fis.close();
            DisplayBill();
        } catch (IOException ex) {
            Logger.getLogger(WaitingDisplay.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_PrintBillMouseClicked

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
            java.util.logging.Logger.getLogger(WaitingDisplay.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(WaitingDisplay.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(WaitingDisplay.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(WaitingDisplay.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            try {
                new WaitingDisplay().setVisible(true);
            } catch (IOException ex) {
                Logger.getLogger(WaitingDisplay.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddMenu;
    private javax.swing.JTable Bill;
    private javax.swing.JLabel Display;
    private javax.swing.JPanel PopUp;
    private javax.swing.JButton PrintBill;
    private javax.swing.JLabel Text;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JPanel newPanel;
    // End of variables declaration//GEN-END:variables
}
