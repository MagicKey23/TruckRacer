package TruckRacer;
import java.util.Random;
public class Spinner {
	public Spinner(){
		
	}
	public int spin() {
		 Random rnd = new Random();
		 return rnd.nextInt(6)-2;
	}
	
}

