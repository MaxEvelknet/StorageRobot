package interfaces;

public interface IIRSensor {	
	boolean setup(String port);
	
	float getDistance();
	
	boolean isBoxDetected(float threshold, int dir);
}