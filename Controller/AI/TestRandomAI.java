
package Controller.AI;

import Model.Grid;


public class TestRandomAI {
    public static void main(String[] args){
        Grid C=new Grid(8,6);
        RandomAI randai=new RandomAI();
        
        //TEST PREMIER COUP:
        System.out.println("prochaine config random");
        Grid prochainCoup=randai.findRandomShot(C);
        for (int i=0; i<prochainCoup.width(); i++){
            for (int j=0; j<prochainCoup.height(); j++){
                if (prochainCoup.get(i, j)==true){
                        System.out.print("O");
                    }
                    else{
                        System.out.print("X");
                    }
            }
            System.out.println("");
        }
        System.out.println("");
        
        //TEST DEUXIEME COUP:
        System.out.println("prochaine config random");
        Grid prochainCoup2=randai.findRandomShot(prochainCoup);
        for (int i=0; i<prochainCoup2.width(); i++){
            for (int j=0; j<prochainCoup2.height(); j++){
                if (prochainCoup2.get(i, j)==true){
                        System.out.print("O");
                    }
                    else{
                        System.out.print("X");
                    }
            }
            System.out.println("");
        }
        System.out.println("");
        
        //TEST TROISIEME COUP:
        System.out.println("prochaine config random");
        Grid prochainCoup3=randai.findRandomShot(prochainCoup2);
        for (int i=0; i<prochainCoup3.width(); i++){
            for (int j=0; j<prochainCoup3.height(); j++){
                if (prochainCoup3.get(i, j)==true){
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
