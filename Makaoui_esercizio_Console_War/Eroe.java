package Makaoui_esercizio_Console_War;

public class Eroe extends Arma{

    // generiche
    String name;
    String role;
    String description;

    private Boolean defeated;

    // combattimento
    int life;
    int baseAttack;
    int baseDefense;
    
    public Eroe(){
        super();
        this.name = "";
        this.role = "";
        this.description = "";
        this.defeated = false;
        this.life = 100;
        this.baseAttack = 10;
        this.baseDefense = 10;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean isDefeated() {
        return defeated;
    }

    public void setDefeated(Boolean defeated) {
        this.defeated = defeated;
    }

    public int getLife() {
        return life;
    }

    public void setLife(int life) {
        this.life = life;
    }

    public int getBaseAttack() {
        return baseAttack;
    }

    public void setBaseAttack(int baseAttack) {
        this.baseAttack = baseAttack;
    }

    public int getBaseDefense() {
        return baseDefense;
    }

    public void setBaseDefense(int baseDefense) {
        this.baseDefense = baseDefense;
    }

    @Override
    public String toString() {
        return "Eroe{" +
               "name='" + name + '\'' +
               ", role='" + role + '\'' +
               ", description='" + description + '\'' +
               ", defeated=" + defeated +
               ", life=" + life +
               ", baseAttack=" + baseAttack +
               ", baseDefense=" + baseDefense +
               '}';
    }
}
