public class Room implements Rentable {

	double rateMultiplier = 1;
	double dailyRate = 100;

	Room(double rate) {
		dailyRate = rate * rateMultiplier;
	}

	@Override
	public void setRate(double newRate) {
		dailyRate = newRate * rateMultiplier;
	}

	@Override
	public double getDailyRate() {
		return dailyRate * rateMultiplier;
	}

	@Override
	public double getPrice() {
		return getDailyRate() * getDays();
	}
}

class Condo extends Room implements Rentable {

	// daily rates decrease for weekly bookings
	static double rateMultiplier = .85;
	double weeklyRate = getDailyRate() * rateMultiplier;

	Condo(double rate) {
		super(rate * rateMultiplier);
	}

	@Override
	public double getDays() {
		return 7;
	}
}

class Tool extends Room implements Rentable {

	// rates increase for hourly bookings
	static double rateMultiplier = 1.5;
	double hourlyRate = getDailyRate() * rateMultiplier;

	Tool(double rate) {
		super(rate * rateMultiplier);
	}

	@Override
	public double getDays() {
		return .042;
	}
}
