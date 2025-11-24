package interfaces;

public interface IMotor {
<<<<<<< HEAD:src/main/java/components/IMotor.java
<<<<<<< HEAD
	
	public boolean setup(String motorPort, int speed, MotorType type);
=======
	public boolean setup(String motorPort);
>>>>>>> refs/remotes/origin/devFlo
=======
	
	public boolean setup(String motorPort, int speed, MotorType type);
>>>>>>> 470ad8f30ea6742ac7c51ff2dd8a8aab2cead1c8:src/main/java/interfaces/IMotor.java
	
	public void moveForward();
	
	public void moveBackward();
	
	public void stop();
	
	public float getCurrentPosition();
	
	public void moveToPosition(float degree);	
	
	public void moveToAbsolutePosition(float degree);
}
