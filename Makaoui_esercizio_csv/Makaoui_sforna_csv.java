package Makaoui_esercizio_csv;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;

public class Makaoui_sforna_csv {

    public static void main(String[] args) {
        String fileName = "Makaoui_esercizio_csv/example.csv";

        try (FileWriter writer = new FileWriter(fileName)) {
            // Scrivi l'intestazione
            writer.append("Nome,Cognome,Età\n");
            // Scrivi i dati
            writer.append("Mario,Rossi,30\n");
            writer.append("Luca,Bianchi,25\n");
            writer.append("Anna,Verdi,22\n");

            System.out.println("File CSV creato con successo!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public class CsvHoven {
        public static void main(String[] args) {
            String fileName = "Makaoui_esercizio_csv/example.csv";

            try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    String[] values = line.split(",");
                    System.out.println("Nome: " + values[0] + ", Cognome: " + values[1] + ", Età: " + values[2]);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
