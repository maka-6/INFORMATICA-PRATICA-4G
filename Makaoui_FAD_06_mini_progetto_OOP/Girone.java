package Makaoui_FAD_06_mini_progetto_OOP;

import java.util.ArrayList;
import java.util.HashMap;

public class Girone {
    private String squadraA;
    private String squadraB;
    private String squadraC;
    private String squadraD;
    HashMap<String, Statistiche> squadre ;

    ArrayList<String> classifica;

    ArrayList<Partita> partite;

    public Girone(String squadraA, String squadraB, String squadraC, String squadraD) {
        this.squadraA = squadraA;
        this.squadraB = squadraB;
        this.squadraC = squadraC;
        this.squadraD = squadraD;

        squadre = new HashMap<>();
        squadre.put(this.squadraA, new Statistiche());
        squadre.put(this.squadraB, new Statistiche());
        squadre.put(this.squadraC, new Statistiche());
        squadre.put(this.squadraD, new Statistiche());

        classifica = new ArrayList<>();
        classifica.add(squadraA);
        classifica.add(squadraB);
        classifica.add(squadraC);
        classifica.add(squadraD);

        partite = new ArrayList<>();
        partite.add(new Partita(this.squadraA, this.squadraB));
        partite.add(new Partita(this.squadraA, this.squadraC));
        partite.add(new Partita(this.squadraA, this.squadraD));
        partite.add(new Partita(this.squadraB, this.squadraC));
        partite.add(new Partita(this.squadraB, this.squadraD));
        partite.add(new Partita(this.squadraC, this.squadraD));

    }
    
    void RegistraRisultati(){
        String squadra1;
        String squadra2;
        for (Partita partita : partite) {
            squadra1 = partita.getSquadra1();
            squadra2 = partita.getSquadra2();

            Statistiche stat1 = squadre.get(squadra1);
            Statistiche stat2 = squadre.get(squadra2);

            //aggiorna i punteggi
            if(partita.getWinner() == null){
                stat1.aggiungiPunteggio(1);
                stat2.aggiungiPunteggio(1);
            }else{
                if(partita.getWinner() == squadra1){
                    stat1.aggiungiPunteggio(3);
                }else{
                    stat2.aggiungiPunteggio(3);
                }
            }

            //aggiorna i punti fatti
            stat1.aggiungiPuntiFatti(partita.getPunteggioSquadra1());
            stat2.aggiungiPuntiFatti(partita.getPunteggioSquadra2());

            //aggiorna i punti subiti
            stat1.aggiungiPuntiSubiti(partita.getPunteggioSquadra2());
            stat2.aggiungiPuntiSubiti(partita.getPunteggioSquadra1());

            squadre.put(squadra1, stat1);
            squadre.put(squadra2, stat2);
        }
    }

    void creaClassifica(){
        String tmp;
        for(int i = 0; i < classifica.size() - 1; i++){
            for(int j = 0; j < (classifica.size() - i - 1); j++){
                if(squadre.get(classifica.get(j)).getPunteggio() > squadre.get(classifica.get(j + 1)).getPunteggio()){
                    tmp = classifica.get(j);
                    classifica.set(j, classifica.get(j + 1));
                    classifica.set((j + 1), tmp);
                }else{
                    if(squadre.get(classifica.get(j)).getPunteggio() == squadre.get(classifica.get(j + 1)).getPunteggio()){
                        if(squadre.get(classifica.get(j)).differenzaPunti() > squadre.get(classifica.get(j + 1)).differenzaPunti()){
                            tmp = classifica.get(j);
                            classifica.set(j, classifica.get(j + 1));
                            classifica.set((j + 1), tmp);
                        }
                    }
                }
            }
        }
    }

}
