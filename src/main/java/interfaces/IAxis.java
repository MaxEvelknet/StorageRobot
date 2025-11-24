package interfaces;

public interface IAxis{
	
	public boolean setup(
			String motorPort,
			String sensorPort,
			Direction direction
			);
	
	public void moveToLimit(Direction direction);
	
	public void moveToPosition(float degree);
}