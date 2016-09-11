import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PingDriver extends JFrame{
	
	static int score = 1;
	PingerBox box;
	static PingerPaddle rightPaddle;
	static JLabel label;
	JTextArea topPanel;
	static PingSecondWindow scoreWindow;
	
	public static void main(String[] args){
		new PingDriver();
		scoreWindow = new PingSecondWindow();
	}
	
	public PingDriver(){
		this.setTitle("Ping");
		this.setSize(700,550);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout());
		
		box = new PingerBox(); //creates box JPanel component
		
		rightPaddle = new PingerPaddle(); //creates right paddle component
		
		PaddleListener rightPaddleListener = new PaddleListener();
		rightPaddle.addMouseMotionListener(rightPaddleListener);
		
		label = new JLabel("Score: 0");
		Font scoreLabelFont = new Font("Serif", 1, 25);
		label.setFont(scoreLabelFont);

		this.addKeyListener(rightPaddleListener);
		this.addMouseMotionListener(rightPaddleListener);
		this.add(rightPaddle, BorderLayout.LINE_END);
		this.add(label, BorderLayout.PAGE_START);
		this.add(box, BorderLayout.CENTER);
		this.setVisible(true);
	}
	
	public static PingerPaddle getPaddle(){
		return rightPaddle;
	}
	
	public static void increaseScore(){
		label.setText("Score: " + score++);
	}
	
	public static JLabel getLabel(){
		return label;
	}
}