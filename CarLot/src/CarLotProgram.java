

public class CarLotProgram {
	public static void main(String args[]) {
		
		Car c1 = new Car(),c2 = new Car(),c3 = new Car();
		Truck t1 = new Truck(),t2 = new Truck(),t3 = new Truck();	
		
		c1.licenseNumber = "3j103";
		
		CarLot c = new CarLot("burnet");
		
		c.add(c1);
		c.add(c2);
		c.add(c3);
		c.add(t1);
		c.add(t2);
		c.add(t3);
		c.list();
		
	}


}
