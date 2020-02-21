package rooms;

import items.Valuable;
import players.Player;

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

    public void giveTreasure(Player player){
        for(Player enemy: this.enemies){

        }
    }
}
