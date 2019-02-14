
public class Main {
	
	public static void main(String args[]) {
		
		String[] one = "14,test,02/13/19 21:29, ,".split(",");
		String[] two = "14,test,02/13/19 21:29, ,".split(",");
		
		System.out.println(one.length);
		
		for(String i:one)
			System.out.print(">" +i+"\n");
		
		for(String i:two)
			System.out.print(">" +i+"\n");
		
		//InMemoryTimesheet i = new InMemoryTimesheet();
		
		//FileBackTimesheet timesheet = 
		
		
		
		Controller program = new Controller();
		program.start();

		
	}
	

}
