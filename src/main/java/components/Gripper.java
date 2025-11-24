package components;

import interfaces.*;

public class Gripper implements IGripper{
	
	private IMotor motor;
	private float openPosition;
	private float closedPosition;
	private final int speed = 50;
	private final float openOffset = 100f;
	private boolean closed;
	
	@Override
	public boolean setup(String motorPort) {
		motor = new Motor();
		motor.setup(motorPort, speed, MotorType.MEDIUM);
		
		this.motor.moveToPosition(300);
		this.closedPosition = motor.getCurrentPosition();
		this.closed = true;
		//Needs be implemented
		//Set closed position
		//Move until hits a physical stop
		this.openPosition = this.openPosition + openOffset; // opening position
		return true;
	}
	
	@Override
	public void open() {
		if(closed)
		{
			motor.moveToPosition(openOffset);
			closed = false;
		}
	}
	
	@Override
	public void close() {
		if(!closed)
		{
			motor.moveToPosition(-openOffset);
			closed = true;
		}
	}
}