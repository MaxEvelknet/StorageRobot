package components;

import interfaces.IMotor;

import lejos.hardware.motor.EV3LargeRegulatedMotor;
import lejos.hardware.ev3.LocalEV3;

public class Motor implements IMotor{
	private EV3LargeRegulatedMotor motor;
	
	@Override
	public boolean setup(String motorPort) {
		this.motor = new EV3LargeRegulatedMotor(LocalEV3.get().getPort(motorPort));
		this.motor.setSpeed(200);
		return true;
	}
	
	@Override
	public void moveForward() {
		this.motor.forward();
	}
	
	@Override
	public void moveBackward() {
		this.motor.backward();
	}
	
	@Override
	public void stop() {
		this.motor.stop();
	}
}