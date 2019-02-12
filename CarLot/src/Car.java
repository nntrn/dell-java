
class Car extends Vehicle {
	
	public String type = "<type>";
	public int doors = 4;
	
	public Car(){
	
	}
	 
	public Car(String license){
		this.licenseNumber = license;
	}
	
	void print() {
		printDesc();
	}
	
	public String[] additionalInfo() {
		String arr[] = {this.type, String.valueOf(this.doors) + "-doors"};
		return arr;
	}
	
	public void setType(String type) {
		if(type.contains("sedan"))
			setSedan();
		if(type.contains("coupe"))
			setCoupe();
		if(type.contains("hatchback"))
			setHatchback();
	}
	
	public void setRandomType() {
		
		int random = (int)(Math.random() * 20 + 1);
		
		setSedan();
		if(random % 5 == 0)
			setCoupe();
		if(random % 3 == 0)
			setHatchback();
		
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