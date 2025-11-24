package components;

import interfaces.*;

public class Axis implements IAxis{
	
	private Motor motor;
	private TouchSensor limitSwitch;
	
	@Override
	public boolean setup(String motorPort, String sensorPort) {
		motor = new Motor();
		motor.setup(motorPort);
		limitSwitch = new TouchSensor();
		limitSwitch.setup(sensorPort);
		return false;
	}

	@Override
	public void moveToLimit() {
		if (limitSwitch.isPressed()) {
			motor.stop();
			return;
		}
		motor.moveForward();
		while (!limitSwitch.isPressed()) {
			//wait until the limit switch is pressed
		}
		motor.stop();
		return
	}

	@Override
	public void move() {
		return
	}
}