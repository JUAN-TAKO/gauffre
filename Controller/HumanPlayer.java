package Controller;
import Model.Grid;

public class HumanPlayer extends Player{
    
    Grid configSuivante(Grid C, int i, int j){ //renvoie la config suivante en fct de là oùa appuyé le joueur,
                                                //null si on est à la fin du jeu
        
        while (C.get(i,j)!=true){}; //on attend que le joueur appuie sur une case non encore mangée
        
        C.set(i, j, false);
        
        Grid C_suivante=C.copy();
        //C_suivante =C U (la matrice où le carré inférieur ou égal à C[i][j] est mangé)
        for(int k=0; k<C.width(); k++){
            for (int l=0; l<C.height(); l++){
                if (k<=i && l<=j){
                    C_suivante.set(k, l, false);
                }
            }
        }
        return C_suivante;
    }
    
    
    public Grid jouerCase(Grid C, int i, int j){ //prend la grille courante et renvoie la grille après modif
        return configSuivante(C, i, j);   
    }
    

}