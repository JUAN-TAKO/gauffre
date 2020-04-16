package View;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AdaptateurSouris extends MouseAdapter {
	
	BoardGUI b;
	EventCollector collector;
	
	AdaptateurSouris(BoardGUI b, EventCollector c){
		this.b = b;
		this.collector = c;
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		int c = (e.getY() - b.oX) / b.cellHeight();
		int l = (e.getX() - b.oY) / b.cellWidth();
		System.out.println("Clicked ! Coordinates : x = " + e.getX() + " y = " + e.getY() + " | Grid Coordinates : x = " + l + " y = " + c);
		collector.mouseClick(l, c);
	}
	
}
