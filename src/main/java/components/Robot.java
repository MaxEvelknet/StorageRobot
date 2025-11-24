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
	private float positions[4][2] ={
		{0.0f, 0.0f},
		{0.0f, 200.0f},
		{-350.0f, 300.0f},
		{-700.0f, 300.0f}
	};
	
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
	public void store(int position) {
		this.moveToPosition(0);
		this.gripper.open();

		this.moveToPosition(1);
		this.gripper.close();

		this.a2.moveToPosition(positions[0][1]);

		this.moveToPosition(position);
		this.gripper.open();

		this.moveToPosition(0);
	}

	@Override
	public void unstore(int position) {
		this.moveToPosition(0);
		this.gripper.open();

		this.moveToPosition(position);
		this.gripper.close();

		this.a2.moveToPosition(positions[0][1]);

		this.moveToPosition(1);
		this.gripper.open();

		this.moveToPosition(0);
	}


	@Override
	public void moveToPosition(int position) {
		this.a2.moveTo(positions[position][1]);
		this.a1.moveTo(positions[position][0]);
	}
	
}
