/**
 * Created by bill on 12/4/15.
 */

public class Player {
    private static int ID = 1;
    private int playerID;

    public Player(){
        playerID = ID;
        ID++;
    }

    public int getID(){ return playerID;}
}
