import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Basic extends Enemy{

    int MAXHP = 20;

    public Basic(int x, int y, Handeler handle) {
        super(x, y,handle);
        HP = MAXHP;
        height = 25;
        width = 25;
        velX = -1;
    }

    @Override
    public void tick() {
        if(x <= 10 ){ Player.HP -=10; remove = true; GameEvent.enemies--;}
        x += velX;
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
            g.setColor(Color.green);
        else
            g.setColor(Color.red);
        g.fillRect(x, y, width, height);
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
