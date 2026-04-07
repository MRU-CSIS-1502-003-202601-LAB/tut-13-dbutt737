package main;

public class LootFactory {

    public static Loot create(String[] parts) {
        String type = parts[0];
        String name = parts[1];
        String rarity = parts[2];
        int value = Integer.parseInt(parts[3]);

        if (type.equals("Weapon")) {
            return new Weapon(name, rarity, value);
        } else if (type.equals("Consumable")) {
            return new Consumable(name, rarity, value);
        } else {
            throw new IllegalArgumentException("Unknown loot type: " + type);
        }
    }
}
