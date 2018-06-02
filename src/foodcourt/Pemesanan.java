/*
 * Copyright May - 2018
 * JTK POLBAN.
 * Made in Ciwaruga.
 */
package foodcourt;

import java.awt.Color;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Iterator;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author ASUS
 */
public class Pemesanan extends javax.swing.JFrame {

    /**
     * Creates new form Pemesanan
     * @throws java.io.IOException
     */
    public String namaResto;
    
    public Pemesanan() throws IOException {
        initComponents();
        jPanel3.setBackground(new Color(101,101,101,200));
        ReadExcelFile();
        accDelete_pane.setVisible(false);
        accBuy_pane.setVisible(false);
        warnKosong_pane.setVisible(false);
    }
    
    public Pemesanan(String namaResto) throws IOException{
        this.namaResto=namaResto;
        System.out.println(this.namaResto);
        initComponents();
        jPanel3.setBackground(new Color(101,101,101,200));
        ReadExcelFile();
        accDelete_pane.setVisible(false);
        accBuy_pane.setVisible(false);
        warnKosong_pane.setVisible(false);
        
    }
    
    
    /*
     * Modul untuk membaca data dair excel
     */
    private void ReadExcelFile() throws FileNotFoundException, IOException {
        XSSFRow row;
        FileInputStream fis = new FileInputStream(new File("src/data/DataMakanan12Resto.xlsx"));       
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet spreadsheet = workbook.getSheet(this.namaResto);
        Iterator< Row> rowIterator = spreadsheet.iterator();
        
        jLabel1.setText("Toko  " + this.namaResto);
  
        
        DefaultTableModel dtm = new DefaultTableModel();
        dtm.addColumn("Nama");
        dtm.addColumn("Jenis");
        dtm.addColumn("Harga");

        row = (XSSFRow) rowIterator.next();
        while (rowIterator.hasNext()) {
            row = (XSSFRow) rowIterator.next();
            Iterator< Cell> cellIterator = row.cellIterator();

            Cell cell = cellIterator.next();
            String nama, kategori;
            double harga;

            nama = cell.getStringCellValue();
            cell = cellIterator.next();
            kategori = cell.getStringCellValue();
            cell = cellIterator.next();
            harga = cell.getNumericCellValue();

            Object[] data = new Object[]{
                nama, kategori, harga
            };

            
            dtm.addRow(data);
        }
        jTable1.setModel(dtm);
        if (workbook != null) {
            workbook.close();
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

        jPanel8 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        accDelete_pane = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        tobeDeletedName = new javax.swing.JLabel();
        warnKosong_pane = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jPanel16 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        accBuy_pane = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jPanel14 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        jSpinner1 = new javax.swing.JSpinner();
        jButton1 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jPanel6 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        bayar_total = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        pajak = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        harga = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        btn_exit = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jPanel11.setBackground(new java.awt.Color(255, 153, 153));

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 120, Short.MAX_VALUE)
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(1366, 768));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(102, 102, 102));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Pesanan");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 60, -1, -1));

        accDelete_pane.setBackground(new java.awt.Color(255, 204, 153));
        accDelete_pane.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 0, 0), 7));
        accDelete_pane.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Yakin ingin menghapus item ini dari list ?");
        accDelete_pane.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 440, 40));

        jPanel10.setBackground(new java.awt.Color(102, 153, 0));
        jPanel10.setForeground(new java.awt.Color(255, 255, 255));
        jPanel10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel10MouseClicked(evt);
            }
        });
        jPanel10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("HAPUS");
        jLabel11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel11MouseClicked(evt);
            }
        });
        jPanel10.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 110, 40));

        accDelete_pane.add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 150, 110, 40));

        jPanel12.setBackground(new java.awt.Color(255, 102, 102));
        jPanel12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel12MouseClicked(evt);
            }
        });
        jPanel12.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel10.setBackground(new java.awt.Color(255, 153, 153));
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("BATAL");
        jLabel10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel10MouseClicked(evt);
            }
        });
        jPanel12.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, 0, 110, 40));

        accDelete_pane.add(jPanel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 150, 110, 40));

        tobeDeletedName.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        tobeDeletedName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tobeDeletedName.setText("jLabel12");
        accDelete_pane.add(tobeDeletedName, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 90, 320, -1));
        tobeDeletedName.getAccessibleContext().setAccessibleName("tobeDeletedName");

        jPanel3.add(accDelete_pane, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 120, -1, 220));

        warnKosong_pane.setBackground(new java.awt.Color(255, 204, 153));
        warnKosong_pane.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 0, 0), 7));
        warnKosong_pane.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setText("Anda belum memesan!");
        warnKosong_pane.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 440, 40));

        jPanel16.setBackground(new java.awt.Color(102, 153, 0));
        jPanel16.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel16MouseClicked(evt);
            }
        });
        jPanel16.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel18.setBackground(new java.awt.Color(255, 153, 153));
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel18.setText("OK");
        jLabel18.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel18MouseClicked(evt);
            }
        });
        jPanel16.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 110, 40));

        warnKosong_pane.add(jPanel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 140, 110, 40));

        jPanel3.add(warnKosong_pane, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 120, -1, 220));

        accBuy_pane.setBackground(new java.awt.Color(255, 204, 153));
        accBuy_pane.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 0, 0), 7));
        accBuy_pane.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("Apakah anda sudah selesai memesan?");
        accBuy_pane.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 440, 40));

        jPanel13.setBackground(new java.awt.Color(102, 153, 0));
        jPanel13.setForeground(new java.awt.Color(255, 255, 255));
        jPanel13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel13MouseClicked(evt);
            }
        });
        jPanel13.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("YA");
        jLabel13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel13MouseClicked(evt);
            }
        });
        jPanel13.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 110, 40));

        accBuy_pane.add(jPanel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 150, 110, 40));

        jPanel14.setBackground(new java.awt.Color(255, 102, 102));
        jPanel14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel14MouseClicked(evt);
            }
        });
        jPanel14.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel14.setBackground(new java.awt.Color(255, 153, 153));
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("BATAL");
        jLabel14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel14MouseClicked(evt);
            }
        });
        jPanel14.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, 0, 110, 40));

        accBuy_pane.add(jPanel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 150, 110, 40));

        jPanel3.add(accBuy_pane, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 120, -1, 220));

        jTable1.setAutoCreateRowSorter(true);
        jTable1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jTable1.setAutoscrolls(false);
        jTable1.setRowHeight(24);
        jTable1.setRowMargin(4);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jPanel3.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 120, -1, 220));

        jLabel4.setFont(new java.awt.Font("Tahoma", 2, 16)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Pilih makanan pada list berikut, lalu tekan tambah!");
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 90, 450, -1));

        jTextArea2.setColumns(20);
        jTextArea2.setRows(5);
        jTextArea2.setText("masukkan catatan disini");
        jTextArea2.setToolTipText("");
        jTextArea2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextArea2MouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jTextArea2);

        jPanel3.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 360, 340, 100));

        jSpinner1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jSpinner1.setModel(new javax.swing.SpinnerNumberModel(1, 1, 50, 1));
        jSpinner1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel3.add(jSpinner1, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 360, 100, 50));

        jButton1.setText("Tambah");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        jPanel3.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 420, 100, 40));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Makanan");
        jPanel3.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 50, -1, -1));

        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Nama");
        model.addColumn("Jumlah");
        model.addColumn("Harga");
        model.addColumn("Catatan");
        jTable2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jTable2.setModel(model);
        jTable2.setRowHeight(20);
        jTable2.getColumnModel().getColumn(3).setMinWidth(0);
        jTable2.getColumnModel().getColumn(3).setMaxWidth(0);
        jScrollPane2.setViewportView(jTable2);

        jPanel3.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 120, 350, 140));

        jPanel6.setBackground(new java.awt.Color(204, 0, 0));
        jPanel6.setForeground(new java.awt.Color(255, 255, 255));
        jPanel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel6MouseClicked(evt);
            }
        });
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Hapus");
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel6MouseClicked(evt);
            }
        });
        jPanel6.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 70, 40));

        jPanel3.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 220, 70, 40));

        jPanel7.setBackground(new java.awt.Color(153, 204, 0));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Pesan Sekarang >");
        jLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel7MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel7MousePressed(evt);
            }
        });
        jPanel7.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 6, 170, 40));

        jPanel3.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 410, 180, 50));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Total                             :");
        jPanel3.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 370, -1, -1));

        bayar_total.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        bayar_total.setForeground(new java.awt.Color(255, 255, 153));
        bayar_total.setText("Rp. 0,-");
        jPanel3.add(bayar_total, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 370, 180, -1));

        jLabel15.setFont(new java.awt.Font("Tahoma", 2, 16)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("makanan yang sudah dipilh akan masuk ke sini..");
        jPanel3.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 90, -1, -1));

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Pajak  (0%)                       :");
        jPanel3.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 320, 240, -1));

        pajak.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        pajak.setForeground(new java.awt.Color(255, 255, 153));
        pajak.setText("Rp. 0,-");
        jPanel3.add(pajak, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 320, 180, -1));

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("Harga total                         :");
        jPanel3.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 290, -1, -1));

        harga.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        harga.setForeground(new java.awt.Color(255, 255, 153));
        harga.setText("Rp. 0,-");
        jPanel3.add(harga, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 290, 180, -1));
        jPanel3.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 360, 440, 20));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 160, 1200, 520));

        jPanel2.setBackground(new java.awt.Color(51, 51, 51));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/foodcourt/images/Untitled-2.png"))); // NOI18N
        jLabel2.setText("jLabel2");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(9, 15, 660, 660));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 350, 590, 420));

        jPanel4.setBackground(new java.awt.Color(153, 0, 0));

        btn_exit.setBackground(new java.awt.Color(255, 0, 51));
        btn_exit.setFont(new java.awt.Font("Tahoma", 1, 22)); // NOI18N
        btn_exit.setForeground(new java.awt.Color(255, 255, 255));
        btn_exit.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btn_exit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/foodcourt/images/icons8_Back_25px.png"))); // NOI18N
        btn_exit.setText("  Back");
        btn_exit.setAutoscrolls(true);
        btn_exit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_exitMousePressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btn_exit, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addComponent(btn_exit, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 700, 140, 50));

        jPanel5.setBackground(new java.awt.Color(51, 51, 51));
        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 3));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 64)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("NAMA RESTORAN");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1354, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel1)
                .addContainerGap(28, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 0, 1390, 140));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_exitMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_exitMousePressed
        new Toko().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btn_exitMousePressed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked

    }//GEN-LAST:event_jTable1MouseClicked

    /*
     * Modul ini digunakan untuk menambah dari daftar tabel kiri ke kanan
     */
    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        DefaultTableModel model;
        model = (DefaultTableModel) jTable2.getModel();      
        double total=0;
        int selectedRowIndex = jTable1.getSelectedRow();
        String nama = (String) jTable1.getValueAt(selectedRowIndex, 0);
        double harga = (double) jTable1.getValueAt(selectedRowIndex, 2);
        int jumlah = (int) jSpinner1.getValue();
        harga = harga*jumlah;
        String catatan = jTextArea2.getText();
        Object[] data = new Object[]{
          nama, jumlah, harga, catatan  
        };
        
        model.addRow(data);
        for(int i=0; i<model.getRowCount(); i++){
            total+=Double.parseDouble(model.getValueAt(i, 2).toString());
        }
        jTable2.setModel(model);
        this.harga.setText("Rp. "+ Format_Number(total) +",-");
        this.pajak.setText("Rp. "+ Format_Number(total*0.1) +",-");
        this.bayar_total.setText("Rp. "+ Format_Number(total*1.1) +",-");
        
        
        //kembalikan spinner dan textarea ke default
        jSpinner1.setValue(1);
        jTextArea2.setText("Masukkan catatan disini");
        jPanel1.repaint();
        jPanel1.validate();
    }//GEN-LAST:event_jButton1MouseClicked


    private void jPanel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel6MouseClicked
    }//GEN-LAST:event_jPanel6MouseClicked

    /*
     * Mengosongkan kembali text area
     */
    private void jTextArea2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextArea2MouseClicked
        jTextArea2.setText("");
    }//GEN-LAST:event_jTextArea2MouseClicked
    
    
    private void jPanel10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel10MouseClicked
    }//GEN-LAST:event_jPanel10MouseClicked

    
    private void jPanel12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel12MouseClicked
    }//GEN-LAST:event_jPanel12MouseClicked

    /*
        Menutup kembali pop up, batal menghapus
    */
    private void jLabel10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MouseClicked
        accDelete_pane.setVisible(false);
        jPanel3.setBackground(new Color(101,101,101,200));

        accDelete_pane.setVisible(false);
        jPanel1.validate();
        jPanel1.repaint();
        jPanel1.validate();
    }//GEN-LAST:event_jLabel10MouseClicked

    /*
        Modul ini digunakan untuk menghapus dari daftar makanan yang sudah dipesan (kiri)
    */
    private void jLabel11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel11MouseClicked
        double total=0;
        
        DefaultTableModel dtm = (DefaultTableModel) jTable2.getModel();
        dtm.removeRow(jTable2.getSelectedRow());
        jTable2.setModel(dtm);
        
        for(int i=0; i<dtm.getRowCount(); i++){
            total+=Double.parseDouble(dtm.getValueAt(i, 2).toString());
        }
        this.harga.setText("Rp. "+ Format_Number(total) +",-");
        this.pajak.setText("Rp. "+ Format_Number(total*0.1) +",-");
        this.bayar_total.setText("Rp. "+ Format_Number(total*1.1) +",-");
        
        accDelete_pane.setVisible(false);
        jPanel1.validate();
        jPanel1.repaint();
        jPanel1.validate();
    }//GEN-LAST:event_jLabel11MouseClicked

    /*
       Menampilkan pop up untuk meyakinkan apakaah akan menghapus atau tidak
    */
    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
        accDelete_pane.setVisible(true);
        DefaultTableModel dtm;
        dtm = (DefaultTableModel) jTable2.getModel();
        tobeDeletedName.setText((String) dtm.getValueAt(jTable2.getSelectedRow(), 0));
    }//GEN-LAST:event_jLabel6MouseClicked


    /*
        Jadi memproses makanan
    */
    private void jLabel13MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel13MouseClicked
        writeToExcel();
        new WaitingDisplay().setVisible(true);
        super.setVisible(false);
    }//GEN-LAST:event_jLabel13MouseClicked

    private void jPanel13MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel13MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel13MouseClicked

    /*
        Batal memproses tutup kembali popup
    */
    private void jLabel14MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel14MouseClicked
        accBuy_pane.setVisible(false);
        jPanel1.validate();
        jPanel1.repaint();
        jPanel1.validate();
    }//GEN-LAST:event_jLabel14MouseClicked

    private void jPanel14MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel14MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel14MouseClicked

    private void jLabel7MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel7MousePressed

    private void jPanel16MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel16MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel16MouseClicked

    private void jLabel18MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel18MouseClicked
        warnKosong_pane.setVisible(false);
    }//GEN-LAST:event_jLabel18MouseClicked
    
    /*
        Sebelum memesan, pastikan user sudah selesai memilih
    */
    private void jLabel7MouseClicked(java.awt.event.MouseEvent evt) {                                     
        if(!tableEmpty(jTable2))
            accBuy_pane.setVisible(true);
        else warnKosong_pane.setVisible(true);
    }       
    /*
     * Modul untuk menulis ke file excel
     */
    private void writeToExcel(){
        
    }
    
    /*
     * Modul untuk mengecek apakah tabel di kanan kosong
     */
    private boolean tableEmpty(javax.swing.JTable j){
        DefaultTableModel dtm = (DefaultTableModel) j.getModel();
        return dtm.getRowCount()==0;
    }
    
    

    /*
     * Modul Format_Number untuk memformat bilangan dilengkapi dengan titik
     */
    String Format_Number(double number){
        DecimalFormat df = new DecimalFormat("#,##0",new DecimalFormatSymbols(new Locale("pt", "ID")));
        BigDecimal value = new BigDecimal(number);

        return String.valueOf(df.format(value.floatValue()));
    }
    
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
            java.util.logging.Logger.getLogger(Pemesanan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Pemesanan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Pemesanan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Pemesanan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
                try {
                    new Pemesanan().setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(Pemesanan.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel accBuy_pane;
    private javax.swing.JPanel accDelete_pane;
    private javax.swing.JLabel bayar_total;
    private javax.swing.JLabel btn_exit;
    private javax.swing.JLabel harga;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JLabel pajak;
    private javax.swing.JLabel tobeDeletedName;
    private javax.swing.JPanel warnKosong_pane;
    // End of variables declaration//GEN-END:variables
}
