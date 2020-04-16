
package Controller.AI;

import Model.Grid;


public class TestRandomAI {
    public static void main(String[] args){
        Grid C=new Grid(8,6);
        RandomAI randai=new RandomAI(C);
        
        for(int n = 0; n < 3; n++) {
        	System.out.println("prochaine config random - i =" + n);
            randai.findRandomShot();
            for (int i=0; i<C.width(); i++){
                for (int j=0; j<C.height(); j++){
                    if (C.get(i, j)==true){
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
    
}
