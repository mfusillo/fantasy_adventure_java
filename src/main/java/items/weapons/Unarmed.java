package items.weapons;

public class Unarmed extends Weapon {

    public Unarmed(String name, int attackMultiplier, int value) {
        super(name, attackMultiplier, value);
    }

    public int getValue() {
        return this.value;
    }
}
