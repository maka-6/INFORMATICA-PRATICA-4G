package Makaoui_FAD_06_mini_progetto_OOP;

import java.util.Random;

public class Spareggio {
    private String squadra1;
    private String squadra2;
    private int puntiSquadra1;
    private int puntiSquadra2;
    private static final int MAX_TIRI = 5; // Numero massimo di rigori

    public Spareggio(String squadra1, String squadra2) {
        this.squadra1 = squadra1;
        this.squadra2 = squadra2;
        this.puntiSquadra1 = 0;
        this.puntiSquadra2 = 0;
    }

    // Metodo per simulare un calcio di rigore
    private int tiri(String squadra) {
        Random rand = new Random();
        return rand.nextInt(2); // 0 o 1, dove 1 è punto e 0 è errore
    }

    // Metodo per giocare la serie di rigori
    public String giocaSpareggio() {
        // Tiri di rigore per entrambe le squadre
        for (int i = 0; i < MAX_TIRI; i++) {
            // Ogni squadra segna
            puntiSquadra1 += tiri(squadra1);
            puntiSquadra2 += tiri(squadra2);

            // Verifica se una squadra è già avanti abbastanza per vincere (fine prematura)
            if (puntiSquadra1 > puntiSquadra2 + (MAX_TIRI - i - 1)) {
                return squadra1; // Squadra 1 vince
            } else if (puntiSquadra2 > puntiSquadra1 + (MAX_TIRI - i - 1)) {
                return squadra2; // Squadra 2 vince
            }
        }

        // Se ci sono ancora pareggi, si continua con la morte improvvisa
        // Simuliamo il caso di morte improvvisa
        while (puntiSquadra1 == puntiSquadra2) {
            puntiSquadra1 += tiri(squadra1);
            puntiSquadra2 += tiri(squadra2);
        }

        // Determina chi ha vinto
        if (puntiSquadra1 > puntiSquadra2) {
            return squadra1;
        } else {
            return squadra2;
        }
    }

}
