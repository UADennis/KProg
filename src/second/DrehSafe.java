package second;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;
/**
 *
 *
 * @author Dennis Mayer
 * @version 1, 06.04.2023
 **/

public class DrehSafe extends JFrame implements ActionListener {

    private final int[] code = {8, 2, 2, 4, 7, 2, 5, 0, 1};
    private int inputIndex = 0;
    private int current = 0;
    private boolean turnRight = true;
    private Map<JButton, Integer> knopfe = new HashMap<>();

    public DrehSafe() {
        setTitle("DrehSafe");
        getContentPane().setLayout(new GridLayout(4, 3));
        setSize(400, 400);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.add(makeButton(3));
        this.add(makeButton(2));
        this.add(makeButton(1));
        this.add(makeButton(4));
        this.add(new JPanel());
        this.add(makeButton(0));
        this.add(makeButton(5));
        this.add(new JPanel());
        this.add(makeButton(9));
        this.add(makeButton(6));
        this.add(makeButton(7));
        this.add(makeButton(8));
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                while (true) {
                    if(turnRight) current += 9;
                    else current++;
                    for(JButton but : knopfe.keySet()){
                        but.setText(Integer.toString((knopfe.get(but)+ current) % 10));
                        but.setActionCommand(Integer.toString((knopfe.get(but)+ current) % 10));

                    }


                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        };
        new Thread(runnable).start();

        this.setVisible(true);

    }

    public JButton makeButton(int i) {
        JButton temp = new JButton(String.valueOf(i));
        temp.addActionListener(this);
        temp.setFont(new Font("Arial", Font.BOLD, 50));
        temp.setFocusable(false);
        temp.setActionCommand(Integer.toString(i));
        knopfe.put(temp, i);
        return temp;

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int button = Integer.parseInt(e.getActionCommand());
        if (button == code[inputIndex]) {
            inputIndex++;
            for(JButton g : knopfe.keySet()){
                g.setBackground(Color.GREEN);
            }

            if (inputIndex >= code.length) {
                System.exit(0);
            }
        } else {
            for(JButton g : knopfe.keySet()){
                g.setBackground(Color.RED);
            }

            inputIndex = 0;
            turnRight = !turnRight;
        }


    }

    public static void main(String[] args) {
        DrehSafe test = new DrehSafe();
    }
}
