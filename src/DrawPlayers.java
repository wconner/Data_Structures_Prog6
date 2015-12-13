import javax.swing.*;
import java.awt.*;
import java.awt.Graphics2D;

/**
 * Created by Jacob on 12/11/15.
 */
public class DrawPlayers extends JPanel{

    int x, y;

    public DrawPlayers(){
        setFocusable(true);
    }

    public DrawPlayers(int posInRoom, Player p){
        switch (posInRoom){
            case 0: x = 200; y = 200;
                break;
            case 1: x = 400; y = 400;
                break;
        }
    }

    //Paint the players
    public void draw(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        ImageIcon ic = new ImageIcon("src/player.png");
        Image i = ic.getImage();
        g2d.drawImage(i, x, y, null);
    }


    //gets x
    public int getX() {
        return x;
    }

    //gets y
    public int getY() {
        return y;
    }

}
