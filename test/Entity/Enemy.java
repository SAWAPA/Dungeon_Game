package test.Entity;

import test.Enum.EnemyType;

public class Enemy {
    private String enemyName;
    private int hp;
    private int defense;
    private int attack;
    private int exp;
    private EnemyType enemyType;

    public Enemy(EnemyType type) {
        this.enemyName = type.getNameEnemy();
        this.enemyType = type;
        this.hp = type.getBaseHp();
        this.defense = type.getBaseDefense();
        this.attack = type.getBaseAttack();
        this.exp = type.getBaseExp();
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

    public int getAttack(){
        return attack;
    }

    public void attackPlayer(Player player){
        int damage = player.getDamageDefense(attack);
        int newHp = player.getDamage(damage);

        if (newHp < 0) newHp = 0;

        player.setHp(newHp);

        System.out.println("Enemy dealt " + damage + " damage to you!");
        System.out.println("Your HP: " + player.getHp());
        System.out.println("Your DF: " + player.getDefense());
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
        return "Enemy Name : " + enemyName + "\nHP : " + hp + 
                "\nDefense : " + defense +  "\nAttck : " + attack + "\nEXP : " + exp;
    }
}
