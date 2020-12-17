package _01_Olympic_Rings;

import java.awt.Color;

import org.jointheleague.graphical.robot.Robot;

public class OlympicRings_Threaded {
	// Make A Program that uses Threads and robots to draw the Olympic rings. One robot should draw one ring simultaneously with the other 4 robots.
	public static void main(String[] args) {
		Robot blue = new Robot(400, 400);
		Robot yellow = new Robot(550, 655);
		Robot black = new Robot(700, 400);
		Robot green = new Robot(850, 655);
		Robot red = new Robot(1000, 400);
		
		blue.setPenColor(new Color(0, 150, 255));
		blue.penDown();
		blue.setSpeed(100);
		Thread r1 = new Thread(()->circle(blue));
		r1.start();
		
		yellow.setPenColor(new Color(255,255,0));
		yellow.penDown();
		yellow.setSpeed(100);
		Thread r2 = new Thread(()->circle(yellow));
		r2.start();
		
		black.setPenColor(new Color(0,0,0));
		black.penDown();
		black.setSpeed(100);
		Thread r3 = new Thread(()->circle(black));
		r3.start();
		
		green.setPenColor(new Color(0,225,100));
		green.penDown();
		green.setSpeed(100);
		Thread r4 = new Thread(()->circle(green));
		r4.start();
		
		red.setPenColor(new Color(255,0,40));
		red.penDown();
		red.setSpeed(100);
		Thread r5 = new Thread(()->circle(red));
		r5.start();
	}
	static void circle(Robot rob) {
		for (int i = 0; i < 360; i++) {
			rob.move(3);
			rob.turn(1);
		}
	}
}

