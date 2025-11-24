package components;

import interfaces.IColorSensor;

import java.awt.Color;

import lejos.hardware.sensor.EV3ColorSensor;
import lejos.hardware.ev3.LocalEV3;


public class ColorSensor implements IColorSensor{
	private EV3ColorSensor colorSensor;
	
	@Override
	public boolean setup(String sensorPort) {
		this.colorSensor = new EV3ColorSensor(LocalEV3.get().getPort(sensorPort));
		return true;
	}
	
	@Override
	public Color getColor() {
		return Color.RED; // Placeholder implementation
	}
}