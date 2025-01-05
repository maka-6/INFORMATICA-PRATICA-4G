package Makaoui_FAD_06_mini_progetto_OOP;

public class Statistiche {
    private int punteggio;
    private int puntiFatti;
    private int puntiSubiti;

    public Statistiche() {
        this.punteggio = 0;
        this.puntiFatti = 0;
        this.puntiSubiti = 0;
    }

    public void setPunteggio(int punteggio) {
        this.punteggio = punteggio;
    }
    public void setPuntiFatti(int puntiFatti) {
        this.puntiFatti = puntiFatti;
    }
    public void setPuntiSubiti(int puntiSubiti) {
        this.puntiSubiti = puntiSubiti;
    }

    public int getPunteggio() {
        return punteggio;
    }
    public int getPuntiFatti() {
        return puntiFatti;
    }
    public int getPuntiSubiti() {
        return puntiSubiti;
    }

    void aggiungiPunteggio(Integer punti){
        this.punteggio += punti;
    }

    void aggiungiPuntiFatti(Integer punti){
        this.puntiFatti += punti;
    }

    void aggiungiPuntiSubiti(Integer punti){
        this.puntiSubiti += punti;
    }

    int differenzaPunti(){
        return puntiFatti - puntiSubiti;
    }
    
}
