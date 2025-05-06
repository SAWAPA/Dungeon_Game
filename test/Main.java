package test;

import test.Entity.*;
import test.Enum.*;

public class Main {
    public static void main(String[] args) {
        Player player = new Player(100, 10, 500);
        Enemy boss = new Enemy(EnemyType.BOSS);
        System.out.println("====================");
        System.out.println(boss);
        System.out.println("====================");
        player.attackEnemy(boss);

    }
}