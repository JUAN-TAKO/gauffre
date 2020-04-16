package Controller.AI;

import Model.Grid;
import Controller.AIPlayer;
import java.lang.reflect.Method;
import java.util.ArrayList;

        
public class WinningShotAI extends AIPlayer{
    
    public WinningShotAI(Grid C) {
	super(C);
    }
    
    public Grid getCoupFinal(Grid C){
        Grid coupFinal=new Grid(C.width(), C.height());
        for (int i=0; i<coupFinal.width(); i++){
            for (int j=0; j<coupFinal.height(); j++){
                coupFinal.set(i,j,false);
            }
        }
        return coupFinal;
    }
    
    public Grid getCoupPerdant(Grid C){
        Grid coupPerdant=this.getCoupFinal(C);
        coupPerdant.set(coupPerdant.width()-1, coupPerdant.height()-1, true); //seule la dernière case n'est pas mangée
        return coupPerdant;
    }
    
    public ArrayList<Grid> getCoupsGagnants(Grid C){
        ArrayList<Grid> coupsGagnants=new ArrayList<Grid>();
        Grid coupGagnant=new Grid(C.width(), C.height());
        
        for (int i=C.width()-2; i>=0; i--){
            coupGagnant=getCoupPerdant(C);
            for (int a=C.width()-2; a>=i; a--){
                coupGagnant.set(a,C.height()-1, true);
            }
            coupsGagnants.add(coupGagnant);
        }
        
        for (int j=C.height()-2; j>=0; j--){
            coupGagnant=getCoupPerdant(C);
            for (int b=C.height()-2; b>=j; b--){
                coupGagnant.set(C.width()-1,b, true);
            }
            coupsGagnants.add(coupGagnant);
        }   
        return coupsGagnants;
    }
    
    public Grid findWinningShot(Grid C){ /*renvoie la configuration la meilleure selon le principe du coup gagnant
                                            (ou une tirée au hasard parmi les meilleures si il y en a plusieurs)
                                           en prenant la grille courante en argument*/
        ArrayList<Grid> L1= new ArrayList<Grid>();
        ArrayList<Grid> L2= new ArrayList<Grid>();
        ArrayList<Grid> L3= new ArrayList<Grid>();
        
        Grid C_suivante; // C_suivante la config que l’on renverra
        
        //L1=toutes les prochaines config possibles en un coup
        L1=this.prochainesConfigurations(C); //voir méthode de AIPlayer
        
        //L2= celles qui ne seront pas des coups gagnants pour l'adversaire, c-à-dire L1 - les configurations gagnantes
        L2=L1;
        ArrayList<Grid> configGagnantes=getCoupsGagnants(C);
        for (int i=0; i<L2.size(); i++){
            if (configGagnantes.contains(L2.get(i))){
                L2.remove(i);
            }
        }
        
        //L3=la config perdante pour l'adversaire si elle est dans L1, nul sinon
        if (L1.contains(getCoupPerdant(C))){
            L3.add(getCoupPerdant(C));
        }
        
        if ((L1.size()==1) && (L1.get(0)==this.getCoupFinal(C))){
            return L1.get(0); //si on n'a pas d'autre choix que de manger le poison, on le fait
        }
        
        //on retire d'office le choix de manger le poison de notre liste de choix si il y est
        if (L1. contains(this.getCoupFinal(C))){
            L1.remove(this.getCoupFinal(C));
        }
        
        if (L3.isEmpty()){  //si on ne peut pas faire perdre l’adversaire par le coup perdant
            if (L2.isEmpty()){ //si on est obligés de laisser un coup gagnant à l’adversaire
                
                //C_suivante=tirer au hasard une config de L1;
                int random=(int)(Math.random()*L1.size());
                C_suivante=L1.get(random);
            }
            else{
                
                //C_suivante=tirer au hasard une config de L2;
                int random=(int)(Math.random()*L2.size());
                C_suivante=L1.get(random);
            }
        }
        else{
            C_suivante=L3.get(0);
        }
            
        return C_suivante;
    }
    
    @Override
    public Grid jouer(Grid C){ //prend la grille courante et renvoie la grille après modif
        return findWinningShot(C);
    }
    
}