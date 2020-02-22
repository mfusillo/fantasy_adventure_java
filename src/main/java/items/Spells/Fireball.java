package items.Spells;

import items.Weapon;

public class Fireball extends Weapon {

    public Fireball(String name, int attackMultiplier, int value) {
        super(name, attackMultiplier, value);
    }

    public int getValue() {
        return this.value;
    }
}
