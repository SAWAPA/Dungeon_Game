package test;

import java.util.Scanner;

import test.Entity.*;
import test.Enum.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Player player = new Player(100, 10, 1000);
        Enemy boss = new Enemy(EnemyType.BOSS);
        System.out.println("==============================");
        

        while (true) {
            System.out.println("==============================");
            System.out.println("*- FOUND ENEMY!! -*");
            System.out.println(boss);
            System.out.println("==============================");
            System.out.println("1 : ATTACK\n" +
                               "==============================");
            System.out.print("choose your choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    player.attackEnemy(boss);
                    if(boss.getHp() == 0){
                        System.out.println("-ENEMY DIED-");
                        return;
                    }
                    break;
            
                default:
                    break;
            }
        }
    }
}