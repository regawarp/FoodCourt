package foodcourt;

/*
 * Deskripsi    : Mengambil Orderan dari meja 
 * Author       : Cahya Ramadhan (171524007)
 * 
 */
//package package1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
//import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;

import java.util.Iterator;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//import javax.swing.DefaultListModel;
import javax.swing.table.DefaultTableModel;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
//import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author lenovo
 */
public class TakePesananDariMeja extends javax.swing.JFrame {

    private static final String EXCEL_FILE_LOCATION = ".\\file\\DATA_PESANAN_DARI_MEJA.xlsx";
    private static final String EXCEL_FILE_DATA_REKAP = ".\\file\\DATA_REKAP_PESANAN.xlsx";
    private static final int MAX_FOOD_COURT = 26;
    String selectedListMeja = " ";
    static XSSFRow row;

    /**
     * Creates new form Dashboard
     */
    public TakePesananDariMeja() {
        initComponents();
        XSSFSheet spreadsheet = null;
        FileInputStream fis;
        try {
            fis = new FileInputStream(new File(EXCEL_FILE_LOCATION));
            XSSFWorkbook workbook = new XSSFWorkbook(fis);
            spreadsheet = workbook.getSheetAt(0);
            fis.close();
        } catch (IOException e) {
            System.out.println("IOException : " + e);
        }
        SetGUI(spreadsheet);
    }

    private void SetGUI(XSSFSheet spreadsheet) {
        if(spreadsheet != null){
            Iterator<Row> rowIterator = spreadsheet.iterator();

            String[] ListMeja = new String[MAX_FOOD_COURT];
            int baris = 0;
            String temp = " ";
            row = (XSSFRow) rowIterator.next(); //pindah dari baris 0 ke baris 1
            while (rowIterator.hasNext()) {
                row = (XSSFRow) rowIterator.next();

                Cell cellTable = row.getCell(0);
                if (!cellTable.getStringCellValue().equals(temp)) {
                    ListMeja[baris] = cellTable.getStringCellValue();
                    temp = ListMeja[baris];
                    baris++;
                }
//                if(baris == 3){
//                    rowIterator = spreadsheet.iterator(); //pindah ke baris 0
//                    row = (XSSFRow) rowIterator.next(); //pindah dari baris 0 ke baris 1
//                }
            }
            JListTable.setListData(ListMeja);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        JTableMenuOrdered = new javax.swing.JTable();
        jScrollPane1 = new javax.swing.JScrollPane();
        JListTable = new javax.swing.JList<>();
        JNoteOrder = new javax.swing.JTextField();
        jButtonTakeOrder = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setAlwaysOnTop(true);

        JTableMenuOrdered.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        JTableMenuOrdered.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
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

        JListTable.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
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

        JNoteOrder.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        JNoteOrder.setText("Note :");

        jButtonTakeOrder.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jButtonTakeOrder.setText("Take Order");
        jButtonTakeOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonTakeOrderActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(148, 148, 148)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 634, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(JNoteOrder, javax.swing.GroupLayout.PREFERRED_SIZE, 634, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 433, Short.MAX_VALUE)
                        .addComponent(jButtonTakeOrder, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(210, 210, 210))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 365, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButtonTakeOrder, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JNoteOrder, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(52, 52, 52))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JListTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JListTableMouseClicked
        FileInputStream fis;
        try {
            fis = new FileInputStream(new File(EXCEL_FILE_LOCATION));

            XSSFWorkbook workbook = new XSSFWorkbook(fis);
            XSSFSheet spreadsheet = workbook.getSheetAt(0);
            Iterator<Row> rowIterator = spreadsheet.iterator();

            selectedListMeja = JListTable.getSelectedValue(); //tabel 1, tabel 2, dll

            DefaultTableModel dtm = new DefaultTableModel();
            dtm.addColumn("Nama Menu");
            dtm.addColumn("Quantity");
            dtm.addColumn("Keterangan");

            String tempMenuName;
            int tempQuantity;
            String tempKeterangan;
            String tempOrderNote = " ";

            row = (XSSFRow) rowIterator.next(); //pindah dari baris 0 ke baris 1
            while (rowIterator.hasNext()) {
                row = (XSSFRow) rowIterator.next();
                Cell cellMenu = row.getCell(1);
                Cell cellQuantity = row.getCell(2);
                Cell cellKeterangan = row.getCell(3);
                Cell cellOrderNote = row.getCell(4);
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
            JTableMenuOrdered.setModel(dtm);
            JNoteOrder.setText("Note :\n" + tempOrderNote);
            fis.close();
        } catch (IOException ex) {
            System.out.println("IOException : " + ex);
        } finally {

        }
    }//GEN-LAST:event_JListTableMouseClicked

    private void jButtonTakeOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonTakeOrderActionPerformed
        //WRITE KE FILE REKAP (BELUM BERHASIL)
        FileInputStream fileInOrderanMeja, fileInDataRekap;
        OutputStream fileOutOrderanMeja, fileOutDataRekap;
        try {
            fileInOrderanMeja = new FileInputStream(EXCEL_FILE_LOCATION);
            XSSFWorkbook workbookOrderanMeja = (XSSFWorkbook) WorkbookFactory.create(fileInOrderanMeja);
            XSSFSheet sheetInOrderanMeja = workbookOrderanMeja.getSheetAt(0);
            Iterator<Row> rowIteratorDataOrder = sheetInOrderanMeja.iterator();
            fileInOrderanMeja.close();
            
            fileInDataRekap = new FileInputStream(EXCEL_FILE_DATA_REKAP);
            XSSFWorkbook workbookDataRekap = (XSSFWorkbook) WorkbookFactory.create(fileInDataRekap);
            XSSFSheet sheetDataRekap = workbookDataRekap.getSheetAt(0);
            Iterator<Row> rowIteratorDataRekap = sheetDataRekap.iterator();
            fileInDataRekap.close();

            XSSFRow rowDataOrder, rowDataRekap;
            rowDataOrder = (XSSFRow) rowIteratorDataOrder.next(); //pindah ke baris 0

            String selectedNamaMeja = null;
            if(selectedListMeja != null)
                selectedNamaMeja = selectedListMeja; //table 1, table 2, dll
            int rowIndexSelectedMeja = getRowIndexOfId(sheetInOrderanMeja, selectedNamaMeja);
            
            for(int i = 0; i < rowIndexSelectedMeja; i++){
                rowDataOrder = (XSSFRow) rowIteratorDataOrder.next(); //pindah ke index selectedListMeja
            }

            Cell cellNamaMejaDataOrder = rowDataOrder.getCell(0);
            Cell cellMenuDataOrder = rowDataOrder.getCell(1);
            Cell cellQuantityDataOrder = rowDataOrder.getCell(2);

            // BUG, data TERAKHIR tidak terdeteksi
            // ex. data "Nasi Uduk" di file rekap
            //     data "ButaBara" di file order
            // kemungkinan bug di method rowIterator.hasNext();
            
            while (rowIteratorDataOrder.hasNext() && cellNamaMejaDataOrder.getStringCellValue().equals(selectedListMeja)) { //Selama "PUNYA" Next && sama, jadi kalo gak punya next, nilainya false
                boolean found = false;
                rowIteratorDataRekap = sheetDataRekap.iterator(); //pindah ke baris 0
                rowDataRekap = (XSSFRow) rowIteratorDataRekap.next(); //pindah ke baris 0
                rowDataRekap = (XSSFRow) rowIteratorDataRekap.next(); //pindah dari baris 0 ke baris 1

                while(rowIteratorDataRekap.hasNext() && !found){
                    Cell cellMenuDataRekap = rowDataRekap.getCell(0);
                    Cell cellQuantityDataRekap = rowDataRekap.getCell(1);
                    if(cellMenuDataOrder.getStringCellValue().equals(cellMenuDataRekap.getStringCellValue()) && !found){
//                        int tempQuantity = Integer.parseInt(String.valueOf(Math.round(cellQuantityDataRekap.getNumericCellValue())));
//                        System.out.println("Menu : " + cellMenuDataRekap.getStringCellValue() + " " + tempQuantity);
//                        cellQuantityDataRekap.setCellValue(Integer.parseInt(String.valueOf(Math.round(++tempQuantity))));
//
//                        System.out.println("Menu : " + cellMenuDataRekap.getStringCellValue() + " " + tempQuantity);
//                        System.out.println();
//                        found = true;
                        int tempQuantityDataRekap = Integer.parseInt(String.valueOf(Math.round(cellQuantityDataRekap.getNumericCellValue())));
                        int tempQuantityDataOrder = Integer.parseInt(String.valueOf(Math.round(cellQuantityDataOrder.getNumericCellValue())));
                        int QuantityTotal = tempQuantityDataRekap + tempQuantityDataOrder;

                        System.out.println("Menu : " + cellMenuDataRekap.getStringCellValue() + " " + tempQuantityDataRekap);
                        cellQuantityDataRekap.setCellValue(Integer.parseInt(String.valueOf(Math.round(QuantityTotal))));
                        System.out.println("Menu : " + cellMenuDataRekap.getStringCellValue() + " " + QuantityTotal);
                        System.out.println();
                        found = true;

                    }
                    rowDataRekap = (XSSFRow) rowIteratorDataRekap.next();
                }
                if(!found){
                    //tambah Row untuk data yang baru
                    System.out.println(cellMenuDataOrder.getStringCellValue() + " : NOT FOUND");
                }
                //write ke file ???
                fileOutDataRekap = new FileOutputStream(EXCEL_FILE_DATA_REKAP);
                workbookDataRekap.write(fileOutDataRekap); //sheet yang telah berubah, mereplace sheet yang ada di file (update file)
                sheetDataRekap = workbookDataRekap.getSheetAt(0);
                fileOutDataRekap.close();

                rowDataOrder = (XSSFRow) rowIteratorDataOrder.next();
                cellNamaMejaDataOrder = rowDataOrder.getCell(0);
                cellMenuDataOrder = rowDataOrder.getCell(1);
                cellQuantityDataOrder = rowDataOrder.getCell(2);
            }
            

            while(rowIndexSelectedMeja != -1){
                rowIndexSelectedMeja = getRowIndexOfId(sheetInOrderanMeja, selectedNamaMeja); //ambil index dari meja yang dipilih
                removeRow(sheetInOrderanMeja, rowIndexSelectedMeja); //delete row dari sheet
            }

            fileOutOrderanMeja = new FileOutputStream(EXCEL_FILE_LOCATION);
            workbookOrderanMeja.write(fileOutOrderanMeja); //sheet yang telah berubah, mereplace sheet yang ada di file (update file)
            XSSFSheet sheetOut = workbookOrderanMeja.getSheetAt(0);
            fileOutOrderanMeja.close();

            SetGUI(sheetOut); //update GUI
        } catch (IOException ex) {
            System.out.println("IOException : " + ex);
        } catch (InvalidFormatException ex) {
            System.out.println("InvalidFormatException : " + ex);
        } catch (EncryptedDocumentException ex){
            System.out.println("EncryptedDocumentException : " + ex);
        } finally {

        }

    }//GEN-LAST:event_jButtonTakeOrderActionPerformed

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
//      BEFORE : 
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new TakePesananDariMeja().setVisible(true);
//            }
//        });

//      AFTER :
        java.awt.EventQueue.invokeLater(() -> {
            new TakePesananDariMeja().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JList<String> JListTable;
    private javax.swing.JTextField JNoteOrder;
    private javax.swing.JTable JTableMenuOrdered;
    private javax.swing.JButton jButtonTakeOrder;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}

//                if(cell.getCellTypeEnum() == CellType.STRING){
//                    tempQuantity = cell.getNumericCellValue(); //harus jadiin INT
//                } else if(cell.getCellTypeEnum() == CellType.NUMERIC){
//                    tempMenuName = cell.getStringCellValue();
//                }
