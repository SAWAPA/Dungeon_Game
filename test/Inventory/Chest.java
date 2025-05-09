package test.Inventory;

import java.util.HashMap;
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
        System.out.println("=== Chest Contents ===");
        for (Map.Entry<Item, Integer> entry : items.entrySet()) {
            System.out.println(entry.getKey().getName() + " x" + entry.getValue());
        }
    }

    public Map<Item, Integer> getItems() {
        return items;
    }
}
