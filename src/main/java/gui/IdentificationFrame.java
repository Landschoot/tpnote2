package gui;

import domain.Personne;
import service.PersonneService;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by landschoot on 25/11/16.
 * Classe qui représente la fenêtre d'identification d'une personne
 */
public class IdentificationFrame extends JFrame {
    private JLabel infoLabel;
    private JLabel identifiantLabel;
    private JTextField identifiantField;
    private JButton loginButton;
    private JButton helpButton;

    private PersonneService personneService;

    public IdentificationFrame(){
        this.personneService = PersonneService.getInstance();
        this.setTitle("IdentificationFrame");
        this.setSize(300, 150);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(buildContentPane());
        this.setVisible(true);
        this.setResizable(false);
    }

    private JPanel buildContentPane(){
        JPanel panel = new JPanel();
        panel.setLayout(null);

        this.infoLabel = new JLabel("IdentificationFrame de la personne ;");
        this.infoLabel.setBounds(10, 10, 250, 25);
        panel.add(infoLabel);

        this.identifiantLabel = new JLabel("Identifiant");
        this.identifiantLabel.setBounds(10, 40, 80, 25);
        panel.add(identifiantLabel);

        this.identifiantField = new JTextField(20);
        this.identifiantField.setBounds(100, 40, 160, 25);
        panel.add(identifiantField);

        this.loginButton = new JButton("login");
        this.loginButton.setBounds(10, 80, 80, 25);
        this.loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                connect();
            }
        });
        panel.add(loginButton);

        this.helpButton = new JButton("aide");
        this.helpButton.setBounds(180, 80, 80, 25);
        panel.add(helpButton);
        return panel;
    }

    private void connect() {
        if (!fieldEmpty()) {
            try {
                checkPersonne(this.personneService.findById(this.identifiantField.getText()));
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
//            this.errorLabel.setText("Veuillez remplir l'ensemble des champs");
        }
    }

    public boolean fieldEmpty() {
        return this.identifiantField.getText() == "";
    }

    public void checkPersonne(Personne personne) {
        if (personne != null) {
            this.setVisible(false);
            new ConsultationFrame(personne);
        } else {
//            this.errorLabel.setText("Identifiant / Mot de passe incorrects");
        }
    }
}
