package gui;

import domain.IUser;
import domain.User;
import service.UserService;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import java.awt.*;
import java.awt.event.ActionEvent;

/**
 * Created by landschoot on 26/11/16.
 */
public class ConsultationFrame extends AppFrame {
    private JLabel nameLabel;
    private JLabel nameFatherLabel;
    private JLabel evaluationLabel;
    private JButton cancelButton;
    private JLabel childrenLabel;
    private JList childrenList;
    private JLabel evaluationChildLabel;
    private JTextArea evaluationChildArea;
    private JButton validateButton;

    private IUser user;
    private IUser userSelected;
    private UserService userService;

    public ConsultationFrame(IUser user){
        super("Consultation", 450, 350);
        this.user = user;
        this.userService = UserService.getInstance();
        this.setContentPane(buildContentPane());
        this.setVisible(true);
    }

    private Container buildContentPane() {
        Panel panel = new Panel();
        panel.setLayout(null);

        this.nameLabel = new JLabel("Vous : " + user);
        this.nameLabel.setBounds(10, 10, 300, 25);
        panel.add(nameLabel);

        this.nameFatherLabel = new JLabel("Votre pere : " + user.getFather());
        this.nameFatherLabel.setBounds(10, 30, 300, 25);
        panel.add(nameFatherLabel);

        this.evaluationLabel = new JLabel("Votre evaluation : " + user.getEvaluation());
        this.evaluationLabel.setBounds(10, 50, 300, 25);
        panel.add(evaluationLabel);

        this.cancelButton = new JButton("Annuler");
        this.cancelButton.setBounds(330, 15, 100, 50);
        this.cancelButton.addActionListener((ActionEvent e) -> {
            this.userService.rollback();
            this.setVisible(false);
            new IdentificationFrame();
        });
        panel.add(cancelButton);

        this.childrenLabel = new JLabel("Vos fils :");
        this.childrenLabel.setBounds(10, 90, 300, 25);
        panel.add(childrenLabel);

        this.evaluationChildLabel = new JLabel("");
        this.evaluationChildLabel.setBounds(200, 120, 300, 25);
        panel.add(evaluationChildLabel);

        this.evaluationChildArea = new JTextArea(4, 20);
        this.evaluationChildArea.setBounds(200, 160, 190, 70);
        this.evaluationChildArea.setVisible(false);
        panel.add(evaluationChildArea);

        this.validateButton = new JButton("Valider");
        this.validateButton.setBounds(300, 260, 100, 40);
        this.validateButton.setVisible(false);
        this.validateButton.addActionListener((ActionEvent e) -> {
            if (this.userSelected != null) {
                this.userSelected.setEvaluation(this.evaluationChildArea.getText());
            }
            this.userService.commit();
            JOptionPane.showMessageDialog(new JFrame(), "Mise à jour effectuée.");
        });
        panel.add(validateButton);

        this.childrenList = new JList(user.getChildren().toArray());
        this.childrenList.setVisibleRowCount(10);
        this.childrenList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        this.childrenList.addListSelectionListener((ListSelectionEvent e) -> {
            if (!e.getValueIsAdjusting()) {
                if (this.userSelected != null) {
                    this.userSelected.setEvaluation(this.evaluationChildArea.getText());
                }
                this.userSelected = (User) childrenList.getSelectedValue();
                this.evaluationChildLabel.setText("Evaluation de " + userSelected + " :");
                this.evaluationChildArea.setVisible(true);
                this.evaluationChildArea.setText(userSelected.getEvaluation());
                this.validateButton.setVisible(true);
            }
        });
        JScrollPane scrollPane = new JScrollPane(childrenList);
        scrollPane.setBounds(10, 120, 150, 180);
        panel.add(scrollPane);

        return panel;
    }
}
