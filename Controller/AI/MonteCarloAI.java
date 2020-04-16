package Controller.AI;
import Controller.AIPlayer;
import Model.Grid;

import java.util.HashMap;

public class MonteCarloAI extends AIPlayer{

    MonteCarloAI(Grid g) {
		super(g);
		// TODO Auto-generated constructor stub
	}

	protected boolean tempsEcoule() {
        return false;
    }
}