package Makaoui_FAD_06_mini_progetto_OOP;

import java.util.Random;

public class Partita {
    private String squadra1;
    private String squadra2;
    private int punteggioSquadra1 = 0;
    private int punteggioSquadra2 = 0;

    public Partita(String squadra1, String squadra2) {
        this.squadra1 = squadra1;
        this.squadra2 = squadra2;
    }

    public String getSquadra1() {
        return squadra1;
    }
    public String getSquadra2() {
        return squadra2;
    }
    public int getPunteggioSquadra1() {
        return punteggioSquadra1;
    }
    public int getPunteggioSquadra2() {
        return punteggioSquadra2;
    }

    public void setSquadra1(String squadra1) {
        this.squadra1 = squadra1;
    }
    public void setSquadra2(String squadra2) {
        this.squadra2 = squadra2;
    }
    public void setPunteggioSquadra1(int punteggioSquadra1) {
        this.punteggioSquadra1 = punteggioSquadra1;
    }
    public void setPunteggioSquadra2(int punteggioSquadra2) {
        this.punteggioSquadra2 = punteggioSquadra2;
    }

    // cerco il nome del vincitore se esiste
    String getWinner(){
        if(punteggioSquadra1 > punteggioSquadra2){
            return squadra1;
        }else if(punteggioSquadra1 < punteggioSquadra2){
            return squadra2;
        }
        return null;    //In caso di pareggio
    }

    //
    void giocaPartita(){
        Random random = new Random();
        punteggioSquadra1 = random.nextInt(15);
        punteggioSquadra2 = random.nextInt(15);
    }

    @Override
    public String toString() {
        return squadra1 + " vs " + squadra2 + "\n" + punteggioSquadra1 + "-" + punteggioSquadra2;
    }
}
