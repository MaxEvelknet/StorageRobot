package interfaces;

public interface IRobot {
	
	public boolean setup(String motorPort1, String motorPort2, String motorPort3, String sensorPort1, String sensorPort2);
	
	public void store(int _position);
	
	public void unstore(int _position);
	
	public void moveToPosition(int _position);
}
