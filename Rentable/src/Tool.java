public class Tool implements Rentable{
	
	double hourlyRate = 1.042; // daily rate increases when day < 1
	double dailyRate = getDailyRate() * hourlyRate;
	double days = .042;

	@Override
	public void setRate(double rate) {
		dailyRate = rate * hourlyRate;
	}
	
	 @Override
	public void setRate() {
		dailyRate = defaultRate * hourlyRate;
	}
	
    @Override
    public double getPrice() {
    	return dailyRate;
    }

}