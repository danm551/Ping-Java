import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PingSecondWindow extends JFrame{
	
	static JLabel label;
	static int score = 1;
	
	public static void main(String[] args){
		new PingSecondWindow();
	}
	public PingSecondWindow(){
		this.setSize(200,550);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocation(1350,245);
		this.setTitle("Score");
		this.setLayout(new BorderLayout());
		
		label = new JLabel("Score: 0");
		Font scoreLabelFont = new Font("Serif", 1, 25);
		label.setFont(scoreLabelFont);
		
		this.add(label, BorderLayout.PAGE_START);
		this.setVisible(true);
	}
	
	public static void increaseScore(){
		label.setText("Score: " + score++);
	}
	
	public static JLabel getLabel(){
		return label;
	}
}
