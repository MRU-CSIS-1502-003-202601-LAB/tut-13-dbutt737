package main;

import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Manages the inventory of RPG Loot.
 */
public class LootManager {
    private ArrayList<Loot> inventory;

    private LootManager() {
        this.inventory = new ArrayList<>();
    }

    public void add(Loot loot) {
        inventory.add(loot);
    }

    public static LootManager load(String filePath) throws FileNotFoundException {
        LootManager lootManager = new LootManager();
        Scanner fileScanner = new Scanner(new File(filePath));

        if (fileScanner.hasNextLine()) {
            fileScanner.nextLine(); // skip header
        }

        while (fileScanner.hasNextLine()) {
            String line = fileScanner.nextLine().trim();

            if (!line.isEmpty()) {
                String[] parts = line.split(",");
                Loot loot = LootFactory.create(parts);
                lootManager.add(loot);
            }
        }

        fileScanner.close();
        return lootManager;
    }

    /**
     * Polymorphically displays all items in the inventory.
     */
    public void displayInventory() {
        System.out.println();
        System.out.println("--- Current Inventory ---");
        for (Loot item : inventory) {
            System.out.println(item.getName() + " [" + item.getRarity() + "] - "
                    + item.getEffectDescription());
        }
        System.out.println("-------------------------");
        System.out.println();
    }

    public void save(String filePath) throws FileNotFoundException {
        PrintWriter writer = new PrintWriter(filePath);

        writer.println("type,name,rarity,value");

        for (Loot item : inventory) {
           writer.println(item.asCsvRow());
        }

        writer.close();
    }
}