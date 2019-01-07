//Ask the user for 2 numbers.
//Print out the sum of the 2 numbers.
//Print out the difference of the 2 numbers.
//Print out the product of the 2 numbers.
//Print out the quotient of the 2 number.

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

        Scanner sc = new Scanner(System.in); 
        
        double sum = 0;
        double difference = 0;
        double product = 0;
        double quotient = 0;
        
  
        System.out.println("provide calculator w/ two numbers, separate using a space ('exit' to close)");
        while (!sc.hasNext("exit")) {
            Scanner lineSc = new Scanner(sc.nextLine());
            double num1 = 0;
            double num2 = 0;
 
            while (lineSc.hasNextDouble()) {
                num1 += lineSc.nextDouble();
                num2 += lineSc.nextDouble();
            }
            
            sum = num1 + num2; 
            difference = num1 - num2; 
            product = num1 * num2;
            quotient = num1 / num2;
            
            System.out.println("sum is " + sum);
            System.out.println("difference is " + difference);
            System.out.println("product is " + product);
            System.out.println("quotient is " + quotient);
            lineSc.close();
            
        }
        
		sc.close();
	}

}
