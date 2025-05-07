package test.Enum;

public enum EnemyType {
    GOBLIN("Goblin", 30, 5, 10),
    ORC("Orc", 50, 10, 50),
    DRAGON("Dragon", 100, 20, 230),
    BOSS("Boss" ,200, 50, 500);

    private final String enemyName;
    private final int baseHp;
    private final int baseDefense;
    private final int baseExp;

    private EnemyType(String name, int hp, int df, int exp){
        enemyName = name;
        baseHp = hp;
        baseDefense = df;
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

    public int getBaseExp(){
        return baseExp;
    }
}
