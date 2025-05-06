package test.Entity;

public class Enemy {
    int hp = 20;
    int defense = 5;
    int exp = 100;

    public Enemy() {

    }

    public int getDamage(int damage){
        hp -= damage;
        return hp;
    }

    public int getExp() {
        return exp;
    }

    @Override
    public String toString(){
        return "Enemy HP = " + hp;
    }
}
