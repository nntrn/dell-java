import java.util.Arrays;
import java.util.ArrayList;

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
		//System.out.println(license + ", " + color + ", " + make + ", " + model);
		String[] car = { license, color, make, model };
		return car;

	}
}

/**
 * represent available parking spots default capacity is 5 if not specified
 */
class ParkingGarage {

	int capacity = 5;
	Car[] parkingSpots = new Car[capacity];
	String[] carArray = new String[capacity];
	String[] licenseOfCarParked = new String[this.capacity];

	public ParkingGarage() {
		parkingSpots = new Car[capacity];
	}

	public ParkingGarage(int setCapacity) {
		this.capacity = setCapacity;
		parkingSpots = new Car[this.capacity];
		carArray = new String[this.capacity];
		licenseOfCarParked = new String[this.capacity];
	}
	
	public void park(Car car, int spot) {
	
		String printMsg = car.license + " => S" + spot +": ";
		
		if(!parkingSpotExists(spot)) 
			printMsg += "S"+spot+" does not exist";
		
		else if (!parkingSpotIsEmpty(spot)) 
			printMsg += "S"+spot+" is already taken";
		
		if (isCarAlreadyParked(car)) 
			printMsg += " / "+car.license + " is alreay parked at S"+indexOfCurrentCar(car);
		
		
		if(parkingSpotExists(spot) && !isCarAlreadyParked(car) && parkingSpotIsEmpty(spot)) {
			this.carArray[spot] = Arrays.deepToString(car.carInfo());
			this.parkingSpots[spot] = car;
			licenseOfCarParked[spot] = car.license;
			System.out.println(printMsg+" parked");
		}
		else {
			System.out.println("  error: " + printMsg);
		}

	}
	
	public void vacate(int spot) {
		
		String license = "";
		
		if(!parkingSpotIsEmpty(spot) ) {
			
			if(!this.parkingSpots[spot].license.isEmpty())
				license = this.parkingSpots[spot].license;
		
			this.carArray[spot] = null;
			this.parkingSpots[spot] = null;
			licenseOfCarParked[spot] = null;
			
			System.out.println(license + " <= S" + spot +" vacated");
			
		}
		else {
			System.out.println("S" + spot +" is already vacant");
		}
	}

	public void printInventory() {
		
		System.out.println("\n\nGARAGE INVENTORY:");
		for (int i = 0; i < this.carArray.length; i++)
			System.out.println("S" + i + ": " + carArray[i]);

	}
	

	public boolean parkingSpotExists(int spot) {

		try {
			String foo = this.parkingSpots[spot].license;
		} catch (ArrayIndexOutOfBoundsException e) {
			return false;
		} catch (NullPointerException e) {
			return true;
		} catch (Exception e) {
			return false;
		}
		return true;

	}

	public boolean parkingSpotIsEmpty(int spot) {
		if(parkingSpotExists(spot)) {
			if (this.parkingSpots[spot] == null) 
				return true;
		}
		return false;
	}
	
	public int indexOfCurrentCar(Car car) {
		int whereIsCarNow = Arrays.asList(this.licenseOfCarParked).indexOf(car.license);
		return whereIsCarNow;
	}

	public boolean isCarAlreadyParked(Car car) {
		int index = indexOfCurrentCar(car);
		if(index > -1)
			return true;
		return false;
	}

}
