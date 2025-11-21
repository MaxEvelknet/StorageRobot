package interfaces;
import java.awt.Color;

public class IBox {
	
	private Color color;
	private int position;
	
	private boolean validPosition(int _position) {
		//check if the given position is valid
		if (_position < 0) {
			return false;
		}
		return true;
	}
	
	public IBox() {
		this.position = 0;
	}
	
	public IBox(int _position) {
		if (!validPosition(_position)){
			return;
		}
		this.position = _position;
	}
	
	public IBox(int _position, Color _color) {
		if (!validPosition(_position)){
			return;
		}
		this.position = _position;
		this.color = _color;
	}
	
	public void setColor(Color _color) {
		this.color = _color;
	}
	
	public Color getColor() {
		return this.color;
	}
	
	public void store(int _position) {
		if (!validPosition(_position)){
			return;
		}
		this.position = _position;
	}
	
	public int unstore() {
		this.position = 0;
		return this.position;
	}
	
	public boolean isStored() {
		if(this.position == 0) {
			return false;
		}
		return true;
	}
	
	public int getPosition() {
		return this.position;
	}
	
}
