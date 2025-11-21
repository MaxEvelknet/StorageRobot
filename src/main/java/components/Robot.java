package components;
import interfaces.IRobot;
import lejos.hardware.motor.EV3LargeRegulatedMotor;
import lejos.hardware.sensor.EV3TouchSensor;
import lejos.hardware.ev3.*;
import lejos.hardware.ev3.LocalEV3;
public class Robot implements IRobot{

	private EV3LargeRegulatedMotor turnMotor;
	private EV3LargeRegulatedMotor YMotor;
	private EV3 ev3;
	private EV3TouchSensor yMax;
	private EV3TouchSensor rotMax;
	@Override
	public boolean setup() {
		ev3 = LocalEV3.get();
		
		turnMotor = new EV3LargeRegulatedMotor(ev3.getPort("D"));
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
		
		return false;
	}

	@Override
	public void store(int _position) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void unstore(int _position) {
		// TODO Auto-generated method stub
		
	}
	
	
}
