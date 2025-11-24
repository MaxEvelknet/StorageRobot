package components;

import interfaces.IColorSensor;

import lejos.robotics.Color;

import lejos.hardware.sensor.EV3ColorSensor;
import lejos.hardware.ev3.LocalEV3;


public class ColorSensor implements IColorSensor{
	private EV3ColorSensor colorSensor;
	
	@Override
	public boolean setup(String sensorPort) {
		this.colorSensor = new EV3ColorSensor(LocalEV3.get().getPort(sensorPort));
		this.colorSensor.setCurrentMode(this.colorSensor.getColorIDMode().getName());
		return true;
	}
	
	@Override
	public int scanColor() {
		return this.colorSensor.getColorID();
	}
}