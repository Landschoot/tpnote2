package gui;

import javax.swing.*;

/**
 * Created by landschoot on 27/11/16.
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
