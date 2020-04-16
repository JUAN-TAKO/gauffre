package Controller;
import Model.Grid;

public class HumanPlayer extends Player{
    
    int[] detecterClic(){           //renvoie le couple (i,j) (tableau de deux int) où le joueur a cliqué
        int[] coupleIJ= new int[2];
        
        /*.......................
        
        A COMPLETER !
        
        .......................*/
        
        return coupleIJ;
    }
    
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
    
    @Override
    public Grid jouer(Grid C){ //prend la grille courante et renvoie la grille après modif
        int[] coupleIJ=new int[2];
        coupleIJ=detecterClic();
        return configSuivante(C, coupleIJ[0], coupleIJ[1]);   
    }
    

}