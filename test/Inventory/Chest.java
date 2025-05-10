package test.Inventory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import test.Interface.Action.AddItem;

public class Chest implements AddItem{
    private Map<Item, Integer> items = new HashMap<>();

    public Chest() {

    }

    @Override
    public void addItem(Item item) {
        if (items.containsKey(item)) {
            items.put(item, items.get(item) + item.getValue());
        } else {
            items.put(item, item.getValue());
        }
    }

    public void showItems() {
        int idx = 1;
        System.out.println("=== Chest Contents ===");
        for (Map.Entry<Item, Integer> entry : items.entrySet()) {
            System.out.println(idx + " | " + entry.getKey().getName() + " x" + entry.getValue());
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
            selectedItem.getType(),
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
