import java.util.LinkedList;
import java.util.Random;

public class GameEvent {
    static LinkedList<GameObject> GEList = new LinkedList<GameObject>();
    static int level = 1;
    static int spawns = 2;
    static int enemies = 0;
    static Random rand = new Random();
    
    public void add(GameObject GO){
        GEList.add(GO);
    }
    
    public void clear(){
        GEList.clear();
    }
    
    public void remove(){
        GEList.remove();
    }

    public static void NextLevel(Handeler handle) {
        if(level % 2 != 0){
            for (int i = spawns; i > 0 ; i--)
                handle.add(new strafeEnemy(rand.nextInt(200) + 1300,rand.nextInt(650)+ 30, handle));
            enemies = spawns;
        }
        else{
            for(int i = level;i>0;i--)
                handle.add(new BigEnemy(rand.nextInt(200) + 600, rand.nextInt(220) + 30, handle));
            enemies = level;
        }
        spawns += level;
        level++;
    }
}
