import java.util.Scanner;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * The GradeBook class implements an application that stores, calculates, and
 * iterates grades for students
 */
public class GradeBook {

	public static Map<String, String> gradebook = new HashMap<String, String>();
	public static Map<String, Double> studentAvgGrade = new HashMap<String, Double>();

	public static Scanner sc = new Scanner(System.in);

	/**
	 * Main method to define number of students
	 */
	public static void main(String[] args) {

		System.out.println("how many students?");
		String numberOfStudents = sc.nextLine();

		inputGradebook(Integer.parseInt(numberOfStudents));

		System.out.println("\ngrade averages:\n");

		// iterate over the HashMap's entrySet
		studentAvgGrade.entrySet().forEach(student -> {
			System.out.println(student.getKey() + " => " + String.format("%.2f", student.getValue()));
		});

	}

	/**
	 * inserts names and grades into grade book and calculate average
	 * 
	 * @param numOfStudents initialized in main method
	 */
	public static void inputGradebook(int numOfStudents) {

		int counter = 0;

		while (counter < numOfStudents) {

			counter++;

			System.out.println("\n" + counter + ". input name:");
			String studentName = sc.nextLine();

			Set<String> keys = gradebook.keySet();
			studentName = renameDuplicateKeys(keys, studentName);

			Double avg = Double.valueOf(0);
			System.out.println("input grades (use comma to separate)");
			String grades = sc.nextLine();

			boolean isGradesValid = false;

			while (!isGradesValid) {
				try {
					avg = Double.valueOf(calcAverage(grades));
					isGradesValid = true;
				} catch (NumberFormatException e) {
					System.out.println(">> error occured\n>> re-enter grades for " + studentName);
					grades = sc.nextLine();
				}
			}

			gradebook.put(studentName, grades);
			studentAvgGrade.put(studentName, avg);

		}

	}

	/**
	 * returns name with id for duplicated key values
	 * 
	 * @param keys set of all the keys in the map (.keySet())
	 * @param name user input for key
	 * 
	 * @return name
	 */
	public static String renameDuplicateKeys(Set<String> keys, String name) {
		int counter = 1;
		
		for (String key : keys) {
			if (key.contains(name))
				counter++;
		}

		if (counter > 1)
			return name + "(" + Integer.toString(counter) + ")";

		return name;

	}

	/**
	 * attempts to return average for a comma separated value list (use exception
	 * handling when calling)
	 * 
	 * @param list should be a comma separated value list
	 * 
	 * @return average
	 */
	public static Double calcAverage(String list) {

		int[] numbers = Arrays.stream(list.split(",")).mapToInt(Integer::parseInt).toArray();
		Double avg = Arrays.stream(numbers).average().orElse(Double.NaN);
		return avg;
	}

}
