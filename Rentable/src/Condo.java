public class Condo implements Rentable{
 
	double dailyRate = getDailyRate();
	double days = 7;

	public void setRate(double rate) {
		dailyRate = rate;
	}
	
	public void setRate() {
		dailyRate = defaultRate;
	}
	
    @Override
    public double getPrice() {
    	return dailyRate * days;
    }

}