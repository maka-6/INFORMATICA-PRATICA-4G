package GestioneLibreria;

class Libreria {
    private Libro[] libri;
    private int numeroLibri;
    private final int DIMENSIONE= 10;

    // Costruttore
    public Libreria() {
        libri = new Libro[DIMENSIONE];
        numeroLibri = 0;
    }

    // Aggiunge un libro, controllando i duplicati
    public void aggiungiLibro(Libro libro) {
        if (cercaLibro(libro.getTitolo(), libro.getAutore()) == null) {
            if (numeroLibri == libri.length) {
                // Raddoppia la dimensione dell'array se è pieno
                Libro[] nuoviLibri = new Libro[libri.length * 2];
                System.arraycopy(libri, 0, nuoviLibri, 0, libri.length);
                libri = nuoviLibri;
            }
            libri[numeroLibri++] = libro;
        } else {
            System.out.println("Libro già presente.");
        }
    }

    // Cerca un libro per titolo e autore
    public Libro cercaLibro(String titolo, String autore) {
        for (int i = 0; i < numeroLibri; i++) {
            if (libri[i].getTitolo().equals(titolo) && libri[i].getAutore().equals(autore)) {
                return libri[i];
            }
        }
        return null;
    }

    // Ordina i libri per anno
    public void ordinaPerAnno() {
        
    }

    // Stampa tutti i libri
    public void stampaLibri() {
        for (int i = 0; i < numeroLibri; i++) {
            System.out.println(libri[i]);
        }
    }
}