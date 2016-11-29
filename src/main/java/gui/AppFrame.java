package gui;

import javax.swing.*;

/**
 * Classe abstraite représentant une fenêtre de l'application.
 *
 * @author Ludovic LANDSCHOOT & Laurent THIEBAULT
 */
public abstract class AppFrame extends JFrame {

    public AppFrame(String title, int height, int width){
        this.setTitle(title);
        this.setSize(height, width);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
    }

    public boolean fieldEmpty(JTextField jTextField) {
        return "".equals(jTextField.getText());
    }
}
