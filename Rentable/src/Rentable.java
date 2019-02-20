import java.text.DecimalFormat;

public interface Rentable {

	final double defaultRate = 100;
	double multiplier = 1;
	double dailyRate = defaultRate;
    double days = 1;
    
    DecimalFormat money = new DecimalFormat("$0.00");

	void setRate(double dailyRate);
	void setRate(); // method for setting dailyRate back to default

    default double getPrice() {
    	return (dailyRate * multiplier) * days;
    }
    
    default double getDailyRate() {
    	return dailyRate;
    }
    
    default String getDescription() {
    	System.out.println(
    			this.getClass().getSimpleName() + 
    			"\n total price: " + money.format(getPrice()) + 
    			"\n daily rate: " + money.format(getDailyRate())
    			);
        return this.getClass().getSimpleName() + " price is $" + getPrice();
    }
 
} 