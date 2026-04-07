package main;

/**
 * Abstract parent class for all loot items.
 */
public abstract class Loot {
    private String name;
    private String rarity;

    public Loot(String name, String rarity) {
        this.name = name;
        this.rarity = rarity;
    }

    public String getName() {
        return name;
    }

    public String getRarity() {
        return rarity;
    }

    public abstract String getEffectDescription();

    public abstract String asCsvRow(); 
}
