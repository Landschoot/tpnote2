package gui;

import domain.IUser;
import domain.User;
import service.UserService;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import java.awt.event.ActionEvent;

/**
 * Classe représentant la fenêtre de consultation.
 *
 * @author Ludovic LANDSCHOOT & Laurent THIEBAULT
 */
public class ConsultationFrame extends AppFrame {
    private JLabel nameLabel;
    private JLabel nameFatherLabel;
    private JLabel evaluationLabel;
    private JButton cancelButton;
    private JLabel childrenLabel;
    private JList childrenList;
    private JLabel evaluationChildLabel;
    private JTextField evaluationChildTextField;
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

    private JPanel buildContentPane() {
        JPanel panel = new JPanel();
        panel.setLayout(null);

        buildUserInfos(panel);
        buildCancelButton(panel);
        buildEvaluationChild(panel);

        if (!user.getChildren().isEmpty()) {
            buildChildrenLabel(panel, "Vos fils :");
            buildChildrenList(panel);
        } else {
            buildChildrenLabel(panel, "Pas de fils.");
        }

        return panel;
    }

    private void buildChildrenLabel(JPanel panel, String label) {
        this.childrenLabel = new JLabel(label);
        this.childrenLabel.setBounds(10, 90, 300, 25);
        panel.add(childrenLabel);
    }

    private void buildEvaluationChild(JPanel panel) {
        this.evaluationChildLabel = new JLabel();
        this.evaluationChildLabel.setBounds(200, 120, 300, 25);
        panel.add(evaluationChildLabel);

        this.evaluationChildTextField = new JTextField();
        this.evaluationChildTextField.setBounds(200, 160, 190, 70);
        this.evaluationChildTextField.setVisible(false);
        panel.add(evaluationChildTextField);

        this.validateButton = new JButton("Valider");
        this.validateButton.setBounds(300, 260, 100, 40);
        this.validateButton.setVisible(false);
        this.validateButton.addActionListener((ActionEvent e) -> {
            if (this.userSelected != null) {
                this.userSelected.setEvaluation(this.evaluationChildTextField.getText());
            }
            this.userService.commit();
            JOptionPane.showMessageDialog(new JFrame(), "Mise à jour effectuée.");
        });
        panel.add(validateButton);
    }

    private void buildChildrenList(JPanel panel) {
        this.childrenList = new JList(user.getChildren().toArray());
        this.childrenList.setVisibleRowCount(10);
        this.childrenList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        this.childrenList.addListSelectionListener((ListSelectionEvent e) -> {
            if (!e.getValueIsAdjusting()) {
                if (this.userSelected != null) {
                    this.userSelected.setEvaluation(this.evaluationChildTextField.getText());
                }
                this.userSelected = (User) childrenList.getSelectedValue();
                this.evaluationChildLabel.setText("Evaluation de " + userSelected + " :");
                this.evaluationChildTextField.setVisible(true);
                this.evaluationChildTextField.setText(userSelected.getEvaluation());
                this.validateButton.setVisible(true);
            }
        });
        JScrollPane scrollPane = new JScrollPane(childrenList);
        scrollPane.setBounds(10, 120, 150, 180);
        panel.add(scrollPane);
    }

    private void buildCancelButton(JPanel panel) {
        this.cancelButton = new JButton("Annuler");
        this.cancelButton.setBounds(330, 15, 100, 50);
        this.cancelButton.addActionListener((ActionEvent e) -> {
            this.userService.rollback();
            this.setVisible(false);
            new LoginFrame();
        });
        panel.add(cancelButton);
    }

    private void buildUserInfos(JPanel panel) {
        this.nameLabel = new JLabel("Vous : " + user);
        this.nameLabel.setBounds(10, 10, 300, 25);
        panel.add(nameLabel);

        if (user.getFather() != null) {
            this.nameFatherLabel = new JLabel("Votre pere : " + user.getFather());
            this.nameFatherLabel.setBounds(10, 30, 300, 25);
            panel.add(nameFatherLabel);
        }

        this.evaluationLabel = new JLabel("Votre evaluation : " + user.getEvaluation());
        this.evaluationLabel.setBounds(10, 50, 300, 25);
        panel.add(evaluationLabel);
    }
}
