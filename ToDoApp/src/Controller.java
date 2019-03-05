import java.util.Scanner;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Arrays;

/*
 * easily switch between local array and database files by commenting either
 * note: need to comment out unused database object (InMemory or DAO)
 */
public class Controller {

	Scanner sc;
	//InMemory database;
	DAO database;

	public Controller() {
		sc = new Scanner(System.in);
		//this.database = new InMemory();
		this.database = new DAO();
	}

	public void connect() throws SQLException {
		printHelp();
		boolean quit = false;

		while (!quit) {
			String input = promptString("\n$command:").toLowerCase();
			String[] actionParts = input.split(" ");
			String action = actionParts[0].trim();

			if (action.equals("add")) {
				String desc = promptString("todo item desc:");
				LocalDate date = (actionParts.length == 1) ? 
						null : convertToDate(actionParts[1]);
				database.add(desc, date);
			}

			else if (action.equals("delete"))
				database.delete(i(actionParts[1]));

			else if (action.equals("done"))
				database.update(i(actionParts[1]));

			else if (action.equals("list")) {
				String listStatus = (actionParts.length == 1) ? 
						"all" : actionParts[1];
				database.list(listStatus);
			}

			else if (action.equals("drop"))
				database.drop();

			else if (action.equals("quit"))
				quit = true;

			else if (action.equals("help"))
				printHelp();
		}
	}

	protected void printHelp() {
		System.out.println(dashes(50));
		System.out.println("Valid commands: ");
		System.out.println("  list [STATUS(<blank>|Pending|Completed|Overdue)]");
		System.out.println("  add [DUE-DATE(MM/DD/YYYY)]");
		System.out.println("  done [ID]");
		System.out.println("  delete [ID]");
		System.out.println("  drop table");
		System.out.println("  help");
		System.out.println("  quit");
		System.out.println(dashes(50));
		System.out.println();
	}

	/*
	 * prompts the user to enter input returns the text entered by the user
	 */
	String promptString(String label) {
		System.out.print(label + "\n > ");
		return sc.nextLine();
	}
	
	/*
	 * convert date string to LocalDate
	 * string format: M/D/YYYY
	 */
	LocalDate convertToDate(String dateStr) {
		int[] dateArr = Arrays.stream(dateStr.split("/")).mapToInt(Integer::parseInt).toArray();
		try {
			return LocalDate.of(dateArr[2], dateArr[0], dateArr[1]);
		} catch (Exception e) {
			System.out.println("--error occured setting due date ");
			return null;
		}
	}

	/* misc methods */
	
	private static String dashes(int length) {
		return String.format("%" + length + "c", ' ').replace(' ', '-');
	}
	private int i(String s) {
		return Integer.parseInt(s);
	}
}
