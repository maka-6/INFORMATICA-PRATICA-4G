package Makaoui_FAD_02;

public class Complex extends Point {

    Complex(double r,double i){
        super(r,i);
    }

    // get
    double getReal(){
        return super.getX();
    }
    double getImg(){
        return super.getY();
    }

    // set
    void setReal(double d){
        super.setX(d);
    }
    void setImg(double d){
        super.setY(d);
    }

    double modulo(){
        Point p = new Point(0,0);
        return super.distance( p.getX(), p.getY() );
    }

    double arg(){
        double a=Math.atan(super.getY()/super.getX());
        if(super.getX() < 0 && super.getY() < 0)
            a+=Math.PI;
        if(super.getX() > 0 && super.getY() < 0)
            a+=Math.PI;
        return a;
    }

    // Metodo Somma
    public Complex add(Complex b) {
        double realPart = this.getReal() + b.getReal();
        double imaginaryPart = this.getImg() + b.getImg();
        return new Complex(realPart, imaginaryPart);
    }

    // Metodo Sottrazione
    public Complex subtract(Complex b) {
        double realPart = this.getReal() - b.getReal();
        double imaginaryPart = this.getImg() - b.getImg();
        return new Complex(realPart, imaginaryPart);
    }

    // metodo moltiplicazione
    // z1 x z2 = (ac-bd)+(ad-bc)i
    public Complex multiply(Complex b) {
        double realPart = this.getReal() * b.getReal() - this.getImg() * b.getImg();
        double imaginaryPart = this.getReal() * b.getImg() + this.getImg() * b.getReal();
        return new Complex(realPart, imaginaryPart);
    }
}