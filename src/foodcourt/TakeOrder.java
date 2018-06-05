/*
 * Deskripsi    : Mengambil Orderan dari meja 
 * Author       : Cahya Ramadhan (171524007)
 * 
 */
package foodcourt;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author lenovo
 */
public class TakeOrder extends javax.swing.JFrame {

    private static final String EXCEL_FILE_DATA_PESANAN_MEJA = ".\\src\\data\\dataPesananDariMeja.xlsx";
    private static final String EXCEL_FILE_DATA_REKAP = ".\\src\\data\\dataRekapPesanan.xlsx";
    private static FileInputStream fileInDataPesananDariMeja = null, fileInDataRekapPesanan = null;
    private static OutputStream fileOutDataPesananDariMeja = null, fileOutDataRekap = null;
    private static final int MAX_FOOD_COURT = 26;
    private String selectedListMeja = " ";
    private String namaToko = "Aciap";
    private XSSFSheet sheetInDataPesananDariMeja = null, sheetInDataRekap = null;
    static XSSFRow row;

    public TakeOrder() {
        initComponents();
        OpenFile();
        SetGUI(sheetInDataPesananDariMeja);
    }
    public TakeOrder(String namaToko){
        initComponents();
        this.namaToko = namaToko;
        OpenFile();
        SetGUI(sheetInDataPesananDariMeja);
    }

    
    private void OpenFile(){
        try {
            fileInDataPesananDariMeja = new FileInputStream(new File(EXCEL_FILE_DATA_PESANAN_MEJA));
            XSSFWorkbook workbookInDataPesananDariMeja = new XSSFWorkbook(fileInDataPesananDariMeja);
            sheetInDataPesananDariMeja = GetSheetByNamaToko(workbookInDataPesananDariMeja, namaToko);
//            fileInDataPesananDariMeja.close();

            fileInDataRekapPesanan = new FileInputStream(new File(EXCEL_FILE_DATA_REKAP));
            XSSFWorkbook workbookInDataRekap = new XSSFWorkbook(fileInDataRekapPesanan);
            sheetInDataRekap = GetSheetByNamaToko(workbookInDataRekap, namaToko);
//            fileInDataRekapPesanan.close();

//            fileOutDataPesananDariMeja = new FileOutputStream(EXCEL_FILE_DATA_PESANAN_MEJA);
//            fileOutDataRekap = new FileOutputStream(EXCEL_FILE_DATA_REKAP);
        } catch (IOException ex) {
           System.out.println("IOException : " + ex);
        }
    }

    private XSSFSheet GetSheetByNamaToko(XSSFWorkbook workbookIn, String namaToko){
        XSSFSheet spreadsheet = null;
        String sheetName; boolean sheetFound = false;

        int indexSheet = 0;
        spreadsheet = workbookIn.getSheetAt(indexSheet);
        while(spreadsheet != null && !sheetFound){
            sheetName = spreadsheet.getSheetName();
            if(sheetName.equals(namaToko)){
                sheetFound = true;
            } else {
                indexSheet++;
                if(indexSheet < workbookIn.getNumberOfSheets()){ //hanya jika ada nama tokonya di file, baru bisa dijalankan
                    spreadsheet = workbookIn.getSheetAt(indexSheet);
                } else {
                    spreadsheet = null;
                }
            }
        }
        return spreadsheet;
    }
    
    private void SetGUI(XSSFSheet spreadsheet) {
        if(spreadsheet != null){
            JLabelNamaToko.setText(spreadsheet.getSheetName());
            Iterator<Row> rowIterator = spreadsheet.iterator();

            String[] ListMeja = new String[MAX_FOOD_COURT];
            int baris = 0;
            String temp = " ";
            XSSFRow row = (XSSFRow) rowIterator.next(); //pindah dari baris 0 ke baris 1
            while (rowIterator.hasNext()) {
                row = (XSSFRow) rowIterator.next();

                Cell cellTable = row.getCell(0);
                if(cellTable != null){
                    if (!cellTable.getStringCellValue().equals(temp)) {
                        ListMeja[baris] = cellTable.getStringCellValue();
                        temp = ListMeja[baris];
                        baris++;
                    }
                }
            }
            JListTable.setListData(ListMeja);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        JLabelNamaToko = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        JTableMenuOrdered = new javax.swing.JTable();
        JNoteOrder = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        JListTable = new javax.swing.JList<>();
        JButtonDashboard = new javax.swing.JButton();
        jButtonTakeOrder = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setAlwaysOnTop(true);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jPanel1.setBackground(new java.awt.Color(84, 82, 82));
        jPanel1.setPreferredSize(new java.awt.Dimension(1366, 768));

        jPanel2.setBackground(new java.awt.Color(84, 82, 82));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 5));

        JLabelNamaToko.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        JLabelNamaToko.setForeground(new java.awt.Color(255, 255, 255));
        JLabelNamaToko.setText("NAMA TOKO");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1336, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(573, 573, 573)
                    .addComponent(JLabelNamaToko)
                    .addContainerGap(543, Short.MAX_VALUE)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(26, 26, 26)
                    .addComponent(JLabelNamaToko)
                    .addContainerGap(26, Short.MAX_VALUE)))
        );

        jPanel3.setBackground(new java.awt.Color(150, 150, 150));
        jPanel3.setToolTipText("");

        JTableMenuOrdered.setBackground(new java.awt.Color(188, 188, 188));
        JTableMenuOrdered.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        JTableMenuOrdered.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        JTableMenuOrdered.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Nama Menu", "Quantity", "Keterangan"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(JTableMenuOrdered);

        JNoteOrder.setBackground(new java.awt.Color(188, 188, 188));
        JNoteOrder.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        JNoteOrder.setText("Note :");

        jScrollPane1.setBackground(new java.awt.Color(240, 0, 240));

        JListTable.setBackground(new java.awt.Color(188, 188, 188));
        JListTable.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        JListTable.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        JListTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JListTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(JListTable);

        JButtonDashboard.setBackground(new java.awt.Color(251, 218, 245));
        JButtonDashboard.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        JButtonDashboard.setText("Dashboard");
        JButtonDashboard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JButtonDashboardActionPerformed(evt);
            }
        });

        jButtonTakeOrder.setBackground(new java.awt.Color(231, 0, 0));
        jButtonTakeOrder.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jButtonTakeOrder.setForeground(new java.awt.Color(255, 255, 255));
        jButtonTakeOrder.setText("Take Order");
        jButtonTakeOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonTakeOrderActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(JNoteOrder, javax.swing.GroupLayout.PREFERRED_SIZE, 634, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonTakeOrder, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 634, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(JButtonDashboard, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(68, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 319, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JButtonDashboard, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(JNoteOrder, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonTakeOrder, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 552, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(118, 118, 118)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 578, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(70, 70, 70))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1346, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 890, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 810, Short.MAX_VALUE)
                .addGap(702, 702, 702))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JListTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JListTableMouseClicked
        if(sheetInDataPesananDariMeja != null){
            Iterator<Row> rowIterator = sheetInDataPesananDariMeja.iterator();
            selectedListMeja = JListTable.getSelectedValue(); //tabel 1, tabel 2, dll

            DefaultTableModel dtm = new DefaultTableModel();
            dtm.addColumn("Nama Menu");
            dtm.addColumn("Quantity");
            dtm.addColumn("Keterangan");

            String tempMenuName;
            int tempQuantity;
            String tempKeterangan;
            String tempOrderNote = " ";

            XSSFRow row = (XSSFRow) rowIterator.next(); //pindah dari baris 0 ke baris 1
            while (rowIterator.hasNext()) {
                row = (XSSFRow) rowIterator.next();
                Cell cellMenu = row.getCell(1);
                Cell cellQuantity = row.getCell(2);
                Cell cellKeterangan = row.getCell(3);
                Cell cellOrderNote = row.getCell(4);
                if(row.getCell(0) != null){
                    if (row.getCell(0).getStringCellValue().equals(selectedListMeja)) {
                        tempMenuName = cellMenu.getStringCellValue();
                        tempQuantity = Integer.parseInt(String.valueOf(Math.round(cellQuantity.getNumericCellValue())));
                        tempKeterangan = cellKeterangan != null ? cellKeterangan.getStringCellValue() : "        -";
                        tempOrderNote = cellOrderNote != null ? cellOrderNote.getStringCellValue() : " ";
                        Object[] rowData = new Object[]{
                            tempMenuName,
                            tempQuantity,
                            tempKeterangan
                        };
                        dtm.addRow(rowData);
                    }
                }
            }
            JTableMenuOrdered.setModel(dtm);
            JNoteOrder.setText("Note :\n" + tempOrderNote);
        }
    }//GEN-LAST:event_JListTableMouseClicked

    private void jButtonTakeOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonTakeOrderActionPerformed
        try {
            fileInDataPesananDariMeja = new FileInputStream(new File(EXCEL_FILE_DATA_PESANAN_MEJA));
            XSSFWorkbook workbookInOutDataPesananDariMeja = (XSSFWorkbook) WorkbookFactory.create(fileInDataPesananDariMeja);
            XSSFSheet sheetInDataPesananDariMeja = GetSheetByNamaToko(workbookInOutDataPesananDariMeja, namaToko);
            Iterator<Row> rowIteratorDataOrder = sheetInDataPesananDariMeja.iterator();

            fileInDataRekapPesanan = new FileInputStream(new File(EXCEL_FILE_DATA_REKAP));
            XSSFWorkbook workbookInOutDataRekapPesanan = (XSSFWorkbook) WorkbookFactory.create(fileInDataRekapPesanan);
            XSSFSheet sheetInDataRekap = GetSheetByNamaToko(workbookInOutDataRekapPesanan, namaToko);
            Iterator<Row> rowIteratorDataRekap = sheetInDataRekap.iterator();

            XSSFRow rowDataOrder, rowDataRekap;
            rowDataOrder = (XSSFRow) rowIteratorDataOrder.next(); //pindah ke baris 0

            String selectedNamaMeja = null;
            if(selectedListMeja != null)
                selectedNamaMeja = selectedListMeja; //table 1, table 2, dll
            int rowIndexSelectedMeja = getRowIndexOfId(sheetInDataPesananDariMeja, selectedNamaMeja);
            
            for(int i = 0; i < rowIndexSelectedMeja; i++){
                rowDataOrder = (XSSFRow) rowIteratorDataOrder.next(); //pindah ke index selectedListMeja
            }

            Cell cellNamaMejaDataOrder = rowDataOrder.getCell(0);
            Cell cellMenuDataOrder = rowDataOrder.getCell(1);
            Cell cellQuantityDataOrder = rowDataOrder.getCell(2);

            if(cellNamaMejaDataOrder != null && cellNamaMejaDataOrder.getStringCellValue().equals(selectedListMeja)){
                boolean found = false;
                rowIteratorDataRekap = sheetInDataRekap.iterator(); //pindah ke baris 0
                rowDataRekap = (XSSFRow) rowIteratorDataRekap.next(); //pindah ke baris 0

                while(rowIteratorDataRekap.hasNext() && !found){
                    rowDataRekap = (XSSFRow) rowIteratorDataRekap.next();
                    Cell cellMenuDataRekap = rowDataRekap.getCell(0);
                    Cell cellQuantityDataRekap = rowDataRekap.getCell(1);
                    if(cellMenuDataRekap != null){
                        if(cellMenuDataOrder.getStringCellValue().equals(cellMenuDataRekap.getStringCellValue()) && !found){
                            int tempQuantityDataRekap = Integer.parseInt(String.valueOf(Math.round(cellQuantityDataRekap.getNumericCellValue())));
                            int tempQuantityDataOrder = Integer.parseInt(String.valueOf(Math.round(cellQuantityDataOrder.getNumericCellValue())));
                            int QuantityTotal = tempQuantityDataRekap + tempQuantityDataOrder;

                            System.out.println("Menu : " + cellMenuDataRekap.getStringCellValue() + " " + tempQuantityDataRekap);
                            cellQuantityDataRekap.setCellValue(Integer.parseInt(String.valueOf(Math.round(QuantityTotal))));
                            System.out.println("Menu : " + cellMenuDataRekap.getStringCellValue() + " " + QuantityTotal);
                            System.out.println();
                            found = true;

                        }
                    }
                }
                if(!found){
                    System.out.println(cellMenuDataOrder.getStringCellValue() + " : NOT FOUND DI FILE REKAP");
                }
//                XSSFWorkbook workbookOutDataRekap = sheetInDataRekap.getWorkbook();
                fileOutDataRekap = new FileOutputStream(EXCEL_FILE_DATA_REKAP);
                workbookInOutDataRekapPesanan.write(fileOutDataRekap); //sheet yang telah berubah, mereplace sheet yang ada di file (update file)
                sheetInDataRekap = GetSheetByNamaToko(workbookInOutDataRekapPesanan, namaToko);
                fileOutDataRekap.close();
            }
            
            while (rowIteratorDataOrder != null && cellNamaMejaDataOrder != null && rowIteratorDataOrder.hasNext() && cellNamaMejaDataOrder.getStringCellValue().equals(selectedListMeja)) { //Selama "PUNYA" Next && sama, jadi kalo gak punya next, nilainya false
                rowDataOrder = (XSSFRow) rowIteratorDataOrder.next();
                cellNamaMejaDataOrder = rowDataOrder.getCell(0);
                cellMenuDataOrder = rowDataOrder.getCell(1);
                cellQuantityDataOrder = rowDataOrder.getCell(2);

                boolean found = false;
                rowIteratorDataRekap = sheetInDataRekap.iterator(); //pindah ke baris 0
                rowDataRekap = (XSSFRow) rowIteratorDataRekap.next(); //pindah ke baris 0

                while(rowIteratorDataRekap.hasNext() && !found){
                    rowDataRekap = (XSSFRow) rowIteratorDataRekap.next();
                    Cell cellMenuDataRekap = rowDataRekap.getCell(0);
                    Cell cellQuantityDataRekap = rowDataRekap.getCell(1);
                    if(cellMenuDataOrder.getStringCellValue().equals(cellMenuDataRekap.getStringCellValue()) && !found){
                        int tempQuantityDataRekap = Integer.parseInt(String.valueOf(Math.round(cellQuantityDataRekap.getNumericCellValue())));
                        int tempQuantityDataOrder = Integer.parseInt(String.valueOf(Math.round(cellQuantityDataOrder.getNumericCellValue())));
                        int QuantityTotal = tempQuantityDataRekap + tempQuantityDataOrder;

                        System.out.println("Menu : " + cellMenuDataRekap.getStringCellValue() + " " + tempQuantityDataRekap);
                        cellQuantityDataRekap.setCellValue(Integer.parseInt(String.valueOf(Math.round(QuantityTotal))));
                        System.out.println("Menu : " + cellMenuDataRekap.getStringCellValue() + " " + QuantityTotal);
                        System.out.println();
                        found = true;

                    }
                }
                if(!found){
                    System.out.println(cellMenuDataOrder.getStringCellValue() + " : NOT FOUND DI FILE REKAP");
                }
//                XSSFWorkbook workbookOutDataRekap = sheetInDataRekap.getWorkbook();
                fileOutDataRekap = new FileOutputStream(EXCEL_FILE_DATA_REKAP);
                workbookInOutDataRekapPesanan.write(fileOutDataRekap); //sheet yang telah berubah, mereplace sheet yang ada di file (update file)
                sheetInDataRekap = GetSheetByNamaToko(workbookInOutDataRekapPesanan, namaToko);
                fileOutDataRekap.close();
            }
            

            while(rowIndexSelectedMeja != -1){
                rowIndexSelectedMeja = getRowIndexOfId(sheetInDataPesananDariMeja, selectedNamaMeja); //ambil index dari meja yang dipilih
                removeRow(sheetInDataPesananDariMeja, rowIndexSelectedMeja); //delete row dari sheet
            }

//            XSSFWorkbook workbookOutDataPesananDariMeja = sheetInDataPesananDariMeja.getWorkbook();
            fileOutDataPesananDariMeja = new FileOutputStream(EXCEL_FILE_DATA_PESANAN_MEJA);
            workbookInOutDataPesananDariMeja.write(fileOutDataPesananDariMeja); //sheet yang telah berubah, mereplace sheet yang ada di file (update file)

            fileOutDataPesananDariMeja.close();
            SetGUI(sheetInDataPesananDariMeja); //update GUI
        } catch (IOException ex) {
            System.out.println("IOException :  " + ex);
//        } catch (InvalidFormatException ex) {
//            System.out.println("InvalidFormatException : " + ex);
        } catch (EncryptedDocumentException ex){
            System.out.println("EncryptedDocumentException : " + ex);
        } catch (InvalidFormatException ex) {
            Logger.getLogger(TakeOrder.class.getName()).log(Level.SEVERE, null, ex);
        } finally {

        }
    }//GEN-LAST:event_jButtonTakeOrderActionPerformed

    private void JButtonDashboardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JButtonDashboardActionPerformed
        new DashboardToko(this.namaToko).setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_JButtonDashboardActionPerformed

    private static int getRowIndexOfId(XSSFSheet sheet, String selectedid) {
        DataFormatter formatter = new DataFormatter();
        for (Row selectedRow : sheet) {
            for (Cell cell : selectedRow) {
                if (formatter.formatCellValue(cell).trim().equals(selectedid)) {
                    return selectedRow.getRowNum();
                }
            }
        }
        return -1;
    }

    private static void removeRow(XSSFSheet sheet, int rowIndex) {
        if (rowIndex >= 0) {
            sheet.removeRow(sheet.getRow(rowIndex));
            if (rowIndex < sheet.getLastRowNum()) {
                sheet.shiftRows(rowIndex + 1, sheet.getLastRowNum(), -1);
            }
        }
    }

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
            System.out.println("ClassNotFoundException : " + ex);
        } catch (InstantiationException ex) {
            System.out.println("InstantiationException : " + ex);
        } catch (IllegalAccessException ex) {
            System.out.println("IllegalAccessException : " + ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            System.out.println("javax.swing.UnsupportedLookAndFeelException : " + ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new TakeOrder().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JButtonDashboard;
    private javax.swing.JLabel JLabelNamaToko;
    private javax.swing.JList<String> JListTable;
    private javax.swing.JTextField JNoteOrder;
    private javax.swing.JTable JTableMenuOrdered;
    private javax.swing.JButton jButtonTakeOrder;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}