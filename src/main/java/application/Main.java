package application;

import components.*;
import interfaces.*;

public class Main {

	public static void main(String[] args) {
		
		//EV3 Setup
		
		
		//Storage System Setup
		Motor m1 = new Motor();
		Motor m2 = new Motor();
		Motor m3 = new Motor();
		ColorSensor b1 = new ColorSensor();
		IRSensor b2 = new IRSensor();
		TouchSensor b3 = new TouchSensor();
		TouchSensor b4 = new TouchSensor();
		Gripper gripper = new Gripper();
		Axis a1 = new Axis();
		Axis a2 = new Axis();
		
		
		IConveyerBelt conveyerBelt = new ConveyerBelt();
		IRobot robot = new Robot();
		StorageSystem storageBot = new StorageSystem(robot, conveyerBelt);		
		
		//loop
		while (true) {
			storageBot.loadNextBox();
			if (storageBot.boxLoaded()) {
				IBox box = storageBot.scanBox();
				storageBot.store(box, 1);
			}			
		}
		ConveyerBelt belt = new ConveyerBelt();
		Robot bot = new Robot();
		bot.setup();
		
		belt.setup("A", "S4", "S2");
		
		//belt.loadNextBox();
	}

}
