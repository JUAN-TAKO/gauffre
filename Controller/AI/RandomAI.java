package Controller.AI;

import Model.Grid;
import Controller.AIPlayer;
import java.util.ArrayList;

public class RandomAI extends AIPlayer {
    
    public RandomAI(Grid C) {
	super(C);
    }
    
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
    
    @Override
    public Grid jouer(Grid C){ //prend la grille courante et renvoie la grille après modif
        return findRandomShot(C);
    }
}