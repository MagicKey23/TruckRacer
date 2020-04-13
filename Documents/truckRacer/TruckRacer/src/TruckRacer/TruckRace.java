package TruckRacer;
import TruckRacer.Truck;
import TruckRacer.Car;
import TruckRacer.State;
import TruckRacer.Spinner;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import TruckRacer.Location;
import TruckRacer.Coupe;
public class TruckRace {
	//SET UP 
	//Create state and give its a name
	 private State theState = new State("First State");
	 //Start Location
	 Location startLocation = theState.getStartLocation();
	 Truck truck;
	 Coupe coupe;
	 private Spinner theSpinner = new Spinner();
	 private Scanner scan = new Scanner(System.in);
	 private ArrayList<Car> cars = new ArrayList<Car>();
	 private boolean carExist = false;
	 private int numCar;
	 //------- CONSTRUCTOR -------------/
	public TruckRace() {
		
		// ASK USER for how many car does the user want?
		
		
		
		try {
		System.out.printf("Enter the number of car in the game\n");
		numCar = scan.nextInt();
		while(numCar < 2) {
			System.out.println("Number of car must more than 2, please re-enter\n");
			numCar = scan.nextInt();
			if(numCar >= 2) {
				break;
			}
		}
		}catch(InputMismatchException e){
		System.out.println("Error: Input can't be a decimal number, string, char\nProgram close.");
		System.exit(1);
		}
		//-------------------
		
		System.out.printf("\nThere are %d cars compete in the game\n", numCar);
		
		// Ask for the car's name and add them to the array
		for(int i = 0; i < numCar; i++) {
		//Go back to the loop
		carExist = false;
		//Ask name
		System.out.printf("What is the name for the car %d? \n", i+1);
		String carName = scan.next();
		//ASK user which vehicle is it?
	
		while(carExist != true) {
		System.out.printf("Will this vehicle be a coupe or truck?\n");
		String selectCar = scan.next();
		if(selectCar.toLowerCase().equals("truck")) {
		truck = new Truck(carName, startLocation);
		cars.add(truck);
		carExist = true;
		break;
		}else if(selectCar.toLowerCase().equals("coupe")) {
		coupe = new Coupe(carName, startLocation);
		cars.add(coupe);
		carExist = true;
		break;
		}else {System.out.printf("The car doesn't exist please try again\n"); carExist = false;}
		
		}//end while loop
		
			}//end loop
		}
		
	public void playGame() {
		// Control Game
		 boolean keepPlaying = true;
		 //Display
		theState.showState(cars);
		
		while(keepPlaying == true) {
			for(Car car: cars) {
				car.takeTurn(theSpinner, theState);
				theState.showState(cars);
				Location lastLocation = theState.getLastLocation(); 
				if(car.isLocatedOn(lastLocation)) {
					keepPlaying = false;
					break;
					}else {keepPlaying = true;}
			}
			
		}
	}

}
