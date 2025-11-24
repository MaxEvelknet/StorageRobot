package interfaces;

public interface IMotor {
	public boolean setup(String motorPort);
	
	public void moveForward();
	
	public void moveBackward();
	
	public void stop();
	
	public int getCurrentPosition();
	
	public void moveToPosition(int degree);	
}