package View;

import Controller.Controller;
import Model.Grid;
import View.AdaptateurTemps;

import javax.swing.*;
import java.awt.*;

public class GraphicsInterface implements Runnable{
	EventCollector collector;
    Grid g;
    
    GraphicsInterface(Grid g, EventCollector collector) {
        this.collector = collector;
        this.g = g;
    }

    public static void demarrer(Grid g, EventCollector collector) {
        SwingUtilities.invokeLater(new GraphicsInterface(g, collector));
    }

    @Override
    public void run() {
        JFrame frame = new JFrame("Gaufre Empoisonnée");
        BoardGUI board = new BoardGUI(g, 300, 300,0, 0);
        MenuGUI menu = new MenuGUI(200, 500,0, 0);
        board.addMouseListener(new AdaptateurSouris(board, collector));
		Timer chrono = new Timer( 16, new AdaptateurTemps(collector));
		chrono.start();
        JPanel menuContainer = new JPanel(new BorderLayout());
        JPanel gridContainer = new JPanel(new BorderLayout());
        JPanel globalContainer = new JPanel();
        globalContainer.setLayout(new BoxLayout(globalContainer, BoxLayout.LINE_AXIS));
        globalContainer.add(menuContainer);
        globalContainer.add(gridContainer);
        menuContainer.add(menu);
        gridContainer.add(board);
        frame.add(globalContainer);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000, 500);
        frame.setVisible(true);
    }
}
