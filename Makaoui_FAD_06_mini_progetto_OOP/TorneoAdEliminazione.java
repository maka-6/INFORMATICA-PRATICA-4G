package Makaoui_FAD_06_mini_progetto_OOP;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class TorneoAdEliminazione{
    private String nomeDisciplina;
    private ArrayList<String> partecipanti;

    private Girone[] faseAgirnoni;

    public TorneoAdEliminazione(String nomeDisciplina) {
        this.nomeDisciplina = nomeDisciplina;
        faseAgirnoni = new Girone[8];
        partecipanti = new ArrayList<>();
    }

    public void setPartecipanti(Scanner scanner) {
        String nome;
        for (int i = 0; i < 32; i++) {
            do {
                System.out.println("Partecipante " + i + ": ");
                nome = scanner.nextLine();
                if(partecipanti.contains(nome)){
                    System.out.println("Il nome di questo partecipante è gia presente nella lista");
                }
            }while(partecipanti.contains(nome));
            this.partecipanti.add(nome);
        }
    }

    void giocaEliminatorie(ArrayList<String> qualificati, int numeroPartite, ArrayList<String> vincitori) {
        PartitaConWinner[] eliminatorie = new PartitaConWinner[numeroPartite];
        int c = 0;
        for (int i = 0; i < numeroPartite; i++) {
            eliminatorie[i] = new PartitaConWinner(qualificati.get(c), qualificati.get(c + 1));
            vincitori.add(eliminatorie[i].getWinner());
            c += 2;
        }
    }    

    void giocaTorneo(){
        ArrayList<String> qualificati = new ArrayList<>();
        ArrayList<String> vincitori = new ArrayList<>();
        Integer c = 0;

        //gioca gironi
        for (int i = 0; i < 8; i++) {
            faseAgirnoni[i].RegistraRisultati();
        }

        for (int i = 0; i < 8; i++) {
            qualificati.add(faseAgirnoni[i].classifica.get(0));
            qualificati.add(faseAgirnoni[i].classifica.get(1));
        }

        //gioca ottavi
        giocaEliminatorie(qualificati, 8, vincitori);
        qualificati = new ArrayList<>(vincitori);
        vincitori.clear();
    
        //gioca quarti
        giocaEliminatorie(qualificati, 4, vincitori);
        qualificati = new ArrayList<>(vincitori);
        vincitori.clear();
    
        //gioca semifinali
        giocaEliminatorie(qualificati, 2, vincitori);
    
        PartitaConWinner finale = new PartitaConWinner(vincitori.get(0), vincitori.get(1));
        System.out.println("Ha vinto " + finale.getWinner());
    }
    

    void creaGironi(){
        Collections.shuffle(partecipanti);
        Integer j = 0;
        
        for(int i = 0; i < 8; i++){
            faseAgirnoni[i] = new Girone(partecipanti.get(j), partecipanti.get(j + 1), partecipanti.get(j + 2), partecipanti.get(j + 3));
            j += 4;
        }
    }
    
}
