package quest;

import java.util.ArrayList;

public class Quest {

    private ArrayList<Room> rooms;

    public Quest(){
        this.rooms = new ArrayList<Room>();
    }

    public ArrayList<Room> getRooms() {
        return this.rooms;
    }
}
