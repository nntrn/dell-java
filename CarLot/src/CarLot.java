import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class CarLot {
	
	private String name = "<CarLot.name>";
	private List<Vehicle> lot;
	
	public CarLot() {
		this.lot = new ArrayList<>();
	}
	
	public CarLot(String name) {
		this.name = name;
		this.lot = new ArrayList<>();
	}
	
	public void add(Vehicle addVehicle) {

		lot.add(addVehicle);		
	}
	
	public void list() {
		
	
		int counter = 1;

		System.out.println("CAR LOT: \n" +  this.name);
		printLines("-",50);
		for(Vehicle vehicle:lot) {
			System.out.print(counter++ + " ");
			vehicle.print();
		
		}
		
		printLines("-",50);
		
		System.out.println("number of vehicles: " + lot.size());
		
	}
	
	
	public void printLines(String str, int num) {
		
		String strToPrint = str;
		
		 for(int i=0;i<num;i++){
			 strToPrint+= str;
	        }
		 
		 System.out.println(strToPrint);
		 
	}
	
	
}
