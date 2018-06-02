/*
 * Copyright May - 2018
 * JTK POLBAN.
 * Made in Ciwaruga.
 */
package foodcourt.dashboard;

import foodcourt.data;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;
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
public class chart {
    /*
     * Modul berikut mengembalikan pie chart
     */
    public static JPanel createChartPanel() {
        DefaultPieDataset pieDataset = new DefaultPieDataset();
        List<data> daftar = new ArrayList<>();
        
        for(int i = 0; i < 10; i++){
            data e  = new data();
            e.setInfo(10);
            e.setTitle("eee"+i);
            daftar.add(i, e);
        }
        
        for(int i =0; i<daftar.size(); i++){
            pieDataset.setValue(daftar.get(i).getTitle(), daftar.get(i).getInfo());
        }
        JFreeChart chart = ChartFactory.createPieChart3D("", pieDataset, true, true, true);
//        chart.setBackgroundPaint(Color.BLUE);
//        chart.setBorderPaint(Color.BLUE);
        
        return new ChartPanel(chart);
    }
    
    /*
     * Modul berikut mengembalikan chart line
     */
    public static JPanel createChartPanelLine(){
      DefaultCategoryDataset line_chart_dataset = new DefaultCategoryDataset();
      line_chart_dataset.addValue( 15 , "makanan a" , "1970" );
      line_chart_dataset.addValue( 30 , "makanan a" , "1980" );
      line_chart_dataset.addValue( 300, "makanan a" , "1990" );
      line_chart_dataset.addValue( 120, "makanan a" , "2000" );
      line_chart_dataset.addValue( 500, "makanan b", "1980" );
      line_chart_dataset.addValue( 20 , "makanan b" , "1990" ); 
      line_chart_dataset.addValue( 300, "makanan b" , "2000" );
//    gunakan sebagai acuan
//    line_chart_dataset.addValue( int Level kiri(naik), String kategori, String Level(geser)

      JFreeChart lineChartObject = ChartFactory.createLineChart(
         "","Year",
         "Jenis Makanan",
         line_chart_dataset,PlotOrientation.VERTICAL,
         true,true,true);
      
//      blok dibawah untuk menyimpan sebagai gambar
//      int width = 640;    /* Width of the image */
//      int height = 480;   /* Height of the image */ 
//      File lineChart = new File( "...LineChart.jpeg" ); 
//        try {
//            ChartUtilities.saveChartAsJPEG(lineChart ,lineChartObject, width ,height);
//        } catch (IOException ex) {
//            Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
//        }
      return new ChartPanel(lineChartObject);
    }
}
