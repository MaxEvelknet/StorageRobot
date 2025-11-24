package components;

import interfaces.IMotor;
import interfaces.MotorType;

import lejos.hardware.motor.EV3LargeRegulatedMotor;
import lejos.hardware.motor.EV3MediumRegulatedMotor;
import lejos.hardware.motor.BaseRegulatedMotor;
import lejos.hardware.ev3.EV3;
import lejos.hardware.ev3.LocalEV3;

public class Motor implements IMotor{
	private BaseRegulatedMotor motor;
	private EV3 ev3;

	@Override
	public boolean setup(String motorPort, int speed, MotorType type) {
		this.ev3 = LocalEV3.get();
		
		if (type == MotorType.MEDIUM) {
			this.motor = new EV3MediumRegulatedMotor(ev3.getPort(motorPort));
		}else if (type == MotorType.LARGE) {
			this.motor = new EV3LargeRegulatedMotor(ev3.getPort(motorPort));
		} else {
			return false; // Unsupported motor type
		}
		this.motor.setSpeed(speed);
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
	
	@Override
	public float getCurrentPosition() {
		// TODO Auto-generated method stub
		return this.motor.getTachoCount();
	}

	@Override
	public void moveToPosition(float degree) {
		int pos = this.motor.getTachoCount();
		int relativeDegree = pos+(int)degree;
		this.motor.rotateTo(relativeDegree);
	}
}