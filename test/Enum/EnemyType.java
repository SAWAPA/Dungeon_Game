package test.Enum;

public enum EnemyType {
    GOBLIN("Goblin", 30, 5, 10, 10),
    ORC("Orc", 50, 10, 24, 50),
    DRAGON("Dragon", 100, 20, 55, 230),
    BOSS("Boss" ,200, 50, 120,  500);

    private final String enemyName;
    private final int baseHp;
    private final int baseDefense;
    private final int baseAttack;
    private final int baseExp;

    private EnemyType(String name, int hp, int df, int attack, int exp){
        enemyName = name;
        baseHp = hp;
        baseDefense = df;
        baseAttack = attack;
        baseExp = exp;
    }

    public String getNameEnemy(){
        return enemyName;
    }

    public int getBaseHp() {
        return baseHp;
    }

    public int getBaseDefense() {
        return baseDefense;
    }

    public int getBaseAttack(){
        return baseAttack;
    }

    public int getBaseExp(){
        return baseExp;
    }
}
