
public class GarageManager {

	public static void main(String args[]) {
		
		Car c1 = new Car("1adjak");
		Car c2 = new Car("2ialjd");
		Car c3 = new Car("3kadf");
		Car c4 = new Car("4ildjla");
		Car c5 = new Car("5jdlag");
		Car c6 = new Car("6ladgir");

		ParkingGarage p1 = new ParkingGarage(); // capacity is 10
		ParkingGarage p2 = new ParkingGarage(10); // capacity is 4
		
		c1.color("black");
		c1.model("civic");
		c1.make("honda");
		
		c2.color("white");
		c2.model("camry");
		c2.make("toyota");
		
		p1.park(c1,0);
		p1.park(c2,1);
		p1.park(c1,1); // spot already taken
		p1.park(c2,1); // spot does not exist
		p1.park(c2,45); // spot does not exist
		p1.park(c4,99); 
		p1.park(c5,3); 
		p1.park(c6,99); 
		//p1.park(c99,6); // user does not exist
		
		p1.vacate(1);
		p1.vacate(4);
		p1.park(c2,1);
		
		
		System.out.println("\n\nTEST");
//		p1.isCarParked(c2);
//		p1.isCarParked(c1);
//		p1.isCarParked(c3);
//		p1.isCarParked(c4);
		
//		p2.park(c1,0);
//		p2.park(c2,1);
//		p2.park(c1,1); // spot already taken
//		p2.park(c3,1); // spot does not exist
//		p2.park(c2,4); // spot does not exist
//		p2.park(c4,6); 
		
		p1.printInventory();
		p2.printInventory();


	}

}
