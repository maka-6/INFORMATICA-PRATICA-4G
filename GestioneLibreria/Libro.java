package GestioneLibreria;

class Libro {
    private String titolo;
    private String autore;
    private int annoPubblicazione;
    private String genere;

    // Costruttore
    public Libro(String titolo, String autore, int annoPubblicazione, String genere) {
        this.titolo = titolo;
        this.autore = autore;
        this.annoPubblicazione = annoPubblicazione;
        this.genere = genere;
    }

    // Getters
    public String getAutore(){
        return autore;
    }
    public String getTitolo(){
        return titolo;
    }
    public int getAnnoPubblicazione(){
        return annoPubblicazione;
    }
    public String getGenere(){
        return genere;
    }
    // Setters
    public void setAutore(String autore){
        this.autore = autore;
    }
    public void setTitolo(String titolo){
        this.titolo=titolo;
    }
    public void  setAnnoPubblicazione(int annoPubblicazione){
        this.annoPubblicazione=annoPubblicazione;
    }
    public void setGenere(String genere){
        this.genere=genere;
    }
    @Override
    public String toString() {
        return "Titolo: " + titolo + ", Autore: " + autore + ", Anno: " + annoPubblicazione + ", Genere: " + genere;
    }
}