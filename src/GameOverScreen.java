import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;

public class GameOverScreen extends GameObject{

    Font f = new Font("serif", 0, 20);
    public GameOverScreen(int x, int y, Handeler handle) {
        super(x, y, handle);
    }

    @Override
    public void tick() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public Rectangle getHitBox() {
        return null;
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.blue);
        g.setFont(f);
        g.drawString(("Game Over"), x, y + 20);
    }
}
