
public class GarageManager {

	public static void main(String args[]) {
		
		Car c1 = new Car("1adjak");
		Car c2 = new Car("2ialjd");
		Car c3 = new Car("3kadf");
		Car c4 = new Car("4ildjla");
		Car c5 = new Car("5jdlag");
		Car c6 = new Car("6ladgir");

		ParkingGarage p1 = new ParkingGarage(); // capacity is 10
		ParkingGarage p2 = new ParkingGarage(4); // capacity is 4
		
		c1.color("black");
		c1.model("civic");
		c1.make("honda");
		
		c2.color("white");
		c2.model("camry");
		c2.make("toyota");
		
		p1.park(c1,0);
		p1.park(c2,1);
		p1.park(c1,1); // spot already taken
		p1.park(c3,99); // spot does not exist
		p1.park(c2,45); // spot does not exist
		p1.park(c4,2); 
		//p1.park(c99,6); // user does not exist
		
		p1.printInventory();
	}

}
