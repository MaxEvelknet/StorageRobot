package components;

import java.awt.Color;
import interfaces.IBox;

public class Box implements IBox{
	
	private Color color;
	private int position;
	
	private boolean validPosition(int _position) {
		//check if the given position is valid
		if (_position < 0) {
			return false;
		}
		return true;
	}
	
	public Box() {
		this.position = 0;
	}
	
	public Box(int _position) {
		if (!validPosition(_position)){
			return;
		}
		this.position = _position;
	}
	
	public Box(int _position, Color _color) {
		if (!validPosition(_position)){
			return;
		}
		this.position = _position;
		this.color = _color;
	}
	
	@Override
	public void setColor(Color _color) {
		this.color = _color;
	}

	@Override
	public Color getColor() {
		return this.color;
	}

	@Override
	public void store(int _position) {
		if (!validPosition(_position)){
			return;
		}
		this.position = _position;
	}

	@Override
	public int unstore() {
		this.position = 0;
		return this.position;
	}

	@Override
	public boolean isStored() {
		if(this.position == 0) {
			return false;
		}
		return true;
	}

	@Override
	public int getPosition() {
		return this.position;
	}
	
}
