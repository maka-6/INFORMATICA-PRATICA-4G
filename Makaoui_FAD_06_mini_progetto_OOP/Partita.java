public class Partita {
    private String squadra1;
    private String squadra2;
    private Integer punteggioSquadra1 = 0;
    private Integer punteggioSquadra2 = 0;

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

    @Override
    public String toString() {
        return squadra1 + " vs " + squadra2 + "\n" + punteggioSquadra1 + "-" + punteggioSquadra2;
    }

}
