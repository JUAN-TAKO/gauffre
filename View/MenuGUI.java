package View;

import javax.swing.*;
import java.awt.*;

public class MenuGUI  extends JPanel implements Observateur{
    int largeur, hauteur, oX, oY;

    public MenuGUI(int largeur, int hauteur, int oX, int oY) {
        this.largeur = largeur;
        this.hauteur = hauteur;
        this.oX = oX;
        this.oY = oY;
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D drawable = (Graphics2D) g;
        g.clearRect(oX,oY, largeur, hauteur);
        g.drawLine(oX, oY, largeur, hauteur);
    }

    @Override
    public void miseAJour() {
        repaint();
    }
}