package Esercizio_distanza_due_punti;

class Punto {

    private float x;
    private float y;
    public String name;

    Punto(){
        y = 3;
        x = 2;
    }

    Punto ( float x, float y ){

        this.x = x;
        this.y = y;
    }

    float getX() {
        return this.x;
    }
    float getY() {
        return this.y;
    }

    void SetX( float x ){
        this.x = x;
    }

    void SetY( float y ){
        this.y = y;
    }

    float Distance ( float x, float y ){
        return (float) Math.sqrt(Math.pow( this.x - x, 2) + Math.pow( this.y - y, 2));
    }

    Punto newPunto(){
        this.x = getX();
        this.y = getY();
        return new Punto( this.x, this.y );
    }

    public boolean SetName( String name ){
        if ( name.length() == 0 ) {
            return false;
        }
        this.name = name;
        return true;
    }

}
