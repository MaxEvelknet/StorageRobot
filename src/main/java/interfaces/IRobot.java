package interfaces;

public interface IRobot {
	
	public boolean setup(
			String motorA1Port,
			String motorA2Port,
			String motorGripperPort,
			String sensorA1Port,
			String sensorA2Port
			);
	
	public void store(int _position);
	
	public void unstore(int _position);
	
	public void moveToPosition(int _position);
}
