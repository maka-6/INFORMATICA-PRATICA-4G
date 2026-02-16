import java.util.*;


/*
* Autore: Youness Makaoui
* Classe: 4G
* Data: 16/02/2026
* Luogo: Home
* Versione: 2.0
* Descrizione: Esercitazione classe punto
*/

public class Punto {

    private float x, y;
    private String name;

    // costruttore base
    Punto(){
        y = 0;
        x = 0;
        name = "Origine";
    }


    Punto ( float x, float y ){
        this.x = x;
        this.y = y;
        name = "Punto";
    }

    Punto ( float x, float y, String name ){
        this.x = x;
        this.y = y;
        this.name = name;
    }

    // distanza tra due punti
    float Distance ( Punto p ){
        return (float) Math.sqrt(Math.pow( this.x - p.x, 2 ) + Math.pow( this.y - p.y, 2 ));
    }

    void setName(String name){
        this.name = name;
    }

    // comparazione distanza dall'origine'
    // trova anche se i due punti sono uguali
    int compareTo(Punto p){
        double d1, d2;
        d1 = Distance(new Punto());
        d2 = p.Distance(new Punto());

        // caso secondo punto piu vicino all'Origine
        if ( d1 < d2 )
            return -1;

        // caso primo punto piu vicino all'Origine'
        else if ( d1 > d2 )
            return 1;

        // entrambi i punti sono equidistanti dall'Origine e quindi uguali
        else
            return 0;
    }

    Punto puntoMedio(Punto p){
        return new Punto( (this.x + p.x)/2 , (this.y + p.y)/2, "Punto Medio" );
    }

    @Override
    public String toString() {
        return name + " (" + x + "," + y + ")";
    }

    public static void main(String[] args) {
        Punto punto = new Punto( 7 , 7 );
        System.out.println(punto.toString());

        Punto puntoUtente = new Punto();
        Scanner sc = new Scanner(System.in);

        System.out.println("Inserisci x: ");
        puntoUtente.x = sc.nextInt();
        System.out.println("Inserisci y: ");
        puntoUtente.y = sc.nextInt();
        puntoUtente.setName("Punto Utente");
        sc.close();

        System.out.println(puntoUtente.toString());

        if ( punto.compareTo(puntoUtente) == 1 ){
            System.out.println("Primo punto e' il piu vicino all'origine'");

        } else if ( punto.compareTo(puntoUtente) == -1 ){
            System.out.println("Il tuo punto e' il piu vicino all'origine'");

        } else {
            System.out.println("I due punti sono uguali");
        }

        System.out.println("Il punto medio: " + punto.puntoMedio(puntoUtente).toString());
    }
}
