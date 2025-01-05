package Makaoui_FAD_06_mini_progetto_OOP;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Inserisci il nome della disciplina: ");
        String nomeDisciplina = scanner.nextLine();
        TorneoAdEliminazione torneo = new TorneoAdEliminazione(nomeDisciplina);

        System.out.println("Inserisci i nomi dei partecipanti:");
        torneo.setPartecipanti(scanner);

        torneo.creaGironi();

        torneo.giocaTorneo();

        scanner.close();
    }
}
