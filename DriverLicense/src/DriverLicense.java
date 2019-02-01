import java.lang.reflect.Field;
import java.time.LocalDate;
import java.time.Period;
import java.util.Arrays;

/**
 * this DriverLicense class initial
 *
 */
public class DriverLicense {

	private String firstName;
	private String lastName;
	private String dob;
	private String height;
	private String gender;

	/**
	 * returns full name and displays null for missing last names
	 * 
	 */
	public String getFullName() {
		return firstName + " " + lastName;
	}

	/**
	 * returns age if correct date format is used: MM/DD/YYYY, otherwise -1 is
	 * returned 999 is returned for missing DOB and exceptions
	 * 
	 */
	public int getAge() {
		String printException = "";
		try {
			int[] arr = Arrays.stream(dob.split("/")).mapToInt(Integer::parseInt).toArray();
			LocalDate birthday = LocalDate.of(arr[2], arr[0], arr[1]);

			if (arr[0] <= 12 && arr[1] <= 31 && arr[2] >= 1900)
				return Period.between(birthday, LocalDate.now()).getYears();
			return -1;

		} catch (Exception e) {
			printException = "\f";
			printException += e.toString().split("\\.")[2].toString() + "\n\f";
			return 999;
		} finally {
			if (printException != null)
				System.out.print(printException);
		}
	}
	
	/**
	 * returns full name and age 
	 * 
	 */
	public void print() {
		System.out.println("name: " + getFullName());
		System.out.println("age: " + getAge());
		System.out.println("------------------------");
	}
	
	/**
	 * returns specified attributes
	 * 
	 * @param items String of class attributes separated by a semicolon ';' to print
	 */
	public void print(String items) {

		String[] arr = items.toLowerCase().replace(" ", "").split(";");

		Arrays.asList(arr).forEach(e -> {
			if (e.contains("name")) // accepts firstName, lastName, fullname, full name
				System.out.println("name: " + getFullName());
		});

		if (Arrays.asList(arr).indexOf("age") > -1)
			System.out.println("age: " + getAge());
		
		// exception handling for undeclared attributes
		for (Field attr : this.getClass().getDeclaredFields()) {
			try {
				if (Arrays.asList(arr).indexOf(attr.getName()) > 1)
					System.out.println(attr.getName() + ": " + attr.get(this));
			} catch (Exception e) {
			} // silently ignore
		}
		System.out.println("------------------------");

	}

	/**
	 * Builder class
	 * 
	 */
	public static class Builder {

		private String firstName;
		private String lastName;
		private String dob;
		private String height;
		private String gender;

		public Builder() {
		}

		public Builder setFirstName(String firstName) {
			this.firstName = firstName;
			return this;
		}

		public Builder setLastName(String lastName) {
			this.lastName = lastName;
			return this;
		}

		public Builder setDOB(String dob) {
			this.dob = dob;
			return this;
		}

		public Builder setHeight(String height) {
			this.height = height;
			return this;
		}

		public Builder setGender(String gender) {
			this.gender = gender;
			return this;
		}

		public DriverLicense build() {

			DriverLicense dl = new DriverLicense();

			dl.firstName = this.firstName;
			dl.lastName = this.lastName;
			dl.dob = this.dob;
			dl.height = this.height;
			dl.gender = this.gender;
			return dl;
		}
	}

	/**
	 * constructor is made private so that the only way to initialize it is via the
	 * Builder class.
	 */
	public DriverLicense() {

	}

}
