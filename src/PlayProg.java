import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class PlayProg extends Projectiles{
    int MAXRANGE;

    public PlayProg(int x, int y , GameObject GO, Handeler handle) {
        super(x, y, handle);
        MAXRANGE = x + 400;
        Damage = 10;
        GameEvent.GEList.add(this);
        height = 7;
        width = 7;
    }

    @Override
    public void tick() {
        x += 10;
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.blue);
        g.fillOval(x, y, width, height);
        g.fillOval(x - 2, y+2, 5, 3);
        if (x > MAXRANGE)
            remove = true;
    }

    @Override
    public Rectangle getHitBox() {
        return new Rectangle(x, y, width, height);
    }

    public boolean checkHit(GameObject GO){
        return this.getHitBox().intersects(GO.getHitBox());
    }
}
