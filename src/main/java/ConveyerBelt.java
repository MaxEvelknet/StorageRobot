
public interface ConveyerBelt {
	
	public boolean setup();
	
	public boolean loadNextBox();
	
	public boolean boxLoaded();
	
	public Box scanBox();
}
