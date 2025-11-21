package main_package;
import components;
import components.ConveyerBelt;
public class Main {

	public static void main(String[] args) {
		ConveyerBelt belt = new ConveyerBelt();
		
		belt.setup("A", "4", "2");
		
		belt.loadNextBox();
	}

}
