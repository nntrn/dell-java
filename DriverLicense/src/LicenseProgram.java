
public class LicenseProgram {
	public static void main(String[] args) {
		
		DriverLicense dr = new DriverLicense();
		
		int age = dr.getAge("02/01/1992");
		
		System.out.println(age);
			
	}
}
