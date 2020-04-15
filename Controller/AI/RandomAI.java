package Controller;

import Model.Grid;
import Controller.AIPlayer;
import java.util.ArrayList;

public class RandomAI extends AIPlayer {
    public Grid findRandomShot(Grid C){
        
        ArrayList<Grid> L1= new ArrayList<Grid>();
        Grid C_suivante; // C_suivante la config que l’on renverra
        
        //L1=toutes les prochaines config possibles en un coup
        L1=this.prochainesConfigurations(C); //voir méthode de AIPlayer
        
        //C_suivante=tirer au hasard une config de L1;
        int random=(int)(Math.random()*L1.size());
        C_suivante=L1.get(random);
        return C_suivante;
    }

}