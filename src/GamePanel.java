/**
 * Created by Jacob on 12/8/15.
 */

import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;

/**
 * Creates the Rooms
 */
public class GamePanel extends JPanel {
    static String directions = "nesw";

    ArrayList<DrawRooms> doors;
    ArrayList<DrawPlayers> players;
    DrawRooms walls;
    Room currentRoom;

    public GamePanel(Room currentRoom) {
        this.currentRoom = currentRoom;
        doors = new ArrayList<DrawRooms>();
        players = new ArrayList<DrawPlayers>();
        buildPanel();
        setVisible(true);
    }


    public void buildPanel() {
        walls = new DrawRooms(75, 50, 650, 500);
        drawPlayers();
        doors.clear();
        for (char c : directions.toCharArray())
            if (currentRoom.getExit(Character.toString(c)) != null)
                drawExit(c);
}
    /*
    drawPlayer method draws each player in their room
     */
    private void drawPlayers(){
        int c = 0;
        for (Player p : currentRoom.getPlayersInRoom()){
            players.add(new DrawPlayers(c, p));
            c++;
        }
    }
    /*
    drawExit method to draw the exits to each room
     */
    private void drawExit(char exit){
        switch (exit){
            case 'n':  doors.add(new DrawRooms(340,50,80,20));
                break;
            case 'e':  doors.add(new DrawRooms(705,225,20,80));
               break;
            case 's': doors.add(new DrawRooms(340,530, 80,20));
                break;
            case 'w': doors.add(new DrawRooms(75,225,20,80));
                break;
            default: System.out.println("Error, GamePanel > drawExit");
        }

    }

    /*
    paintComponent to draw the rooms and doors
     */
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        walls.draw(g2d);
        for (DrawRooms d : doors)
            d.draw(g2d);
        for (DrawPlayers p : players)
            p.draw(g2d);
    }
}