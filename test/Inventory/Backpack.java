package test.Inventory;

import java.util.ArrayList;

import test.Interface.Action.AddItem;

public class Backpack implements AddItem{
    private ArrayList<Item> backPack = new ArrayList<>();

    public Backpack(){

    }

    @Override
    public void addItem(Item item){
        backPack.add(item);
        System.out.println("You received: " + item.getName());
    }

    public void showBackPack(){
        System.out.println("=== Backpack ===");
        if (backPack.isEmpty()) {
            System.out.println("Your Backpack is empty.");
        } else {
            for (int i = 0; i < backPack.size(); i++) {
                System.out.println((i + 1) + ". " + backPack.get(i));
            }
        }
    }

    public void useItemBackPack(){

    }
}
