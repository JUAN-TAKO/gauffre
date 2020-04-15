package Controller;

import Model.Grid;

public abstract class Player {
    Grid grid;
    
    public Player(Grid C) {
            grid = C;
    }


    public abstract Grid jouer(Grid C); //prend la grille courante et renvoie la grille après modif
            
}