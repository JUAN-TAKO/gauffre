package Controller;

import Model.*;

import java.util.ArrayList;
import javafx.util.Pair;

public abstract class AIPlayer {

    public ArrayList<Pair<Integer, Grid>> GenerateNext(Grid current) {
        ArrayList<Pair<Integer, Grid>> grids = new ArrayList<>();
        for (int j = 0; j < current.height(); j++) {
            for (int i = 0; i < current.width(); i++) {
                if (current.get(i, j)) {
                    Grid next = current.copy();
                    next.play(i, j);
                    int idx = j*current.width() + i;
                    grids.add(new Pair<>(idx, next));
                }
            }    
        }
        return grids;
    }

    public abstract int getNextPlay(Grid g);
    
    public ArrayList<Grid> prochainesConfigurations(Grid C){ //renvoie la liste des prochaines config accessibles
        int m=C.width();
        int n=C.height();
        ArrayList<Grid> L=new ArrayList<Grid>();
        Grid C_suivante; //la config que l’on renverra
        for (int i=0; i<m; i++){
            for (int j=0; j<n; j++){
                if (C.get(i,j)==true){ /* si la case courante n’est pas encore mangée, alors on
                                                    construit une nouvelle configuration C_suivante */
                    C_suivante=new Grid(m, n);
                    //C_suivante =C U (la matrice où le carré inférieur ou égal à C[i][j] est mangé)
                    for(int k=0; k<C.width(); k++){
                        for (int l=0; l<C.height(); l++){
                            if ((C.get(k, l)==false)||(k<=i && l<=j)){
                                C_suivante.set(k, l, false);
                            }
                        }
                    }
                    
                    //ajouter C_suivante à L
                    L.add(L.size(), C_suivante);
                }
            }
        }
        return L;

    }

}