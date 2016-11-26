package gui;

import javax.swing.*;

/**
 * Created by landschoot on 26/11/16.
 */
public class ConsultationFrame extends JFrame {

    public ConsultationFrame(){
        this.setTitle("ConsultationFrame");
        this.setSize(700, 350);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        this.setContentPane(buildContentPane());
        this.setVisible(true);
        this.setResizable(false);
    }
}
