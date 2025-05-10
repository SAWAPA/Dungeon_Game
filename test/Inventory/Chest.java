package test.Inventory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import test.Interface.Action.AddItem;
import test.Enum.*;

public class Chest implements AddItem{
    private Map<Item, Integer> items = new HashMap<>();
    private List<Item> itemList = new ArrayList<>();
    private RatingType ratingType;

    public Chest(RatingType ratingType) {
        this.ratingType = ratingType;
    }

    @Override
    public void addItem(Item item) {
        if (items.containsKey(item)) {
            items.put(item, items.get(item) + item.getValue());
        } else {
            items.put(item, item.getValue());
        }
    }

    //random Item in chest
    public void openChest(){

    }

    public void showItems() {
        int idx = 1;
        System.out.println("=== Chest Type: " + ratingType.name() + " ===");
        for (Map.Entry<Item, Integer> entry : items.entrySet()) {
            Item item = entry.getKey();
            int qty = entry.getValue();
            System.out.println(idx + " | " + item.getRatingType() + " | " + item.getItemType().name() + " | " + item.getName() + " x" + qty);
            idx++;
        }
    }

    public void getItems(int num, Backpack backpack) {
        List<Item> itemList = new ArrayList<>(items.keySet());

        if (num < 1 || num > itemList.size()) {
            System.out.println("Invalid item number.");
            return;
        }

        Item selectedItem = itemList.get(num - 1);
        int quantity = items.get(selectedItem);

        // Add 1 piece to backpack
        backpack.addItem(new Item(
            selectedItem.getRatingType(),
            selectedItem.getItemType(),
            selectedItem.getName(),
            selectedItem.getDescription(),
            selectedItem.getPower(),
            1
        ));

        // Adjust the amount in chest
        if (quantity > 1) {
            items.put(selectedItem, quantity - 1);
        } else {
            items.remove(selectedItem);
        }

        System.out.println("Add " + selectedItem.getName() + " to backpack.");
    }
}
