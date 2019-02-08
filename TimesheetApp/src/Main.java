
public class Main {
	
	public static void main(String args[]) {
		
		// TESTING TIMESHEETENTRY **********************/
		TimesheetEntry testEntry = new TimesheetEntry("test1", "task1");
		TimesheetEntry testEntry2 = new TimesheetEntry("test2", "task2");
		TimesheetEntry testEntry3 = new TimesheetEntry("test3", "task3");
		
		testEntry2.setEndTime("2019, 2, 8, 2, 30");
		testEntry3.setEndTime("2019, 2, 8, 30");
		testEntry3.updateEndTime();
		
		
		// TESTING TIMESHEET **********************/
		printLines();
		
		
		Timesheet timesheet = new Timesheet();
		
		timesheet.add("monkey", "beans");
		timesheet.add("lava beans", "juju");
		
		timesheet.list();
		
		// TESTING CONTROLLER **********************/
		printLines();
		
		
		Controller program = new Controller();
		program.start();

		
	}
	
	
	public static void printLines() {
		//TODO: DELETE THIS LATER
		
		System.out.println();
		System.out.println();
		System.out.println();
		
	}
	
}
