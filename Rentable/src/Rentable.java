import java.text.DecimalFormat;

public interface Rentable {

    double dailyRate = 100;
    double days = 1;
    final double defaultRate = 100;
    
    DecimalFormat money = new DecimalFormat("$0.00");

	void setRate(double dailyRate);
	void setRate();

    default double getPrice() {
    	return getDailyRate() * days;
    }
    
    default double getDailyRate() {
    	return dailyRate;
    }
    
    default String getDescription() {
    	System.out.println(this.getClass().getSimpleName() + " price is " + money.format(getPrice()));
        return this.getClass().getSimpleName() + " price is $" + getPrice();
    }
 
} 