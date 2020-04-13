package Model;

import java.util.ArrayList;

public class Grid {
    private ArrayList<Boolean> grid;
    private int w, h;

    public Grid(int w, int h){
        this.w = w;
        this.h = h;
        this.grid = new ArrayList<Boolean>();
        for(int i = 0; i < w*h; i++){
            this.grid.add(true);
        }
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
}