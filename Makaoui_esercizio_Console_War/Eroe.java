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

    }
    
    public Eroe( String name, String role, String description, int life, int baseAttack, int baseDefense){
        this.name = name;
        this.role = role;
        this.life = life;
        this.baseAttack = baseAttack;
        this.baseAttack = baseAttack;
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

    public Boolean getDefeated() {
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
}
