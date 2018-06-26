package foodcourt.dashboard;

import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class DigitalClock2 {

    public static void main(String[] arguments) {

        ClockLabel dateLable = new ClockLabel("date");
        ClockLabel timeLable = new ClockLabel("time");
        ClockLabel dayLable = new ClockLabel("day");

        JFrame.setDefaultLookAndFeelDecorated(true);
        JFrame frame = new JFrame("Digital Clock");
        JPanel f = new JPanel();
        frame.setSize(300, 150);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(3, 1));

//        f.setSize(300, 150);
        f.add(dateLable);
        f.add(timeLable);
        f.add(dayLable);

        frame.add(f);

        f.setBackground(Color.black);

        frame.setVisible(true);
    }
}
