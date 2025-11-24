package components;

import interfaces.*;

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
	private EV3 ev3;
	private float treshold;

	@Override
	public boolean setup(String motorPort, String distSensorPort, String colSensorPort, float _treshold) {
		
		ev3 = LocalEV3.get();
		
		this.colorSensor = new ColorSensor();
		this.beltMotor = new Motor();
		this.IRSensor = new IRSensor();
		this.colorSensor.setup(colSensorPort);
		this.beltMotor.setup(motorPort);
		this.IRSensor.setup(distSensorPort);
		
		this.treshold = _treshold;
		
		return IRSensor.isBoxDetected(this.treshold);
	}

	@Override
	public boolean loadNextBox() {	
		if (this.IRSensor.isBoxDetected(this.treshold))
		{
			return tur; //box already present
		}
		this.beltMotor.moveForward();
		
		while(!this.IRSensor.isBoxDetected(this.treshold))
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
		return null;
	}

}
