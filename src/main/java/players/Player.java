package players;

import items.Weapon;
import items.weapons.Unarmed;
import quest.Quest;
import quest.Room;

public abstract class Player implements Attacking {

    protected int healthPoints;
    protected String name;
    protected int attackRating;
    protected int defenceRating;
    protected Weapon heldWeapon;
    protected StatusType status;
    protected int loot;

    public Player(int healthPoints, String name, int attackRating, int defenceRating) {
        this.healthPoints = healthPoints;
        this.name = name;
        this.attackRating = attackRating;
        this.defenceRating = defenceRating;
        this.heldWeapon = new Unarmed("unarmed", 1, 0);
        this.status = StatusType.HEALTHY;
        this.loot = 0;
    }

    public Weapon getHeldWeapon() {
        return heldWeapon;
    }

    public int getDefenceRating() {
        return defenceRating;
    }

    public int getHealthPoints() {
        return healthPoints;
    }

    public int getLoot() {
        return this.loot;
    }

    public void selectAttackingItem(Weapon heldWeapon) {
        this.heldWeapon = heldWeapon;
    }

    public StatusType getStatus() {
        return this.status;
    }

    public void setStatus(StatusType status){
        this.status = status;
    }

    public int calculateTotalAttackValue() {
        return this.heldWeapon.getAttackMultiplier() * this.attackRating;
    }

    public void embarkQuest(Quest quest){
        for(Room room : quest.getRooms()){
            tackleRoom(room);
        }
    }

    public void tackleRoom(Room room){
        for(Player enemy : room.getEnemies()){
            while (enemy.getHealthPoints() > 0) {
                attack(enemy);
            }
            enemy.setStatus(StatusType.DEFEATED);
        }
        if(room.areAllEnemiesDefeated()) this.loot += room.totalTreasureValue();
    }

    public void attack(Player opposingPlayer) {
        int effectiveDamage = calculateTotalAttackValue() - opposingPlayer.defenceRating;
        if(effectiveDamage > 0) {
            opposingPlayer.healthPoints -= effectiveDamage;
        }
        opposingPlayer.defenceRating --;
    }



}
