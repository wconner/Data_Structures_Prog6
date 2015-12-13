import java.util.ArrayList;
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
    private int[] diceRoll = {0,0};
    private Program6_GUI GUI;
    private Scanner scanner;

    public Game(){
        scanner = new Scanner(System.in);
        players = new ArrayList<Player>();
        rooms = new ArrayList<Room>();

        initRooms();
        initPlayers();
        playerInFocus = players.get(0);
        currentRoom = findRoom(playerInFocus);
        GUI = new Program6_GUI(this, currentRoom);
        playerInFocus = players.get(0);

        runLoop();
    }

    private void runLoop(){
        currentRoom = findRoom(playerInFocus);
        System.out.println("It is " + playerInFocus.getName() + " turn.");
        if (currentRoom.getPlayersInRoom().size() == 1) {        /** Nobody else in room */
            System.out.println("Nobody else in the room");
        }
        else {                                                   /** Multiple people in the room */
            System.out.println("Somebody else in the room");
            collision();
        }
        if (players.size() == 1)
            gameWon();
    }

    private void collision(){
        for (int i = 0; i < 2; i++)
            diceRoll[i] = currentRoom.getPlayersInRoom().get(i).rollDice();
        if (diceRoll[0] > diceRoll[1]) {                      /** Removes first person in room */
            players.remove(currentRoom.getPlayersInRoom().get(0));
        }
        else                                                /** Removes second person in room */
            players.remove(currentRoom.getPlayersInRoom().get(1));
    }

    public void move(String direction){
        if(currentRoom.getExit(direction) != null){
            currentRoom.getExit(direction).addPlayer(playerInFocus);
            currentRoom.removePlayer(playerInFocus);
            playerInFocus.setInRoom(currentRoom.getExit(direction));
            playerInFocus = nextPlayerTurn();
            runLoop();
            GUI.setGAME_PANEL(currentRoom);
        }
        else
            System.out.println("Error, no door in that direction");
    }

    public Player getPlayerInFocus(){ return playerInFocus;}

    private Player nextPlayerTurn(){
        for (int i = 0; i < players.size(); i++){
            if (players.get(i) == playerInFocus){
                for (int j = i + 1; j < players.size(); j++)
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
        System.out.println("How many people are playing?");
        numPlayers = scanner.nextInt();
            for (int i = 0; i < numPlayers; i++){
                System.out.println("Enter player " + i + "'s name: ");
                players.add(new Player(rooms.get(i), scanner.next()));
                rooms.get(i).addPlayer(players.get(i));
        }
    }

    private void initRooms(){                       /** Right now the map is just a box */
        for (int i = 0; i < 4; i ++)
            rooms.add(new Room());

        rooms.get(0).setExit("north", rooms.get(1));
        rooms.get(0).setExit("east", rooms.get(3));
        rooms.get(0).setExit("west", rooms.get(2));

        rooms.get(1).setExit("south", rooms.get(0));
        rooms.get(1).setExit("east", rooms.get(2));

        rooms.get(2).setExit("south", rooms.get(3));
        rooms.get(2).setExit("west", rooms.get(1));

        rooms.get(3).setExit("north", rooms.get(2));
        rooms.get(3).setExit("west", rooms.get(0));
    }

    private void gameWon(){
        System.out.println("Game over!\nThe winner is: " + players.iterator().next().getName());
    }

    public void listPlayersInRoom(){
        for (Room r : rooms){
            System.out.println("Room: " + r.toString());
            System.out.println("Players in room: " + r.getPlayersInRoom());
        }
    }











    public static void main(String argc[]){
        new Game();
    }
}
