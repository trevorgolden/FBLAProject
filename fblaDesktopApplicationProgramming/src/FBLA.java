
/*
 * Name: Trevor
 * Period: 6
 * Program Name: Drawing Shapes
 * Program Description: GUI Program that Draws a Face using OVals, Fill, Draw, Rectangles, arcs and More.
 */
import java.awt.BorderLayout;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;

import javax.swing.JFrame;
import javax.swing.JPanel;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class FBLA {

    JFrame frame;
    Container cp;
    DrawingPanel dp;
    private JButton btnCreate;
    private String btnText;
    private Workbook workbook;
    private Sheet sheet;
    public static void main(String[] args) {

        new FBLA();

    }

    public FBLA() {
        frame = new JFrame();
        frame.setTitle("Trevor Golden - FBLA State Leadership Conference");
        cp = frame.getContentPane();
        cp.setLayout(new BorderLayout());
        frame.setBackground(Color.WHITE);
        frame.setSize(1000, 1000);
        dp = new DrawingPanel();
        cp.add(dp);
        frame.setContentPane(cp);
        btnCreate = new JButton("Create A New .xlsx File");
        cp.add(btnCreate, BorderLayout.NORTH);
        btnCreate.addActionListener(new ButtonListener());
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setResizable(false);
    }

    public class DrawingPanel extends JPanel {

        public void paintComponent(Graphics g) {

            g.setColor(Color.black);

            
        }
    }
    
    public class ButtonListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            btnText = e.getActionCommand();
            if (btnText.equalsIgnoreCase("Create A New .xlsx File")) {
                try {
                    workbook = Workbook.getWorkbook(new File("FBLA.xls"));
                } catch (IOException ex) {
                    Logger.getLogger(FBLA.class.getName()).log(Level.SEVERE, null, ex);
                    System.exit(1);
                } catch (BiffException ex) {
                    Logger.getLogger(FBLA.class.getName()).log(Level.SEVERE, null, ex);
                    System.exit(1);
                }
                sheet = workbook.getSheet(0);
                Cell a1 = sheet.getCell(0,0); 
                Cell b2 = sheet.getCell(1,1); 
                Cell c2 = sheet.getCell(2,1); 
            }

        }
    }
}
