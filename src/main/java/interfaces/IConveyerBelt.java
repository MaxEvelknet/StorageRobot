package interfaces;

import interfaces.IBox;

public interface IConveyerBelt {
	
	public boolean setup(
			String motorPort,
			String sensorColorPort,
			String sensorDistancePort
			);
	
	public boolean loadNextBox();
	
	public boolean boxLoaded();
	
	public IBox scanBox();
	
	public void unstoreBox();
}
