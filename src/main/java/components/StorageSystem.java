package components;

import interfaces.*;

public class StorageSystem implements IStorageSystem{

	private IBox[] boxStorage;
	private IRobot robot;
	private IConveyerBelt conveyerBelt;
	
	@Override
	public boolean setup(
			String motorA1Port,
			String motorA2Port,
			String motorgripperPort,
			String motorBeltPort,
			String sensorColorPort,
			String sensorA1Port,
			String sensorDistancePort,
			String sensorA2Port
			)
	{
		
		this.robot = new Robot();
		this.conveyerBelt = new ConveyerBelt();
		
		this.robot.setup(
				motorA1Port,
				motorA2Port,
				motorgripperPort,
				sensorA1Port,
				sensorA2Port
				);
		this.conveyerBelt.setup(
				motorBeltPort,
				sensorDistancePort,
				sensorColorPort
				);
		
		this.boxStorage = new IBox[2];
		this.boxStorage[0] = null;
		this.boxStorage[1] = null;
		
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
	public IBox store(int _position) {
		//store a box in storage at given position
		if (this.boxStorage[_position] != null) {
			System.out.println("There is already a box at postion " + _position );
			return null;
		}
		if (_position <= 0 || _position >= this.boxStorage.length) {
			System.out.println("Invalid position . There is no storage at" + _position );
			return null;			
		}
		
		this.loadNextBox();
		this.boxStorage[_position] = this.scanBox();
		this.robot.store(_position);	
		return this.boxStorage[_position];
	}
	
	@Override
	public IBox unstore(int _position) {
		//store a box in storage at given position
		if (this.boxStorage[_position] == null) {
			System.out.println("There is no box at postion " + _position );
			return null;
		}
		if (_position <= 0 || _position >= this.boxStorage.length) {
			System.out.println("Invalid position . There is no storage at" + _position );
			return null;			
		}
		if(this.boxLoaded()) {
			System.out.println("There is already a box on the conveyer belt" );
			return null;	
		}
		
		IBox box = this.boxStorage[_position];
		this.robot.unstore(_position);
		this.conveyerBelt.unstoreBox();
		this.boxStorage[_position] = null;
		return box;
	}	
}
