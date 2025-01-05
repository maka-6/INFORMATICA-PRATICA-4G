package Makaoui_FAD_06_mini_progetto_OOP;

import java.util.Random;

public class PartitaConWinner {
    private String squadra1;
    private String squadra2;
    private Integer punteggioSquadra1 = 0;
    private Integer punteggioSquadra2 = 0;

    public PartitaConWinner(String squadra1, String squadra2) {
        this.squadra1 = squadra1;
        this.squadra2 = squadra2;
        giocaPartita();
    }

    public String getSquadra1() {
        return squadra1;
    }
    public String getSquadra2() {
        return squadra2;
    }
    public Integer getPunteggioSquadra1() {
        return punteggioSquadra1;
    }
    public Integer getPunteggioSquadra2() {
        return punteggioSquadra2;
    }

    public void setSquadra1(String squadra1) {
        this.squadra1 = squadra1;
    }
    public void setSquadra2(String squadra2) {
        this.squadra2 = squadra2;
    }
    public void setPunteggioSquadra1(Integer punteggioSquadra1) {
        this.punteggioSquadra1 = punteggioSquadra1;
    }
    public void setPunteggioSquadra2(Integer punteggioSquadra2) {
        this.punteggioSquadra2 = punteggioSquadra2;
    }

    String getWinner(){
        if(punteggioSquadra1 > punteggioSquadra2){
            return squadra1;
        }else{
            if(punteggioSquadra1 < punteggioSquadra2){
                return squadra2;
            }else{
                return null;    //In caso di pareggio
            }
        }
        
    }

    void giocaPartita(){
        Random random = new Random();
        punteggioSquadra1 = random.nextInt(15);
        punteggioSquadra2 = random.nextInt(15);
    }

    @Override
    public String toString() {
        return squadra1 + " vs " + squadra2 + " : " + punteggioSquadra1 + "-" + punteggioSquadra2;
    }

}
