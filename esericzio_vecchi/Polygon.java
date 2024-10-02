package esericzio_vecchi;

public class Polygon {
    private int nEdges;
    private float lenEdge;

    public Polygon(int nEdges, float lenEdge) {
        this.nEdges = nEdges;
        this.lenEdge = lenEdge;
    }

    public Polygon() {
        /*
        this.nEdges = 3;
        this.lenEdge = 1;
         */
        this((int)3,(float)1);
    }

    public int getnEdges() {
        return nEdges;
    }

    public void setnEdges(int nEdges) {
        this.nEdges = nEdges;
    }

    public float getLenEdge() {
        return lenEdge;
    }

    public void setLenEdge(float lenEdge) {
        this.lenEdge = lenEdge;
    }

    public float perimeter(){
        return nEdges*lenEdge;
    }
    public float area(){
        //calcolo apotema
        float theta=(float)Math.PI/nEdges;  //semiangolo al vertice dei triangoli
        float apo=lenEdge/(float)(2*Math.tan(theta));    //apotema (raggio del cerchio inscritto)
        return perimeter()*apo/2;           //area
    }
}
