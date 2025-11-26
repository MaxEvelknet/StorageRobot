package components;

import interfaces.IIRSensor;

import lejos.hardware.sensor.EV3IRSensor;

public class IRSensor implements IIRSensor{
	
	private EV3IRSensor IRSensor;
	
	@Override
	public boolean setup(String port) {
		this.IRSensor = new EV3IRSensor(lejos.hardware.ev3.LocalEV3.get().getPort(port));
		this.IRSensor.setCurrentMode("Distance");
		return true;
	}

	@Override
	public float getDistance() {
		float distSamples[] = new float[1];
		this.IRSensor.fetchSample(distSamples, 0);
		return distSamples[0];
	}
	
	@Override
	public boolean isBoxDetected(float threshold, int dir) {
		float distance = this.getDistance();
		
		if (dir == 0) {
			return distance < threshold && distance != 0;
		}
		return distance > threshold && distance != 0;
	}
}