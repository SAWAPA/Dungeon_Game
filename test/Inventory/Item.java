package test.Inventory;

import test.Enum.InventoryType;

public class Item {
    private InventoryType type;
    private String itemName;
    private String descriptions;
    private int itemDamage;
    private int itemHeal;
    private int itemShield;
    private int value;

    public Item(){

    }

    public Item(String name, String description, int value) {
        this.itemName = name;
        this.descriptions = description;
        this.value = value;
    }

    public String getName() {
        return itemName;
    }

    public String getDescription() {
        return descriptions;
    }

    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        return itemName + " (Value: " + value + ") - " + descriptions;
    }
}
