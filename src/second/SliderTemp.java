package second;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

/**
 * Schreiben Sie ein Programm SliderTemp zur Umrechnung von Celsius in Fahrenheit und
 * umgekehrt, wobei die Ein- und Ausgaben jeweils durch Stellungen von Schiebereglern erfolgen
 *
 * @author Henri Staudenrausch, Dennis Mayer
 * @version 1, 06.04.2023
 */

public class SliderTemp extends JFrame implements ChangeListener {
    JSlider cel, fahr;
    JTextField celText, fahrText;

    public SliderTemp() {
        this.setTitle("SliderTemp");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(600, 250);
        this.setLayout(new FlowLayout());

        //celsius
        cel = new JSlider(SwingConstants.HORIZONTAL, -300, 1000, 100);
        cel.setMajorTickSpacing(100);
        cel.setMinorTickSpacing(50);
        cel.setPaintTicks(true);
        cel.setPaintLabels(true);
        cel.setPreferredSize(new Dimension(500, 100));
        cel.addChangeListener(this);
        cel.setName("cel");
        cel.setToolTipText("Celsius einstellen");
        celText = new JTextField(4);
        celText.setText(cel.getValue() + " ");
        celText.setToolTipText("Celsius");
        celText.setEditable(true);
        celText.addActionListener(e -> cel.setValue(Integer.parseInt(celText.getText().trim())));
        this.add(celText);
        this.add(cel);

        //fahrenheit
        fahr = new JSlider(SwingConstants.HORIZONTAL, -300, 1000, 212);
        fahr.setMajorTickSpacing(100);
        fahr.setMinorTickSpacing(50);
        fahr.setPaintTicks(true);
        fahr.setPaintLabels(true);
        fahr.setPreferredSize(new Dimension(500, 100));
        fahr.addChangeListener(this);
        fahr.setName("fahr");
        fahr.setToolTipText("Fahrenheit einstellen");
        fahrText = new JTextField(4);
        fahrText.setText(fahr.getValue() + " ");
        fahrText.setToolTipText("Fahrenheit");
        fahrText.setEditable(true);
        fahrText.addActionListener(e -> fahr.setValue(Integer.parseInt(fahrText.getText().trim())));
        this.add(fahrText);
        this.add(fahr);

        this.setVisible(true);
    }

    public static void main(String[] args) {
        new SliderTemp();

    }

    //executed when a slider is changed
    public void stateChanged(ChangeEvent evt) {
        JSlider source = (JSlider) evt.getSource();
        if (source.getName().equals("cel")) {
            celText.setText(source.getValue() + "");
            int fahrenheitFromCelsius = (int) (source.getValue() * 1.8 + 32);
            fahr.setValue(fahrenheitFromCelsius);
        }
        if (source.getName().equals("fahr")) {
            fahrText.setText(source.getValue() + " ");
            int celsiusFromFahrenheit = (int) ((source.getValue() - 32) / 1.8);
            cel.setValue(celsiusFromFahrenheit);
        }
    }
}