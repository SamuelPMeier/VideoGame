import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.LinkedList;

public abstract class GameObject {
    protected int x, y, height, width;
    protected double velX = 0, velY = 0;
    Rectangle HBox;
    boolean isCollectable;
    boolean isBoarder;
    boolean remove = false;
    LinkedList<BufferedImage> img = new LinkedList<BufferedImage>(); 
    Handeler handle;
    
    public GameObject(int x, int y, Handeler handle){
        this.x = x;
        this.y = y;
        this.handle = handle;
    }
    
    public abstract void tick();
    
    public abstract Rectangle getHitBox();
    
    public abstract void render(Graphics g);
    public void setX(int x){this.x = x;}
    public void setY(int y){this.y = y;}
    public int getX(){return x;}
    public int getY(){return y;}
    public void setVelX(int x){this.velX = x;}
    public void setVelY(int y){this.velY = y;}
    public double getVelX(){return velX;}
    public double getVelY(){return velY;}
}
