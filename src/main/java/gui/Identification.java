package gui;

import javax.swing.*;
import java.awt.*;

/**
 * Created by landschoot on 25/11/16.
 * Classe qui représente la fenêtre d'identification d'une personne
 */
public class Identification extends JFrame {
    public Identification(){
        this.setTitle("Identification");
        this.setSize(240, 100);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(buildContentPane());
        this.setVisible(true);
        this.setResizable(false);
    }

    private JPanel buildContentPane(){
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.setBackground(Color.white);
        JLabel label = new JLabel("Entrer votre identifiant :");
        label.setHorizontalAlignment(JLabel.CENTER);
        JTextField text = new JTextField(20);
        JButton button = new JButton("OK");
        panel.add(label, BorderLayout.NORTH);
        panel.add(text, BorderLayout.CENTER);
        panel.add(button, BorderLayout.SOUTH);
        return panel;
    }
}
