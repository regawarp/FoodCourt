/*
 * Copyright May - 2018
 * JTK POLBAN.
 * Made in Ciwaruga.
 */
package foodcourt.dashboard;

import foodcourt.dashboard.data.*;
import java.awt.Color;
import java.awt.Dimension;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

/**
 *
 * @author ASUS
 */
public class statistik extends javax.swing.JPanel {

    String tokoTerlaris = "";
    int jmlTransaksiBulanan = 0;
    double pendapatan = 0;

    /**
     * Creates new form penjualan
     *
     * @throws java.io.IOException
     */
    public statistik() throws IOException {
        initComponents();
        firstLoad();
    }

    private void firstLoad() throws IOException {
        Date today = new Date();

        ArrayList<TransaksiHarian> tHr = new ArrayList<>();
        ArrayList<TransaksiHarian> tHrBef = new ArrayList<>();
        loadDataExcel("" + (today.getYear() + 1900), today.getMonth()+1, tHr);
        loadDataExcel("" + (today.getYear() + 1900), today.getMonth(), tHrBef);

        JPanel panel1 = loadPie(today.getMonth(), tHr);
        panel1.setPreferredSize(new Dimension(10, 10));
        jPanel5.add(panel1);
        jPanel5.repaint();
        jPanel5.revalidate();

        JPanel panel2 = loadLine(today.getMonth(), tHr);
        panel2.setPreferredSize(new Dimension(10, 10));
        jPanel6.add(panel2);
        jPanel6.repaint();
        jPanel6.revalidate();

        this.jComboBox1.setSelectedIndex(today.getMonth());

        this.lbl_pendapatan.setText("Rp." + Format_Number(hitungPemasukanBulanan(tHr)) + ",-");
        this.lbl_tokoTerlaris.setText(cariTokoTerlaris(tHr));
        this.lbl_jmlTransaksi.setText("" + hitungJumlahTransaksi(tHr));

        double presentase = hitungPemasukanBulanan(tHr) - hitungPemasukanBulanan(tHrBef);
        presentase /= hitungPemasukanBulanan(tHr);
        presentase *= 100;
        if (presentase < 0) {
            this.jLabel5.setText("Penjualan menurun " + presentase + "%");
            this.jLabel5.setForeground(new Color(153, 0, 0));
            this.jLabel8.setForeground(new Color(153, 0, 0));
        } else {
            this.jLabel5.setText("Penjualan meningkat " + presentase + "%");
            this.jLabel5.setForeground(new Color(0, 102, 0));
            this.jLabel8.setForeground(new Color(0, 102, 0));
        }

    }

    public void loadDataExcel(String Tahun, int Bulan, ArrayList<TransaksiHarian> dt) throws FileNotFoundException, IOException {

        FileInputStream fis;
        fis = new FileInputStream(new File("src/data/dataTransaksi.xlsx"));
        List<ObjekTransaksi> listTransaksi;
        try (XSSFWorkbook workbook = new XSSFWorkbook(fis)) {
            XSSFSheet spreadsheet = workbook.getSheet(Tahun);
//            XSSFSheet spreadsheet = workbook.getSheetAt(0);
            Iterator<Row> rowIterator = spreadsheet.iterator();
            XSSFRow row;
            row = (XSSFRow) rowIterator.next();
            Iterator<Cell> cellIterator;
            Cell cell;
            listTransaksi = new ArrayList<>();

            while (rowIterator.hasNext() && rowIterator != null) {
                //biarkan loop ini,
                //loop membaca sheet (tahun) untuk membaca bulan
                row = (XSSFRow) rowIterator.next();
                cellIterator = row.cellIterator();

                cell = cellIterator.next();
                ObjekTransaksi ot = new ObjekTransaksi();
                ot.setTanggalTransaksi(cell.getDateCellValue());
                cell = cellIterator.next();
                ot.setID(cell.getStringCellValue());
                cell = cellIterator.next();
                ot.setToko(cell.getStringCellValue());
                cell = cellIterator.next();
                ot.setHarga(cell.getNumericCellValue());
                if (ot.getTanggalTransaksi().getMonth() + 1 == Bulan) {
                    listTransaksi.add(ot);
                }

                while (ot.getTanggalTransaksi().getMonth() + 1 == Bulan && rowIterator.hasNext()) {
                    ObjekTransaksi otr = new ObjekTransaksi();
                    //ambil datanya disini, ini udh sesuai bulan sama tahunnya

                    //ganti baris
                    row = (XSSFRow) rowIterator.next();
                    cellIterator = row.cellIterator();
                    cell = cellIterator.next();
                    otr.setTanggalTransaksi(cell.getDateCellValue());
                    cell = cellIterator.next();
                    otr.setID(cell.getStringCellValue());
                    cell = cellIterator.next();
                    otr.setToko(cell.getStringCellValue());
                    cell = cellIterator.next();
                    otr.setHarga(cell.getNumericCellValue());

                    listTransaksi.add(otr);
                }
            }
        }

        for (ObjekTransaksi ObjTr : listTransaksi) {
            TransaksiHarian thr = new TransaksiHarian();

            Penjualan penj = new Penjualan();
            penj.setHarga(ObjTr.getHarga());
            penj.setToko(ObjTr.getToko());

            ArrayList<Penjualan> arlistPenj = new ArrayList<>();
            arlistPenj.add(penj);

            Transaksi tr = new Transaksi();
            tr.setIdTransaksi(ObjTr.getID());
            tr.setPenjualan(arlistPenj);

            ArrayList<Transaksi> arlistTr = new ArrayList<>();
            arlistTr.add(tr);

            thr.setTglTransaksi(ObjTr.getTanggalTransaksi());
            thr.setListTr(arlistTr);

            //kalau ada yang tanggalnya sama
            if (dt.contains(thr)) {
                int i = dt.indexOf(thr);
                //kalau ada yang idnya sama
                if (dt.get(i).getListTr().contains(tr)) {
                    int j = dt.get(i).getListTr().indexOf(tr);
                    dt.get(i).getListTr().get(j).getPenjualan().add(penj);
                } else {
                    dt.get(i).getListTr().add(tr);
                }
            } else {
                dt.add(thr);
            }
        }
    }

    /*
        Modul untuk mengisi chart line
        menampilkan tingkat transaksi setiap harinya
     */
    static JPanel loadLine(int month, ArrayList<TransaksiHarian> dt) {
        DefaultCategoryDataset lineDataset = new DefaultCategoryDataset();
        List<Dataset> dataChart = new ArrayList<>();

        //isi dari list ke dataset
        for (int i = 0; i < dt.size(); i++) {
            Dataset ds = new Dataset();
            ds.setInfo("" + dt.get(i).getTglTransaksi().getDate());
            ds.setValue(dt.get(i).getListTr().size());
            dataChart.add(ds);
        }

        //ini ngisi dari dataset
        for (int i = 0; i < dataChart.size(); i++) {
            lineDataset.addValue(dataChart.get(i).getValue(), "Penjualan", dataChart.get(i).getInfo());
        }

        JFreeChart chart = ChartFactory.createLineChart(
                "", "Tanggal",
                "Transaksi",
                lineDataset, PlotOrientation.VERTICAL,
                true, true, true);
        return new ChartPanel(chart);
    }

    /*
        Modul untuk mengisi chart pie,
        menampilkan presentase transaksi di toko mana saja
     */
    static JPanel loadPie(int month, ArrayList<TransaksiHarian> dt) {
        DefaultPieDataset pieDataset = new DefaultPieDataset();
        List<Dataset> dataChart = new ArrayList<>();

        //isi dari list ke dataset
        for (int i = 0; i < dt.size(); i++) {
            for (int j = 0; j < dt.get(i).getListTr().size(); j++) {
                for (Penjualan penjualan : dt.get(i).getListTr().get(j).getPenjualan()) {
                    Dataset ds = new Dataset();
                    ds.setInfo(penjualan.getToko());
                    ds.setValue(1);
                    if (dataChart.contains(ds)) {
                        dataChart.get(dataChart.indexOf(ds)).setValue(dataChart.get(dataChart.indexOf(ds)).getValue() + ds.getValue());
                    } else {
                        dataChart.add(ds);
                    }
                }
            }
        }

        //ini ngisi dari dataset
        for (int i = 0; i < dataChart.size(); i++) {
            pieDataset.setValue(dataChart.get(i).getInfo(), dataChart.get(i).getValue());
        }

        JFreeChart chart = ChartFactory.createPieChart3D("", pieDataset, true, true, true);
        return new ChartPanel(chart);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        stats_pane = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jComboBox2 = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        lbl_tokoTerlaris = new javax.swing.JLabel();
        lbl_jmlTransaksi = new javax.swing.JLabel();
        lbl_pendapatan = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();

        stats_pane.setBackground(new java.awt.Color(255, 153, 153));
        stats_pane.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel19.setText("Ini");
        stats_pane.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 20, -1, -1));

        jPanel1.setBackground(new java.awt.Color(153, 153, 153));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Januari", "Februari", "Maret", "April", "Mei", "Juni", "Juli", "Agustus", "September", "Oktober", "November", "Desember" }));
        jPanel1.add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 170, 30));

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2018" }));
        jPanel1.add(jComboBox2, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 10, 100, 30));

        jButton1.setText("Tampilkan");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 10, -1, -1));

        stats_pane.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 890, 50));

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel7.setBackground(new java.awt.Color(102, 102, 102));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel2.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 260, 890, 10));

        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setLayout(new java.awt.BorderLayout());
        jPanel3.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 440, 210));

        jLabel6.setText("Penjualan Per Toko");
        jPanel3.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 480, 260));

        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setLayout(new java.awt.CardLayout());
        jPanel4.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 840, 230));

        jLabel7.setText("Transaksi Harian");
        jPanel4.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 10, -1, -1));

        jPanel2.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 270, 890, 280));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Toko Terlaris");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 80, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("Jumlah Transaksi");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 110, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("Pendapatan");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 140, -1, -1));

        jLabel5.setText("%");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 190, -1, -1));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 19)); // NOI18N
        jLabel1.setText("Summary");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 20, -1, -1));

        lbl_tokoTerlaris.setText("jLabel6");
        jPanel2.add(lbl_tokoTerlaris, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 80, -1, -1));

        lbl_jmlTransaksi.setText("jLabel7");
        jPanel2.add(lbl_jmlTransaksi, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 110, -1, -1));

        lbl_pendapatan.setText("jLabel8");
        jPanel2.add(lbl_pendapatan, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 140, -1, -1));

        jLabel8.setText("dari bulan lalu");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 210, -1, -1));

        stats_pane.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, 890, 550));

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel20.setText("Statistik Penjualan Bulan");
        stats_pane.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 890, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(stats_pane, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 660, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(stats_pane, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        int bulan = jComboBox1.getSelectedIndex() + 1;
        String tahun = jComboBox2.getSelectedItem().toString();
        int bulan2;

        if (bulan == 1) {
            bulan2 = 12;
        } else {
            bulan2 = bulan - 1;
        }

        ArrayList<TransaksiHarian> tHr = new ArrayList<>();
        ArrayList<TransaksiHarian> tHrBef = new ArrayList<>();

        try {
            loadDataExcel("" + tahun, bulan, tHr);
            loadDataExcel("" + tahun, bulan2, tHrBef);
        } catch (IOException ex) {
            Logger.getLogger(statistik.class.getName()).log(Level.SEVERE, null, ex);
        }

        JPanel panel1 = loadPie(bulan, tHr);
        jPanel5.removeAll();
        jPanel5.add(panel1);
        jPanel5.repaint();
        jPanel5.revalidate();

        JPanel panel2 = loadLine(bulan, tHr);
        jPanel6.removeAll();
        jPanel6.add(panel2);
        jPanel6.repaint();
        jPanel6.revalidate();

        this.jLabel19.setText(jComboBox1.getSelectedItem().toString() + " - " + tahun);
        this.lbl_pendapatan.setText("Rp." + Format_Number(hitungPemasukanBulanan(tHr)) + ",-");
        this.lbl_tokoTerlaris.setText(cariTokoTerlaris(tHr));
        this.lbl_jmlTransaksi.setText("" + hitungJumlahTransaksi(tHr));

        double presentase = hitungPemasukanBulanan(tHr) - hitungPemasukanBulanan(tHrBef);
        presentase /= hitungPemasukanBulanan(tHr);
        presentase *= 100;
        if (presentase < 0) {
            this.jLabel5.setText("Penjualan menurun " + presentase + "%");
            this.jLabel5.setForeground(new Color(153, 0, 0));
            this.jLabel8.setForeground(new Color(153, 0, 0));
        } else {
            this.jLabel5.setText("Penjualan meningkat " + presentase + "%");
            this.jLabel5.setForeground(new Color(0, 102, 0));
            this.jLabel8.setForeground(new Color(0, 102, 0));
        }
    }//GEN-LAST:event_jButton1MouseClicked

    public int hitungJumlahTransaksi(ArrayList<TransaksiHarian> tHr) {
        int total = 0;
        for (TransaksiHarian thr : tHr) {
            for (Transaksi tr : thr.getListTr()) {
                total = tr.getPenjualan().stream().map((_item) -> 1).reduce(total, Integer::sum);
            }
        }
        return total;
    }

    public double hitungPemasukanBulanan(ArrayList<TransaksiHarian> tHr) {
        double incomen = 0;

        for (TransaksiHarian thr : tHr) {
            for (Transaksi tr : thr.getListTr()) {
                incomen = tr.getPenjualan().stream().map((pj) -> pj.getHarga()).reduce(incomen, (accumulator, _item) -> accumulator + _item);
            }
        }

        return incomen;
    }

    public String cariTokoTerlaris(ArrayList<TransaksiHarian> tHr) {
        String toko = "";
        ArrayList<Penjualan> Toko2 = new ArrayList<>();
        for (TransaksiHarian thr : tHr) {
            for (Transaksi tr : thr.getListTr()) {
                tr.getPenjualan().forEach((pj) -> {
                    if (Toko2.contains(pj)) {
                        Toko2.get(Toko2.indexOf(pj)).setHarga(Toko2.get(Toko2.indexOf(pj)).getHarga() + 1);
                    } else {
                        pj.setHarga(1);
                        Toko2.add(pj);
                    }
                });
            }
        }
        int max = 0;
        for (Penjualan pj : Toko2) {
            if (pj.getHarga() > max) {
                toko = pj.getToko();
                max = (int) pj.getHarga();
            }
        }

        return toko;
    }

    String Format_Number(double number) {
        DecimalFormat df = new DecimalFormat("#,##0", new DecimalFormatSymbols(new Locale("pt", "ID")));
        BigDecimal value = new BigDecimal(number);

        return String.valueOf(df.format(value.floatValue()));
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JLabel lbl_jmlTransaksi;
    private javax.swing.JLabel lbl_pendapatan;
    private javax.swing.JLabel lbl_tokoTerlaris;
    private javax.swing.JPanel stats_pane;
    // End of variables declaration//GEN-END:variables
}
