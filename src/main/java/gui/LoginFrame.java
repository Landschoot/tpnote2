package gui;

import domain.IUser;
import domain.exceptions.PersonNotFoundException;
import service.UserService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Classe représentant la fenêtre d'identification.
 *
 * @author Ludovic LANDSCHOOT & Laurent THIEBAULT
 */
public class LoginFrame extends AppFrame {
    private JLabel infoLabel;
    private JLabel identifiantLabel;
    private JTextField identifiantField;
    private JButton loginButton;
    private JButton helpButton;

    private UserService userService;

    public LoginFrame(){
        super("Identification", 280, 140);
        this.userService = UserService.getInstance();
        this.setContentPane(buildContentPane());
        this.setVisible(true);
    }

    /**
     * Construit le panel de la page.
     * @return
     */
    private JPanel buildContentPane(){
        JPanel panel = new JPanel();
        panel.setLayout(null);

        this.identifiantLabel = new JLabel("Identifiant");
        this.identifiantLabel.setBounds(10, 10, 80, 25);
        panel.add(identifiantLabel);

        this.identifiantField = new JTextField(20);
        this.identifiantField.setBounds(100, 10, 160, 25);
        KeyListener keyListener = new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    connect();
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }
        };
        this.identifiantField.addKeyListener(keyListener);
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

    /**
     * Connecte l'utilisateur.
     */
    private void connect() {
        if (!fieldEmpty(this.identifiantField)) {
            try {
                IUser user = this.userService.findById(this.identifiantField.getText());
                this.setVisible(false);
                new ConsultationFrame(user);
            } catch (PersonNotFoundException e2) {
                this.infoLabel.setText(e2.getMessage());
                this.infoLabel.setForeground(new Color(-3932126));
            }
        } else {
            this.infoLabel.setText("Indiquez l'identifiant de la personne.");
            this.infoLabel.setForeground(new Color(-3932126));
        }
    }
}
