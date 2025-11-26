package interfaces;

import interfaces.IBox;

public interface IStorageSystem{
	
	public boolean setup(
			String motorA1Port,
			String motorA2Port,
			String motorgripperPort,
			String motorBeltPort,
			String sensorColorPort,
			String sensorA1Port,
			String sensorDistancePort,
			String sensorA2Port
			);

	public boolean loadNextBox();

	public boolean boxLoaded();

	public IBox scanBox();

	public IBox store(int _position);

	public IBox unstore(int _position);
}