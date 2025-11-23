package components;

import interfaces.ITouchSensor;

import lejos.hardware.sensor.EV3TouchSensor;
import lejos.hardware.ev3.LocalEV3;

public class TouchSensor implements ITouchSensor{
	
	private EV3TouchSensor touchSensor;
	
	@Override
	public boolean setup(String sensorPort) {
		this.touchSensor = new EV3TouchSensor(LocalEV3.get().getPort(sensorPort));
		this.touchSensor.setCurrentMode("Touch");
		return true;
	}
	
	@Override
	public boolean isPressed() {
		float[] sample = new float[1];
		this.touchSensor.fetchSample(sample, 0);
		return sample[0] == 1;
	}
}