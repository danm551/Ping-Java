import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Timer;

public class PingerPaddle extends JPanel{
	
	int y = 10;
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		g.setColor(Color.BLUE);
		g.fillRect(0, y, 30, 60);
	}
}
