import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Hud extends GameObject{

    Font f = new Font("serif", 0, 20);
    
    public Hud(int x, int y, Handeler handle) {
        super(x, y, handle);
        // TODO Auto-generated constructor stub
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
        g.setColor(Color.green);
        g.setFont(f);
        g.drawString(("Level: " + (GameEvent.level - 1) + "    Enemies: " + GameEvent.enemies + " HP: " + Player.HP), x=10, y + 20);
        if (GameEvent.level - 1 == 0)
            g.drawString("W A S D to move SPACE to shoot ENTER to start", 160, 180);
        else if (GameEvent.enemies == 0)
            g.drawString("ENTER to advance", 250, 200);
        
        
    }

}
