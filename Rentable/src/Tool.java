public class Tool implements Rentable{
 
	double dailyRate = getDailyRate();
	double days = 0.042;

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
    	return dailyRate * days;
    }

}