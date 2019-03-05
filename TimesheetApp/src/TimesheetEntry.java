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
	
	// constructor for FileBackTimesheet
	public TimesheetEntry(String f_id, String f_project, String f_task, String f_startTime, String f_endTime) {
		this.id = Integer.parseInt(f_id);
		this.projectName = f_project;
		this.task = f_task;
		this.startTime = LocalDateTime.parse(f_startTime);
		
		this.endTime = null;
		if(f_endTime.length() > 3)
			this.endTime = LocalDateTime.parse(f_endTime);
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



