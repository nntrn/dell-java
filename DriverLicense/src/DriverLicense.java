import java.util.Arrays;
import java.time.*;

public class DriverLicense {

	private String _firstName;
	private String _lastName;
	private String _dob; // make user follow format MM/DD/YYYY
	private int _height; // make user use inches
	private char _gender;
	
	
	public String getFullName(String fname, String lname) {
		return fname + " " + lname;
	}
	
	
	public int getAge(String date) {
		// TODO add error handling
		LocalDate today = LocalDate.now(); 
		
		int[] dob = Arrays.stream(date.split("/")).mapToInt(Integer::parseInt).toArray();
		
		LocalDate birthday = LocalDate.of(dob[2], dob[0], dob[1]); 
		
		Period period = Period.between(birthday, today);
		int age = period.getYears();
		
		return age;
	}
	
	
}
