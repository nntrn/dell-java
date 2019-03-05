
public class GarageManager {

	public static void main(String args[]) {
		
		Car c1 = new Car("1adjak");
		Car c2 = new Car("2ialjd");
		Car c3 = new Car("3kadff");
		Car c4 = new Car("4ildjla");
		Car c5 = new Car("5jdlag");
		Car c6 = new Car("6ladgir");

		ParkingGarage p1 = new ParkingGarage(); // default capacity is 5
		ParkingGarage p2 = new ParkingGarage(2); // capacity is 10
		
		c1.color("red");
		c1.model("camry");
		c1.make("toyota");
		
		c2.color("white");
		c2.model("camry");
		c2.make("toyota");
		
		c3.giveMeABlackCivic();
		c4.giveMeABlackCivic();
		c5.giveMeABlackCivic();
		c6.giveMeABlackCivic();
		
		p1.park(c1,0);
		p1.park(c2,1);
		p1.park(c3,99); // spot doesn't exist
		p1.vacate(1); // c2 removed from s1
		p1.park(c6,0); // c1 already parked, spot is also taken
		p1.park(c1,4); // c1 is already parked
		p1.vacate(0); // c1 removed from s0
		p1.vacate(1); // c2 removed from s1
		p1.vacate(100); // spot doesn't exist
		p1.park(c1,1); 
		p2.park(c3, 0);
		p2.park(c4, 1);
		p2.park(c5, 1); // spot is already taken
		
		p1.printInventory();
		p2.printInventory();

	}

}
