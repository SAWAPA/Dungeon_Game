package test.Inventory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import test.Interface.Action.AddItem;
import test.Enum.*;

public class Chest implements AddItem {
    private Map<Item, Integer> items = new HashMap<>();
    private RatingType chestType;

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

    public void openChest() {
        Random random = new Random();
        // สุ่ม RatingType ของ Chest
        RatingType[] types = RatingType.values();
        this.chestType = types[random.nextInt(types.length)]; // เก็บไว้ถ้าอยากแสดงผล

        System.out.println("Chest Type: " + chestType); // แสดงประเภทของกล่อง

        // กำหนดจำนวนไอเท็มขั้นต่ำตามประเภทของ Chest
        int minItemCount = 2;
        int maxItemCount = 4; // ค่าเริ่มต้น

        switch (chestType) {
            case NORMAL:
                maxItemCount = 4; // Normal มี 2-4 ชิ้น
                break;
            case RARE:
                maxItemCount = 6; // Rare มี 2-6 ชิ้น
                break;
            case EPIC:
                maxItemCount = 7; // Epic มี 2-7 ชิ้น
                break;
            case LEGEND:
                maxItemCount = 9; // Legend มี 2-9 ชิ้น
                break;
            default:
                break;
        }

        // สุ่มจำนวนไอเท็มในกล่อง (ตามช่วงที่กำหนด)
        int itemCount = random.nextInt(maxItemCount - minItemCount + 1) + minItemCount; // สุ่มจำนวนไอเท็มตามช่วง

        if (itemCount < 2) {
            itemCount = 2; // ทำให้จำนวนไอเท็มมีอย่างน้อย 2 ชิ้น
        }
        // สร้าง Set เพื่อเก็บ RatingType ที่เลือกไปแล้ว
        Set<RatingType> selectedRatings = new HashSet<>();

        // สร้าง 1 ไอเท็มที่มี ratingType ตรงกับ chestType เสมอ
        List<Item> guaranteedItems = Item.allItems.stream()
            .filter(item -> item.getRatingType() == this.chestType)
            .toList();

        if (!guaranteedItems.isEmpty()) {
            Item guaranteed = guaranteedItems.get(random.nextInt(guaranteedItems.size()));
            addItem(copyItem(guaranteed));  // เพิ่มไอเท็มที่ตรงกับ chestType
            selectedRatings.add(this.chestType); // เพิ่ม ratingType ของไอเท็มที่เราเพิ่มลงใน Set
        }

        // เพิ่มไอเท็มที่เหลือตามจำนวนที่สุ่ม
        int remaining = itemCount - 1; // ลด 1 สำหรับไอเท็มที่เราเพิ่มแล้ว

        for (int i = 0; i < remaining; i++) {
            RatingType randomRate = getWeightedRatingType(chestType);

            // ต้องทำให้แน่ใจว่าไอเท็มที่เราสุ่มได้ ไม่ซ้ำกับที่ได้เพิ่มไปแล้ว
            if (!selectedRatings.contains(randomRate)) {
                List<Item> filtered = Item.allItems.stream()
                    .filter(item -> item.getRatingType() == randomRate)
                    .toList();

                if (!filtered.isEmpty()) {
                    Item randomItem = filtered.get(random.nextInt(filtered.size()));
                    addItem(copyItem(randomItem));
                    selectedRatings.add(randomRate); // เพิ่ม ratingType ที่สุ่มไปแล้วลงใน Set
                }
            }
        }
    }



    private Item copyItem(Item item) {
        return new Item(
            item.getRatingType(),
            item.getItemType(),
            item.getName(),
            item.getDescription(),
            item.getPower(),
            1 // เพิ่มไอเท็ม 1 ชิ้น
        );
    }

    private RatingType getWeightedRatingType(RatingType chestType) {
        Random random = new Random();
        int roll = random.nextInt(100);

        switch (chestType) {
            case NORMAL:
                if (roll < 80) return RatingType.NORMAL;
                else if (roll < 95) return RatingType.RARE;
                else return RatingType.EPIC;
            case RARE:
                if (roll < 20) return RatingType.NORMAL;
                else if (roll < 70) return RatingType.RARE;
                else return RatingType.EPIC;
            case EPIC:
                if (roll < 10) return RatingType.NORMAL;
                else if (roll < 40) return RatingType.RARE;
                else if (roll < 80) return RatingType.EPIC;
                else return RatingType.LEGEND;
            case LEGEND:
                if (roll < 10) return RatingType.NORMAL; // 10%
                else if (roll < 25) return RatingType.RARE; // 10–24 → 15%
                else if (roll < 50) return RatingType.EPIC; // 25–49 → 25%
                else return RatingType.LEGEND; // 50–99 → 50%

            default:
                return RatingType.NORMAL;
        }
    }

    public void showItems() {
        int idx = 1;
        System.out.println("=== Chest Type: " + chestType.name() + " ===");
        for (Map.Entry<Item, Integer> entry : items.entrySet()) {
            Item item = entry.getKey();
            int qty = entry.getValue();
            System.out.println(idx + " | " + item.getRatingType() + " | " + item.getItemType().name() + " | " + item.getName() + " x" + qty);
            idx++;
        }
    }

    // Method to transfer item from chest to backpack
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

        System.out.println("Added " + selectedItem.getName() + " to backpack.");
    }
}
