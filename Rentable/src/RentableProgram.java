public class RentableProgram {
	
	public static void main(String[] args) { 
	    
		
		Rentable condo1 = new Condo();
		
		condo1.getDescription(); // default value
	    condo1.setRate(140); // set rate 
	    condo1.getDescription();
	    
	    condo1.setRate(); // resets daily rate back to the default
	    condo1.getDescription();
	    
	    
	    Rentable room1 = new Room();
	    room1.getDescription(); 
	    room1.setRate(140);   
	    room1.getDescription();
	    room1.setRate();   
	    room1.getDescription();

	 
	}
    

}
