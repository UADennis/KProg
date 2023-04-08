package second;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class Clones extends Frame implements ActionListener {

    Button black = new Button("Color");
    Button blue = new Button("Clone");
    Color[] colors = {Color.black, Color.BLUE, Color.cyan, Color.gray, Color.green, Color.magenta, Color.orange, Color.pink, Color.red, Color.white, Color.YELLOW};
    int colCounter = 0;
    ArrayList<Button> knopf = new ArrayList<>();


    public Clones() {
        this.setTitle("Clones");
        this.setSize(800, 800);
        setLayout(new FlowLayout());
        knopf.add(black);
        knopf.add(blue);

        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);

            }
        });

        for (Button e : knopf) {
            e.setActionCommand(e.getLabel());
            e.addActionListener(this);
            this.add(e);

        }

        this.setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println(e.getActionCommand());
        if(e.getActionCommand().equals("Color")){
            setBackground(colors[colCounter]);
            colCounter = (colCounter + 1) % colors.length;
            repaint();



        }
        if(e.getActionCommand().equals("Clone")){
            new Clones();
        }


        }


    public static void main(String[] args) {
        Clones test = new Clones();





    }


}