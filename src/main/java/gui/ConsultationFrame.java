package gui;

import domain.Personne;

import javax.swing.*;
import java.awt.*;

/**
 * Created by landschoot on 26/11/16.
 */
public class ConsultationFrame extends JFrame {
    private JLabel nameLabel;
    private JLabel namePereLabel;
    private JLabel evaluationLabel;
    private JButton annulerButton;
    private JList filsList;
    private JLabel filsLabel;
    private JLabel evaluationFilsLabel;
    private JButton valideButton;

    private Personne personne;

    public ConsultationFrame(Personne personne){
        this.personne = personne;
        this.setTitle("ConsultationFrame");
        this.setSize(700, 350);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(buildContentPane());
        this.setVisible(true);
        this.setResizable(false);
    }

    private Container buildContentPane() {
        Panel panel = new Panel();

        return panel;
    }
}
