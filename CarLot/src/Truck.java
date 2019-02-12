class Truck extends Vehicle {
	
	private String bedSize="<bedSize>";

	public Truck(){
		randBedSize();
	}
	 
	public Truck(String license){
		this.licenseNumber = license;
		randBedSize();
	}
	
	void print() {
		printDesc();
	}

	
	public String[] additionalInfo() {
		
		String arr[] = {"("+this.bedSize+")"};
		return arr;
		
	}
	
	public void randBedSize() {
		int r = randomInt(0,2);
		String[] sizes = {"STANDARD", "LARGE", "SHORT"};
		setBedSize(sizes[r]);
	}
	
	public void setBedSize(String size) {
	
		this.bedSize = size;
	}
	
}

