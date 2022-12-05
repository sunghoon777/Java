import java.util.Date;

public class WeatherData {
	Date dateTime;
	double temperature;
	double relativeHumidity;
	double windVelocity;
	
	public WeatherData(Date dateTime, double temperature, double relativeHumidity, double windVelocity) {
		this.dateTime = dateTime;
		this.temperature = temperature;
		this.relativeHumidity = relativeHumidity;
		this.windVelocity = windVelocity;
	}
	
	
	public WeatherData() {

	}

	public Date getDateTime() {
		return dateTime;
	}

	public void setDateTime(Date dateTime) {
		this.dateTime = dateTime;
	}

	public double getTemperature() {
		return temperature;
	}

	public void setTemperature(double temperature) {
		this.temperature = temperature;
	}

	public double getRelativeHumidity() {
		return relativeHumidity;
	}

	public void setRelativeHumidity(double relativeHumidity) {
		this.relativeHumidity = relativeHumidity;
	}

	public double getWindVelocity() {
		return windVelocity;
	}

	public void setWindVelocity(double windVelocity) {
		this.windVelocity = windVelocity;
	}

	@Override
	public String toString() {
		return "WeatherData [dateTime=" + dateTime + ", temperature=" + temperature + ", relativeHumidity="
				+ relativeHumidity + ", windVelocity=" + windVelocity + "]";
	}

}
