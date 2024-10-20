package GestioneLibreria;

public class Main {
    public static void main(String[] args) {
        Libreria libreria = new Libreria();

        // Aggiungi libri alla libreria
        libreria.aggiungiLibro(new Libro("Il Nome della Rosa", "Umberto Eco", 1980, "Mistero"));
        // ... altri libri

        // Cerca un libro
        Libro libroCercato = libreria.cercaLibro("Il Nome della Rosa", "Umberto Eco");
        if (libroCercato != null) {
            System.out.println("Trovato: " + libroCercato);
        }

        // Ordina e stampa i libri
        //libreria.ordinaPerAnno();
        libreria.stampaLibri();
    }
}