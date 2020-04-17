package View;

import javax.swing.*;

import Patterns.Observateur;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class MenuGUI  extends JPanel implements Observateur, ActionListener {
    int largeur, hauteur, oX, oY;
    ArrayList<JButton> buttons;

    public MenuGUI(int largeur, int hauteur, int oX, int oY) {
        this.largeur = largeur;
        this.hauteur = hauteur;
        this.oX = oX;
        this.oY = oY;
        this.setLayout(new BoxLayout(this,BoxLayout.PAGE_AXIS));
        this.setSize(largeur, hauteur);
        buttons = new ArrayList<>();

        for(int i = 0; i < 2; i++) {
            JPanel buttonContainer = new JPanel();
            buttonContainer.setSize(largeur,hauteur/8);
            buttonContainer.setLayout(new BoxLayout(buttonContainer,BoxLayout.LINE_AXIS));
            JButton button= new JButton("Bouton");
            switch (i) {
                case 0:
                    button.setText("Recommencer");
                    break;
                case 1:
                    button.setText("Abandonner");
                    break;
            }
            buttons.add(button);
            buttonContainer.add(button);
            this.add(buttonContainer);
        }
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D drawable = (Graphics2D) g;
        g.setColor(Color.black);
        g.clearRect(oX,oY, oX + largeur, oY + hauteur);
    }

    @Override
    public void miseAJour() {
        repaint();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if(source == buttons.get(0)) {

        } else {

        }
    }
}