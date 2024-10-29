package Makaoui_FAD_02;

class Point {

    private double x;
    private double y;
    public String name;

    Point(){
        y = 3;
        x = 2;
    }

    Point( double x, double y ){
        this.x = x;
        this.y = y;
    }

    double getX() {
        return this.x;
    }
    double getY() {
        return this.y;
    }

    void setX( double x ){
        this.x = x;
    }
    void setY( double y ){
        this.y = y;
    }

    double distance ( double x, double y ){
        return Math.sqrt(Math.pow( this.x - x, 2) + Math.pow( this.y - y, 2));
    }

    Point newPunto(){
        this.x = getX();
        this.y = getY();
        return new Point( this.x, this.y );
    }

    public boolean SetName( String name ){
        if ( name.length() == 0 ) {
            return false;
        }
        this.name = name;
        return true;
    }

}
