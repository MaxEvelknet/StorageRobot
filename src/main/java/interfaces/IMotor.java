package interfaces;

public interface IMotor {
<<<<<<< HEAD
	
	public boolean setup(String motorPort, int speed, MotorType type);
=======
	public boolean setup(String motorPort);
>>>>>>> refs/remotes/origin/devFlo
	
	public void moveForward();
	
	public void moveBackward();
	
	public void stop();
	
	public float getCurrentPosition();
	
	public void moveToPosition(float degree);	
}
