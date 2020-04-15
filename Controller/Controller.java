import Model.Grid;

public class Controller {
    
    public boolean finDuJeu(Grid C){ //méthode pour savoir si on a fini
        Grid coupFinal=new Grid(C.width(), C.height());
        for (int i=0; i<coupFinal.width(); i++){
            for (int j=0; j<coupFinal.height(); j++){
                coupFinal.set(i,j,false);
            }
        }
        if (coupFinal==C){
            return true;
        }
        
        return false;
    }

}