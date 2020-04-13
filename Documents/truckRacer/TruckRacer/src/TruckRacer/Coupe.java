package TruckRacer;
import TruckRacer.Spinner;
import TruckRacer.Location;
import TruckRacer.State;
import java.util.Random;
import java.util.Scanner;
public class Coupe extends Car {
	//SET UP Attributes and Reference
	private Scanner scan = new Scanner(System.in);
	private Random rnd = new Random();
	
	
	public Coupe(String name, Location label) {
		super(name, label);
	}
	public void takeTurn(Spinner spinner, State state) {
    	System.out.printf("%s's turn. Press Enter to Spin...\n", this.getName());
    	String keyPress = scan.nextLine();
    	if(keyPress.isEmpty()) {
    	//Spin 
    	int spinVal = rnd.nextInt(3);
    	System.out.printf("%s\n", this.getCurrentlocation());
		System.out.printf("%s spins %d\n",this.getName(), spinVal);
		this.setCurrentLocation(state.move(this.getCurrentlocation(), spinVal));
		//Winner
		if(this.getCurrentlocation() == state.getLastLocation()) {
			System.out.printf("%s is the Winner\n", this.getName());
			this.printWinnerCertificate(this.getName());
		}else {
			System.out.printf("%s at %s\n", this.getName(), this.getCurrentlocation());
		}
		
		
    	}
    	
		
	}
	
	
}
