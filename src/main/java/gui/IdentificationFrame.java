package gui;

import domain.IUser;
import service.UserService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by landschoot on 25/11/16.
 * Classe qui représente la fenêtre d'identification d'une personne
 */
public class IdentificationFrame extends AppFrame {
    private JLabel infoLabel;
    private JLabel identifiantLabel;
    private JTextField identifiantField;
    private JButton loginButton;
    private JButton helpButton;

    private UserService userService;

    public IdentificationFrame(){
        super("Identification", 300, 150);
        this.userService = UserService.getInstance();
        this.setContentPane(buildContentPane());
        this.setVisible(true);
    }

    private JPanel buildContentPane(){
        JPanel panel = new JPanel();
        panel.setLayout(null);

        this.infoLabel = new JLabel("Veuillez indiquer le champ !");
        this.infoLabel.setBounds(10, 10, 270, 25);
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
        this.helpButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(new JFrame(),
                        "Voici l'arbre généalogique :\n\n" +
                                "            Charles\n" +
                                "                  |\n" +
                                "               Guy\n" +
                                "                  |\n" +
                                "Ludovic  Alicia  Tony");
            }
        });
        panel.add(helpButton);
        return panel;
    }

    private void connect() {
        if (!fieldEmpty()) {
            try {
                checkPersonne(this.userService.findById(this.identifiantField.getText()));
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            this.infoLabel.setText("Indiquer l'identifiant de la personne");
            this.infoLabel.setForeground(new Color(-3932126));
        }
    }

    public boolean fieldEmpty() {
        return "".equals(this.identifiantField.getText());
    }

    public void checkPersonne(IUser personne) {
        if (personne != null) {
            this.setVisible(false);
            new ConsultationFrame(personne);
        } else {
            this.infoLabel.setText("Identifiant / Mot de passe incorrects");
            this.infoLabel.setForeground(new Color(-3932126));
        }
    }
}
