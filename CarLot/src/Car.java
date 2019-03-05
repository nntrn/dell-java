
class Car extends Vehicle {
	
	private String type = "<type>";
	private int doors = 4;
	
	// car type is randomized at creation (not ideal for real life)
	public Car(){
		setRandomType();
	}
	 
	public Car(String license){
		this.licenseNumber = license;
	}
	
	void print() {
		printDesc();
	}
	
	/* add new fields here that you want printed with */
	public String[] additionalInfo() {
		String arr[] = {"      "  + String.valueOf(this.doors) + "dr " + this.type};
		return arr;
	}
	
	/* setters  ******************************/
	public void setRandomType() {
		
		int random = (int)(Math.random() * 20 + 1);
		
		this.setSedan();
		if(random % 5 == 0) { this.setCoupe(); }
		if(random % 3 == 0) { this.setHatchback(); }
	}
	
	public void setSedan() {
		this.type = "Sedan";
		this.doors = 4;
	}
	
	public void setCoupe() {
		this.type = "Coupe";
		this.doors = 2;
	}
	
	public void setHatchback() {
		this.type = "Hatchback";
		this.doors = ((int)(Math.random()*10+1)%2==0) ? 2 : 4;
	}
	
}
