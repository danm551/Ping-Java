import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import java.io.BufferedInputStream;
import java.io.File;

import java.io.InputStream;
import java.net.URL;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class PingerBox extends JPanel implements ActionListener{
	
	boolean direction = true, bounce = false;
	int x = 0, y = 152, l = 30, w = 30, velX = 2, velY = 2, currPaddleLocY, currPaddleLocX, score = 1; //x = initial position, velX = speed
	Timer tm = new Timer(5, this);
	Random randomGenerator = new Random();
	URL boop, bgm;
	
	public PingerBox(){
		boop = PingerBox.class.getClassLoader().getResource("Recording.wav");
		bgm = PingerBox.class.getClassLoader().getResource("Jump Hi.wav");
		PlaySound(bgm);
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		g.setColor(Color.RED);
		g.fillArc(x, y, l, w, 360, 360);
		
		tm.start();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		currPaddleLocY = PaddleListener.getPaddleLocY(); 
		
		if(x < 700 && direction == true){
			if(y >= 440){
				bounce = true;
				velY = randomGenerator.nextInt(3) + 1;
			}
			if(y <= 0){
				bounce = false;
				velY = randomGenerator.nextInt(3) + 1;
			}
			
			x = x + velX;
			
			if(!bounce){
				y = y + velY;
			}
			else{
				y = y - velY;
			}
			
			if(x == 700){
				x = 0;
			}
			else if(y > (currPaddleLocY-50) && y < (currPaddleLocY+30) && x == 650){
				direction = false;
				l--;
				w--;
				PingSecondWindow.increaseScore();
				PlaySound(boop);
			}
		}
		else if(x > 0 && direction == false){
			if(y >= 440){
				bounce = true;
				velY = randomGenerator.nextInt(3) + 1;
			}
			if(y <= 0){
				bounce = false;
				velY = randomGenerator.nextInt(3) + 1;
			}
			
			x = x - velX;
			
			if(!bounce){
				y = y + velY;
			}
			else{
				y = y - velY;
			}
			
			if(x == 0){
				direction = true;
			}
		}
		
		repaint();
		
	}
	
	static void PlaySound(URL sound){
		try{
			Clip clip = AudioSystem.getClip();
			clip.open(AudioSystem.getAudioInputStream(sound));
			clip.start();
			
			//Thread.sleep(clip.getMicrosecondLength()/10000);
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
}
