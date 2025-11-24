package components;

import interfaces.IRobot;
import lejos.hardware.motor.EV3LargeRegulatedMotor;
import lejos.hardware.sensor.EV3TouchSensor;
import lejos.hardware.ev3.*;
import lejos.hardware.ev3.LocalEV3;

public class Robot implements IRobot{

	private Axis a1;
	private Axis a2;
	
	@Override
	public boolean setup() {
		
		this.a1 = new Axis();
		this.a2 = new Axis();
		this.a1.setup("D", "S1");
		this.a2.setup("C", "S3");
		
		this.a1.moveToLimit();
		this.a2.moveToLimit();
		
		/*turnMotor = new EV3LargeRegulatedMotor(ev3.getPort("D"));
		turnMotor.setSpeed(200);
		YMotor = new EV3LargeRegulatedMotor(ev3.getPort("C"));
		YMotor.setSpeed(200);
		
		yMax = new EV3TouchSensor(ev3.getPort("S3"));
		yMax.setCurrentMode("Touch");
		rotMax = new EV3TouchSensor(ev3.getPort("S1"));
		rotMax.setCurrentMode("Touch");
		
		float samples[] = new float[1];
		yMax.fetchSample(samples, 0);
		YMotor.backward();
		while(samples[0] != 1)
		{
			yMax.fetchSample(samples, 0);
		}
		YMotor.stop();
		
		rotMax.fetchSample(samples, 0);
		turnMotor.forward();
		while(samples[0] != 1)
		{
			rotMax.fetchSample(samples, 0);
		}
		turnMotor.stop();
		
		return false;*/
		return true;
	}

	@Override
	public void store(int _position) {
		
	}

	@Override
	public void unstore(int _position) {
		
	}
	
	
}
