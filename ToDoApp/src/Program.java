
public class Program {

	public static void main(String args[]) {

		// Controller program = new Controller();
		DAO program = new DAO();

		System.out.print("\ninput command: ");

		program.connect();

		System.out.print("\ninput command: ");

		boolean quit = false;
		while (!quit) {
			String input = program.promptString("command").toLowerCase();
			String[] actionParts = input.split(" ");
			String action = actionParts[0].trim();

			if (action.equals("add"))
				program.add(actionParts);

			else if (action.equals("delete"))
				program.delete(actionParts[1]);

			else if (action.equals("done"))
				program.update(actionParts[1]);

			else if (action.equals("list")) {
				String listStatus = (actionParts.length == 1) ? "all" : actionParts[1];
				program.list(listStatus);
			}

			else if (action.equals("quit"))
				quit = true;

			else if (action.equals("help"))
				program.printHelp();
		}

	}

}
