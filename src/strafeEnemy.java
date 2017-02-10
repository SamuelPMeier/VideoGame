import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class strafeEnemy extends Enemy{

    int MAXHP = 10;

    public strafeEnemy(int x, int y, Handeler handle) {
        super(x, y,handle);
        HP = MAXHP;
        height = 25;
        width = 25;
        velX = -0.5;
        velY = 1;
    }

    @Override
    public void tick() {
        if(x <= 10 ){ Player.HP -=10; remove = true; GameEvent.enemies--;}
        x += velX;
        if (y >= 650) velY = -.2;
        if (y <= 50)  velY = 1;
        y += velY;
        for(GameObject GO: handle.OList){
            if(GO instanceof PlayProg)
                if(GO != null && checkHit(((PlayProg)GO))){
                    HP -= ((PlayProg)GO).Damage;
                    ((PlayProg)GO).remove = true;
                }
            if(GO instanceof Player)
                if(GO != null && checkHit(((Player)GO))){
                    Player.HP -= 10;
                    remove = true;
                    GameEvent.enemies--;
                }
        }
    }

    @Override
    public void render(Graphics g) {
        if((HP / MAXHP) > 0.5)
            g.setColor(Color.red);
        else
            g.setColor(Color.red);
        g.fillOval(x, y, width, height);
        if(HP <= 0){
            if (!remove)
                GameEvent.enemies--;
            remove = true;
        }
    }

    @Override
    public Rectangle getHitBox() {
        return new Rectangle(x, y, width, height);
    }

    public boolean checkHit(GameObject GO){
        return this.getHitBox().intersects(GO.getHitBox());
    }
}
