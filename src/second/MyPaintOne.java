package second;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MyPaintOne extends JFrame {
    private boolean mousePressed1 = false;
    private boolean mousePressed2 = false;
    private Color color = Color.BLACK;

    public MyPaintOne() {
        this.setSize(816, 839);
        this.setTitle("MyPaint");
        this.setLayout(new GridLayout(100, 100));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                JPanel pixel = new JPanel();
                pixel.setBackground(Color.WHITE);
                pixel.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mousePressed(MouseEvent e) {
                        recordMousePress(e);
                    }

                    @Override
                    public void mouseReleased(MouseEvent e) {
                        recordMouseRelease(e);
                    }

                    @Override
                    public void mouseEntered(MouseEvent e) {
                        if (mousePressed1) pixel.setBackground(color);
                        if (mousePressed2) pixel.setBackground(Color.WHITE);
                    }
                });
                this.add(pixel);
            }
        }
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new MyPaintOne();
    }

    private void recordMousePress(MouseEvent e) {
        switch (e.getButton()) {
            case 1 -> mousePressed1 = true;
            case 3 -> mousePressed2 = true;
            case 2 -> color = JColorChooser.showDialog(this, "Choose a color", color);
        }
    }

    private void recordMouseRelease(MouseEvent e) {
        switch (e.getButton()) {
            case 1 -> mousePressed1 = false;
            case 3 -> mousePressed2 = false;
        }
    }
}