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
        this.setLayout(null);
        this.setSize(oX + largeur, oY + hauteur);
        JButton button = new JButton("Recomancer");
        button.setLocation(this.largeur/2 - button.getWidth()/2,this.hauteur/3 - button.getHeight()/2);
        this.add(button);
        button = new JButton("Abandonner");
        button.setLocation(this.largeur/2 - button.getWidth()/2,this.hauteur*2/3 - button.getHeight()/2);
        this.add(button);
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D drawable = (Graphics2D) g;
        g.clearRect(oX,oY, largeur, hauteur);
    }

    @Override
    public void miseAJour() {
        repaint();
    }
}