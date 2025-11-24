package interfaces;

import lejos.robotics.Color;

public interface IColorSensor{
	public boolean setup(String sensorPort);
	
	public int scanColor();
}