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
		
		this.projectName = myProject;
		this.task = myTask;
		this.startTime = LocalDateTime.now();
		this.id = NEXTID;
		NEXTID++;
		printAddEntry();
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
		
		printAddEntry();
	}
	public void updateEndTime() {
		// TODO THROW EXCEPTION IF END TIME IS ALREADY SET
		
		if(this.endTime == null) {
			this.endTime = LocalDateTime.now();
			System.out.println("--end time updated for entry " + getId());
		}
		else {
			System.out.println("--error: existing end time for entry " + getId());
		}
		
	}
	
	public void printAddEntry() {
		String str = String.join(" ", this.projectName, "has been added", this.startTime.toString());
		System.out.println(id + " " + str);	
	}
}

class Timesheet {
	
	private List<TimesheetEntry> database;
	private List<TimesheetEntry> activeEntries = new ArrayList<>();
	private List<TimesheetEntry> projectEntries = new ArrayList<>();
	

	public Timesheet() {
		this.database = new ArrayList<>();
	}
	
	public void add(String project, String task) {
		
		if(project.indexOf(" ")>-1)
			System.out.println("--note: spaces are not allowed and will be removed");
		
		TimesheetEntry newEntry = new TimesheetEntry(project.replace(" ", ""), task);
		FileBackTimesheet f = new FileBackTimesheet();
		
		database.add(newEntry);
		f.add(project, task);
		
		
	}
	public void delete(int id) {
	
		TimesheetEntry removeThis = findId(id);
		
		if(removeThis != null) {
			database.remove(removeThis);
			System.out.println("--removed entry " + removeThis.getId());
		}
	}
	public void stop(int id) {
		
		TimesheetEntry updateThis = findId(id);

		if(updateThis != null) {
			updateThis.updateEndTime();
			database.set(getIndex(id), updateThis);
		}
	}
	
	
	public List<TimesheetEntry> list(boolean activeOnly, String name) {

		projectEntries = new ArrayList<>();
		
		for(TimesheetEntry entry:database) {
			if(entry.getProjectName().indexOf(name) > -1) {
				projectEntries.add(entry);
			}
		}
		
		if(name.equals("-a") || name.isEmpty())
			projectEntries = database;

		if(activeOnly) {
			
			activeEntries = new ArrayList<>();
		
			for(TimesheetEntry entry:projectEntries) {
				if(entry.getEndTime() == null)
					activeEntries.add(entry);
			}
				
			return this.activeEntries;
		}
		else {
			return this.projectEntries;
		}
	
	}
	
	public TimesheetEntry findId(int id) {
		
		for(TimesheetEntry entry:database) {
			if(entry.getId()==id) {
				return entry;
			}
		}
		System.out.println("--error: no entry with id "+ id);
		return null;
	}

	public int getIndex(int id) {
		int counter = 0;
		for(TimesheetEntry entry:database) {
			
			if(entry.getId()==id) {
				return counter;
			}
			counter++;
		}
		
		return -1;
	}
	

}

