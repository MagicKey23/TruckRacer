package TruckRacer;

public class Location {
	private String location;
	public Location(String location) {
		
		this.setLabel(location);
	}
	public void setLabel(String location) {
			this.location  = location;
	}
	public String getLabel() {
		return location;
	}	
	
	public String toString() {
		return location;
	}
}
