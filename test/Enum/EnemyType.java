package test.Enum;

public enum EnemyType {
    GOBLIN(30, 5, 10),
    ORC(50, 10, 50),
    DRAGON(100, 20, 230),
    BOSS(200, 50, 500);

    private final int baseHp;
    private final int baseDefense;
    private final int baseExp;

    private EnemyType(int hp, int df, int exp){
        baseHp = hp;
        baseDefense = df;
        baseExp = exp;
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
