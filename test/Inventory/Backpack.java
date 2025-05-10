package test.Inventory;

import java.util.ArrayList;
import java.util.Scanner;

import test.Enum.InventoryType;
import test.Interface.Action.AddItem;
import test.Entity.Player;

public class Backpack implements AddItem{
    private ArrayList<Item> backPack = new ArrayList<>();

    public Backpack(){

    }

    @Override
    public void addItem(Item item){
        backPack.add(item);
        System.out.println("You received: " + item.getName());
    }

    public void showBackPack(Player player){
        System.out.println("=== Backpack ===");
        if (backPack.isEmpty()) {
            System.out.println("Your Backpack is empty.");
        } else {
            for (int i = 0; i < backPack.size(); i++) {
                System.out.println((i + 1) + ". " + backPack.get(i));
            }
    
            useItemBackPack(player); // ส่ง Player เข้าไป
        }
    }
    
    public void useItemBackPack(Player player){
        Scanner sc = new Scanner(System.in);
        System.out.print("Choose your backpack item: ");
        int num = sc.nextInt();
    
        if(num > 0 && num <= backPack.size()){  // ตรวจสอบ index
            Item selected = backPack.get(num - 1);  // หยิบไอเทมจาก Backpack
    
            if(selected.getItemType() == InventoryType.SWORD){
                player.itemBuffDamage(selected);
                System.out.println("Current Attack: " + player.getAttack());
            }
            else if(selected.getItemType() == InventoryType.SHIELD){
                player.itemShield(selected);
                System.out.println("Current Defense: " + player.getDefense());
            }
            else if(selected.getItemType() == InventoryType.POTION){
                player.potion(selected);
                System.out.println("Current HP: " + player.getHp());
            }
    
            // อัปเดตค่า item ใน backpack ถ้า value หมดก็ลบออก
            if (selected.getValue() <= 0) {
                backPack.remove(selected);
            }
    
        } else {
            System.out.println("Invalid choice.");
        }
    }
    
}
