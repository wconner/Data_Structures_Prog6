import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

/**
 * Created by bill on 12/4/15.
 */
public class Room {
    private static Random rnd = new Random();
    private String roomName;
    private HashMap <String, Room> exits;
    private ArrayList<Player> playersInRoom;

    public Room(){
        exits = new HashMap<String, Room>();
        roomName = generateRoomName();
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

    public void setExit(String direction, Room room){ exits.put(direction, room);}

    private String generateRoomName(){
        StringBuilder s = new StringBuilder();

        for (int i = 0; i < rnd.nextInt(5) + 3; i++)    /** Name will be 3 - 8 characters long */
            s.append(rnd.nextInt(25) + 65);             /** ASCII codes for a - z */
        return s.toString();
    }
}
