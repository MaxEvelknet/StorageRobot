package components;

import interfaces.IBox;
import interfaces.IConveyerBelt;

import lejos.hardware.motor.EV3LargeRegulatedMotor;
import lejos.hardware.ev3.LocalEV3;
import lejos.hardware.ev3.*;
import lejos.hardware.sensor.EV3ColorSensor;
import lejos.hardware.sensor.EV3IRSensor;
import lejos.hardware.lcd.*;
import lejos.utility.Delay;

public class ConveyerBelt implements IConveyerBelt{
	
	private EV3LargeRegulatedMotor beltMotor;
	private EV3ColorSensor colorSensor;
	private EV3IRSensor IRSensor;
	private EV3 ev3;

	@Override
	public boolean setup(String motorPort, String distSensorPort, String colSensorPort) {
		
		ev3 = LocalEV3.get();
		
		beltMotor = new EV3LargeRegulatedMotor(ev3.getPort(motorPort));
		colorSensor = new EV3ColorSensor(ev3.getPort(colSensorPort));
		IRSensor = new EV3IRSensor(ev3.getPort(distSensorPort));
		
		IRSensor.setCurrentMode("Distance");
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean loadNextBox() {
		float distSamples[] = new float[1];
		
		beltMotor.setSpeed(100);
		
		beltMotor.backward();
		
		IRSensor.fetchSample(distSamples, 0);
		
		while(distSamples[0] > 38 || distSamples[0] == 0) 
		{
			IRSensor.fetchSample(distSamples, 0);
			LCD.drawString(Float.toString(distSamples[0]), 0, 0);
		}
		
		
		beltMotor.stop();
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean boxLoaded() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public IBox scanBox() {
		// TODO Auto-generated method stub
		return null;
	}

}
