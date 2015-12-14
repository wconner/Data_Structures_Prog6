/**
 * Created by Jacob on 12/8/15.
 */

import java.awt.BorderLayout;

import javax.swing.JFrame;

public class Program6_GUI extends JFrame {
    private final int WIDTH = 800;
    private final int HEIGHT = 800;
    private GamePanel GAME_PANEL;
    private final ButtonPanel BUTTON_PANEL;
    private final LogoPanel LOGO_PANEL;
    private Room currentRoom;

    public Program6_GUI(Game game, Room currentRoom){
        //Set Title
        setTitle("Game");

        //Set width and height
        setSize(WIDTH, HEIGHT);

        //Set current room
        this.currentRoom = currentRoom;

        //Set the Layout of the Frame
        setLayout(new BorderLayout());
        setLayout(new BorderLayout());
        LOGO_PANEL = new LogoPanel();
        GAME_PANEL = new GamePanel(currentRoom);
        BUTTON_PANEL = new ButtonPanel(game);

        //Specify an action for the close button.
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Add the panels to the frame
        add(LOGO_PANEL, BorderLayout.NORTH);
        add(GAME_PANEL, BorderLayout.CENTER);
        add(BUTTON_PANEL, BorderLayout.SOUTH);

        //Make the window visible
        setVisible(true);
        //Set the windows position to the center of the screen
        setLocationRelativeTo(null);
        //Make the window unable to be resized
        setResizable(false);
        //Make the window visible
        setVisible(true);
    }

    public void setGAME_PANEL (Room r){
        GAME_PANEL = new GamePanel(r);
        add(GAME_PANEL, BorderLayout.CENTER);
        BUTTON_PANEL.updateLabel();
        GAME_PANEL.paintComponent(getGraphics());

    }
}
