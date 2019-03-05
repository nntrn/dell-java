import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class InMemory {
	private List<ToDoItem> database;
	private String formatHeader = "\n%3S %-9S %-12S %-25S";
	
	public InMemory() {
		this.database = new ArrayList<>();
	}

	public void add(String desc, LocalDate date) {
		ToDoItem addItem = new ToDoItem(desc, date);
		if(date!= null)
			addItem.checkIfOverdue();
		database.add(addItem);
	}

	/*
	 * list all ToDoItem objects optional viewing option for filtering status:
	 * Pending, Completing, Overdue
	 */
	public void list(String actionParts) {
		printTableHeader();
		for (ToDoItem el : database) {
			if( el.getStatus().toLowerCase().equals(actionParts) | actionParts == "all")
				System.out.format(formatHeader, el.getId(), el.getStatus(), el.getDueDateStr(), el.getDesc());
		}
		System.out.format("\n " + dashes(51)+ "\n%51s", database.size() +" row(s)");
	}
	
	public void printTableHeader() {
		System.out.format(formatHeader, "ID", "STATUS", "DUE DATE", "DESCRIPTION");
		System.out.format(formatHeader, dashes(2), dashes(8), dashes(10), dashes(25));
	}

	void update(int id) {
		getToDo(id).setCompleteTask();
	}

	void delete(int id) {
		database.remove(getToDo(id));
	}
	
	void drop() {
		this.database = new ArrayList<>();
	}
	
	/*
	 * find and return ToDoItem object using id
	 */
	private ToDoItem getToDo(int id) {
		for (ToDoItem entry : database) {
			if (entry.getId() == id)
				return entry;
		}
		System.out.println("--error: no entry with id " + id);
		return null;
	}
	
	private static String dashes(int length) {
		return String.format("%" + length + "c", ' ').replace(' ', '-');
	}
}
