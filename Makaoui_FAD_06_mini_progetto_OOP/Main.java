package Makaoui_FAD_06_mini_progetto_OOP;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Creazione di un oggetto Scanner per leggere l'input da tastiera
        Scanner scanner = new Scanner(System.in);

        // Richiesta all'utente di inserire il nome dello sport
        System.out.print("Inserisci il nome della disciplina sportiva: ");
        String nomeSport = scanner.nextLine();  // Legge il nome dello sport inserito dall'utente

        // Impostazione del percorso del file con i nomi delle squadre
        String filePath = "squadre.txt"; // Percorso del file delle squadre

        // Creazione dell'oggetto TorneoAdEliminazione con il nome della disciplina scelto dall'utente
        TorneoAdEliminazione torneo = new TorneoAdEliminazione(nomeSport);

        try {
            // Lettura dei nomi delle squadre dal file e aggiunta dei partecipanti al torneo
            List<String> nomi = LetturaFile.leggiNomiDaFile(filePath);
            torneo.setPartecipanti(nomi);  // Aggiungi i partecipanti

            // Creazione dei gironi con i partecipanti letti dal file
            torneo.creaGironi();

            // Avvio del torneo: fase a gironi + eliminatorie
            torneo.giocaTorneo();

        } catch (IOException e) {
            // Gestione degli errori nel caso ci sia un problema nella lettura del file
            System.out.println("Errore durante la lettura del file: " + e.getMessage());
        } finally {
            scanner.close();  // Chiusura dello Scanner
        }
    }
}
