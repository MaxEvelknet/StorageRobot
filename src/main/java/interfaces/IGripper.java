package interfaces;

public interface IGripper {
	
	public boolean setup(String motorPort);
	
	public void open();
	
	public void close();
}