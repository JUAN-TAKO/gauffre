package Controller.AI;

import Controller.AIPlayer;
import java.util.HashMap;
import javafx.util.Pair;
import java.util.ArrayList;
import Model.Grid;

public class MonteCarloAI extends AIPlayer{
    
    private HashMap<Integer, ArrayList<Pair<Integer, Float>>> graph;
    private Grid grid;

    public MonteCarloAI(Grid g){
        this.graph = new HashMap<Integer, ArrayList<Pair<Integer, Float>>>();
        this.grid = g;
    }

    
}