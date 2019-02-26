import java.time.LocalDate;
import java.util.Arrays;


public class ToDoItem {
	
	/* Member variables */
	
	private int id;
	private String item;
	private String status;
	private LocalDate dueDate;
	private static int NEXTID = 1;
	
	/* Constructor */
	
	public ToDoItem(String newItem) {
		this.item = newItem;
		this.add();
	}
	
	public ToDoItem(String newItem, String date) {
		this.item = newItem;
		this.add();
		String arr[] = date.split("/");
		setDueDate(i(arr[2]), i(arr[0]), i(arr[01]));
	}
	
	/* Methods */
	
	private void add() {
		this.id = NEXTID++;
		pendingTask();
		printAddEntry();
	}
	
	public int getId() {
		return this.id;
	}
	
	public String getItem() {
		return this.item;
	}
	
	public String getStatus() {
		return this.status;
	}
	
	public LocalDate getDueDate() {
		return this.dueDate;
	}
	
	public String getDueDateStr() {
		if(this.dueDate==null)
			return "(none)";
		return this.dueDate.toString();
	}
	
	public void setDueDate(int year, int month, int day) {
		try {
			this.dueDate = LocalDate.of(year, month, day);
			checkIfOverdue();
		}
		catch(Exception e) {
			System.out.println("--error setting due date");
		}
	}
	
	public void checkIfOverdue() {
		if(this.dueDate.isBefore(LocalDate.now()))
			if(getStatus().toLowerCase()!="completed")
				overdueTask();	
	}
	
	public void completeTask() {
		this.status = "Completed";
	}
	
	public void overdueTask() {
		this.status = "Overdue";
	}
	
	public void pendingTask() {
		this.status = "Pending";
	}
	
	public void printAddEntry() {
		System.out.print("\t--" + this.item + " has been added");	
	}
	
	public int i(String s) {
		return Integer.parseInt(s);
	}
	
	public String s(int i) {
		return String.valueOf(i);
	}
}
