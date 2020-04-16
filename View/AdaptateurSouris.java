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
		System.out.println("Yo");
		int l = e.getY() / b.cellHeight();
		int c = e.getX() / b.cellWidth();
		collector.mouseClick(l, c);
	}
	
}
