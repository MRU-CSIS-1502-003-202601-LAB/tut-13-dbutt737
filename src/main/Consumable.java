package main;

public class Consumable extends Loot {
    private int restoreAmount;

    public Consumable(String name, String rarity, int restoreAmount) {
        super(name, rarity);
        this.restoreAmount = restoreAmount;
    }

    @Override
    public String getEffectDescription() {
        return "Restores " + restoreAmount + " HP";
    }

    @Override
    public String asCsvRow() {
        return "Consumable," + getName() + "," + getRarity() + "," + restoreAmount;
}
}