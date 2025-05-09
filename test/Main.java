package test;

import java.util.Scanner;

import test.Entity.*;
import test.Enum.*;
import test.Inventory.Backpack;
import test.Inventory.Chest;
import test.Inventory.Item;

public class Main {
    public static void main(String[] args) {
        //demo1();
        demo1();
    }

    public static void demo2(){
        Backpack chest = new Backpack();
        Item potion = new Item(InventoryType.POTION, "Potion", "Heal 20 HP", 20, 2);
        Item elixir = new Item(InventoryType.POTION, "Elixir", "Restore full HP", 999, 1);

        chest.addItem(potion);
        chest.addItem(elixir);

        Scanner sc = new Scanner(System.in);
        System.out.print("1 : Open Backpack");
        int n = sc.nextInt();

        if(n == 1){
            chest.showBackPack();
        }
    }

    public static void demo1(){
        Scanner sc = new Scanner(System.in);
        Player player = new Player(100, 10, 10);
        Enemy enemy = new Enemy(EnemyType.BOSS);
        System.out.println("==============================");

        Item sword1 = new Item(InventoryType.SWORD, "Excalibur", "Legend Sword", 1000, 10);
        Item shield1 = new Item(InventoryType.SHIELD, "Iron Shield", "this shield is protect damage from enemy.", 500, 10);
        Item potion1 = new Item(InventoryType.POTION, "Potion Heal", "Heal your HP", 100, 10);

        player.addItem(sword1);
        player.addItem(shield1);
        player.addItem(potion1);

        while (true) {
            System.out.println("==============================");
            System.out.println("*- FOUND ENEMY!! -*");
            System.out.println(enemy);
            System.out.println("==============================");
            System.out.println("1 : ATTACK\n" +
                                "2 : INVENTORY\n" +
                               "==============================");
            System.out.print("choose your choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    attackTurn(choice, player, enemy);
                    break;
                case 2:
                    itemPlayer(player, sc);
                    break;
                default:
                    break;
            }
        }
    }

    /*---------------------------------------------------------------------*/

    public static void attackTurn(int num, Player player, Enemy enemy){
        player.attackEnemy(enemy);

        if(enemy.getHp() <= 0){
            System.out.println("-ENEMY DIED-");
            System.exit(0);
        }

        enemy.attackPlayer(player);

        if (player.getHp() <= 0) {
            System.out.println("-YOU DIED-");
            System.exit(0);
        }
    }

    public static void itemPlayer(Player player, Scanner sc){
        player.showInventory();
    
        System.out.print("Choose your inventory item: ");
        int num = sc.nextInt();
    
        if(num > 0 && num <= player.getInventory().size()){  // ตรวจสอบ index
            Item selected = player.getInventory().get(num - 1);  // หยิบไอเทมที่เลือก

            if(selected.getType() == InventoryType.SWORD){
                player.itemBuffDamage(selected);
                System.out.println("Current Attack: " + player.getAttack());
            }
            else if(selected.getType() == InventoryType.SHIELD){
                player.itemShield(selected);
                System.out.println("Current Defense: " + player.getDefense());
            }
            else if(selected.getType() == InventoryType.POTION){
                player.potion(selected);
                System.out.println("Current HP: " + player.getHp());
            }
        } else {
            System.out.println("Invalid choice.");
        }
    }
}