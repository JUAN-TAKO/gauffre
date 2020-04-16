package View;

import Model.Grid;

import javax.swing.*;

public class GraphicsInterface implements Runnable{

    GraphicsInterface() {
    }

    public static void demarrer() {
        SwingUtilities.invokeLater(new GraphicsInterface());
    }

    @Override
    public void run() {
        JFrame frame = new JFrame("Gaufre Empoisonnée");
        Grid g = new Grid(3,3);
        BoardGUI board = new BoardGUI(g, 300, 300,500-300, 500-300);
        board.addMouseListener(new AdaptateurSouris());
        frame.add(board);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setVisible(true);
    }
}
