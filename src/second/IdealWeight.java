package second;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * Ergänzen Sie das Programm IdealWeight zur Idealgewichtsberechnung, so dass eine
 * Ausgabe erfolgt. Das Idealgewicht W in Pfund ergibt sich für Männer nach der Formel
 * W = H2
 * / 30 und für Frauen nach W = H2
 * / 28, wobei H die Größe in Inch ist.
 * • Schreiben Sie ein Programm SliderTemp zur Umrechnung von Celsius in Fahrenheit und
 * umgekehrt, wobei die Ein- und Ausgaben jeweils durch Stellungen von Schiebereglern erfolgen.
 *
 * @author Dennis Mayer, Henri Staudenrausch
 * @version 1, 06.04.2023
 **/

public class IdealWeight extends JFrame implements ActionListener { // sollte zusätzlich ActionListener sein
    JRadioButton genderM, genderF; // Knöpfe für Geschlecht
    ButtonGroup genderGroup; // ... dazu Knopfgruppe
    JPanel genderPanel; // ... dazu Panel
    JRadioButton heightA, heightB, heightC, heightD, heightE; // Kn. Grösse
    ButtonGroup heightGroup; // ... Gruppe
    JPanel heightPanel; // ... Panel
    JTextField resultText; // Textfeld für Ergebnis
    JLabel resultLabl; // ... dazu Label
    JPanel resultPanel; // ... dazu Panel

    public IdealWeight() { // Konstruktor
        setTitle("Your Ideal Weight"); // Fenstertitel
        setDefaultCloseOperation(EXIT_ON_CLOSE); // zum Fensterschliessen

        // Geschlechts-Gruppe
        genderM = new JRadioButton("Male", false); // Knopf M. selekt.
        genderF = new JRadioButton("Female", false); // Knopf F. nicht s.
        genderGroup = new ButtonGroup(); // Gruppe def.
        genderGroup.add(genderM);
        genderGroup.add(genderF); // Kn. hinzufuegen
        genderPanel = new JPanel(); // G.-Panel
        genderPanel.setLayout( // Layout
                new BoxLayout(genderPanel, BoxLayout.Y_AXIS)); // ... vertikal
        genderPanel.add(new JLabel("Your Gender")); // Label &
        genderPanel.add(genderM);
        genderPanel.add(genderF); // Knoepfe hinzuf.
// Hoehen-Gruppe
        heightA = new JRadioButton("60 to 64 inches", false); // ... selektiert
        heightB = new JRadioButton("64 to 68 inches", false); // nicht selektiert
        heightC = new JRadioButton("68 to 72 inches", false); // ...
        heightD = new JRadioButton("72 to 76 inches", false); // ...
        heightE = new JRadioButton("76 to 80 inches", false); // ...
        heightGroup = new ButtonGroup(); // Gruppe def.
        heightGroup.add(heightA);
        heightGroup.add(heightB); // Kn.
        heightGroup.add(heightC);
        heightGroup.add(heightD); // ... hinzufuegen
        heightGroup.add(heightE); // ...
        heightA.addActionListener(this);
        heightB.addActionListener(this);
        heightC.addActionListener(this);
        heightD.addActionListener(this);
        heightE.addActionListener(this);
        genderM.addActionListener(this);
        genderF.addActionListener(this);

        heightPanel = new JPanel(); // H-Panel
        heightPanel.setLayout( // Layout
                new BoxLayout(heightPanel, BoxLayout.Y_AXIS)); // ... vertikal
        heightPanel.add(new JLabel("Your Height")); // Label &
        heightPanel.add(heightA);
        heightPanel.add(heightB); // Kn. hinzufuegen
        heightPanel.add(heightC);
        heightPanel.add(heightD); // ...
        heightPanel.add(heightE); // ...
// Ergebnis-Panel
        resultText = new JTextField(7); // Textfeld
        resultText.setEditable(false); // ... nur Ausgabe
        resultLabl = new JLabel("Ideal Weight"); // Label def.
        resultPanel = new JPanel(); // Panel def.
        resultPanel.add(resultLabl); // Label hinzufuegen
        resultPanel.add(resultText); // Textfeld ...

// Gesamt-Fenster
        getContentPane().setLayout(new BorderLayout()); // Layout: Border
        getContentPane().add(genderPanel, BorderLayout.WEST); // G-Panel hinzuf.
        getContentPane().add(heightPanel, BorderLayout.EAST); // H-Panel ...
        getContentPane().add(resultPanel, BorderLayout.SOUTH); // Ergebnis-Panel ..
    }

    public static void main(String[] args) { // main ...
        IdealWeight weightApp = new IdealWeight();
        weightApp.setSize(250, 225);
        weightApp.setVisible(true);
    }

    // ActionListener prüft welche Knöpfe ausgewählt sind und Berechnet dann das Passende Gewicht
    @Override
    public void actionPerformed(ActionEvent e) {
        if (genderM.isSelected() && heightA.isSelected()) {
            int weight = (int) (Math.pow(60, 2)) / 30;
            resultText.setText(Double.toString(weight));

        } else if (genderM.isSelected() && heightB.isSelected()) {
            int weight = (int) (Math.pow(64, 2)) / 30;
            resultText.setText(Double.toString(weight));


        } else if (genderM.isSelected() && heightC.isSelected()) {
            int weight = (int) (Math.pow(68, 2)) / 30;
            resultText.setText(Double.toString(weight));

        } else if (genderM.isSelected() && heightD.isSelected()) {
            int weight = (int) (Math.pow(72, 2)) / 30;
            resultText.setText(Double.toString(weight));

        } else if (genderM.isSelected() && heightE.isSelected()) {
            int weight = (int) (Math.pow(76, 2)) / 30;
            resultText.setText(Double.toString(weight));
        } else if (genderF.isSelected() && heightA.isSelected()) {
            int weight = (int) (Math.pow(60, 2)) / 28;
            resultText.setText(Double.toString(weight));
        } else if (genderF.isSelected() && heightB.isSelected()) {
            int weight = (int) (Math.pow(64, 2)) / 28;
            resultText.setText(Double.toString(weight));
        } else if (genderF.isSelected() && heightC.isSelected()) {
            int weight = (int) (Math.pow(68, 2)) / 28;
            resultText.setText(Double.toString(weight));
        } else if (genderF.isSelected() && heightD.isSelected()) {
            int weight = (int) (Math.pow(72, 2)) / 28;
            resultText.setText(Double.toString(weight));
        } else if (genderF.isSelected() && heightE.isSelected()) {
            int weight = (int) (Math.pow(76, 2)) / 28;
            resultText.setText(Double.toString(weight));
        } else {
            resultText.setText("");
        }
    }
}



