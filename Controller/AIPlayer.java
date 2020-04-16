package Controller;

import Model.*;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

public abstract class AIPlayer extends Player{
    
    public AIPlayer(Grid C) {
	super(C);
    }

    public void GenerateConfigs(Grid config, Object obj, Method method) {
        for (int j = 0; j < config.height(); j++) {
            for (int i = 0; i < config.width(); i++) {
                if (config.get(i, j)) {
                    Grid new_config = config.copy();
                    new_config.play(i, j);
                    try {
                        method.invoke(obj, new_config);
                    } catch (IllegalAccessException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    } catch (IllegalArgumentException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    } catch (InvocationTargetException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
            }    
        }
    }
    
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