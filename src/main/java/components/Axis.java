package components;

import interfaces.*;

public class Axis implements IAxis{
	
	private Motor motor;
	private TouchSensor limitSwitch;
	private MotorType motorType = MotorType.LARGE;
	private final int speed = 200;
	
	@Override
<<<<<<< HEAD
	public boolean setup(String motorPort, String sensorPort, Direction direction) {
		
		motor = new Motor();
		motor.setup(motorPort, speed, motorType);
		limitSwitch = new TouchSensor();
		limitSwitch.setup(sensorPort);
		
		this.moveToLimit(direction);
		
		return false;
=======
	public boolean setup(String motorPort, String sensorPort) {
		try {
			motor = new Motor();
			motor.setup(motorPort);
			limitSwitch = new TouchSensor();
			limitSwitch.setup(sensorPort);
			return true;
		}
		catch (Exception e)
		{
			return false;
		}
>>>>>>> refs/remotes/origin/devFlo
	}

	@Override
	public void moveToLimit(Direction direction) {
		if (limitSwitch.isPressed()) {
			return;
		}
		
		if (direction == Direction.FORWARD) {
			motor.moveForward();
		} else if (direction == Direction.BACKWARD) {
			motor.moveBackward();
		} else {
			return;
		}
		
		while (!limitSwitch.isPressed()) {
			//wait until the limit switch is pressed
		}
		motor.stop();
		return;
	}

	@Override
<<<<<<< HEAD
	public void moveToPosition(float degree) {
		this.motor.moveToPosition(degree);
=======
	public void move() {
>>>>>>> refs/remotes/origin/devFlo
		return;
	}
}