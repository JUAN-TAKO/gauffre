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
        BoardGUI board = new BoardGUI(g, 300, 300,500-300, 500-300);
        MenuGUI menu = new MenuGUI(500-300, 500,0, 0);
        board.addMouseListener(new AdaptateurSouris(board, collector));
		Timer chrono = new Timer( 16, new AdaptateurTemps(collector));
		chrono.start();
        JPanel panel = new JPanel(new BorderLayout());
        frame.add(panel);
        panel.add(board);
        panel.add(menu);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setVisible(true);
    }
}
