package components;

import interfaces.*;

public class Gripper implements IGripper{
	
	private IMotor motor;
	private float openPosition;
	private float closedPosition;
	private final int speed = 50;
	private final float openOffset = 90f;
	
	@Override
	public boolean setup(String motorPort) {
		motor = new Motor();
		motor.setup(motorPort);
		
		
		//Needs be implemented
		//Set closed position
		//Move until hits a physical stop
		this.closedPosition = 180f; // closing position
		this.openPosition = this.openPosition + openOffset; // opening position
	return true;
	}
	
	@Override
	public void open() {
		motor.moveToPosition(this.openPosition); // Open position
	}
	
	@Override
	public void close() {
		motor.moveToPosition(this.closedPosition); // Closed position
	}
}