package Makaoui_esercizio_app;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    public static void main(String[] args) {
        MainFrame app = new MainFrame();

        JLabel topPanel, midPanel, bottomPanel;
        JTextField textField;

        app.setVisible(true);
        JFrame frame = new JFrame("Mazao UI");

        frame.setLayout(new FlowLayout());
        frame.setSize(500, 500);

        JLabel label = new JLabel("Scegli un colore:");
        JLabel label2 = new JLabel("...");

        JComboBox<String> combColors;
        String[] colors = {"NERO","GIALLO","BIANCO"};
        combColors = new JComboBox<>(colors);

        textField = new JTextField();
        textField.setEditable(true);
        textField.setColumns(10);
        textField.selectAll();
        topPanel = new JLabel();
        midPanel = new JLabel();
        bottomPanel = new JLabel();

        frame.add(label);
        frame.add(label2);
        frame.add(combColors);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        combColors.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) { // Corretto "actionPerfomed" in "actionPerformed"
                String color = (String) combColors.getSelectedItem();
                label2.setText("Colore selezionato: " + color); // Mostra il colore selezionato
            }
        });
        frame.setVisible(true);
    }
}
