package components;

import interfaces.*;

public class StorageSystem implements IStorageSystem{

	private IBox[] boxStorage;
	private IRobot robot;
	private IConveyerBelt conveyerBelt;
	
	
	public StorageSystem(IRobot _robot, IConveyerBelt _conveyerBelt) {
		this.robot = _robot;
		this.conveyerBelt = _conveyerBelt;
		this.boxStorage = new IBox[] {};
	}
	
	@Override
	public boolean setup() {
		//setup robot and conveyerbelt
		//return (this.robot.setup() && this.conveyerBelt.setup());
		return true;
	}

	@Override
	public boolean loadNextBox() {
		//load box onto position
		return this.conveyerBelt.loadNextBox();
	}

	@Override
	public boolean boxLoaded(){
		//check if a box is loaded
		return this.conveyerBelt.boxLoaded();
	}

	@Override
	public IBox scanBox() {
		//scan the color of the box and return a box object
		return this.conveyerBelt.scanBox();
	}

	@Override
	public boolean store(IBox _box, int _position) {
		//store a box in storage at given position
		if (this.boxStorage[_position] != null) {
			System.out.println("There is already a box at postion " + _position );
			return false;
		}
		if (_position <= 0) {
			System.out.println("Invalid position . There is no storage at" + _position );
			return false;			
		}
		this.robot.store(_position);
		_box.store(_position);
		this.boxStorage[_position] = _box;
		return true;
	}
	
	@Override
	public IBox unstore(int _position) {
		//unstore box and load it onto the conveyerbelt
		if (this.boxLoaded()) {
			System.out.println("A box is already on the conveyer belt can not unload a box from storage");
			return null;
		}
		if (this.boxStorage[_position] == null) {
			System.out.println("There is no box avaiable at position " + _position);
			return null;
		}
		this.robot.unstore(_position);
		IBox unloadedBox = this.boxStorage[_position];
		this.boxStorage[_position] = null;
		return unloadedBox;
	}	
}
