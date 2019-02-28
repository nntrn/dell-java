import java.util.Scanner;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Controller {

	Scanner sc;
	private List<ToDoItem> database;
	DAO database2;

	public Controller() {
		sc = new Scanner(System.in);
		this.database = new ArrayList<>();
		this.database2 = new DAO();
	}

	public void connect() throws SQLException {

		printHelp();
		boolean quit = false;
		while (!quit) {

			String input = promptString("command:").toLowerCase();

			String[] actionParts = input.split(" ");
			String action = actionParts[0].trim();

			if (action.equals("add")) {
				String desc = promptString("todo item desc:");
				LocalDate date = (actionParts.length == 1) ? null : convertToDate(actionParts[1]);
				database2.add(desc, date);
			}

			else if (action.equals("delete"))
				database2.delete(i(actionParts[1]));

			else if (action.equals("done"))
				database2.update(i(actionParts[1]));

			else if (action.equals("list")) {
				String listStatus = (actionParts.length == 1) ? "all" : actionParts[1];
				list(listStatus);
			} else if (action.equals("quit"))
				quit = true;

			else if (action.equals("help"))
				printHelp();
		}
	}

	protected void printHelp() {
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
	 * prompts the user to enter input returns the text entered by the user
	 */
	String promptString(String label) {
		System.out.print(label + "\n> ");
		return sc.nextLine();
	}

	LocalDate convertToDate(String dateStr) {
		int[] dateArr = Arrays.stream(dateStr.split("/")).mapToInt(Integer::parseInt).toArray();
		try {
			return LocalDate.of(dateArr[2], dateArr[0], dateArr[1]);
		} catch (Exception e) {
			System.out.println("--error occured setting due date ");
			return null;
		}
	}

	/*
	 * add a new ToDoItem object optional due date can be added following the format
	 * MM/DD/YYYY
	 */
	void add(String[] actionParts) {
		String description = promptString("Description");
		ToDoItem addItem = (actionParts.length == 1) ? new ToDoItem(description)
				: new ToDoItem(description, actionParts[1]);
		database.add(addItem);
	}

	void add() {
		String description = promptString("Description");
		ToDoItem addItem = new ToDoItem(description);
		database.add(addItem);
	}

	void add(String desc) {
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

	void update(String id) {
		getToDo(i(id)).setCompleteTask();
	}

	void delete(String id) {
		database.remove(getToDo(i(id)));
	}

	private static String dashes(int length) {
		return String.format("%" + length + "c", ' ').replace(' ', '-');
	}

	private int i(String s) {
		return Integer.parseInt(s);
	}

}
