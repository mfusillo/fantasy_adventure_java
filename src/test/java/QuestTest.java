import items.Spells.Fireball;
import items.Valuable;
import items.weapons.Sword;
import org.junit.Before;
import org.junit.Test;
import players.Player;
import players.StatusType;
import players.casters.Warlock;
import players.fighters.Knight;
import quest.Quest;
import quest.Room;

import static org.junit.Assert.assertEquals;

public class QuestTest {

    Quest quest1;
    Room room1;
    Room room2;
    Player warlock;
    Player enemyWarlock;
    Player enemyKnight;
    Valuable treasure1;
    Valuable treasure2;

    @Before
    public void before(){
        room1 = new Room();
        room2 = new Room();
        quest1 = new Quest();
        warlock = new Warlock(10, "Harlock", 2, 4);
        enemyWarlock = new Warlock(10, "Evil Harlock", 2, 4);
        enemyKnight = new Knight(100, "Evil Knight", 4, 5);
        treasure1 = new Sword("Iron Sword", 3, 2);
        treasure2 = new Fireball("Molten Fireball", 6, 10);
        room1.getEnemies().add(enemyWarlock);
        room1.getTreasure().add(treasure1);
        room2.getEnemies().add(enemyKnight);
        room2.getTreasure().add(treasure2);
        quest1.getRooms().add(room1);
        quest1.getRooms().add(room2);
    }

    @Test
    public void can_embark_quest_and_defeat_enemies(){
        warlock.embarkQuest(quest1);
        assertEquals(StatusType.DEFEATED, enemyWarlock.getStatus());
        assertEquals(StatusType.DEFEATED, enemyKnight.getStatus());
    }

    @Test
    public void can_embark_quest_and_increase_loot(){
        warlock.embarkQuest(quest1);
        assertEquals(12, warlock.getLoot());
    }

}
