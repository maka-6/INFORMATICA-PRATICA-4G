package Makaoui_Esercizio_ereditarietà_interface;

public class Gpu implements Ram {

    private String name;
    private int gen;

    public Gpu() {
        this.name = "Radeon Vega RX";
        this.gen = 7;
    }

    public Gpu(String name, int gen) {
        this.name = name;
        this.gen = gen;
    }

    // get
    public String getName() {
        return name;
    }
    public int getGen() {
        return gen;
    }

    // set
    public void setName(String name) {
        this.name = name;
    }
    public void setGen(int gen) {
        this.gen = gen;
    }

    @Override
    public String toString() {
        return "Gpu{" + "name=" + name + ", gen=" + gen + '}';
    }
}
