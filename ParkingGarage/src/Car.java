/**
 * Car has the following attributes:
 * Color, License#, Make, and Model
 * 
 *  https://howtodoinjava.com/design-patterns/behavioral/mediator-pattern/
 *  
 */
public class Car {
	
	public Car color;
	//public String licenseNum;
	//public String make;
	public Car model;
	
    // the Bicycle class has one constructor
    public Car() {
    	
    	//licenseNum = startCadence;
    	//make = startSpeed;
    	model = getModel();
    	
    	Car d = new Car();
    	d.color = getColor();
    	d.model = getModel();
    }
    
	public Car getColor() {
		return this;
	}
	
	public Car getModel() {
		return this;
	}


}
