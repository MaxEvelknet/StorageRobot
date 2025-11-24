package interfaces;

import java.awt.Color;

public interface IColorSensor{
	public boolean setup(String sensorPort);
	
	public Color getColor();
}