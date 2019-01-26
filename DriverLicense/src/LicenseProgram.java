

/**
 * the LicenseProgram class runs and creates DriversLicense instances.
 * The LicenseProgram class will contain one main method (and nothing else).
 * When run, LicenseProgram should create three different instances of a DriversLicense 
 * and print out the full name and age on each license. 
 * 
 * */
public class LicenseProgram {
	public static void main(String[] args) {
			
		DriverLicense DL1 = new DriverLicense.Builder()
				.setFirstName("annie")
				.setLastName("tran")
				.setDOB("02/08/1994")
				.setHeight("5'4")
				.setGender("F")
				.build();
		
		// object to demonstrate missing last name
		DriverLicense DL2 = new DriverLicense.Builder()
				.setFirstName("annie tran")
				.setDOB("02/08/1994")
				.build();
		
		// object to demonstrate incorrect string format for DOB
		DriverLicense DL3 = new DriverLicense.Builder()
				.setFirstName("annie")
				.setDOB("tran")
				.build();
		
		System.out.println(DL1.getFullName() +": " + DL1.getAge());
		System.out.println(DL2.getFullName() +": " + DL2.getAge());
		System.out.println(DL3.getFullName() +": " + DL3.getAge());
		
	}
}
