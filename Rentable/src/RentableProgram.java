public class RentableProgram {
	
	public static void main(String[] args) { 
	    
		
		Rentable condo = new Condo();
		condo.getDescription(); // default value
	    condo.setRate(140); // set rate 
	    condo.getDescription();
	    
	    condo.setRate(); // resets daily rate back to the default
	    condo.getDescription();
	    
	    Rentable room = new Room();
	    room.getDescription(); 
	    room.setRate(140);   
	    room.getDescription();
	    room.setRate();   
	    room.getDescription();
	    
	    Rentable tool = new Tool();
	    tool.getDescription(); 
	    tool.setRate(308);   
	    tool.getDescription();
	    tool.setRate();   
	    tool.getDescription();
	 
	}
    

}
