package Controller;

import Controller.AI.RandomAI;
import Controller.AI.WinningShotAI;
import Model.Grid;
import View.EventCollector;

public class Controller implements EventCollector {
    
    Grid grid;
    Player joueur1; //peuvent être autant des IA que des joueurs humains
    Player joueur2;
    Player joueurCourant;
    final int lenteurAttente = 50;
    

	@Override
	public void mouseClick(int l, int c) {
		// TODO Auto-generated method stub
		if(joueurCourant.jouer(l, c))
			changeJoueur();
	}

	@Override
	public void clock() {
		// TODO Auto-generated method stub
		
	}
    
    public Controller(Grid grid) {
        this.grid=grid;
        
        //A PRECISER COMMENT ON CHOISIT IA ET JOUEUR
        joueur1 = new /*Player choisi*/ HumanPlayer(grid);
        joueur2 = new /*Player choisi*/ HumanPlayer(grid);
        joueurCourant = joueur1;
	}
    
    public boolean finDuJeu(){ //méthode pour savoir si on a fini
        Grid coupFinal=new Grid(grid.width(), grid.height());
        coupFinal.play(coupFinal.height(), coupFinal.width());
        return coupFinal == grid;
    }
    
    void changeJoueur() {
            if (joueurCourant==joueur1){
                joueurCourant=joueur2;
            }
            else{
                joueurCourant=joueur1;
            }
    }

    public Player getJoueurCourant() {
        return joueurCourant;
    }
    
    /*
     * En attente de fix pour la nouvelle architecture
     * 
     
    void jouer(){
        if (joueurCourant instanceof AIPlayer){
            if (joueurCourant instanceof RandomAI){
                RandomAI joueurCourantRand=(RandomAI) joueurCourant;
                grid=joueurCourantRand.jouer(grid);
            }
            else if (joueurCourant instanceof WinningShotAI){
                WinningShotAI joueurCourantWin= (WinningShotAI) joueurCourant;
                grid=joueurCourantWin.jouer(grid);
            }
        }
        else if (joueurCourant instanceof HumanPlayer){
            HumanPlayer joueurCourantHum=(HumanPlayer)joueurCourant;
            int i=0; //A MODIFIER
            int j=0; //A MODIFIER
            //i=.........voir comment les recuperer
            //j=...................................
            grid=joueurCourantHum.jouerCase(grid,i,j);
        }
    }
    */


}