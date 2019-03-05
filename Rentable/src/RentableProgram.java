import java.util.Scanner;

public class RentableProgram {

	static String formatHeader = "%-6S %-8S %-8S %-7S %-10S \n";
	static String formatData = "%-6s $%-7.1f $%-7.1f $%-6.2f $%9.2f \n";

	static int lengthOfStayDays = 1;
	static int lengthOfStayHours = 24; // TODO: maybe do something with this later

	public static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		// create random listing data
		Rentable[] listing = new Rentable[(int) (Math.random() * 100 + 20)];

		for (int i = 0; i < listing.length; i++) {
			double val = Math.random() * 300 + 70;
			listing[i] = (i % 2 == 0) ? new Condo(val) : (i % 5 == 0) ? new Tool(val) : new Room(val);
		}

		userInput();
		buildTable(arraySort(listing));
	}

	public static void userInput() {

		System.out.print("input number of days for calculating total price\n> ");
		int days = sc.nextInt();
		lengthOfStayDays = days;

	}

	// a bubble sort for sorting listing items by daily rate
	public static Rentable[] arraySort(Rentable[] arr) {
		Rentable temp;

		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = 0; j < arr.length - 1; j++) {
				double thisListing = arr[j].getDailyRate();
				double nextListing = arr[j + 1].getDailyRate();

				if (thisListing > nextListing) {
					temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
		}
		return arr;
	}

	public static void header() {

		System.out.println("\nRENTABLE LISTINGS:\nshow prices for " + lengthOfStayDays + " day(s)");
		System.out.println(dash(44));
		System.out.format(formatHeader, "type", "day", "week", "hr", "price");
		System.out.format(formatHeader, dash(6), dash(8), dash(8), dash(7), dash(10));
	}

	public static void buildTable(Rentable[] list) {
		header();

		for (Rentable el : list) {
			double arr[] = el.getDescription();
			System.out.format(formatData, el.getClass().getName(), arr[0], arr[1], arr[2], arr[0] * lengthOfStayDays);
		}
		System.out.println(dash(44) + "\ncount: " + list.length);
	}

	static String dash(int length) {
		return String.format("%" + length + "c", ' ').replace(' ', '-');
	}

}
