package gui;

import javax.swing.*;

/**
 * Created by landschoot on 25/11/16.
 * Classe qui représente la fenêtre d'identification d'une personne
 */
public class Identification extends JFrame {
    public Identification(){
        this.setTitle("Identification");
        this.setSize(400, 500);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}
