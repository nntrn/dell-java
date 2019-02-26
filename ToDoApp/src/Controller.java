import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Controller {

	Scanner sc;
	private List<ToDoItem> database;
	
	public Controller() {
		sc = new Scanner(System.in);
		this.database = new ArrayList<>();
	}
	
	/*
	 * runs the program
	 */
	public void start() {
		printHelp();
		System.out.print("\ninput command: ");
		
		boolean quit = false;
		while (!quit) {
			String input = promptString("").toLowerCase();
			String[] actionParts = input.split(" ");
			String action = actionParts[0].trim();
			
			if (action.equals("add"))
				processAddAction(actionParts);
			else if (action.equals("delete"))
				processDeleteAction(actionParts[1]);
			else if (action.equals("done"))
				processStopAction(actionParts[1]);
			else if (action.equals("list"))
				processListAction(actionParts);
			else if (action.equals("quit"))
				quit = true;
			else if (action.equals("help"))
				printHelp();
		}
	}
	
    private void printHelp(){
        System.out.println("Valid commands: ");
        System.out.println("  list [STATUS]   optional status filter (Pending, Completed, Overdue)");
        System.out.println("  add [DUE-DATE]  optional due date (MM/DD/YYYY)");
        System.out.println("  done ID");
        System.out.println("  delete ID");
        System.out.println("  help");
        System.out.println("  quit");
        System.out.println();
    }
    
	/*
	 * prompts the user to enter input
	 * returns the text entered by the user
	 */
    private String promptString(String label){
    	System.out.print(label + "\n> ");
        return sc.nextLine();
    }
    
	/*
	 * find and return ToDoItem object using id
	 */
    private ToDoItem getToDo(int id) {
    	
		for(ToDoItem entry:database) {
			if(entry.getId() == id)
				return entry;
		}
		System.out.println("--error: no entry with id "+ id);
		return null;
	}
    
	/*
	 * add a new ToDoItem object
	 * optional due date can be added following the format MM/DD/YYYY
	 */
    private void processAddAction(String[] actionParts){
        String description = promptString("Description");
        ToDoItem addItem = (actionParts.length == 1) ? 
        		new ToDoItem(description) : 
        			new ToDoItem(description, actionParts[1]);
        database.add(addItem);
    }
    
	/*
	 * list all ToDoItem objects
	 * optional viewing option for filtering status: Pending, Completing, Overdue
	 */
    private void processListAction(String[] actionParts){
    	
    	String formatHeader = "\n%4S %-9S %-12S %-15S";
    	System.out.format(formatHeader, "ID", "STATUS", "DUE DATE", "DESCRIPTION");
    	System.out.format(formatHeader, dashes(2), dashes(8), dashes(10), dashes(15));
    	
		for(ToDoItem entry:database)
			System.out.format(formatHeader, entry.getId(), entry.getStatus(), entry.getDueDateStr(), entry.getItem());

		System.out.println("\n  "+dashes(40)+"\n  total: " + database.size());
    }
    
    private void processStopAction(String id){
    	getToDo(i(id)).completeTask();
    }
    
    private void processDeleteAction(String id){
    	database.remove(getToDo(i(id)));
    }
    
	private static String dashes(int length) {
		return String.format("%" + length + "c", ' ').replace(' ', '-');
	}
	
	private int i(String s) {
		return Integer.parseInt(s);
	}
}
