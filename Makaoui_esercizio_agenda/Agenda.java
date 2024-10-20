package Makaoui_esercizio_agenda;

public class Agenda {
    private Evento[] eventi;
    private int numeroEventi;

    public Agenda() {
        this.eventi = new Evento[10];  // Limite di 10 eventi
        this.numeroEventi = 0;
    }

    public void aggiungiEvento(Evento evento) {
        if (numeroEventi < eventi.length) {  // Controlla se c'è spazio nell'array
            eventi[numeroEventi] = evento;
            numeroEventi++;  // Incrementa il contatore
        } else {
            System.out.println("L'agenda è piena! Non è possibile aggiungere altri eventi.");
        }
    }

    public void mostraEventi() {
        for (int i = 0; i < numeroEventi; i++) {
            System.out.println(eventi[i]);
        }
    }
}
