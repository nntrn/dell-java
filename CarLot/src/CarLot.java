import java.util.List;
import java.util.ArrayList;

public class CarLot {
	
	private String name = "<CarLot.name>";
	private List<Vehicle> lot;
	private Vehicle addRandomVehicle;
	
	public CarLot() {
		this.lot = new ArrayList<Vehicle>();
	}
	
	public CarLot(String name) {
		this.name = name;
		this.lot = new ArrayList<>();
	}
	
	public void add(Vehicle addVehicle) {
		lot.add(addVehicle);	
	}
	
	public void addRandom() {

		int random = (int)(Math.random() * 200 + 1);		
		addRandomVehicle = (random%2 == 0) ? new Car() : new Truck();
	
		if(addRandomVehicle.licenseNumber.indexOf("<")> -1)
			addRandomVehicle.setLicense(randomLicense());
		
		if(addRandomVehicle.model.indexOf("<")> -1)
			randomMakeModel(addRandomVehicle);
		
		if(addRandomVehicle.price == 0)
			addRandomVehicle.setPrice((int)((double)(Math.random() * 1 + .75)*1e4));

		if(addRandomVehicle.model.indexOf("<")> -1)
			addRandomVehicle.setRandomType();
		//TO DO SET RANDOM TYPE
		
		add(addRandomVehicle);
		
	}
	
	public void list() {
	
		int counter = 1;

		System.out.println("\nCAR LOT: \n" +  this.name);
		printLines("-",50);
		
		for(Vehicle vehicle:lot) {
			System.out.print(counter++ + " ");
			vehicle.print();
			System.out.print( "\n");
		}
		
		printLines("-",50);
		System.out.println("number of vehicles: " + lot.size());
		
	}
	
	public void printLines(String str, int num) {
		
		String strToPrint = str;
		
		 for(int i=0;i<num;i++)
			 strToPrint+= str;
		 
		 System.out.println(strToPrint);
		 
	}
	
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
		
		String[][] car = new String [][] { 
			{ "NISSAN", "ALTIMA", "MAXIMA", "FRONTIER", "TITAN"},
            { "TOYOTA", "COROLLA","CAMRY", "TUNDRA","TACOMA"},
            { "FORD", "MUSTANG","FOCUS", "F150 LARIAT","F150 XLT"}};
          
        int rModel = (int)(Math.random() * 3 + 0);
        int random = (int)(Math.random() * 2 + 1);

		if(this.getClass().getName().toUpperCase().indexOf("CAR")>-1){
			veh.setMake(car[rModel][0]);
			veh.setModel(car[rModel][random]);
		}
		if(this.getClass().getName().toUpperCase().indexOf("TRUCK")>-1){
			veh.setMake(car[rModel][0]);
			veh.setModel(car[rModel][random+2]);
			
		}
	}
	
}
