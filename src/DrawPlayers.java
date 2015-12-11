import javax.swing.*;
import java.awt.*;
import java.awt.Graphics2D;

/**
 * Created by Jacob on 12/11/15.
 */
public class DrawPlayers extends JPanel{

    public DrawPlayers(){
        setFocusable(true);
    }

    //Paint the players
    public void draw(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        ImageIcon ic = new ImageIcon("src/player.png");
        Image i = ic.getImage();
        g2d.drawImage(i,200,200,null);
    }

}
