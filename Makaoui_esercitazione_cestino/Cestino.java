package Makaoui_esercitazione_cestino;

public class Cestino {

    // Attributi
    private int capacity;
    private String type;
    private String color;
    private int level;

    public Cestino(int capacity, String type,  String color, int level) {
        this.capacity = capacity;
        this.type = type;
        this.color = color;
        this.level = level;
    }

    public Cestino() {
        capacity = 40;
        type = "Vetro";
        color = "Verde";
        level = 0;
    }

    // Metodi

    // get
    public int getCapacity() {
        return capacity;
    }
    public String getType() {
        return type;
    }
    public String getColor() {
        return color;
    }
    public int getLevel() {
        return level;
    }

    // set
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
    public void setType(String type) {
        this.type = type;
    }
    public void setColor(String color) {
        this.color = color;
    }
    public void setLevel(int level) {
        this.level = level;
    }

    @Override
    public String toString() {
        return "Capacita: " + capacity + " Tipo: " + type + " Colore: " + color + " Livello: " + level;
    }
}