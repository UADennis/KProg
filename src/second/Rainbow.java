package second;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Timer;

public class Rainbow extends Frame implements ActionListener {


    Color[] colors = {Color.black, Color.BLUE, Color.cyan, Color.gray, Color.green, Color.magenta, Color.orange, Color.pink, Color.red, Color.white, Color.YELLOW};
    int colCounter = 0;

    public Rainbow(){
        this.setTitle("Rainbow");
        this.setSize(800, 800);
        setLayout(new FlowLayout());
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                while (true) {
                    setBackground(colors[colCounter]);
                    colCounter = (colCounter + 1) % colors.length;
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        };
        new Thread(runnable).start();

        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);

            }
        });


        this.setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {

    }

    public static void main(String[] args) {
        Frame haupt = new Frame();
        haupt.setSize(400, 400);
        Button b1 = new Button("Rainbow");
        b1.addActionListener(e -> new Rainbow());
        haupt.add(b1);
        haupt.setLayout(new FlowLayout());
        haupt.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);

            }
        });
        haupt.setVisible(true);


    }
}
