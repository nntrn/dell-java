import java.io.IOException;
import java.util.List;

public class Controller {

	/* Member variables */
	
    Timesheet timesheet;
    ConsoleUtils consoleUtils;
	FileBackTimesheet fileTimesheet;

    
    /* Constructor */
    
    public Controller(){
        this.timesheet = new Timesheet();
        this.fileTimesheet = new FileBackTimesheet();
        this.consoleUtils = new ConsoleUtils();
    }
    
    /* Methods */

	/*
	 * Runs the program
	 */
    public void start() {

        consoleUtils.printHelp(); // Print the action menu

        // TEST ENTRIES MEANT FOR TESTING PROGRAM ONLY -----------------------//
	        
	        this.timesheet.add("nntrn", "consectetur adipiscing elit");
	        this.timesheet.add("mspagon", "dolor sit amet, consectetur");
	        this.timesheet.add("mspagon", "Lorem ipsum dolor sit amet");
	        this.timesheet.add("nntrn", "consectetur adipiscing elit");
	        this.timesheet.add("mspagon", "dolor sit amet, consectetur");
	        this.timesheet.add("nntrn", "Lorem ipsum dolor sit amet");
	        this.timesheet.add("test", "Lorem ipsum dolor sit amet");
	        
	        String testArr[][] = {
	        		{"list"},
	        		{"list", "-a"},
	        		{"list", "nntrn", "-a"},
	        		{"list", "mspagon", "-a"},
	        		{"list", "mspagon"},
	        		{"stop","1"}, 
	        		{"stop","2"},
	        		{"stop"},
	        		{"stop", "99"}
	        		
	        		};
	        
	        processStopAction(testArr[5]);
	        processStopAction(testArr[5]); // time has already been set
	        processStopAction(testArr[6]);
	        processStopAction(testArr[7]); // need to specify id
	        processStopAction(testArr[8]); // does not exist
	        
	        System.out.println("\n\n\n");
	        
	        processListAction(testArr[0]);
	        processListAction(testArr[1]);
	        processListAction(testArr[2]);
	        processListAction(testArr[3]);
	        processListAction(testArr[4]);

        	
        // -----------------------------------------------------------//
        
        boolean quit = false;
        while(!quit) {

			// Prompt the user for input, collect input, parse into parts
            String input = consoleUtils.promptString("> ");
            String[] actionParts = input.split(" ");
            String action = actionParts[0].trim(); // Primary action

			// Figure out what to do depending on the user's primary action
            if (action.equals("add")) {

                processAddAction();

            } else if (action.equals("delete")) {
            	
            	if(input.matches(".*\\s\\d*"))
            		 processDeleteAction(actionParts);
            	
            	else {
            		System.out.println("invalid delete entry");
            	}

               
            } else if (action.equals("stop")) {

                processStopAction(actionParts);

            } else if (action.equals("list")) {
            	
                processListAction(actionParts);

            } else if (action.equals("quit")) {

              quit = true;
              break;

            } else if (action.equals("help")) {

            	// Your code here

            } else if(action.length() ==0 ){
            
                // do nothing.
                
            } else {
            
                // Your code here
                
            }
        }
        System.out.println("--end");

    }

	/*
	 * The user requested that a given TimesheetEntry be stopped (marked as complete)
	 * This method conveys that request to the Timesheet
	 */
    public void processStopAction(String[] actionParts){

        if(actionParts.length > 2){
            consoleUtils.error("Too many inputs to stop command");
            return;
        }
        
        if(actionParts.length != 2){
            consoleUtils.error("specify id");
            return;
        }

		int id = Integer.parseInt(actionParts[1]);
		timesheet.stop(id);

    }

	/*
	 * The user requested that a given TimesheetEntry be deleted
	 * This method conveys that request to the Timesheet
	 */
    public void processDeleteAction(String[] actionParts){

        if(actionParts.length > 2){
            consoleUtils.error("Too many inputs to delete command");
            return;
        }
        if(actionParts.length != 2){
            consoleUtils.error("specify id");
            return;
        }

        int id = Integer.parseInt(actionParts[1]);
        timesheet.delete(id);	
        
    }

	/*
	 * The user wants to view a list of timesheet entries
	 * This method conveys that request to the Timesheet,
	 * along with any special options (active-only, filter by project name)
	 */
    public void processListAction(String[] actionParts){
    
        if(actionParts.length > 3){
            consoleUtils.error("Too many inputs to list command");
            return;
        }
        
        boolean printActive = false;
        String project = "";
        
        String listString = String.join(" ", actionParts);
        
        if(actionParts.length > 1) {
        	System.out.println(listString);
        	if(listString.contains("-a"))
        		printActive = true;
        	
        	project = actionParts[1];
        }
        
        List<TimesheetEntry> list = timesheet.list(printActive, project);
        consoleUtils.printList(list);	
        List<String> flist = fileTimesheet.list();
       
    }

	/*
	 * The user wants to add a new entry to the Timesheet
	 * This method conveys that request to the Timesheet, along with
	 * the specified project name and task description 
	 */
    public void processAddAction(){
    	// Important note: The project name entered by the user must be one word only
		
        String project = consoleUtils.promptString("Project Name (one word only):");
        String description = consoleUtils.promptString("Task:");

        //timesheet.add(project, description); 		
        fileTimesheet.add(project,description); // TODO: the id is incrementing twice
    }
}