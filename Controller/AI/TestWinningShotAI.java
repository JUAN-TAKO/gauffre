package Controller.AI;
import Model.Grid;
import Controller.AI.WinningShotAI;
import java.util.ArrayList;


public class TestWinningShotAI {
    public static void main (String[] args){
        
        Grid C=new Grid(8,6);
        WinningShotAI wiai=new WinningShotAI(C);
        
        //TEST GETCOUPFINAL:
        System.out.println("coup final:");
        Grid coupFinal=wiai.getCoupFinal(C);
        for (int i=0; i<coupFinal.width(); i++){
            for (int j=0; j<coupFinal.height(); j++){
                if (coupFinal.get(i, j)==true){
                        System.out.print("O");
                    }
                    else{
                        System.out.print("X");
                    }
            }
            System.out.println("");
        }
        System.out.println("");
        
        //TEST GETCOUPPERDANT: VALIDE OK!
        System.out.println("coup perdant:");
        Grid coupPerdant=wiai.getCoupPerdant(C);
        for (int i=0; i<coupPerdant.width(); i++){
            for (int j=0; j<coupPerdant.height(); j++){
                if (coupPerdant.get(i, j)==true){
                        System.out.print("O");
                    }
                    else{
                        System.out.print("X");
                    }
            }
            System.out.println("");
        }
        System.out.println("");
        
        //===================================//
        
        //TEST GETCOUPSGAGNANTS : VALIDE OK!
        System.out.println("coups gagnants:");
        ArrayList<Grid> coupsGagnants=wiai.getCoupsGagnants(C);
        for (int k=0; k<coupsGagnants.size(); k++){
            Grid coupGagnantCourant=coupsGagnants.get(k);
            for (int l=0; l<coupGagnantCourant.width(); l++){
                for (int m=0; m<coupGagnantCourant.height(); m++){
                    if (coupGagnantCourant.get(l, m)==true){
                        System.out.print("O");
                    }
                    else{
                        System.out.print("X");
                    }
                }
                System.out.println("");
            }
            System.out.println("\n");
        }
        
        //TEST FINDWINNING SHOT
        //TEST1: sur la grille vide
        Grid emptyC=new Grid(8,6);
        WinningShotAI wiaiVide = new WinningShotAI(emptyC);
        System.out.println("coup gagnant test1:");
        wiaiVide.findWinningShot();
        for (int p=0; p<emptyC.width(); p++){
                for (int q=0; q<emptyC.height(); q++){
                    if (emptyC.get(p, q)==true){
                        System.out.print("O");
                    }
                    else{
                        System.out.print("X");
                    }
                }
                System.out.println("");
            }
        System.out.println("");
        
        //TEST2: sur la grille remplie grâce au test précédent
        System.out.println("coup gagnant test2:");
        wiaiVide.findWinningShot();
        for (int p=0; p<emptyC.width(); p++){
                for (int q=0; q<emptyC.height(); q++){
                    if (emptyC.get(p, q)==true){
                        System.out.print("O");
                    }
                    else{
                        System.out.print("X");
                    }
                }
                System.out.println("");
            }
        System.out.println("");
        
        //TEST3: sur la grille remplie grâce au test précédent (encore)
        System.out.println("coup gagnant test3:");
        wiaiVide.findWinningShot();
        for (int p=0; p<emptyC.width(); p++){
                for (int q=0; q<emptyC.height(); q++){
                    if (emptyC.get(p, q)==true){
                        System.out.print("O");
                    }
                    else{
                        System.out.print("X");
                    }
                }
                System.out.println("");
            }
        System.out.println("");
        
        //TEST4: sur une configuration pouvant être gagnante (gagne)
        System.out.println("coup gagnant test4:");
        WinningShotAI wiaiGagnant = new WinningShotAI(coupsGagnants.get(0));
        wiaiGagnant.findWinningShot();
        for (int p=0; p<coupsGagnants.get(0).width(); p++){
                for (int q=0; q<coupsGagnants.get(0).height(); q++){
                    if (coupsGagnants.get(0).get(p, q)==true){
                        System.out.print("O");
                    }
                    else{
                        System.out.print("X");
                    }
                }
                System.out.println("");
            }
        System.out.println("");
        
        //TEST5: sur une configuration perdante (perd)
        System.out.println("coup perdant test5:");
        WinningShotAI wiaiPerdant = new WinningShotAI(coupPerdant);
        wiaiPerdant.findWinningShot();
        for (int p=0; p<coupPerdant.width(); p++){
                for (int q=0; q<coupPerdant.height(); q++){
                    if (coupPerdant.get(p, q)==true){
                        System.out.print("O");
                    }
                    else{
                        System.out.print("X");
                    }
                }
                System.out.println("");
            }
        System.out.println("");
    }
}