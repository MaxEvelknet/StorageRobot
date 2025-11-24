package interfaces;

public interface IMotor {
	
	public boolean setup(String motorPort, int speed, MotorType type);
	
	public void moveForward();
	
	public void moveBackward();
	
	public void stop();
	
	public float getCurrentPosition();
	
	public void moveToPosition(float degree);	
}
