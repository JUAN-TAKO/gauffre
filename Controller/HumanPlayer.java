package Controller;
import Model.Grid;

public class HumanPlayer extends Player{
    
    HumanPlayer(Grid g) {
		super(g);
	}

	int[] detecterClic(){           //renvoie le couple (i,j) (tableau de deux int) où le joueur a cliqué
        int[] coupleIJ= new int[2];
        
        /*.......................
        
        A COMPLETER !
        
        .......................*/
        
        return coupleIJ;
    }
    
    void configSuivante(int i, int j){ //renvoie la config suivante en fct de là oùa appuyé le joueur,                                        //null si on est à la fin du jeu
        g.play(i, j);
    }
    
    @Override
    public boolean jouer(int i, int j){ //prend la grille courante et renvoie la grille après modif
        if(g.empty(i,j)) {
        	configSuivante(i,j);
        	return true;
        } else {
        	return false;
        }
    }
}