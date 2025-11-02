

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
		
		ConveyerBelt conveyerBelt = new ConveyerBelt();
		Robot robot = new Robot();
		StorageSystem storageBot = new StorageSystem(robot, conveyerBelt);		
		
		//loop
		while (true) {
			storageBot.loadNextBox();
			if (storageBot.boxLoaded()) {
				Box box = storageBot.scanBox();
				storageBot.store(box, 1);
			}			
		}
	}

}
