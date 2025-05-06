package test.Entity;

public class Player {
    int hp;
    int maxHp;
    int attack = 25;
    int defense;
    int level = 1;
    int exp = 0;

    public Player(int hp, int defense) {
        this.hp = hp;
        this.maxHp = hp;
        this.defense = defense;
        this.level = 1; // start Level 1
    }

    public void attackEnemy(Enemy enemy){
        int damage = Math.max(0, this.attack - enemy.defense);
        enemy.getDamage(damage);
        if(enemy.hp == 0){
            exp += enemy.getExp() ;
        }

        if(exp >= 100){
            level++;
            exp = 0;
        }

        System.out.println("You dealt " + damage + " damage!");
        System.out.println(enemy.toString());
        System.out.println(exp);
        System.out.println(level);
    }
}
