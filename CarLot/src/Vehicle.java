abstract class Vehicle {
	
	String licenseNumber = "<license>", make = "<make>", model = "<model>";
	int price;
	
	abstract void print();

	public void printDesc() {
		
		for (String a : desc()) // print legacy/inherited cols
			System.out.print(a);
		
		for(String a : additionalInfo()) // print subclass cols
			System.out.print(a.toUpperCase()); 
	}
	
	public String[] desc() {

		String vehClass = this.getClass().getName().toUpperCase(),
				licNum = this.licenseNumber.toUpperCase(),
				carPrice = "$" + String.valueOf(this.price);

		String[] desc = { 
				vehClass + spaces(8, vehClass), 
				licNum + spaces(8, licNum), 
				this.make + spaces(10, this.make),
				this.model + spaces(10, this.model), 
				carPrice + spaces(10, carPrice) };
		return desc;
	}
	
	// need to initialize additionalInfo so that we can print stuff later
	public String[] additionalInfo() {
		return null; 
	}
	
	public int randomInt(int min, int max) {
		return (int) (Math.random() * max + min);
	}
	
	/* setters  ******************************/
	
	public void setLicense(String license) {
		this.licenseNumber = license;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
	/* formatting  ******************************/
	
	public String spaces(int num, String str) {

		String sp = "";
		int spaces = num;

		if (str != "") { spaces = num - str.length(); } 
		for (int i = 0; i < spaces; i++) { sp += " "; }
		return sp;

	}
}
