package main;

import java.io.FileNotFoundException;

public class LootManagerDriver {

    private static final String START_FILE_PATH = "res/starting-loot.csv";
    private static final String END_FILE_PATH = "res/ending-loot.csv";

    public static void main(String[] args) throws FileNotFoundException {
        LootManager lootManager = LootManager.load(START_FILE_PATH);

        // TODO: Step 6
        // Uncomment these lines when you're ready.
        // Feel free to add some more!
         lootManager.add(LootFactory.create("Weapon,Pointy Stick,Common,3".split(",")));
         lootManager.add(LootFactory.create("Consumable,Bitter Little Berries,Common,12".split(",")));

        lootManager.displayInventory();

        lootManager.save(END_FILE_PATH);
    }
}
