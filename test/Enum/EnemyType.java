package test.Enum;

public enum EnemyType {
    GOBLIN("Goblin", 30, 5, 10, 27),
    ORC("Orc", 100, 10, 24, 120),
    DRAGON("Dragon", 900, 20, 55, 1100),
    BOSS("Boss" ,1700, 50, 120,  2000);

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
