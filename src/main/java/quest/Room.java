package quest;

import items.Valuable;
import players.Player;
import players.StatusType;

import java.util.ArrayList;

public class Room {

    private ArrayList<Player> enemies;
    private ArrayList<Valuable> treasure;

    public Room (){
        this.enemies = new ArrayList<Player>();
        this.treasure = new ArrayList<Valuable>();
    }

    public ArrayList<Player> getEnemies() {
        return this.enemies;
    }

    public ArrayList<Valuable> getTreasure() {
        return this.treasure;
    }

    public boolean areAllEnemiesDefeated(){
        for(Player enemy : this.enemies){
            if(enemy.getStatus() != StatusType.DEFEATED){
                return false;
            }
        }
        return true;
    }

    public int totalTreasureValue(){
        int totalValue = 0;
        for(Valuable valuable: treasure){
            totalValue += valuable.getValue();
        }
        return totalValue;
    }

}
