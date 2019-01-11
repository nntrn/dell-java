
import java.util.Scanner;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("input numbers separated by commas");

		String input = sc.nextLine();
		sc.close();

		int[] numbers = Arrays.stream(input.split(",")).mapToInt(Integer::parseInt).toArray();

		for (int i = 0; i < numbers.length; i++)
			System.out.println(numbers[i]);

		int min = Arrays.stream(numbers).min().getAsInt();
		int max = Arrays.stream(numbers).max().getAsInt();
		int sum = 0;
		for (int i = 0; i < numbers.length; i++)
			sum += numbers[i];
		
		Double avg = Double.valueOf(sum)/Double.valueOf(numbers.length);

		System.out.println("the min is: " + min);
		System.out.println("the max is: " + max);
		System.out.println("number of elements: " + numbers.length);
		System.out.println("the average is: " + avg);
		System.out.println("the sum is: " + sum);

	}

}
