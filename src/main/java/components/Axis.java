package components;

import interfaces.*;

public class Axis implements IAxis{
	
	private Motor motor;
	private TouchSensor limitSwitch;
	private MotorType motorType = MotorType.LARGE;
	private final int speed = 200;
	
	@Override
	public boolean setup(String motorPort, String sensorPort, Direction direction) {
		
		motor = new Motor();
		motor.setup(motorPort, speed, motorType);
		limitSwitch = new TouchSensor();
		limitSwitch.setup(sensorPort);
		
		this.moveToLimit(direction);
		
		return false;
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
	public void moveToPosition(float degree) {
		this.motor.moveToPosition(degree);
		return;
	}
}