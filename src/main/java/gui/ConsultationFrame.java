package gui;

import domain.IUser;
import domain.User;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import java.awt.*;

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

    public ConsultationFrame(IUser user){
        super("Consultation", 450, 350);
        this.user = user;
        this.setContentPane(buildContentPane());
        this.setVisible(true);
    }

    private Container buildContentPane() {
        Panel panel = new Panel();
        panel.setLayout(null);

        this.nameLabel = new JLabel("Vous : "+ user);
        this.nameLabel.setBounds(10, 10, 300, 25);
        panel.add(nameLabel);

        this.nameFatherLabel = new JLabel("Votre pere : "+ user.getFather());
        this.nameFatherLabel.setBounds(10, 30, 300, 25);
        panel.add(nameFatherLabel);

        this.evaluationLabel = new JLabel("Votre evaluation : "+ user.getEvaluation());
        this.evaluationLabel.setBounds(10, 50, 300, 25);
        panel.add(evaluationLabel);

        this.cancelButton = new JButton("Annuler");
        this.cancelButton.setBounds(330, 15, 100, 50);
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
        panel.add(validateButton);

        this.childrenList = new JList(user.getChildren().toArray());
        this.childrenList.setVisibleRowCount(10);
        this.childrenList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        this.childrenList.addListSelectionListener((ListSelectionEvent e) -> {
            if (!e.getValueIsAdjusting()) {
                User personneSelected = (User) childrenList.getSelectedValue();
                this.evaluationChildLabel.setText("Evaluation de "+personneSelected+" :");
                this.evaluationChildArea.setVisible(true);
                this.evaluationChildArea.setText(personneSelected.getEvaluation());
                this.validateButton.setVisible(true);
            }
        });
        JScrollPane scrollPane = new JScrollPane(childrenList);
        scrollPane.setBounds(10, 120, 150, 180);
        panel.add(scrollPane);

        return panel;
    }
}
