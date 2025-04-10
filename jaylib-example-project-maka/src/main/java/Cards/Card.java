package Cards;

public class Card {
    private String name;
    private int number;
    private int life;
    private String description;
    private String origin;

    // rarità
    private int rarity;

    // se la carta e stata eliminata
    private boolean action;


    public Card(String name, int number, int life, String description, int rarity, String origin) {
        this.name = name;
        this.number = number;
        this.life = life;
        this.description = description;
        this.rarity = rarity;
        this.action = true;
        this.origin = origin;
    }

    // get
    public String getName() {
        return name;
    }
    public int getNumber() {
        return number;
    }
    public int getLife() {
        return life;
    }
    public String getDescription() {
        return description;
    }
    public int getRarity() {
        return rarity;
    }
    public boolean isAction() {
        return action;
    }
    public String getOrigin() {
        return origin;
    }

    // set
    public void setName(String name) {
        this.name = name;
    }
    public void SetNumber(int number) {
        this.number = number;
    }
    public void SetLife(int life) {
        this.life = life;
    }
    public void SetDescription(String description) {
        this.description = description;
    }
    public void SetRarity(int rarity) {
        this.rarity = rarity;
    }
    public void SetAction(boolean action) {
        this.action = action;
    }
    public void SetOrigin(String origin) {
        this.origin = origin;
    }
}