import java.util.Date;

public abstract class WeatherIndexCaclculator extends WeatherData {
	double value;
	
	

	public WeatherIndexCaclculator(Date dateTime, double temperature, double relativeHumidity, double windVelocity) {
		super(dateTime, temperature, relativeHumidity, windVelocity);
		this.value = calculate();
	}
	
	public WeatherIndexCaclculator() {
		super();
	}

	public double getValue() {
		return value;
	}
	
	public static double fromMStoKMH(double ms) {
		return 3.6*ms;
	}
	
	public static double fromKMHtoMS(double kmh) {
		return kmh/3.6;
	}
	
	public static double fromFahrenheitTOCelsius(double f) {
		return (f-32)/1.8;
	}
	
	public static double fromCelsiusTOfahrenheit(double c) {
		return (c*1.8)+32;
	}
	
	@Override
	public String toString() {
		return "WeatherIndexCaclculator [value=" + value + "]";
	}


	abstract double calculate();
	abstract void printTable();
	abstract public void getUserInput();
}
