public class Controller {
    
    Grid grid;
    Player joueur1; //peuvent être autant des IA que des joueurs humains
    Player joueur2;
    Player joueurCourant=joueur1;
    final int lenteurAttente = 50;
    
    public Controller(Grid grid, Player joueur1, Player joueur2) {
        this.grid=grid;
        this.joueur1=joueur1;
        this.joueur2=joueur2;
		
	}
    
    public boolean finDuJeu(){ //méthode pour savoir si on a fini
        Grid coupFinal=new Grid(grid.width(), grid.height());
        for (int i=0; i<coupFinal.width(); i++){
            for (int j=0; j<coupFinal.height(); j++){
                coupFinal.set(i,j,false);
            }
        }
        if (coupFinal==grid){
            return true;
        }
        
        return false;
    }
    

    void changeJoueur() {
            if (joueurCourant==joueur1){
                joueurCourant=joueur2;
            }
            else{
                joueurCourant=joueur1;
            }
    }
    
    void jouer(){
        grid=joueurCourant.jouer(grid);
    }


}