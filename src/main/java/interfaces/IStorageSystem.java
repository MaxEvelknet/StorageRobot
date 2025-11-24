package interfaces;

import interfaces.IBox;

public interface IStorageSystem{
	public boolean setup(
			String motorA1Port,
			String motorA2Port,
			String motorGripperPort,
			String motorBeltPort,
			String sensorA1Port,
			String sensorA2Port,
			String sensorColorPort,
			String sensorDistancePort
	);

	public boolean loadNextBox();

	public boolean boxLoaded();

	public IBox scanBox();

	public boolean store(IBox _box, int _position);

	public IBox unstore(int _position);
}