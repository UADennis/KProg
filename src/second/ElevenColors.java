package second;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class ElevenColors extends Frame implements ActionListener {

    Button black = new Button("black");
    Button blue = new Button("blue");
    Button cyan = new Button("cyan");
    Button gray = new Button("gray");
    Button green = new Button("green");
    Button magenta = new Button("magenta");
    Button orange = new Button("orange");
    Button pink = new Button("pink");
    Button red = new Button("red");
    Button white = new Button("white");
    Button yellow = new Button("yellow");

    ArrayList<Button> knopf = new ArrayList<>();


    public ElevenColors() {
        this.setTitle("Eleven Colors");
        this.setSize(800, 800);
        setLayout(new FlowLayout());
        knopf.add(black);
        knopf.add(blue);
        knopf.add(cyan);
        knopf.add(gray);
        knopf.add(green);
        knopf.add(magenta);
        knopf.add(orange);
        knopf.add(pink);
        knopf.add(red);
        knopf.add(white);
        knopf.add(yellow);


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

        switch (e.getActionCommand()){
            case "black" -> setBackground(Color.BLACK);
            case "blue" -> setBackground(Color.BLUE);
            case "cyan" -> setBackground(Color.CYAN);
            case "gray" -> setBackground(Color.gray);
            case "green" -> setBackground(Color.green);
            case "magenta" -> setBackground(Color.magenta);
            case "orange" -> setBackground(Color.orange);
            case "pink" -> setBackground(Color.pink);
            case "red" -> setBackground(Color.red);
            case "white" -> setBackground(Color.white);
            case "yellow" -> setBackground(Color.yellow);
        }
    }

    public static void main(String[] args) {
        ElevenColors test = new ElevenColors();





    }


}
