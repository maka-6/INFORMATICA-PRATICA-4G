package Makaoui_esercizio_agenda;
import java.util.Calendar;

public class MainAgenda {
    public static void main(String[] args) {
        Agenda agenda = new Agenda();

        // Imposta una data valida
        Calendar dataEvento = Calendar.getInstance();
        dataEvento.set(2024, Calendar.OCTOBER, 20, 10, 30);  // Data personalizzata

        // Aggiungi un evento
        agenda.aggiungiEvento(new Evento("Visita medica", dataEvento, "Legnano", true));

        // Stampa tutti gli eventi
        agenda.mostraEventi();
    }
}