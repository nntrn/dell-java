public class Room implements Rentable {
 
	double dailyRate = getDailyRate();
	
    @Override
    public void setRate(double rate) {
    	dailyRate = rate;
    }
    
    @Override
	public void setRate() {
		dailyRate = defaultRate;
	}
    	
    @Override
    public double getPrice() {
        return dailyRate;
    }

}