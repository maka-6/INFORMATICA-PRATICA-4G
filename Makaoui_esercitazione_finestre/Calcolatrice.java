package Makaoui_esercitazione_finestre;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calcolatrice {
    public static void main(String[] args) {
        // Creazione della finestra
        JFrame frame = new JFrame("Calcolatrice");
        frame.setSize(300, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null); // Posizionamento manuale

        // Campi di testo per inserire i numeri
        JTextField numero1Field = new JTextField();
        numero1Field.setBounds(50, 20, 80, 30);

        JTextField numero2Field = new JTextField();
        numero2Field.setBounds(150, 20, 80, 30);

        // Pulsanti per le operazioni
        JButton sommaButton = new JButton("+");
        sommaButton.setBounds(50, 60, 50, 30);

        JButton sottrazioneButton = new JButton("-");
        sottrazioneButton.setBounds(110, 60, 50, 30);

        JButton moltiplicazioneButton = new JButton("*");
        moltiplicazioneButton.setBounds(170, 60, 50, 30);

        JButton divisioneButton = new JButton("/");
        divisioneButton.setBounds(230, 60, 50, 30);

        // Etichetta per mostrare il risultato
        JLabel risultatoLabel = new JLabel("Risultato:");
        risultatoLabel.setBounds(50, 100, 200, 30);

        // Aggiunta dei componenti alla finestra
        frame.add(numero1Field);
        frame.add(numero2Field);
        frame.add(sommaButton);
        frame.add(sottrazioneButton);
        frame.add(moltiplicazioneButton);
        frame.add(divisioneButton);
        frame.add(risultatoLabel);

        // Aggiunta delle azioni per i pulsanti
        sommaButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    double numero1 = Double.parseDouble(numero1Field.getText());
                    double numero2 = Double.parseDouble(numero2Field.getText());
                    risultatoLabel.setText("Risultato: " + (numero1 + numero2));
                } catch (NumberFormatException ex) {
                    risultatoLabel.setText("Errore: inserire numeri validi!");
                }
            }
        });

        sottrazioneButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    double numero1 = Double.parseDouble(numero1Field.getText());
                    double numero2 = Double.parseDouble(numero2Field.getText());
                    risultatoLabel.setText("Risultato: " + (numero1 - numero2));
                } catch (NumberFormatException ex) {
                    risultatoLabel.setText("Errore: inserire numeri validi!");
                }
            }
        });

        moltiplicazioneButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    double numero1 = Double.parseDouble(numero1Field.getText());
                    double numero2 = Double.parseDouble(numero2Field.getText());
                    risultatoLabel.setText("Risultato: " + (numero1 * numero2));
                } catch (NumberFormatException ex) {
                    risultatoLabel.setText("Errore: inserire numeri validi!");
                }
            }
        });

        divisioneButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    double numero1 = Double.parseDouble(numero1Field.getText());
                    double numero2 = Double.parseDouble(numero2Field.getText());
                    if (numero2 != 0) {
                        risultatoLabel.setText("Risultato: " + (numero1 / numero2));
                    } else {
                        risultatoLabel.setText("Errore: divisione per zero!");
                    }
                } catch (NumberFormatException ex) {
                    risultatoLabel.setText("Errore: inserire numeri validi!");
                }
            }
        });

        // Mostra la finestra
        frame.setVisible(true);
    }
}