import java.time.LocalDate;

public class ToDoItem {

	/* Member variables */

	private int id;
	private String description;
	private String status;
	private LocalDate dueDate;
	private static int NEXTID = 1;

	/* Constructor */

	public ToDoItem(String newToDo) {
		this.description = newToDo;
		this.add();
	}
	
	public ToDoItem(String newToDo, LocalDate date) {
		this.description = newToDo;
		this.dueDate = date;
		this.add();
	}

	public ToDoItem(String newToDo, String date) {
		this.description = newToDo;
		this.add();
		String arr[] = date.split("/");
		setDueDate(i(arr[2]), i(arr[0]), i(arr[01]));
	}

	/* Methods */

	private void add() {
		this.id = NEXTID++;
		setPendingTask();
	}

	public int getId() {
		return this.id;
	}

	public String getDesc() {
		return this.description;
	}

	public String getStatus() {
		return this.status;
	}

	public LocalDate getDueDate() {
		return this.dueDate;
	}

	public String getDueDateStr() {
		if (getDueDate() == null)
			return "(none)";
		return getDueDate().toString();
	}

	public void setDueDate(int year, int month, int day) {
		try {
			this.dueDate = LocalDate.of(year, month, day);
			checkIfOverdue();
		} catch (Exception e) {
			System.out.println("--error setting due date");
		}
	}

	public void checkIfOverdue() {
		if (getDueDate().isBefore(LocalDate.now()))
			if (getStatus().toLowerCase() != "completed")
				setOverdueTask();
	}

	public void setCompleteTask() {
		this.status = "Completed";
	}

	public void setOverdueTask() {
		this.status = "Overdue";
	}

	public void setPendingTask() {
		this.status = "Pending";
	}

	public int i(String s) {
		return Integer.parseInt(s);
	}

}


