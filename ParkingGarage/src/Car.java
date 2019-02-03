
/**
 * represents a car
 */
public class Car {

	String license;
	String color;
	String make;
	String model;

	/**
	 * this is the constructor of the class Car
	 */
	public Car(String license) {
		this.license = license.toUpperCase();
	}

	/**
	 * assigns color to car
	 */
	public void color(String carColor) {
		color = carColor;
	}

	/**
	 * assign car make
	 */
	public void make(String carMake) {
		make = carMake;
	}

	/**
	 * assign car model
	 */
	public void model(String carModel) {
		model = carModel;
	}

	/**
	 * Print the Car details
	 */
	public void printCar() {
		System.out.print(license + ", ");
		System.out.print(color + ", ");
		System.out.print(make + ", ");
		System.out.print(model + ", ");
	}
}

/**
 * represent available parking spots
 */
class ParkingGarage{
	
	int capacity = 10;
	
	public ParkingGarage() {
		this.capacity = this.capacity -1;
		System.out.print(capacity);
	}

	
}

