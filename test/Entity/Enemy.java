package test.Entity;

import test.Enum.EnemyType;

public class Enemy {
    private String enemyName;
    private int hp;
    private int defense;
    private int exp;
    private EnemyType enemyType;

    public Enemy(EnemyType type) {
        this.enemyName = type.getNameEnemy();
        this.enemyType = type;
        this.hp = type.getBaseHp();
        this.defense = type.getBaseDefense();
        this.exp = type.getBaseExp();
    }

    public void attackPlayer(){
        
    }

    public int getDamage(int damage){
        if(defense <= 0){
            hp -= damage;
        }
        
        if(hp < 0){
            hp = 0;
        }

        return hp;
    }

    public EnemyType type(){
        return enemyType;
    }

    public String getNameEnemy(){
        return enemyName;
    }

    public int getExp() {
        return exp;
    }

    public int getDefense(){
        return defense;
    }

    public int getDefenseDamage(int damage){
        if(defense > 0){
            defense -= damage;
            if(defense < 0){
                int reminding = -defense;
                defense = 0;
                return reminding;
            }
            return 0;
        }
        return damage;
    }

    public int getHp(){
        return hp;
    }

    @Override
    public String toString(){
        return "Enemy Name : " + enemyName + "\nEnemy type : " + enemyType + "\nHP : " + hp + 
                "\nDefense : " + defense + "\nEXP : " + exp;
    }
}
