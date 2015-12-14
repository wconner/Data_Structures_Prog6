import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by bill on 12/4/15.
 * Room class holds players in it and has exits assigned to it.
 */
public class Room {
    private HashMap <String, Room> exits;
    private ArrayList<Player> playersInRoom;

    public Room(){
        exits = new HashMap<String, Room>();
        playersInRoom = new ArrayList(4);
    }

    public void addPlayer(Player player){ playersInRoom.add(player);}
    public void removePlayer(Player player){playersInRoom.remove(player);}

    public boolean isPlayerInRoom(Player player){
        for (Player p : playersInRoom)
            if (p == player)
                return true;
        return false;
    }

    public ArrayList<Player> getPlayersInRoom(){ return playersInRoom;}

    /**
     * Returns the room in the passed direction from this room.
     * Room is looked up in hashmap.
     * @param direction the direction you are looking for a room
     * @return the room if one exits, otherwise null
     */
    public Room getExit(String direction){
        switch (direction.charAt(0)){
            case 'n':
                if (exits.containsKey("north"))
                    return exits.get("north");
                else
                    return null;
            case 'e':
                if (exits.containsKey("east"))
                        return exits.get("east");
                else
                    return null;
            case 's':
                if (exits.containsKey("south"))
                    return exits.get("south");
                else
                    return null;
            case 'w':
                if (exits.containsKey("west"))
                    return exits.get("west");
                else
                    return null;
            default:
                return null;
        }
    }

    /**
     * Exits are added to the room via hashmap.
     * @param direction the direction of the exit
     * @param room the room in that direction
     */
    public void setExit(String direction, Room room){ exits.put(direction, room);}
}
