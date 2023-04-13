package second;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class MyPaint extends JFrame implements ActionListener {
    private boolean mousePressedOne = false;
    private boolean mousePressedTwo = false;
    private Color farbe = Color.BLACK;
    private JPanel canvas = new JPanel(new GridLayout(100,100));

    private JButton selection = new JButton("Farbe");
    private JButton wipe = new JButton("Reset");
    ArrayList<JPanel> hintergrund = new ArrayList<>();


    public MyPaint() {
        this.setTitle("MyPaint");
        this.setLayout(null);
        this.setSize(800, 900);
        this.setPreferredSize(new Dimension(800, 900));
        this.pack();
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        canvas.setBounds(0,100, 800,800);
        this.add(canvas);
        wipe.setBounds(10, 10, 100, 50);
        selection.setBounds(110, 10, 100, 50);
        this.add(wipe);
        this.add(selection);
        wipe.addActionListener(this);
        selection.addActionListener(this);
        selection.setBackground(farbe);
        selection.setActionCommand("Farbe");
        wipe.setActionCommand("Wipe");
        JLabel hilfe = new JLabel("Linke Maustaste: Malen Mittlere Maustaste: Farbauswahl Rechte Maustaste: Radieren");
        hilfe.setBounds(10, 50, 500,50);
        this.add(hilfe);
        for (int i = 0; i < 10000; i++) {
            JPanel pixel = new JPanel();
            hintergrund.add(pixel);
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
                    if (mousePressedOne) pixel.setBackground(farbe);
                    if (mousePressedTwo) pixel.setBackground(Color.WHITE);
                }
            });
            canvas.add(pixel);
        }
        this.setVisible(true);


    }


    private void recordMousePress(MouseEvent e) {
        switch (e.getButton()) {
            case 1 -> mousePressedOne = true;
            case 3 -> mousePressedTwo = true;
            case 2 -> farbe = JColorChooser.showDialog(this, "Wähle eine Farbe", farbe);
        }
    }

    private void recordMouseRelease(MouseEvent e) {
        switch (e.getButton()) {
            case 1 -> mousePressedOne = false;
            case 3 -> mousePressedTwo = false;
        }
    }

    public static void main(String[] args) {
        MyPaint test = new MyPaint();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals(selection.getActionCommand())) {
            farbe = JColorChooser.showDialog(this, "Wähle eine Farbe", farbe);
            selection.setBackground(farbe);
        }
        if(e.getActionCommand().equals(wipe.getActionCommand())){
            for(JPanel k: hintergrund){
                k.setBackground(Color.WHITE);
            }

        }


    }
}
