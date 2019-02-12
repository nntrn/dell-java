abstract class Vehicle {
	
	String licenseNumber = "<license>", make = "<make>", model = "<model>";
	int price;
	
	abstract void print();


	public String[] desc() {		
		
		String[] desc = { 
				this.getClass().getName().toUpperCase(), 
				this.licenseNumber.toUpperCase(), 
				this.make,
				this.model, 
				"$" + String.valueOf(this.price) };
		return desc;
	}
	
	public void printDesc() {

		for (String a : desc())
			System.out.print(a + " ");
		
		for(String a : additionalInfo())
			System.out.print(a + " ");
	}
	
	
	public String[] additionalInfo() {
		return null;
	}
	
	

	public boolean isFieldEmpty(String field) {
		if(field.indexOf("<") > -1)
			return true;
		return false;
	}
	
	public void setLicense(String license) {
		if(isFieldEmpty(this.licenseNumber))
			this.licenseNumber = license;
	}
	
	public void setMake(String make) {
		if(isFieldEmpty(this.make))
			this.make = make;
	}
	
	public void setModel(String model) {
		if(isFieldEmpty(this.model))
			this.model = model;
	}
	
	public void setPrice(int price) {
			this.price = price;
	}

	public int randomInt(int min, int max) {
		return (int)(Math.random() * max + min);
	}

	
}
