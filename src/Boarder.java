import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Boarder extends GameObject{

    public Boarder(Handeler handle) {
        super(10,30, handle);
        width = 1273;
        height = (width/ 16 * 9) -54;
        HBox = new Rectangle(x, y, width, height);
    }

    @Override
    public void tick() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public Rectangle getHitBox() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void render(Graphics g) {
        g.setColor(new Color(128,128,128));
        g.fillRect(x, y, width, height);
    }

}
