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
    DrawRooms walls;
    DrawPlayers player_1, player_2;
    Room currentRoom;

    public GamePanel(Room currentRoom) {
        this.currentRoom = currentRoom;
        doors = new ArrayList();
        buildPanel();
        setVisible(true);
    }


    public void buildPanel() {
        walls = new DrawRooms(75, 50, 650, 500);
        player_1 = new DrawPlayers();
        doors.clear();
        for (char c : directions.toCharArray())
            if (currentRoom.getExit(Character.toString(c)) != null)
                drawExit(c);
}
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

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        walls.draw(g2d);
        for (DrawRooms d : doors)
            d.draw(g2d);
        player_1.draw(g2d);
    }
}