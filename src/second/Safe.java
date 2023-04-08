package second;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

public class Safe extends Frame implements ActionListener {

    private final int[] code = {3,1,0,3,2,0,2,3 };
    private int inputIndex = 0;

    public Safe(){
        this.setSize(400, 400);
        this.setTitle("Safe");
        this.setLayout(new FlowLayout());
        for(int i = 0; i < 10; i++){
          Button b = new Button(Integer.toString(i));
          b.addActionListener(this);
          b.setActionCommand(Integer.toString(i));
          this.add(b);


        }
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
        int button = Integer.parseInt(e.getActionCommand());
        if(button == code[inputIndex]){
            inputIndex++;
            this.setBackground(Color.green);
            if(inputIndex >= code.length){
                System.exit(0);
            }
        }else{
            this.setBackground(Color.red);
            inputIndex = 0;
        }


    }

    public static void main(String[] args) {
        Safe safe = new Safe();

    }
}
