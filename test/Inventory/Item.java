package test.Inventory;

import test.Enum.InventoryType;

public class Item{
    private InventoryType type;
    private String itemName;
    private String descriptions;
    private int itemPower;
    private int value;

    public Item(){

    }

    public Item(InventoryType type, String name, String description, int power, int value) {
        this.type = type;
        this.itemName = name;
        this.descriptions = description;
        this.itemPower = power;
        this.value = value;
    }

    public InventoryType getType(){
        return type;
    }

    public String getName(){
        return itemName;
    }

    public String getDescription(){
        return descriptions;
    }

    public int getValue(){
        return value;
    }

    public int getPower(){
        return itemPower;
    }

    public void decreaseValue(){
        this.value--;
    }

    @Override
    public String toString() {
        return itemName + " | " + descriptions + " | " + "(Value: " + value + ")";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Item)) return false;
        Item item = (Item) o;
        return itemName.equals(item.itemName);
    }

    @Override
    public int hashCode() {
        return itemName.hashCode();
    }
}
