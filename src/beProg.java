import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class beProg extends Projectiles{
    int MAXRANGE;

    public beProg(int x, int y , GameObject GO, Handeler handle) {
        super(x, y, handle);
        MAXRANGE = x - 300;
        Damage = 5;
        GameEvent.GEList.add(this);
        height = 12;
        width = 12;
    }

    @Override
    public void tick() {
        x -= 5;
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.magenta);
        g.fillOval(x, y, width, height);
        if (x < MAXRANGE)
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