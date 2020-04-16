package Controller.AI;

import Model.Grid;
import Controller.AIPlayer;
import java.util.ArrayList;

public class RandomAI extends AIPlayer {
    
    public RandomAI(Grid g) {
		super(g);
		// TODO Auto-generated constructor stub
	}

	public void findRandomShot(){
        
        ArrayList<Grid> L1= new ArrayList<Grid>();
        Grid C_suivante; // C_suivante la config que l’on renverra
        
        //L1=toutes les prochaines config possibles en un coup
        L1=this.prochainesConfigurations(g); //voir méthode de AIPlayer
        
        //C_suivante=tirer au hasard une config de L1;
        int random=(int)(Math.random()*L1.size());
        g = L1.get(random); // Et remplacer la gaufre courante par celle-ci
    }
    
	@Override
    public boolean tempsEcoule() {
    	findRandomShot();
		return true;
    }

	@Override
	public int getNextPlay(Grid g) {
		// TODO Auto-generated method stub
		return 0;
	}
}