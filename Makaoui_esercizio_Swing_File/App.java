package Makaoui_esercizio_Swing_File;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class App {

    private JComboBox<String> countryComboBox;
    private JTextArea notesArea;
    private JButton saveButton, openButton, closeButton;

    public App() {
        JFrame frame = new JFrame("Makaoui Esercizio Software");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);
        frame.setLayout(new BorderLayout());

        JPanel infoPanel = new JPanel(new GridLayout(2, 2));
        JLabel nameLabel = new JLabel("Nome: ");
        JTextField nameField = new JTextField();
        JLabel surnameLabel = new JLabel("Cognome: ");
        JTextField surnameField = new JTextField();

        infoPanel.add(nameLabel);
        infoPanel.add(nameField);
        infoPanel.add(surnameLabel);
        infoPanel.add(surnameField);

        // Radio Gender
        JRadioButton maleButton, femaleButton, otherButton;
        JPanel genderPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        maleButton = new JRadioButton("Male");
        femaleButton = new JRadioButton("Female");
        otherButton = new JRadioButton("Other");

        ButtonGroup genderGroup = new ButtonGroup();

        genderGroup.add(maleButton);
        genderGroup.add(femaleButton);
        genderGroup.add(otherButton);

        genderPanel.add(otherButton);
        genderPanel.add(maleButton);
        genderPanel.add(femaleButton);

        // Checkbox
        JCheckBox sportCheckBox, musicCheckBox, readingCheckBox;

        sportCheckBox = new JCheckBox("Sport");
        musicCheckBox = new JCheckBox("Music");
        readingCheckBox = new JCheckBox("Reading");

        JPanel interestPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));

        interestPanel.add(new JLabel("Interessi:"));
        interestPanel.add(sportCheckBox);
        interestPanel.add(musicCheckBox);
        interestPanel.add(readingCheckBox);

        //Nazione
        JPanel nation = new JPanel(new FlowLayout(FlowLayout.LEFT));
        String[] nazioni = {"Italia", "Francia", "Germania", "Spagna", "USA"};
        JComboBox<String> comboNazioni = new JComboBox<>(nazioni);
        nation.add(comboNazioni);

        // Creazione del pannello principale e aggiunta dei sotto-pannelli
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.add(infoPanel, BorderLayout.NORTH);
        mainPanel.add(genderPanel, BorderLayout.CENTER);
        mainPanel.add(interestPanel, BorderLayout.SOUTH);
        mainPanel.add(nation, BorderLayout.WEST);

        TextArea notesTextArea = new TextArea();
        notesTextArea.setEditable(true);
        notesArea = new JTextArea();

        mainPanel.add(notesArea, BorderLayout.CENTER);

        saveButton = new JButton("Save");
        openButton = new JButton("Open");
        closeButton = new JButton("Close");

        JMenuBar menuGroup = new JMenuBar();

        menuGroup.add(saveButton);
        menuGroup.add(openButton);
        menuGroup.add(closeButton);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));

        buttonPanel.add(saveButton);
        buttonPanel.add(openButton);
        buttonPanel.add(closeButton);

        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        saveButton.addActionListener(e -> {
            String name = nameField.getText();
            String surname = surnameField.getText();

            String gender;
            if (maleButton.isSelected()) {
                gender = "Male";
            } else if (femaleButton.isSelected()) {
                gender = "Female";
            } else {
                gender = "Other";
            }
            String interest = "";
            if (sportCheckBox.isSelected()) interest += "Sport ";
            if (musicCheckBox.isSelected()) interest += "Musica ";
            if (readingCheckBox.isSelected()) interest += "Lettura ";

            String nations = (String) comboNazioni.getSelectedItem();
            String notes = notesArea.getText();

            SaveOnFile( name, surname, gender, interest.trim(), nations, notes);
        });

        openButton.addActionListener(e -> ReadOnFile());

        frame.add(mainPanel);

        frame.setVisible(true);
    }

    private void SaveOnFile( String name, String surname, String gender, String interest, String nation, String note) {

        try {
            FileWriter fileWriter = new FileWriter("Utenti.txt");
            fileWriter.write("Nome: "+name+"\n");
            fileWriter.write("Cognomexx: "+surname+"\n");
            fileWriter.write("Genere: "+gender+"\n");
            fileWriter.write("Interessi: "+interest+"\n");
            fileWriter.write("Origine: "+nation+"\n");
            fileWriter.write(note);
            fileWriter.close();
        } catch (IOException e) {
            System.out.println("Errore nel salvataggio");
        }
    }

    private void ReadOnFile() {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("Utenti.txt"));
            StringBuilder stringBuilder = new StringBuilder();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                stringBuilder.append(line).append("\n");
            }
            bufferedReader.close();
            JOptionPane.showMessageDialog(null, stringBuilder.toString(), "Dati salvati", JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Errore durante la lettura: " + e.getMessage());
        }
    }
}