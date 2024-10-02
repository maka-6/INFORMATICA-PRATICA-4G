public class Main {
    public static void main(String[] args) {

        Polygon p, q;
        p=new Polygon(6,1);
        q=new Polygon();
        System.out.println(p.perimeter());
        System.out.println(p.area());
        System.out.println();
        System.out.println(q.perimeter());
        System.out.println(q.area());

    }
}