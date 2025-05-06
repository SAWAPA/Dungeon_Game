package test.Entity;

import test.Enum.EnemyType;

public class Enemy {
    private int hp;
    private int defense;
    private int exp;
    private EnemyType enemyType;

    public Enemy(EnemyType type) {
        this.enemyType = type;
        this.hp = type.getBaseHp();
        this.defense = type.getBaseDefense();
        this.exp = type.getBaseExp();
    }

    public int getDamage(int damage){
        hp -= damage;

        if(hp < 0){
            hp = 0;
        }

        return hp;
    }

    public EnemyType type(){
        return enemyType;
    }

    public int getExp() {
        return exp;
    }

    public int getDefense(){
        return defense;
    }

    public int getHp(){
        return hp;
    }

    @Override
    public String toString(){
        return "Enemy type : " + enemyType + "\nHP : " + hp + 
                "\nDefense : " + defense + "\nEXP : " + exp;
    }
}
