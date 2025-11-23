package interfaces;

public interface IAxis{
	public boolean setup(String motorPort, String sensorPort);
	
	public void moveToLimit();
	
	public void move();
}