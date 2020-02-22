import items.Valuable;
import items.weapons.Sword;
import org.junit.Before;
import org.junit.Test;
import players.Player;
import players.StatusType;
import players.casters.Warlock;
import quest.Room;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class RoomTest {

    Room room1;
    Player warlock;
    Player enemyWarlock;
    Valuable treasure1;

    @Before
    public void before(){
        room1 = new Room();
        warlock = new Warlock(10, "Harlock", 2, 4);
        enemyWarlock = new Warlock(10, "Evil Harlock", 2, 4);
        treasure1 = new Sword("Iron Sword", 3, 2);
        room1.getEnemies().add(enemyWarlock);
        room1.getTreasure().add(treasure1);
    }

    @Test
    public void can_tackle_room_with_one_enemy_and_reduce_enemy_hp_to_0(){
        warlock.tackleRoom(room1);
        assertEquals(StatusType.DEFEATED, enemyWarlock.getStatus());
    }

    @Test
    public void can_increase_loot_when_all_enemies_are_defeated(){
        warlock.tackleRoom(room1);
        assertEquals(2, warlock.getLoot());
    }



}
