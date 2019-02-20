public class Condo implements Rentable{
 
	double dailyRate = getDailyRate();
	double days = 7;

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