package main;

public class Weapon extends Loot {
    private int damage;

    public Weapon(String name, String rarity, int damage) {
        super(name, rarity);
        this.damage = damage;
    }

    @Override
    public String getEffectDescription() {
        return "Deals " + damage + " damage";
    }

    @Override
    public String asCsvRow() {
        return "Weapon," + getName() + "," + getRarity() + "," + damage;
}
}
