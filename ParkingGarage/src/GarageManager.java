
public class GarageManager {
	
	public static void main(String args[]) {
	      /* Create two objects using constructor */
	      Car c1 = new Car("3jsofs");
	      Car c2 = new Car("ajskaji");

	      // Invoking methods for each object created
	      c1.color("black");
	      c1.model("civic");
	      c1.make("honda");
	      
	      c1.printCar();
	      
	      ParkingGarage p = new ParkingGarage();
	   }

}
