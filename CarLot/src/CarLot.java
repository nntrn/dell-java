import java.util.List;
import java.util.ArrayList;

public class CarLot {
	
	String name = "<CarLot.name>";
	List<Vehicle> lot;
	Vehicle addRandomVehicle;
	
	String[] header = {
			" id"+spaces(4,"id"), "type"+spaces(8,"type"), 
			"plate"+spaces(8,"plate"), "make"+spaces(10,"make"), 
			"model"+spaces(10,"model"), "price"+spaces(10,"price"), "bed"+spaces(6,"bed"),
			"door/type"};
	
	public CarLot() {
		this.lot = new ArrayList<>();
	}
	
	public CarLot(String name) {
		this.name = name;
		this.lot = new ArrayList<>();
	}
	
	/* adding vehicles ***************************************/
	
	public void add(Vehicle addVehicle) {
		lot.add(addVehicle);	
	}
	
	public void addRandom() {

		int random = (int)(Math.random() * 200 + 1);		
		addRandomVehicle = (random%2 == 0) ? new Car() : new Truck();
	
		addRandomVehicle.setLicense(randomLicense());
		randomMakeModel(addRandomVehicle);
		addRandomVehicle.setPrice((int)((double)(Math.random() * 1 + .75)*1e4));
		
		add(addRandomVehicle);
				
	}
	
	/* print table ***************************************/
	public void list() {
	
		int counter = 1;
		System.out.println("\nCAR LOT: \n" +  this.name);
		System.out.println(dashes(80));

		for (String a : header) { System.out.print(a); }
		
		System.out.print("\n"+dashes(80)+"\n");

		for(Vehicle vehicle:lot) {
			System.out.print(spaces(3, String.valueOf(counter)) + counter++ + spaces(2,""));
			vehicle.print();
			System.out.print( "\n");
		}
		
		System.out.println(dashes(80) + "\nnumber of vehicles: " + lot.size());
		
	}
	
	/* formatting  ***************************************/
	
	public String dashes(int num) {
		String dash = "";
		for (int i = 0; i < num; i++) { dash += "-";
		}
		return dash;
	}
	
	public String spaces(int num, String str) {

		String sp = "";
		int spaces = num;

		if (str != "") { spaces = num - str.length(); }
		for (int i = 0; i < spaces; i++) { sp += " "; }

		return sp;
	}
	
	/* random data  ***************************************/
	
	public String randomLicense() {

		String abc = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
		StringBuilder str = new StringBuilder();
		int count = 6;
		while (count-- != 0) {
			int character = (int) (Math.random() * abc.length());
			str.append(abc.charAt(character));
		}
		return str.toString();
	}
	
	public void randomMakeModel(Vehicle veh) {
		
		// format:
		// [CAR MAKE] [CAR MODEL] [CAR MODEL] [TRUCK MODEL][TRUCK MODEL]
		
		String[][] car = new String[][] { 
			{ "NISSAN", "ALTIMA", "MAXIMA", "FRONTIER", "TITAN"},
            { "TOYOTA", "COROLLA","CAMRY", "TUNDRA","TACOMA"},
            { "FORD", "MUSTANG","FOCUS", "F150 LARIAT","F150 XLT"}};
          
        int rModel = (int)(Math.random() * 3 + 0);
        int random = (int)(Math.random() * 2 + 1);

		if(this.getClass().getName().toUpperCase().indexOf("CAR")>-1){
			veh.setMake(car[rModel][0]);
			veh.setModel(car[rModel][random]);
		}
		// +2 bc last two elements in arr are trucks
		if(this.getClass().getName().toUpperCase().indexOf("TRUCK")>-1){
			veh.setMake(car[rModel][0]);
			veh.setModel(car[rModel][random+2]); 
		}
	}
}



