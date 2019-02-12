class Truck extends Vehicle {
	
	private String bedSize="<bedSize>";
	
	// bed size is randomized at creation (not ideal for real life)
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
	
	/* add subclass fields here ***********************/
	public String[] additionalInfo() {
		
		String arr[] = {this.bedSize};
		return arr;
	}
	
	public void setBedSize(String size) {
		this.bedSize = size;
	}
	
	public void randBedSize() {
		int r = randomInt(0,2);
		String[] sizes = {"REG", "LRG", "SM"};
		setBedSize(sizes[r]);
	}
	
}
