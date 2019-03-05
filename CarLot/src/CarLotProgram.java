
public class CarLotProgram {
	public static void main(String args[]) {

		Car c1 = new Car();
		Truck t1 = new Truck();

		CarLot Lot1 = new CarLot("burnet");
		CarLot Lot2 = new CarLot("highland mall");

		c1.setLicense("CAR-C1");
		t1.setLicense("CAR-T1");

		Lot1.add(c1);
		Lot1.add(t1);

		for (int i = 0; i < 50; i++) {
			Lot1.addRandom();
			
			Vehicle toAdd = i%2==0? new Car() : new Truck();
			toAdd.setLicense(Lot2.randomLicense());
			Lot2.add(toAdd);
		}

		Lot1.list();
		Lot2.list();

	}

}

