package Model;

import java.util.ArrayList;
import Patterns.Observable;

public class Grid extends Observable {
    private ArrayList<Boolean> grid;
    private int w, h;
    boolean enCours = true;
    int joueurCourant = 1;
    
    public Grid(int w, int h){
        this.w = w;
        this.h = h;
        this.grid = new ArrayList<Boolean>();
        for(int i = 0; i < w*h; i++){
            this.grid.add(true);
        }
    }

    public Grid(Grid g){
        this.w = g.w;
        this.h = g.h;
        this.grid = new ArrayList<>(g.grid);
    }

    public ArrayList<Boolean> data(){
        return this.grid;
    }

    public Boolean get(int x, int y){
        return this.grid.get(x + this.w*y);
    }

    public void set(int x, int y, Boolean b){
        this.grid.set(x + this.w*y, b);
    }

    public int width(){
        return this.w;
    }

    public int height(){
        return this.h;
    }

    public Grid copy(){
        return new Grid(this);
    }

    public void play(int x, int y){
        for(int j = y; j < this.h; j++){
            for(int i = x; i < this.w; i++){
                this.set(i, j, false);
            }
        }
        
        enCours = get(0,0);
        joueurCourant = joueurCourant == 1 ? 2 : 1;
        metAJour();
    }
    
    public int getJoueurCourant() {
    	return joueurCourant;
    }
    
    public boolean enCours() {
    	return enCours;
    }

    public void reset(Grid g){
        this.grid = g.grid;
    }
    
    public boolean empty(int x, int y) {
    	return (x >= 0 && x < width() && y >= 0 && y < height()) 
    			&& this.get(x, y);
    }
}