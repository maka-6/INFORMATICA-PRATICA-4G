public class Statistiche {
    private Integer punteggio;
    private Integer puntiFatti;
    private Integer puntiSubiti;

    public Statistiche() {
        this.punteggio = 0;
        this.puntiFatti = 0;
        this.puntiSubiti = 0;
    }

    public void setPunteggio(Integer punteggio) {
        this.punteggio = punteggio;
    }
    public void setPuntiFatti(Integer puntiFatti) {
        this.puntiFatti = puntiFatti;
    }
    public void setPuntiSubiti(Integer puntiSubiti) {
        this.puntiSubiti = puntiSubiti;
    }

    public Integer getPunteggio() {
        return punteggio;
    }
    public Integer getPuntiFatti() {
        return puntiFatti;
    }
    public Integer getPuntiSubiti() {
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

    Integer differenzaPunti(){
        return puntiFatti - puntiSubiti;
    }
    
}
