public class Condo implements Rentable {
	
	double weeklyRate = .85; // daily rates decrease when days >= 7
	double dailyRate = getDailyRate() * weeklyRate;
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
	public double getDailyRate() {
		return dailyRate * weeklyRate;
	}
	
	@Override
	public double getPrice() {
		return getDailyRate() * days;
	}


}