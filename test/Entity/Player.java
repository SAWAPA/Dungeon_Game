package test.Entity;

import java.util.ArrayList;

import test.Inventory.Item;

public class Player {
    private int hp;
    private int maxHp;
    private int attack;
    private int defense;
    private int level = 1;
    private int exp = 0;
    private ArrayList<Item> inventory = new ArrayList<>();

    public Player(){

    }

    public Player(int hp, int defense, int attack) {
        this.hp = hp;
        this.maxHp = hp;
        this.defense = defense;
        this.attack = attack;
        this.level = 1; // start Level 1
    }

    public int getHp(){
        return hp;
    }

    public int getHeal(Item item){
        this.hp += item.getValue();
    
        if (this.hp > this.maxHp) {
            this.hp = this.maxHp;
        }
    
        inventory.remove(item);
        System.out.println("==============================");
        System.out.println("You used: " + item.getName());
        System.out.println("==============================");
        return hp;
    }

    public ArrayList<Item> getInventory() {
        return inventory;
    }

    public int getMaxHp(){
        return maxHp;
    }

    public int getAttack(){
        return attack;
    }

    public int getDefense(){
        return defense;
    }

    public int getLevel(){
        return level;
    }

    public int getExp(){
        return exp;
    }

    public int setHp(int hp){
        this.hp = hp;
        return hp;
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

    public int getDamageDefense(int damage){
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

    public void attackEnemy(Enemy enemy){
        int damage = enemy.getDefenseDamage(attack);
        enemy.getDamage(damage);

        if(enemy.getHp() <= 0 && enemy.getDefense() <= 0){
            exp += enemy.getExp();
        }

        if(exp >= 100){
            level += exp / 100;
            exp %= 100;
        }

        System.out.println("You dealt " + damage + " damage!");
        System.out.println(enemy.toString());
        System.out.println("==============================");
        System.out.println("Level : " + level);
        System.out.println("EXP : " + exp);
    }

    public void addItem(Item item) {
        inventory.add(item);
        System.out.println("You received: " + item.getName());
    }

    public void showInventory() {
        System.out.println("=== Inventory ===");
        if (inventory.isEmpty()) {
            System.out.println("Your inventory is empty.");
        } else {
            for (int i = 0; i < inventory.size(); i++) {
                System.out.println((i + 1) + ". " + inventory.get(i));
            }
        }
    }
}
