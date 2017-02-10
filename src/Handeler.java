import java.awt.Graphics;
import java.util.LinkedList;

public class Handeler {
    LinkedList<GameObject> OList = new LinkedList<GameObject>();
    LinkedList<GameObject> ROList = new LinkedList<GameObject>();
    
    
    public void tick(){
        for(Object GO:OList.toArray()){
            ((GameObject)GO).tick();
            if(((GameObject)GO).remove)
                ROList.add(((GameObject)GO));
        }
        for(GameObject GO: ROList)
            remove(GO);
        ROList.clear();
        
    }

    public void render(Graphics g){
        for(Object GO:OList.toArray())
            ROList.add((GameObject)GO);
        for(GameObject GO:ROList)
            GO.render(g);
        ROList.clear();
    }
    
    public void add(GameObject GO){
        OList.add(GO);
    }

    public void remove(GameObject GO){
        OList.remove(GO);
    }
    
    public void setList(LinkedList<GameObject> list){
        OList = list;
    }
}
