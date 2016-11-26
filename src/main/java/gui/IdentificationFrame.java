package gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by landschoot on 25/11/16.
 * Classe qui représente la fenêtre d'identification d'une personne
 */
public class IdentificationFrame extends JFrame {

    public IdentificationFrame(){
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

        JLabel userLabel = new JLabel("IdentificationFrame de la personne ;");
        userLabel.setBounds(10, 10, 250, 25);
        panel.add(userLabel);

        JLabel passwordLabel = new JLabel("Identifiant");
        passwordLabel.setBounds(10, 40, 80, 25);
        panel.add(passwordLabel);

        JPasswordField passwordText = new JPasswordField(20);
        passwordText.setBounds(100, 40, 160, 25);
        panel.add(passwordText);

        JButton loginButton = new JButton("login");
        loginButton.setBounds(10, 80, 80, 25);
        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new ConsultationFrame();
            }
        });
        panel.add(loginButton);

        JButton registerButton = new JButton("aide");
        registerButton.setBounds(180, 80, 80, 25);
        panel.add(registerButton);
        return panel;
    }
}
