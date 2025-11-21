import components.ConveyerBelt;
import components.Robot;
import interfaces.IBox;
import interfaces.IConveyerBelt;
import interfaces.IRobot;
import interfaces.StorageSystem;

public class Main {

	public static void main(String[] args) {
		
		//EV3 Setup
		
		
		//Storage System Setup
		/*Motor m1 = new Motor();
		Motor m2 = new Motor();
		Motor m3 = new Motor();
		ColorSensor b1 = new ColorSensor();
		DistanceSensor b2 = new DistanceSensor();
		ContactSensor b3 = new ContactSensor();
		ContactSensoor b4 = new ContactSensor();
		Gripper gripper = new Gripper();
		Axis a1 = new axis();
		Axis a2 = new axis();*/
		
		/*
		IConveyerBelt conveyerBelt = new IConveyerBelt();
		IRobot robot = new IRobot();
		StorageSystem storageBot = new StorageSystem(robot, conveyerBelt);		
		
		//loop
		while (true) {
			storageBot.loadNextBox();
			if (storageBot.boxLoaded()) {
				IBox box = storageBot.scanBox();
				storageBot.store(box, 1);
			}			
		}*/
		ConveyerBelt belt = new ConveyerBelt();
		Robot bot = new Robot();
		bot.setup();
		
		belt.setup("A", "S4", "S2");
		
		//belt.loadNextBox();
	}

}
