package interfaces;
public interface IConveyerBelt {
	
	public boolean setup(String motorPort, String distSensorPort, String colSensorPort);
	
	public boolean loadNextBox();
	
	public boolean boxLoaded();
	
	public IBox scanBox();
}
