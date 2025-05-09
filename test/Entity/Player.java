package test.Entity;

import java.util.ArrayList;

import test.Interface.Action.*;

import test.Inventory.Item;

public class Player implements AddItem, Potion, Attack, Shield{
    private int hp;
    private int maxHp;
    private int attack;
    private int defense;
    private int level;
    private int exp = 0;
    private double maxExp = 100.0;
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

    public ArrayList<Item> getInventory() {
        return inventory;
    }

    public double getMaxExp(){
        return maxExp;
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

    public void attackEnemy(Enemy enemy) {
        int damage = enemy.getDefenseDamage(attack);
        enemy.getDamage(damage);
    
        System.out.println("You dealt " + damage + " damage!");
        System.out.println(enemy);
        
        if (enemy.getHp() <= 0 && enemy.getDefense() <= 0) {
            int gainedExp = enemy.getExp();
            exp += gainedExp;
            System.out.println("You defeated the enemy and gained " + gainedExp + " EXP!");
    
            while (exp >= maxExp) {
                exp -= maxExp;
                level++;
                maxExp *= 1.25;
                System.out.println("Leveled up! New level: " + level);
            }
        }
    
        System.out.println("==============================");
        System.out.println("Level : " + level);
        System.out.println("EXP : " + exp);
        System.out.printf("Max EXP : %.0f%n", maxExp);
    }

    @Override
    public int potion(Item item) {
        if (this.hp == this.maxHp) {
            System.out.println("Can't use Item.");
            return hp;
        }
    
        this.hp += item.getPower();
        if (this.hp > this.maxHp) {
            this.hp = this.maxHp;
        }
    
        item.decreaseValue();
        if (item.getValue() <= 0) {
            inventory.remove(item);
        }
    
        System.out.println("==============================");
        System.out.println("You used: " + item.getName());
        System.out.println("Remaining: " + item.getValue());
        System.out.println("==============================");
    
        return hp;
    }

    @Override
    public int itemBuffDamage(Item item){
        this.attack += item.getPower();
    
        item.decreaseValue();
    
        if(item.getValue() <= 0){
            inventory.remove(item);
        }
    
        System.out.println("==============================");
        System.out.println("You used: " + item.getName());
        System.out.println("Remaining: " + item.getValue());
        System.out.println("==============================");
    
        return attack;
    }

    @Override
    public int itemShield(Item item){
        this.defense += item.getPower();

        item.decreaseValue();
    
        if(item.getValue() <= 0){
            inventory.remove(item);
        }

        System.out.println("==============================");
        System.out.println("You used: " + item.getName());
        System.out.println("==============================");

        return defense;
    }

    @Override
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
