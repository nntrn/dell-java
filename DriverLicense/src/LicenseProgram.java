/**
 * the LicenseProgram class runs and creates DriversLicense instances. The
 * LicenseProgram class will contain one main method (and nothing else). When
 * run, LicenseProgram should create three different instances of a
 * DriversLicense and print out the full name and age on each license.
 * 
 */
public class LicenseProgram {
	public static void main(String[] args) {

		DriverLicense DL1 = new DriverLicense.Builder()
				.setFirstName("annie")
				.setLastName("tran")
				.setDOB("02/08/1994")
				.setHeight("5'3")
				.setGender("F")
				.build();

		DriverLicense DL2 = new DriverLicense.Builder()
				.setFirstName("michael")
				.setLastName("spagon")
				.setDOB("02/04/1989")
				.setHeight("5'10")
				.setGender("M")
				.build();

		DriverLicense DL3 = new DriverLicense.Builder()
				.setFirstName("charlie")
				.setLastName("tran")
				.setDOB("03/25/2007")
				.setGender("M")
				.build();

		DL1.print();
		DL2.print();
		DL3.print();

		
		
		// below are demonstrations of shotty data entries
		// TODO: create J Unit test
		
		DriverLicense testDLNoLastName = new DriverLicense.Builder().setFirstName("annie").setDOB("02/08/94").build();
		DriverLicense testDLIncorrectDOB = new DriverLicense.Builder().setFirstName("annie").setLastName("tran").setDOB("").build();

		System.out.print("\n\n\f## ");
		System.out.print("below are demonstrations of shotty data entries");
		System.out.print("\f## \n\n");
		
		// silent exception handling to ignore undeclared attributes
		DL1.print("asa; dsds; full name; age");
		// string specifying containing 'name' will always return full name
		DL3.print("dob; lastName; lname; age; height; gender");
		
		testDLIncorrectDOB.print("name;dob;age; height; ");
		testDLNoLastName.print(); 

	}
}
