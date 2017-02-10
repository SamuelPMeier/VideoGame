import java.awt.Canvas;
import java.awt.Dimension;
import javax.swing.JFrame;

public class Window extends Canvas{
    
    private static final long serialVersionUID = 9034494958129720942L;

    public Window(int wid, int hei, String title, Game game){
        JFrame frame = new JFrame(title);
        frame.setPreferredSize(new Dimension(wid, hei));
        frame.setMaximumSize(new Dimension(wid, hei));
        frame.setMinimumSize(new Dimension(wid, hei));
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.add(game);
        frame.setVisible(true);
        game.start();
    }

}
