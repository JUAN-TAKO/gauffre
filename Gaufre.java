import Model.*;
import Controller.*;
import View.*;

public class Gaufre{
    public static void main(String[] args){
        Grid gaufre=new Grid(8,6);
        EventCollector eventCollector = new Controller(gaufre);

        GraphicsInterface.demarrer(gaufre, eventCollector);
        
        /*
        while (control.finDuJeu()!=true){  //tant qu'on est pas arrivé à la fin du jeu on alterne
            gaufre=joueur1.jouer(gaufre);
            gaufre=joueur2.jouer(gaufre);
            //prévoir un break pour une fin de la partie en cours de route
            
        }
        */
        
        //blablabla
        
    }
}