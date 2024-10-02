package Esercizio_modello_auto;

public class TestAuto {
    public static void main(String[] args) {
        Auto auto = new Auto();
        // scrivo questo perchè hi avuto problemi
        float a = 14 ,b = 2,c = 300;
        auto.SetDim( a, b, c );
        auto.SetBrand( "BMW" );
        auto.SetName( "Serie 3" );
        auto.SetModel( "M3 GTR" );
        // true benzina, false diesel
        auto.SetFuel( false );
        auto.SetColor( 3 );
        // posti
        auto.SetSeats( 5 );
        auto.SetHorsePower( 250 );

    }
}
