package interfaces;

import interfaces.IBox;

public interface IConveyerBelt {
	
	public boolean setup(
			String motorPort,
			String sensorColorPort,
			String sensorDistancePort,
			float treshold);
	
	public boolean loadNextBox();
	
	public boolean boxLoaded();
	
	public IBox scanBox();
}
