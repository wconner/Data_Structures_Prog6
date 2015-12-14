/**
 * Created by Jacob on 12/8/15.
 */
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class LogoPanel extends JPanel{

    public LogoPanel(){
        //Logo for the panel with apporpriate font and size
        JLabel logo = new JLabel("2 Player Dice Elimination Game");
        logo.setFont(new Font("Serif",Font.BOLD, 20));
        //Add the logo to the panel
        add(logo);
    }
}