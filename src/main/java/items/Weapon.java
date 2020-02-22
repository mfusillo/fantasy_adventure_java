package items;

public abstract class Weapon implements Valuable {

    protected String name;
    protected int attackMultiplier;
    protected int value;

    public Weapon(String name, int attackMultiplier, int value) {
        this.name = name;
        this.value = value;
        this.attackMultiplier = attackMultiplier;
    }

    public int getAttackMultiplier() {
        return attackMultiplier;
    }
}
