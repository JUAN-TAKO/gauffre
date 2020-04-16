package Controller;

import Model.Grid;

public abstract class Player {
	
	protected Grid g;
	
	Player(Grid g){
		this.g = g;
	}

	// Méthode appelée par le joueur HUMAIN lors d'un clic sur le plateau
	// S'il s'agit d'une IA, elle sera ignorée.
    boolean jouer(int i, int j) {
    	return false; 
    }
    
	// Méthode appelée par le joueur IA une fois le temps écoulé
	// S'il s'agit d'un joueur humain, elle sera ignorée.
    boolean tempsEcoule() {
    	return false;
    }
}