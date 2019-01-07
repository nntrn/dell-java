import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		double num1 = getNumberInputs();
		double num2 = getNumberInputs();

		calcSum(num1, num2);
		calcDifference(num1, num2);
		calcProduct(num1, num2);
		calcQuotient(num1, num2);

	}

	public static double getNumberInputs() {
		Scanner sc = new Scanner(System.in);
		System.out.println("enter value:");
		
		// advance the Scanner until it hasNextDouble()
		// removing sc.next() would cause an infinite loop
		while (!sc.hasNextDouble()) {
			System.out.println("only double data types allowed");
			sc.next();
		}
		return sc.nextDouble();

	}

	public static double calcSum(double num1, double num2) {
		System.out.println("addition: " + (num1 + num2));
		return num1 + num2;
	}

	public static double calcDifference(double num1, double num2) {
		System.out.println("subtraction: " + (num1 - num2));
		return num1 - num2;
	}

	public static double calcProduct(double num1, double num2) {
		System.out.println("multiplication " + (num1 * num2));
		return num1 * num2;
	}

	public static double calcQuotient(double num1, double num2) {
		System.out.println("division: " + (num1 / num2));
		return num1 / num2;
	}

}
