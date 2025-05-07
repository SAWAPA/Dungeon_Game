package test;

import java.util.Scanner;

import test.Entity.*;
import test.Enum.*;
import test.Inventory.Item;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Player player = new Player(100, 10, 10);
        Enemy enemy = new Enemy(EnemyType.GOBLIN);
        System.out.println("==============================");
        Item potion = new Item("Health Potion", "Restore 50 HP", 10);
        player.addItem(potion);
        

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
                    healPlayer(player, potion, sc);
                    break;
                default:
                    break;
            }
        }
    }

    public static void attackTurn(int num, Player player, Enemy enemy){
        player.attackEnemy(enemy);

        if(enemy.getHp() <= 0){
            System.out.println( );
            System.exit(0);
        }

        enemy.attackPlayer(player);

        if (player.getHp() <= 0) {
            System.out.println("-YOU DIED-");
            System.exit(0);
        }
    }

    public static void healPlayer(Player player, Item dummyItem, Scanner sc){
        player.showInventory();
    
        System.out.print("Choose your inventory item: ");
        int num = sc.nextInt();
    
        if(num > 0 && num <= player.getInventory().size()){  // ตรวจสอบ index
            Item selected = player.getInventory().get(num - 1);  // หยิบไอเทมที่เลือก
            player.getHeal(selected);
            System.out.println("Current HP: " + player.getHp());
        } else {
            System.out.println("Invalid choice.");
        }
    }
}