package Makaoui_FAD_06_mini_progetto_OOP;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

class TorneoAdEliminazione {
    private String nomeDisciplina;   // Nome della disciplina sportiva
    private ArrayList<String> partecipanti;  // Lista dei partecipanti

    private Girone[] faseAgirnoni;  // Array di gironi ( 8 gironi per 32 partecipanti)

    public TorneoAdEliminazione(String nomeDisciplina) {
        this.nomeDisciplina = nomeDisciplina;
        faseAgirnoni = new Girone[8];  // 8 gironi
        partecipanti = new ArrayList<>();  // Lista vuota inizialmente
    }

    // Metodo per aggiungere i partecipanti al torneo
    public void setPartecipanti(List<String> nomi) {
        for (String nome : nomi) {
            if (!partecipanti.contains(nome)) { // Evita duplicati
                partecipanti.add(nome);
            }
        }
        // Controlla se ci sono almeno 32 partecipanti
        if (partecipanti.size() < 32) {
            System.out.println("Errore: servono 32 partecipanti. Attualmente ne hai " + partecipanti.size());
        }
    }

    // Metodo per giocare le eliminatorie con spareggio in caso di pareggio
    void giocaEliminatorie(ArrayList<String> qualificati, int numeroPartite, ArrayList<String> vincitori) {
        Partita[] eliminatorie = new Partita[numeroPartite];  // Array per le partite
        int c = 0;  // Contatore per iterare sui qualificati

        // Crea e gioca le partite eliminatorie
        for (int i = 0; i < numeroPartite; i++) {
            eliminatorie[i] = new Partita(qualificati.get(c), qualificati.get(c + 1)); // Crea una partita
            eliminatorie[i].giocaPartita();  // Gioca la partita
            System.out.println("Partita: " + eliminatorie[i].getSquadra1() + " vs " + eliminatorie[i].getSquadra2());
            System.out.println("Risultato: " + eliminatorie[i].getPunteggioSquadra1() + " - " + eliminatorie[i].getPunteggioSquadra2());

            // Se la partita finisce in pareggio, si giocano gli spareggi
            if (eliminatorie[i].getPunteggioSquadra1() == eliminatorie[i].getPunteggioSquadra2()) {
                Spareggio spareggio = new Spareggio(eliminatorie[i].getSquadra1(), eliminatorie[i].getSquadra2());
                String vincitoreSpareggio = spareggio.giocaSpareggio(); // Gioca lo spareggio
                System.out.println("La partita finisce in pareggio, si giocano gli spareggi.");
                System.out.println("Vincitore degli spareggi: " + vincitoreSpareggio);
                vincitori.add(vincitoreSpareggio);  // Aggiungi il vincitore alla lista dei vincitori
            } else {
                String vincitore = eliminatorie[i].getWinner(); // Se non ci sono spareggi, si usa il vincitore normale
                System.out.println("Vincitore: " + vincitore);
                vincitori.add(vincitore);  // Aggiungi il vincitore alla lista dei vincitori
            }

            c += 2;  // Passa ai prossimi due partecipanti
        }
    }

    // Metodo principale per giocare l'intero torneo
    void giocaTorneo() {
        ArrayList<String> qualificati = new ArrayList<>();  // Lista dei qualificati
        ArrayList<String> vincitori = new ArrayList<>();  // Lista dei vincitori

        // 1. Gioca la fase dei gironi
        System.out.println("Inizio della fase a gironi:");
        for (int i = 0; i < 8; i++) {
            faseAgirnoni[i].RegistraRisultati();  // Registra i risultati di ogni girone
        }

        // 2. Aggiungi i primi 2 qualificati di ogni girone
        System.out.println("\nQualificati dalla fase a gironi:");
        for (int i = 0; i < 8; i++) {
            qualificati.add(faseAgirnoni[i].classifica.get(0));  // Aggiungi il primo classificato
            qualificati.add(faseAgirnoni[i].classifica.get(1));  // Aggiungi il secondo classificato
            System.out.println(faseAgirnoni[i].classifica.get(0) + " e " + faseAgirnoni[i].classifica.get(1) + " si qualificano.");
        }

        // 3. Gioca gli ottavi di finale
        System.out.println("\nInizio degli ottavi di finale:");
        giocaEliminatorie(qualificati, 8, vincitori);  // Gioca 8 partite e raccogli i vincitori
        qualificati = new ArrayList<>(vincitori);  // I vincitori diventano i qualificati per la fase successiva
        vincitori.clear();  // Svuota la lista dei vincitori

        // 4. Gioca i quarti di finale
        System.out.println("\nInizio dei quarti di finale:");
        giocaEliminatorie(qualificati, 4, vincitori);  // Gioca 4 partite e raccogli i vincitori
        qualificati = new ArrayList<>(vincitori);  // I vincitori diventano i qualificati per la fase successiva
        vincitori.clear();  // Svuota la lista dei vincitori

        // 5. Gioca le semifinali
        System.out.println("\nInizio delle semifinali:");
        giocaEliminatorie(qualificati, 2, vincitori);  // Gioca 2 partite e raccogli i vincitori

        // 6. Gioca la finale
        System.out.println("\nInizio della finale:");
        Partita finale = new Partita(vincitori.get(0), vincitori.get(1));  // Crea la partita finale
        finale.giocaPartita();  // Gioca la finale
        System.out.println("Partita finale: " + finale.getSquadra1() + " vs " + finale.getSquadra2());
        System.out.println("Risultato finale: " + finale.getPunteggioSquadra1() + " - " + finale.getPunteggioSquadra2());
        System.out.println("Ha vinto " + finale.getWinner());  // Mostra il vincitore finale
    }

    // Metodo per creare i gironi e assegnare i partecipanti
    void creaGironi() {
        Collections.shuffle(partecipanti);  // Mischia la lista dei partecipanti
        int j = 0;  // Indice per attraversare i partecipanti
        // Crea 8 gironi, ognuno con 4 partecipanti
        for (int i = 0; i < 8; i++) {
            faseAgirnoni[i] = new Girone(partecipanti.get(j), partecipanti.get(j + 1), partecipanti.get(j + 2), partecipanti.get(j + 3));
            j += 4;  // Passa ai prossimi 4 partecipanti
        }
    }
}