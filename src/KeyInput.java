import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter{

    public Handeler handle;

    int action = 0;
    GameObject GO1;

    public KeyInput(Handeler handle){ this.handle = handle;};

    public void keyPressed(KeyEvent e){
        int key = e.getKeyCode();
        for (GameObject GO:handle.OList){
            if (GO instanceof Player){
                if (key == KeyEvent.VK_S) GO.setVelY(5);
                if (key == KeyEvent.VK_W) GO.setVelY(-5);
                if (key == KeyEvent.VK_D) GO.setVelX(5);
                if (key == KeyEvent.VK_A) GO.setVelX(-5);
                if (key == KeyEvent.VK_SPACE) action = 1; GO1 = GO;
                if (key == KeyEvent.VK_ENTER) action = 2;
            }
        }
        switch(action){
        case 1:
            handle.add(new PlayProg(GO1.getX() + 10, GO1.getY() + 10, GO1, handle));
            break;
        case 2:
            if (GameEvent.enemies == 0){
                GameEvent.NextLevel(handle);
            }
            break;
        default:
            break;
        }
        action = 0;
    }

    public void keyReleased(KeyEvent e){
        int key = e.getKeyCode();
        for (GameObject GO:handle.OList){
            if (GO instanceof Player){
                if (key == KeyEvent.VK_W) GO.setVelY(0);
                if (key == KeyEvent.VK_D) GO.setVelX(0);
                if (key == KeyEvent.VK_S) GO.setVelY(0);
                if (key == KeyEvent.VK_A) GO.setVelX(0);
            }
        }
    }

}
