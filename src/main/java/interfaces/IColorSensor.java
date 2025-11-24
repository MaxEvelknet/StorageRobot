package interfaces;

import java.awt.Color;

public interface IColorSensor{
	public void setup(String sensorPort);
	
	public Color scanColor();
}