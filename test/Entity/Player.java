package test.Entity;

public class Player {
    int hp;
    int maxHp;
    int attack;
    int defense;
    int level;

    public Player(int hp, int attack, int defense) {
        this.hp = hp;
        this.maxHp = hp;
        this.attack = attack;
        this.defense = defense;
        this.level = 1; // start Level 1
    }

    public void attackEnemy(Enemy enemy){
        int damage = Math.max(0, this.attack - enemy.defense);
        enemy.hp -= damage;
        System.out.println("You dealt " + damage + " damage!");
    }
}
