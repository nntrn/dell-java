import java.util.Arrays;
import java.time.*;

/**
 * this DriverLicense class initial
 *
 */
public class DriverLicense {

	private String fname;
	private String lname;
	private String dob;
	private String height;
	private String gender;

	/**
	 * returns null if first or last names are missing
	 * 
	 */
	public String getFullName() {

		if (fname == null || lname == null)
			return null;

		return fname + " " + lname;
	}

	/**
	 * returns age if correct date format is used: MM/DD/YYYY otherwise -1 is
	 * returned 
	 * TODO: return correct years when MM/DD/YY is used
	 * 
	 */
	public int getAge() {
		try {
			int[] arr = Arrays.stream(dob.split("/")).mapToInt(Integer::parseInt).toArray();
			LocalDate birthday = LocalDate.of(arr[2], arr[0], arr[1]);

			return Period.between(birthday, LocalDate.now()).getYears();

		} catch (Exception e) {
			return -1;
		}

	}

	/**
	 * Builder class
	 * 
	 */
	public static class Builder {

		private String fname;
		private String lname;
		private String dob;
		private String height;
		private String gender;

		public Builder() {
		}

		public Builder setFirstName(String fname) {
			this.fname = fname;
			return this;
		}

		public Builder setLastName(String lname) {
			this.lname = lname;
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

			dl.fname = this.fname;
			dl.lname = this.lname;
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
