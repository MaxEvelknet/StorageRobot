package interfaces;

import java.awt.Color;

public interface IBox{
	
	public boolean setup();
	
	public void setColor(Color _color);
	
	public Color getColor();
	
	public void store(int _position);
	
	public int unstore();
	
	public boolean isStored();
	
	public int getPosition();
}