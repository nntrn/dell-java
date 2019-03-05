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
		//System.out.println(license + ", " + color + ", " + make + ", " + model);
		String[] car = { license, color, make, model };
		return car;
	}
	
	public void giveMeABlackCivic() {
		this.color = "black";
		this.make = "honda";
		this.model = "civic";
	}
	
}

/**
 * available parking spots 
 * (default capacity is 5 if not specified)
 */
class ParkingGarage {

	int capacity = 5;
	Car[] parkingSpots = new Car[capacity];
	String[] carArray = new String[capacity];
	String[] licenseOfCarsParked = new String[this.capacity];

	public ParkingGarage() {
		parkingSpots = new Car[capacity];
	

	public ParkingGarage(int setCapacity) {
		capacity = setCapacity;
		parkingSpots = new Car[this.capacity];
		carArray = new String[this.capacity];
		licenseOfCarsParked = new String[this.capacity];
	}
	
	/**
	 * parks a car if the following conditions are met:
	 * 1) car spot exists
	 * 2) spot is empty 
	 * 3) car is not already parked (need to vacate first)
	 */
	public void park(Car car, int spot) {
	
		String printMsg = "S" + spot +" => ";

		if(parkingSpotExists(spot) && !isCarAlreadyParked(car) && parkingSpotIsEmpty(spot)) {
			this.carArray[spot] = Arrays.toString(car.carInfo());
			this.parkingSpots[spot] = car;
			licenseOfCarsParked[spot] = car.license;
			printMsg += " parked";
		}
		else {
			printMsg += " not parked";
			printMsg += "\n\tisCarAlreadyParked (should be false): " + isCarAlreadyParked(car);
			printMsg += "\n\tparkingSpotIsEmpty (should be true): " + parkingSpotIsEmpty(spot);
		}
			
		System.out.println(printMsg);
		System.out.println("--------");

	}

	/**
	 * vacate a spot only if
	 * 1) car spot exists
	 * 2) spot is not already vacant 
	 */
	public void vacate(int spot) {
		
		String printMsg = "S" + spot +" <= ";
		
		if(parkingSpotExists(spot) && !parkingSpotIsEmpty(spot)) {
			this.carArray[spot] = null;
			this.parkingSpots[spot] = null;
			licenseOfCarsParked[spot] = null;
			printMsg += " vacated";
		}
		else {
			printMsg += " not vacated";
			printMsg += "\n\tparkingSpotIsEmpty (should be false): " + parkingSpotIsEmpty(spot);
		}
			
		System.out.println(printMsg);
		System.out.println("--------");
		
	}

	public void printInventory() {
		System.out.println("\nGARAGE INVENTORY:");
		for (int i = 0; i < this.carArray.length; i++)
			System.out.println("\tS" + i + ": " + carArray[i]);
	}

	public boolean parkingSpotExists(int spot) {

		try {
			String foo = this.parkingSpots[spot].license;
		} catch (ArrayIndexOutOfBoundsException e) {
			return false;
		} catch (NullPointerException e) {
			// empty parking spot
			return true;
		} catch (Exception e) {
			return false;
		}
		// parking spot with car parked
		return true;

	}

	public boolean parkingSpotIsEmpty(int spot) {
		if(parkingSpotExists(spot)) {
			if (this.parkingSpots[spot] == null)
				return true;	
		}
		else
			System.out.println("error: parking spot doesnt exist");
		return false;
	}
	
	// index in array that car is parked (-1 means not parked)
	public int indexOfCurrentCar(Car car) {
		int whereIsCarNow = Arrays.asList(this.licenseOfCarsParked).indexOf(car.license);
		return whereIsCarNow;
	}
	
	public boolean isCarAlreadyParked(Car car) {
		int index = indexOfCurrentCar(car);
		if(index > -1) {
			//System.out.println(" > error: " + car.license + " is already parked at S"+ index);
			return true;
		}
		return false;
	}

}
