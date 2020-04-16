package Controller;

import Model.Grid;
import Controller.AIPlayer;
import Controller.AI.RandomAI;
import java.util.ArrayList;

//TEST VALIDE OK!
public class TestProchainesConfigurations {
    
    public static void main (String[] args){
        Grid C=new Grid(8, 6);
        AIPlayer ai= new RandomAI(C);
        ArrayList<Grid> prochainesConfigs = ai.prochainesConfigurations (C);
        for (int i=0; i<prochainesConfigs.size(); i++){
            Grid grilleAAfficher=prochainesConfigs.get(i);
            for (int j=0; j<grilleAAfficher.width(); j++){
                for (int k=0; k<grilleAAfficher.height(); k++){
                    if (grilleAAfficher.get(j, k)==true){
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
    }
    
}
