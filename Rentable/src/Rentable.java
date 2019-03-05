public interface Rentable {

	double dailyRate = 100;
	double days = 1;
	double rateMultiplier = 1;

	void setRate(double rate);

	default double getDailyRate() {
		return dailyRate;
	}

	default double getPrice() {
		return getDailyRate() * getDays();
	}

	default double getDays() {
		return days;
	}

	default double[] getDescription() {

		double[] arr = { 
				getDailyRate(), 	// daily rate
				getDailyRate() * 7, // weekly rate
				getDailyRate() / 24, // hourly rate
				getPrice() };
		return arr;
	}
}