package Makaoui_verifica_21_10_2024;

public class Studente {
    private String nome;
    private String cognome;
    private String matricola;
    private int dataIscrizione;
    private int[] voti;

    public void AggiungiStudente(String nome, String cognome, String matricola, int dataIscrizione) {
        this.nome = nome;
        this.cognome = cognome;
        this.matricola = matricola;
        this.dataIscrizione = dataIscrizione;
    }

    public Studente(){
        this.nome = "mario";
        this.cognome = "rossi";
        this.matricola = "C03";
        this.dataIscrizione = 2021;
    }

    public int AnniTrascorsi( int annoAttuale ){
        if ( annoAttuale < this.dataIscrizione ){
            System.out.println("Inserire una data valida");
            return 0;
        }
        return annoAttuale - this.dataIscrizione;
    }


    // get
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getCognome() {
        return cognome;
    }
    public int getDataIscrizione() {
        return dataIscrizione;
    }
    public int getVoti( int n ) {
        for (int i = 0; i < n; i++)
            return this.voti[i];
        return 0;
    }
    public double getMedia( int[] voti, int n ) {
        float media = 0;
        for (int i = 0; i < n; i++) {
            media += voti[i];
        }
        return media / n;
    }

    // set
    public void setCognome(String cognome) {
        this.cognome = cognome;
    }
    public String getMatricola() {
        return matricola;
    }
    public void setMatricola(String matricola) {
        this.matricola = matricola;
    }
    public void setDataIscrizione(int dataIscrizione) {
        this.dataIscrizione = dataIscrizione;
    }
    public void setVoti(int[] voti) {
        this.voti = voti;
    }

    @Override
    public String toString() {
        return "\nStudente: " + nome + " " + cognome + "\nMatricola N.: " + matricola + "\nData di Iscrizione: " + dataIscrizione + "\nMedia: " + getMedia(voti, voti.length) + "\nAnno trascorsi: " + AnniTrascorsi(2024);
    }

}
