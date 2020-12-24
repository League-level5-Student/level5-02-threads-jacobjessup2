package _02_Advanced_Robot_Race;

import java.util.Random;

import javax.swing.JOptionPane;

import org.jointheleague.graphical.robot.Robot;

public class AdvancedRobotRace {
	// Re-do the robot race recipe from level 3 module 0. 
	// This time, use threads to make all of the robots go at the same time.
	static Robot[] robots = new Robot[2];
	public static void main(String[] args) {
		

		//2. create an array of 5 robots.
	
		//3. use a for loop to initialize the robots.
	for (int i = 0; i < robots.length; i++) {
		robots[i] = new Robot();
	}
			//4. make each robot start at the bottom of the screen, side by side, facing up
	robots[0].setSpeed(9);
	robots[1].setSpeed(9);
	robots[0].setY(550);
	robots[0].setX(900);
//	robots[0].turn(90);
	robots[0].penDown();
	robots[0].move(200);
	robots[0].penUp();
	robots[0].turn(90);
	robots[1].turn(90);
	int space = 50;
	for (int i = 0; i < robots.length; i++) {
		robots[i].setX(100);
		robots[i].setY(350+space);
		robots[i].setSpeed(10);
		space += 100;
	}
		//5. use another for loop to iterate through the array and make each robot move 
		//   a random amount less than 50.
	Thread r1 = new Thread(()->race(robots[0]));
	Thread r2 = new Thread(()->race(robots[1]));
	r1.start();
	r2.start();
		//6. use a while loop to repeat step 5 until a robot has reached the top of the screen.

		//7. declare that robot the winner and throw it a party!

		//8. try different races with different amounts of robots.

		//9. make the robots race around a circular track.
	}
	static void race(Robot rob) {
		Random rand = new Random();
		while (robots[0].getX() < 900 && robots[1].getX() < 900) {
			for (int j = 0; j < rand.nextInt(20); j++) {
				rob.move(rand.nextInt(10));
			}
		}
		if(robots[0].getX() >= 900) {
			JOptionPane.showMessageDialog(null, "Bot 1 is the winner");
			System.exit(0);
		}
		if(robots[1].getX() >= 900) {
			JOptionPane.showMessageDialog(null, "Bot 2 is the winner");
			System.exit(0);
		}
	}
}
