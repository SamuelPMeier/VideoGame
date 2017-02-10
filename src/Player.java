import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Player extends GameObject{
    
    static int HP;
    BufferedImage currSprite;
    int timer = 0;
    int offset = 0;

    public Player(int x, int y, Handeler handle) throws IOException {
        super(x, y, handle);
        isCollectable = false;
        isBoarder = false;
        HP = 100;
        height = 40;
        width = 40; 
        img.add(ImageIO.read(new File("F:/Documents/GameAssets/SpriteSheet1.png")).getSubimage(0, 0, height, width));
        img.add(ImageIO.read(new File("F:/Documents/GameAssets/SpriteSheet1.png")).getSubimage(40, 0, height, width));
        img.add(ImageIO.read(new File("F:/Documents/GameAssets/SpriteSheet1.png")).getSubimage(80, 0, height, width));
        img.add(ImageIO.read(new File("F:/Documents/GameAssets/SpriteSheet1.png")).getSubimage(120, 0, height, width));
        img.add(ImageIO.read(new File("F:/Documents/GameAssets/SpriteSheet1.png")).getSubimage(160, 0, height, width));
        img.add(ImageIO.read(new File("F:/Documents/GameAssets/SpriteSheet1.png")).getSubimage(0, 40, height, width));
    }

    @Override
    public void tick() {
        if(HP <= 0) remove = true;
        if(x <= 10 ){ velX = 0; x += 1;}
        if(x >= 1200){ velX = 0; x -= 1;}
        if(y <= 33 ){ velY = 0; y += 1;}
        if(y >= 665){ velY = 0; y -= 1;}
        x += velX;
        y += velY;
        if(velY < 0) offset = 4;
        else if(velY > 0) offset = 2;
        else offset = 0;
        currSprite = img.get((timer/5) + offset);
        for(GameObject GO: handle.OList){
            if(GO instanceof beProg)
                if(GO != null && checkHit(((beProg)GO))){
                    HP -= ((beProg)GO).Damage;
                    ((beProg)GO).remove = true;
                }
        }
        timer++;
        if(timer >=9) timer = 0;
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(currSprite, x, y, width, height,null);
    }

    @Override
    public Rectangle getHitBox() {
        return new Rectangle(x, y, height, width);
    }
    
    public boolean checkHit(GameObject GO){
        return this.getHitBox().intersects(GO.getHitBox());
    }

}
