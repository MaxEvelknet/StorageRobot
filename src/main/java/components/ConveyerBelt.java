package components;

import interfaces.*;
import components.*;
import intrfaces.MotorType;

import lejos.hardware.motor.EV3LargeRegulatedMotor;
import lejos.hardware.ev3.LocalEV3;
import lejos.hardware.ev3.*;
import lejos.hardware.sensor.EV3ColorSensor;
import lejos.hardware.lcd.*;
import lejos.utility.Delay;

public class ConveyerBelt implements IConveyerBelt{
	
	private Motor beltMotor;
	private ColorSensor colorSensor;
	private IRSensor IRSensor;
	private final float treshold = 38.0f;
	private final float unloadTreshold = 100.0f;
	private final int speed = 200;
	private final MotorType motorType = MotorType.LARGE;

	@Override
	public boolean setup(String motorPort, String distSensorPort, String colSensorPort) {
		
		this.beltMotor = new Motor();
		this.colorSensor = new ColorSensor();
		this.IRSensor = new IRSensor();
		
		this.beltMotor.setup(motorPort, speed, motorType);
		this.colorSensor.setup(colSensorPort);
		this.IRSensor.setup(distSensorPort);
		
		return this.IRSensor.isBoxDetected(treshold);
	}

	@Override
	public boolean loadNextBox() {	
		if (this.IRSensor.isBoxDetected(this.treshold, 0))
		{
			return true; //box already present
		}
		
		this.beltMotor.moveForward();
		
		while(!this.IRSensor.isBoxDetected(this.treshold, 0))
		{
			//wait until box is detected
		}
		this.beltMotor.stop();
		return true;
	}

	@Override
	public boolean boxLoaded()
	{
		return this.IRSensor.isBoxDetected(this.treshold);
	}

	@Override
	public IBox scanBox()
	{
		Box box = new Box();
		box.setColor(this.colorSensor.getColor());
		return box;
	}
	
	@Override
	public void unstoreBox() {
		
		if(!this.IRSensor.isBoxDetected(treshold)) {
			return;
		}
		
		this.beltMotor.moveForward();
		
		while(this.IRSensor.isBoxDetected(unloadTreshold))
		{
			//wait until box is no longer detected
		}
		this.beltMotor.stop();
	}

}
