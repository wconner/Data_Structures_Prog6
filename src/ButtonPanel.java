/**
 * Created by Jacob on 12/8/15.
 */
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class ButtonPanel extends JPanel {
    private JButton north, south, east, west, restart;
    private JLabel playerTurnLabel;
    private Game game;

    public ButtonPanel(Game game){
        super (new GridBagLayout());
        this.game = game;
        buildPanel();
        setVisible(true);
    }

    public void buildPanel(){
        setBorder(BorderFactory.createTitledBorder("Movement Buttons"));
        //Set layout to GridBag
        GridBagConstraints grid = new GridBagConstraints();
        //grid.anchor = GridBagConstraints.NORTHWEST;
        grid.insets = new Insets(5,5,5,5);

        //Create label for player turn and add to panel
        playerTurnLabel = new JLabel(game.getPlayerInFocus().getName() + "'s turn.");
        grid.gridx = 2;
        grid.gridy = 1;
        add(playerTurnLabel, grid);


        //Create the buttons and add to the panel
        north = new JButton("North");
        grid.gridx = 2;
        grid.gridy = 2;
        add(north, grid);
        north.addActionListener(new DirectionListener());

        east = new JButton("East");
        grid.gridx = 3;
        grid.gridy = 3;
        add(east, grid);
        east.addActionListener(new DirectionListener());

        west = new JButton("West");
        grid.gridx = 1;
        grid.gridy = 3;
        add(west, grid);
        west.addActionListener(new DirectionListener());

        south = new JButton("South");
        grid.gridx = 2;
        grid.gridy = 4;
        add(south, grid);
        south.addActionListener(new DirectionListener());

        restart = new JButton("Restart");
        grid.gridx = 8;
        grid.gridy = 4;
        add(restart, grid);
        restart.addActionListener(new RestartListener());
    }

    /*
    ButtonListener to restart the game
     */
    class RestartListener implements ActionListener{
        public void actionPerformed(ActionEvent event){
            JOptionPane.showMessageDialog(null, "See terminal for instructions","Restart",JOptionPane.INFORMATION_MESSAGE);
            Game game = new Game();
        }

    }

    /*
    updateLabel method that updates the current players label after each turn
     */
    public void updateLabel(){
        playerTurnLabel.setText(game.getPlayerInFocus().getName() + "'s turn");
    }

    /*
    ButtonListener to directions
     */
    class DirectionListener implements ActionListener{
        public void actionPerformed(ActionEvent event){
            if (event.paramString().contains("North"))
                game.move("north");
            else if (event.paramString().contains("East"))
                game.move("east");
            else if (event.paramString().contains("West"))
                game.move("west");
            else if (event.paramString().contains("South"))
                 game.move("south");
            else
                System.out.println("Error ButtonPanel > DirectionListener");
        }
    }
}
