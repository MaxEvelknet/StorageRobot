package interfaces;

public interface ITouchSensor{
	public boolean setup(String sensorPort);
	
	public boolean isPressed();
}