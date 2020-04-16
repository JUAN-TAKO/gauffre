package View;

import Model.Grid;

import javax.swing.*;
import java.awt.*;

public class BoardGUI extends JComponent implements Observateur {

    Grid grid;
    int largeur, hauteur, oX, oY;

    public BoardGUI(Grid g, int largeur, int hauteur, int oX, int oY) {
        this.grid = g;
        this.hauteur = hauteur;
        this.largeur = largeur;
        this.oY = oY;
        this.oX = oX;
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D drawable = (Graphics2D) g;
        g.clearRect(0,0, largeur, hauteur);
        int pasX = largeur/grid.width();
        int pasY = hauteur/grid.height();
        for(int x = 0; x < grid.width(); x++) {
            for(int y = 0; y < grid.height(); y++) {
                if(grid.get(x,y))
                    g.setColor(Color.white);
                else
                    g.setColor(Color.yellow);
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
    public void addMouseListener(AdaptateurSouris adaptateurSouris) {
    }

    @Override
    public void miseAJour() {
        repaint();
    }
}