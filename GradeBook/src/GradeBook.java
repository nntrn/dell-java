import java.util.Scanner;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map; 
import java.util.Set;


public class GradeBook {
	
    public static Map<String, String> gradebook = new HashMap<String, String>();            
    public static Map<String, Double> studentAvgGrade = new HashMap<String, Double>();  
    

    public static Scanner sc = new Scanner(System.in); 
    
    
	public static void main(String[] args) {

		
		System.out.println("how many students?");		
		String numberOfStudents = sc.nextLine();
		
		inputGradebook(Integer.parseInt(numberOfStudents));


	}
	
	public static void inputGradebook(int numOfStudents) {

		int counter = 0;
	
		while(counter < numOfStudents) {
			
			counter++;
			
			System.out.println("input name");
			String studentName = sc.nextLine();
			
			Set<String> keys = gradebook.keySet();
			studentName = renameDuplicateKeys(keys, studentName);
			// System.out.println(studentName);
					
			Double avg = Double.valueOf(0);
			System.out.println("input grades (use comma to separate)");
			String grades = sc.nextLine();
			boolean isGradesValid = false;
			
			while(!isGradesValid) {
				
				try{
					avg = Double.valueOf(calcAverage(grades));
					isGradesValid = true;
				}
				catch (NumberFormatException e) {
					System.out.println("error occured >> re-enter grades for " + studentName);
					grades = sc.nextLine();
				}
				
			}

			System.out.println(avg);
			gradebook.put(studentName, grades);
			studentAvgGrade.put(studentName, avg);
			
		}
		
		System.out.println(gradebook);
		System.out.println(studentAvgGrade);
		
	}
	
	public static String renameDuplicateKeys(Set<String> keys, String name) {
		int counter = 1;
		
		 for (String key:keys) {
			 if(key.contains(name))
				 counter++;			
		 }
		 
		 if (counter > 1)
			 return name + "(" + Integer.toString(counter) + ")";
		
		return name;
		
	}
	
	public static Double calcAverage(String list) {
		
		int[] numbers = Arrays.stream(list.split(",")).mapToInt(Integer::parseInt).toArray();
		Double avg = Arrays.stream(numbers).average().orElse(Double.NaN);
		return avg;
	}
	
	
}

