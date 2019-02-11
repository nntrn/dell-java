
abstract class Vehicle {
	
	String licenseNumber = "<license#>", make = "<make>", model = "<model>";
	int price;
	
	abstract void print();
	
	public String[] desc() {
		String[] desc = {this.licenseNumber, this.make, this.model, "$"+String.valueOf(this.price)};
		return desc;
	}
	
	public void printDesc() {
		String[] arr = desc();
		
		for(String a:arr) 
			System.out.print(a+" ");
		
		System.out.print("\n");	
	}

	
	
}
