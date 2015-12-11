import java.util.Random;

/**
 * Created by bill on 12/4/15.
 */

public class Player {
    private static Random rnd = new Random();
    String name;
    Room inRoom;

    public Player(Room room){
        inRoom = room;
        name = generatePlayerName();
    }

    private String generatePlayerName(){
        StringBuilder s = new StringBuilder();

        for (int i = 0; i < 3; i++)    /** Name will be 3 characters long */
            s.append(rnd.nextInt(25) + 65);             /** ASCII codes for a - z */
        return s.toString();
    }

    public int hashCode(){
        int hash = 0;
        char[] nameC = name.toCharArray();

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
        return rnd.nextInt();
    }

    public Room getInRoom(){ return  inRoom;}
    public void setInRoom(Room room){ inRoom = room;}
}
