package Cards;

public class DefenseCard extends Card{
    int defense;

    DefenseCard(String name, int life, int number, int damage, String description, int rarity, int defense, String origin) {
        super(name, life, number, description, rarity, origin);
        this.defense = defense;
    }

    // get
    public int getDefense() {
        return defense;
    }

    // set
    public void setDefense(int defense) {
        this.defense = defense;
    }
}