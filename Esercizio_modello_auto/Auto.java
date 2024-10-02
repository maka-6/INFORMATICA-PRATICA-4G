package Esercizio_modello_auto;

public class Auto {

    private float height, width;
    private float weight;
    private int seats;
    private int color;

    private int horsePower;

    private String brand, name, model;

    // flag per benzina o diesel
    private boolean fuel;


    // dimensioni e posti
    void SetDim( float height, float width, float weight ){

        this.height = height;
        this.width = width;
        this.weight = weight;
    }
    void SetSeats( int seats ){
        this.seats = seats;
    }

    // carburante
    void SetFuel( boolean fuel ){

        this.fuel = fuel;
    }

    // colore
    void SetColor( int color ){
        this.color = color;
    }

    // marca modello
    void SetBrand( String brand ){
        this.brand = brand;
    }
    void SetName( String name ){
        this.name = name;
    }
    void SetModel( String model ){
        this.model = model;
    }

    // cavalli di potenza
    void SetHorsePower( int horsePower ){
        this.horsePower = horsePower;
    }


    // dimensioni
    float GetHeight(){
        return height;
    }
    float GetWidth(){
        return width;
    }
    float GetWeight(){
        return weight;
    }
    int GetSeats(){
        return seats;
    }

    // carburante
    boolean GetFuel(){
        return fuel;
    }

    // colore
    int GetColor(){
        return color;
    }

    // brand e marca
    String GetBrand(){
        return brand;
    }
    String GetName(){
        return name;
    }
    String GetModel(){
        return model;
    }

    // cavalli
    int GetHorsePower(){
        return horsePower;
    }
}
