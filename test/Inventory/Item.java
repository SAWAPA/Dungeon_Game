package test.Inventory;

import java.util.ArrayList;
import java.util.List;

import test.Enum.ItemType;
import test.Enum.RatingType;

public class Item{
    private RatingType rateType;
    private ItemType type;
    private String itemName;
    private String descriptions;
    private int itemPower;
    private int value;
    public static List<Item> allItems = new ArrayList<>();

    public Item(){

    }

    public Item(RatingType ratingType, ItemType type, String name, String description, int power, int value) {
        this.rateType = ratingType;
        this.type = type;
        this.itemName = name;
        this.descriptions = description;
        this.itemPower = power;
        this.value = value;
    }

    static {
        // NORMAL Items
        allItems.add(new Item(RatingType.NORMAL, ItemType.SWORD, "Wooden Sword", "Basic training sword", 10, 5));
        allItems.add(new Item(RatingType.NORMAL, ItemType.SHIELD, "Wooden Shield", "Weak but usable", 8, 5));
        allItems.add(new Item(RatingType.NORMAL, ItemType.POTION, "Small Heal Potion", "Restore 20 HP", 20, 10));
        allItems.add(new Item(RatingType.NORMAL, ItemType.POTION, "Energy Drink", "Boost minor stamina", 5, 7));
        
        // RARE Items
        allItems.add(new Item(RatingType.RARE, ItemType.SWORD, "Iron Blade", "Reliable sharp sword", 50, 3));
        allItems.add(new Item(RatingType.RARE, ItemType.SHIELD, "Iron Buckler", "Decent protection", 40, 3));
        allItems.add(new Item(RatingType.RARE, ItemType.POTION, "Large Heal Potion", "Restore 100 HP", 100, 3));
        allItems.add(new Item(RatingType.RARE, ItemType.POTION, "Mana Elixir", "Restore 80 MP", 80, 2));
        allItems.add(new Item(RatingType.RARE, ItemType.SWORD, "Flame Blade", "Sword imbued with fire", 75, 2));

        // EPIC Items
        allItems.add(new Item(RatingType.EPIC, ItemType.SWORD, "Thunderfang", "Sword that strikes lightning", 120, 2));
        allItems.add(new Item(RatingType.EPIC, ItemType.SHIELD, "Guardian Wall", "Absorbs magical damage", 110, 2));
        allItems.add(new Item(RatingType.EPIC, ItemType.POTION, "Full Heal", "Completely restores HP", 500, 1));
        allItems.add(new Item(RatingType.EPIC, ItemType.POTION, "Focus Brew", "Sharpens mind for casting", 0, 1));

        // LEGEND Items
        allItems.add(new Item(RatingType.LEGEND, ItemType.SWORD, "Yoru", "Strongest sword ever made", 999, 1));
        allItems.add(new Item(RatingType.LEGEND, ItemType.SWORD, "Soul Reaper", "Steals enemy's soul", 888, 1));
        allItems.add(new Item(RatingType.LEGEND, ItemType.SHIELD, "Aegis", "Indestructible shield", 900, 1));
        allItems.add(new Item(RatingType.LEGEND, ItemType.POTION, "Elixir of Immortality", "Rumored to grant eternal life", 0, 1));
    }


    public RatingType getRatingType(){
        return rateType;
    }

    public ItemType getItemType(){
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
        return rateType + " | " +  itemName + " | " + descriptions + " | " + itemPower + " | (Value: " + value + ")";
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
