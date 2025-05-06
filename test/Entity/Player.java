package test.Entity;

public class Player {
    int hp;
    int maxHp;
    int attack;
    int defense;
    int level = 1;
    int exp = 0;

    public Player(int hp, int defense, int attack) {
        this.hp = hp;
        this.maxHp = hp;
        this.defense = defense;
        this.attack = attack;
        this.level = 1; // start Level 1
    }

    public void attackEnemy(Enemy enemy){
        int damage = Math.max(0, this.attack - enemy.getDefense());
        enemy.getDamage(damage);

        if(enemy.getHp() <= 0){
            exp += enemy.getExp();
        }

        if(exp >= 100){
            exp /= 100;
            level += exp;
            exp = 0;
        }

        System.out.println("You dealt " + damage + " damage!");
        System.out.println(enemy.toString());
        System.out.println("====================");
        System.out.println("Level : " + level);
        System.out.println("EXP : " + exp);
    }
}
