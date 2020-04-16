package View;

import Controller.Controller;
import Model.Grid;

import javax.swing.*;
import java.awt.*;

public class GraphicsInterface implements Runnable{
    Controller control;

    GraphicsInterface(Controller control) {
        this.control = control;
    }

    public static void demarrer(Controller control) {
        SwingUtilities.invokeLater(new GraphicsInterface(control));
    }

    @Override
    public void run() {
        JFrame frame = new JFrame("Gaufre Empoisonnée");
        Grid g = new Grid(8,6);
        BoardGUI board = new BoardGUI(g, 300, 300,500-300, 500-300);
        MenuGUI menu = new MenuGUI(500-300, 500,0, 0);
        board.addMouseListener(new AdaptateurSouris());
        JPanel panel = new JPanel(new BorderLayout());
        frame.add(panel);
        panel.add(board);
        panel.add(menu);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setVisible(true);
    }
}
