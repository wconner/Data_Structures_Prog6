import java.util.Random;

/**
 * Created by bill on 12/4/15.
 * This class is the player, generates the hashcode based on randomly generated player name and
 * the current room that the player is in.
 */

public class Player {
    private static Random rnd = new Random();
    private String name, hashName;
    private Room inRoom;

    public Player(Room room, String name){
        this.name = name;
        inRoom = room;
        hashName = generateHashName();
    }

    /**
     * Randomly generates a 3 character name for hashcode purposes.
     * @return the name for hashcode.
     */
    private String generateHashName(){
        StringBuilder s = new StringBuilder();

        for (int i = 0; i < 3; i++)    /** Name will be 3 characters long */
            s.append(rnd.nextInt(25) + 65);             /** ASCII codes for a - z */
        return s.toString();
    }

    /**
     * Generates the hashcode based on the randomly created hash name, applies a modulus to it based on if the
     * character's position in its array is even or odd, and adds the hashcode from the room % 100.
     * @return  Generated hashcode
     */
    public int hashCode(){
        int hash = 0;
        char[] nameC = hashName.toCharArray();

        for (int i = 0; i < nameC.length; i++){
            if (nameC[i] % 2 == 0)
                hash += nameC[i] / 5;
            else
                hash += nameC[i] / 10;
        }
        hash += inRoom.hashCode() % 100;
        return hash;
    }

    public int rollDice(){
        return rnd.nextInt(100);
    }

    public Room getInRoom(){ return  inRoom;}
    public void setInRoom(Room room){ inRoom = room;}
    public String getName(){ return name;}
}