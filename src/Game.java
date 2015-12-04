import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 * Created by bill on 12/4/15.
 */
public class Game {
    private int numPlayers;
    private ArrayList<Player> players;
    private ArrayList<Room> rooms;
    private Player playerInFocus;
    private Room currentRoom;
    private boolean exit = false;
    private Random rnd;
    private String[] directions = {"north", "east", "south", "west"};

    public Game(int numPlayers){
        this.numPlayers = numPlayers;
        players = new ArrayList<Player>(4);
        rooms = new ArrayList<Room>();
        rnd = new Random();

        initRooms();
        initPlayers();

        playerInFocus = players.get(0);

        while(!exit)
            runLoop();
    }

    private void runLoop(){
        currentRoom = findRoom(playerInFocus);
        if (currentRoom.getPlayersInRoom().size() == 1) {        /** Nobody else in room */
            System.out.println("Nobody else in the room");
            move(directions[rnd.nextInt(4)]);
        }
            else{                                                   /** Multiple people in the room */
                System.out.println("Somebody else in the room");
            }
        playerInFocus = nextPlayerTurn();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void move(String direction){
        if(currentRoom.getExit(direction) != null){
            currentRoom.getExit(direction).addPlayer(playerInFocus);
            currentRoom.removePlayer(playerInFocus);
        }
        else
            System.out.println("Error, no door in that direction");
    }

    private Player nextPlayerTurn(){
        for (int i = 0; i < players.size(); i++){
            if (players.get(i) == playerInFocus){
                for (int j = i; j < players.size(); j++)
                    if (players.get(j) != null)
                        return players.get(j);
                for (int k = 0; k < i; k++)
                    if (players.get(k) != null)
                        return players.get(k);
            }
        }
        return null;
    }

    private Room findRoom(Player player){
        for(int i = 0; i < rooms.size(); i++){
            if (rooms.get(i).isPlayerInRoom(player))
                return rooms.get(i);
        }
        return null;
    }

    private void initPlayers(){
        for (int i = 0; i < numPlayers; i++) {
            players.add(new Player());
            rooms.get(i).addPlayer(players.get(i));
        }
    }

    private void initRooms(){
        for (int i = 0; i < 4; i ++)
            rooms.add(new Room());

        rooms.get(0).setExit("north", rooms.get(1));
        rooms.get(0).setExit("east", rooms.get(3));

        rooms.get(1).setExit("south", rooms.get(0));
        rooms.get(1).setExit("east", rooms.get(2));

        rooms.get(2).setExit("south", rooms.get(3));
        rooms.get(2).setExit("west", rooms.get(1));

        rooms.get(3).setExit("north", rooms.get(2));
        rooms.get(3).setExit("west", rooms.get(0));
    }











    public static void main(String argc[]){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of players: ");
        new Game(scanner.nextInt());
    }
}
