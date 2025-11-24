package components;

import interfaces.IRobot;
import lejos.hardware.motor.EV3LargeRegulatedMotor;
import lejos.hardware.sensor.EV3TouchSensor;
import lejos.hardware.ev3.*;
import lejos.hardware.ev3.LocalEV3;

public class Robot implements IRobot{

	private Axis a1;
	private Axis a2;
	private Gripper gripper;
	
	@Override
	public boolean setup() {
		
		this.a1 = new Axis();
		this.a2 = new Axis();
		this.gripper = new Gripper();
		this.a1.setup("D", "S1");
		this.a2.setup("C", "S3");
		this.gripper.setup("B");
		return true;
	}

	@Override
	public void store(int _position) {
		
	}

	@Override
	public void unstore(int _position) {
		
	}

	@Override
	public void moveToPosition(int _position) {
		
	}
	
	
}
