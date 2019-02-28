import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class InMemory {
	private List<ToDoItem> database;
	
	public InMemory() {
		this.database = new ArrayList<>();
	}

	public void add(String[] actionParts) {
		String description = actionParts[0];
		ToDoItem addItem = (actionParts.length == 1) ? new ToDoItem(description)
				: new ToDoItem(description, actionParts[1]);
		database.add(addItem);
	}
	
	public void add(String desc, LocalDate date) {
		ToDoItem addItem = new ToDoItem(desc, date);
		database.add(addItem);
	}

	public void add(String desc) {
		ToDoItem addItem = new ToDoItem(desc);
		database.add(addItem);
	}

	/*
	 * list all ToDoItem objects optional viewing option for filtering status:
	 * Pending, Completing, Overdue
	 */
	public void list(String actionParts) {

		String formatHeader = "\n%4S %-9S %-12S %-15S";
		System.out.format(formatHeader, "ID", "STATUS", "DUE DATE", "DESCRIPTION");
		System.out.format(formatHeader, dashes(2), dashes(8), dashes(10), dashes(15));

		for (ToDoItem el : database)
			System.out.format(formatHeader, el.getId(), el.getStatus(), el.getDueDateStr(), el.getDesc());

		System.out.println("\n  " + dashes(40) + "\n  total: " + database.size());
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

	void update(int id) {
		getToDo(id).setCompleteTask();
	}

	void delete(int id) {
		database.remove(getToDo(id));
	}

	private static String dashes(int length) {
		return String.format("%" + length + "c", ' ').replace(' ', '-');
	}

	private int i(String s) {
		return Integer.parseInt(s);
	}

}
