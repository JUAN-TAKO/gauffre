package Controller;

import Controller.AI.RandomAI;
import Controller.AI.WinningShotAI;
import Model.Grid;
import Patterns.Observable;
import View.EventCollector;
import Controller.AI.*;

public class Controller implements EventCollector {
    
    Grid grid;
    Player joueur1; //peuvent être autant des IA que des joueurs humains
    Player joueur2;
    Player joueurCourant;
    final int lenteurAttente = 50;
    int decompte;

	@Override
	public void mouseClick(int l, int c) {
		// TODO Auto-generated method stub
		if(joueurCourant.jouer(l, c))
			changeJoueur();
	}
    
    public Controller(Grid grid) {
        this.grid=grid;
        
        //A PRECISER COMMENT ON CHOISIT IA ET JOUEUR
        joueur1 = new /*Player choisi*/ HumanPlayer(grid);
        joueur2 = new /*Player choisi*/ MonteCarloAI(grid, 10);
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
            decompte = lenteurAttente;
    }
    
    public Grid getGrid() {
    	return grid;
    }
    
    @Override
    public void clock() {
    	if(grid.enCours()) {
    		if(decompte == 0) {
    			if(joueurCourant.tempsEcoule()) {
    				// IA
    				System.out.println("L'IA a jou� un coup.");
    				changeJoueur();
    			} else {
    				System.out.println("En attente d'un coup.");
    				decompte = lenteurAttente;
    			}
    		} else {
    			decompte--;
    		}
    	}
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