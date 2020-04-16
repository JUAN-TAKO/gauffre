package View;

import Model.Grid;
import Patterns.Observateur;

import javax.swing.*;
import java.awt.*;

public class BoardGUI extends JComponent implements Observateur {

    Grid grid;
    int largeur, hauteur, oX, oY;

    public BoardGUI(Grid g, int largeur, int hauteur, int oX, int oY) {
        this.grid = g;
        this.hauteur = ((int)((hauteur-5)/g.height()))*g.height();
        this.largeur = ((int)((largeur-5)/g.width()))*g.width();
        this.oY = oY;
        this.oX = oX;
        this.setSize(oX + largeur, oY + hauteur);
        this.grid.ajouteObservateur(this);

    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D drawable = (Graphics2D) g;
        g.clearRect(0, 0, getWidth(), getHeight());
        
        int pasX = largeur/grid.width();
        int pasY = hauteur/grid.height();
        for(int x = 0; x < grid.width(); x++) {
            for(int y = 0; y < grid.height(); y++) {
                if(x == grid.width()-1 && y == grid.height()-1) {
                    g.setColor(Color.green);
                } else {
                    if(grid.get(x,y))
                        g.setColor(Color.white);
                    else
                        g.setColor(Color.yellow);
                }
                g.fillRect(oX+x*pasX,oY+y*pasY,pasX,pasY);
            }
        }

        g.setColor(Color.black);
        for(int i = 0; i < grid.height()+1; i++) {
            g.drawLine(oX,i*pasY+oY,largeur+oX,i*pasY+oY);
        }
        for(int i = 0; i < grid.width()+1; i++) {
            g.drawLine(i*pasX+oX,oY,i*pasX+oX,hauteur+oY);
        }
    }

    @Override
    public void miseAJour() {
        repaint();
    }
    
    public int cellHeight() {
    	return hauteur/grid.height();
    }
    
    public int cellWidth() {
    	return largeur/grid.width();
    }
}