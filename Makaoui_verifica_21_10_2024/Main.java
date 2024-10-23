package Makaoui_verifica_21_10_2024;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int maxStudenti = 25;
        int maxVoti = 10;
        int[] voti = new int[maxVoti];
        Studente[] studente = new Studente[maxStudenti];

        int i;
        for (i = 0; i < maxStudenti; i++) {
            studente[i] = new Studente();
            studente[i].AggiungiStudente("Mario","rossi","C0",2020);
            for (int j = 0; j < maxVoti; j++) {
                voti[j] = j + 1;
            }
            studente[i].setVoti(voti);
        }

        for (i = 0; i < maxStudenti; i++) {
            System.out.println(studente[i].toString());
        }
    }
}
