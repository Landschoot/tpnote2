package gui;

import domain.IUser;
import domain.exceptions.PersonNotFoundException;
import service.UserService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

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
        super("Identification", 300, 140);
        this.userService = UserService.getInstance();
        this.setContentPane(buildContentPane());
        this.setVisible(true);
    }

    private JPanel buildContentPane(){
        JPanel panel = new JPanel();
        panel.setLayout(null);

        this.identifiantLabel = new JLabel("Identifiant");
        this.identifiantLabel.setBounds(10, 10, 80, 25);
        panel.add(identifiantLabel);

        this.identifiantField = new JTextField(20);
        this.identifiantField.setBounds(100, 10, 160, 25);
        panel.add(identifiantField);

        this.loginButton = new JButton("Connexion");
        this.loginButton.setBounds(10, 50, 110, 25);
        this.loginButton.addActionListener((ActionEvent e) -> connect());
        panel.add(loginButton);

        this.helpButton = new JButton("Aide");
        this.helpButton.setBounds(180, 50, 80, 25);
        this.helpButton.addActionListener((ActionEvent e) -> {
            JOptionPane.showMessageDialog(new JFrame(),
                    "Voici l'arbre généalogique :\n\n" +
                            "            Charles\n" +
                            "                  |\n" +
                            "               Guy\n" +
                            "                  |\n" +
                            "Ludovic  Alicia  Tony");
        });
        panel.add(helpButton);

        this.infoLabel = new JLabel();
        this.infoLabel.setBounds(10, 80, 270, 25);
        panel.add(infoLabel);

        return panel;
    }

    private void connect() {
        if (!fieldEmpty()) {
            try {
                IUser user = this.userService.findById(this.identifiantField.getText());
                this.setVisible(false);
                new ConsultationFrame(user);
            } catch (SQLException e1) {
                e1.printStackTrace();
            } catch (PersonNotFoundException e2) {
                this.infoLabel.setText(e2.getMessage());
                this.infoLabel.setForeground(new Color(-3932126));
            }
        } else {
            this.infoLabel.setText("Indiquer l'identifiant de la personne");
            this.infoLabel.setForeground(new Color(-3932126));
        }
    }

    public boolean fieldEmpty() {
        return "".equals(this.identifiantField.getText());
    }
}
