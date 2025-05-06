package test;

import test.Entity.*;

public class Main {
    public static void main(String[] args) {
        Player player = new Player(100, 10);
        Enemy enemy = new Enemy();

        player.attackEnemy(enemy);
    }
}