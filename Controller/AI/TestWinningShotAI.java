package Controller;
import Model.Grid;
import Controller.WinningShotAI;
import java.util.ArrayList;


public class TestWinningShotAI {
    public static void main (String[] args){
        
        Grid C=new Grid(8,6);
        WinningShotAI wiai=new WinningShotAI();
        
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
        System.out.println("coup gagnant test1:");
        Grid coupGagnant=wiai.findWinningShot(C);
        for (int p=0; p<coupGagnant.width(); p++){
                for (int q=0; q<coupGagnant.height(); q++){
                    if (coupGagnant.get(p, q)==true){
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
        Grid coupGagnant2=wiai.findWinningShot(coupGagnant);
        for (int p=0; p<coupGagnant2.width(); p++){
                for (int q=0; q<coupGagnant2.height(); q++){
                    if (coupGagnant2.get(p, q)==true){
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
        Grid coupGagnant3=wiai.findWinningShot(coupGagnant2);
        for (int p=0; p<coupGagnant3.width(); p++){
                for (int q=0; q<coupGagnant3.height(); q++){
                    if (coupGagnant3.get(p, q)==true){
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
        Grid coupGagnant4=wiai.findWinningShot(coupsGagnants.get(0));
        for (int p=0; p<coupGagnant4.width(); p++){
                for (int q=0; q<coupGagnant4.height(); q++){
                    if (coupGagnant4.get(p, q)==true){
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
        System.out.println("coup gagnant test4:");
        Grid coupGagnant5=wiai.findWinningShot(coupPerdant);
        for (int p=0; p<coupGagnant5.width(); p++){
                for (int q=0; q<coupGagnant5.height(); q++){
                    if (coupGagnant5.get(p, q)==true){
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