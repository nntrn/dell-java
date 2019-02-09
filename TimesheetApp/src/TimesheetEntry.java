import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class TimesheetEntry {

	private String projectName;
	private String task;
	private int id;
	private LocalDateTime startTime;
	private LocalDateTime endTime;
	
	private static int NEXTID = 1;
	
	public TimesheetEntry(String myProject, String myTask) {
		// TODO: FIGURE OUT WHAT myTASK IS FOR
		
		this.projectName = myProject;
		this.task = myTask;
		this.startTime = LocalDateTime.now();
		this.id = NEXTID;
		NEXTID++;
		printEntry();
	}
	
	public String getProjectName() {
		return this.projectName;
	}
	public String getTask() {
		return this.task;
	}
	public int getId() {
		return this.id;
	}
	public LocalDateTime getStartTime() {
		return this.startTime;
	}
	public LocalDateTime getEndTime() {
		return this.endTime;
	}
	
	/**
	 * sets the end time (given the time was correctly entered)
	 * 
	 * @param time needs to following the following format:
	 * "year, month, date, hour, minutes" - example for returning 2019-02-08T02:30
	 * would be "2019, 2, 8, 2, 30"
	 */
	public void setEndTime(String time) {
		try {
			int[] arr = Arrays.stream(time.replace(" ", "").split(",")).mapToInt(Integer::parseInt).toArray();
			this.endTime = LocalDateTime.of(arr[0], arr[1], arr[2], arr[3], arr[4]);
		}
		catch(Exception e) {
			System.out.println("--error setting end time for " + this.projectName);
		}
		
		printEntry();
	}
	public void updateEndTime() {
		
		if(this.endTime == null) {
			this.endTime = LocalDateTime.now();
		}
		printEntry();
	}
	
	public void printEntry() {
		// TODO remember to remove this later ????
		System.out.println(
				"#" + this.id + " " +
				this.projectName + " " + 
				this.task + " \nstart:" + 
				this.startTime + " \nend:" + 
				this.endTime + "\n");	
	}
}

class Timesheet {
	
	private List<TimesheetEntry> database;
	private List<TimesheetEntry> entries = new ArrayList<>(); // TODO DELETE THIS LATER
	
	private List<TimesheetEntry> testDatabaseEntries = new ArrayList<>(entries); // TODO DELETE THIS LATER
	
	public Timesheet() {
		this.database = new ArrayList<>();
	}
	
	public void add(String project, String task) {
		
		if(project.indexOf(" ")>-1)
			System.out.println("--note: spaces are not allowed and will be removed");
		
		TimesheetEntry newEntry = new TimesheetEntry(project.replace(" ", ""), task);
		database.add(newEntry);
		entries.add(newEntry); // TODO DELETE LATER
		
	}
	public void remove(int id) {
		// TODO: FIGURE OUT WHY THIS DOESNT REMOVE ANYTHING
		TimesheetEntry removeThis =findId(id);
		database.remove(removeThis);
		entries.remove(removeThis);// TODO DELETE LATER
		
	}
	public List<TimesheetEntry> list() {

		//System.out.println(this.database);
		return this.database;		

	}
	
	public TimesheetEntry findId(int id) {
		
		for(TimesheetEntry entry:database) {
			if(entry.getId()==id) {
				return entry;
			}
		}
		
		return null;
		
	}
	

}

