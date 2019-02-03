import java.util.Arrays;

/**
 * represents a car
 */
public class Car {

	String license;
	String color;
	String make;
	String model;

	/**
	 * this is the constructor of the class car
	 * 
	 * @param license String containing the license plate number
	 */
	public Car(String license) {
		this.license = license.toUpperCase();
	}

	public void color(String carColor) {
		this.color = carColor;
	}

	public void make(String carMake) {
		this.make = carMake;
	}

	public void model(String carModel) {
		this.model = carModel;
	}

	
	public String[] carInfo() {
		String[] car = { license, color, make, model };
		return car;

	}
}

/**
 * represent available parking spots
 */
class ParkingGarage {

	int capacity = 10;
	Car[] parkingSpots = new Car[capacity];
	String[] carArray = new String[capacity];

	public ParkingGarage() {
		parkingSpots = new Car[capacity];
	}

	public ParkingGarage(int setCapacity) {
		this.capacity = setCapacity;
		parkingSpots = new Car[this.capacity];
	}

	public boolean checkParking(int spot) {
		if(this.parkingSpots[spot]==null)
			return true;
		return false;
	}
	
	public void park(Car car, int spot) {
		// TODO: error handling for unresolved cars
		
		try {
			if(checkParking(spot) ) {
				this.parkingSpots[spot] = car;
				this.carArray[spot] = Arrays.deepToString(car.carInfo());
				
				System.out.println(car.license + " parked in S"+spot);
			}
			else {
				System.out.println("\t--"+car.license+": S" +spot+" is already taken ");
			}
			
		} catch (Exception e) {
			System.out.println("\terror: can not park at S"+spot);
		}

	}
	
	public void printInventory() {

		System.out.println("\n\n");
		for (int i = 0; i < this.carArray.length; i++)
			System.out.println("S" + i + " => " + this.carArray[i]);

	}
	

}
