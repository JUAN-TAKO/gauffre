package Controller;

import Model.Grid;

public abstract class Player {
	
	protected Grid g;
	
	Player(Grid g){
		this.g = g;
	}

	// M�thode appel�e par le joueur HUMAIN lors d'un clic sur le plateau
	// S'il s'agit d'une IA, elle sera ignor�e.
    boolean jouer(int i, int j) {
    	return false; 
    }
    
	// M�thode appel�e par le joueur IA une fois le temps �coul�
	// S'il s'agit d'un joueur humain, elle sera ignor�e.
    boolean tempsEcoule() {
    	return false;
    }
}