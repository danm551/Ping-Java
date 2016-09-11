import java.awt.event.*;
import java.awt.*;
import java.util.Timer;

public class PaddleListener implements MouseMotionListener, KeyListener{
	
	int x, oldLoc = 10;
	static int y, currLoc;
	static Point locOnScreen;
	static PingerPaddle rightPaddle = PingDriver.getPaddle();
	
	@Override
	public void mouseDragged(MouseEvent e) {
		
		locOnScreen = e.getLocationOnScreen();
		currLoc = e.getY();
		
		if(e.getY() > oldLoc){
			if(y < 440){
				y = y + 4;
			}
		}
		else if(e.getY() < oldLoc){
			if(y > -5){
				y = y - 4;
			}
		}

		rightPaddle.setLocation(674,y);
		
		oldLoc = currLoc;
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getKeyCode() == KeyEvent.VK_UP){
			if(y > -5){
				y = y - 32;
			}
		}
		if(e.getKeyCode() == KeyEvent.VK_DOWN){
			if(y < 440){
				y = y + 32;
			}
		}
		
		rightPaddle.setLocation(674, y);
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	public static int getPaddleLocY(){
		return y;
	}
}
