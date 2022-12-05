import java.util.Date;

public class WeatherData implements Comparable<WeatherData> {
	
	double temperature;
	double relativeHumidity;
	
	public WeatherData( double temperature, double relativeHumidity) {
	
		this.temperature = temperature;
		this.relativeHumidity = relativeHumidity;
	}
	
	
	public WeatherData() {

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


	@Override
	public String toString() {
		return "WeatherData,"+temperature+","+relativeHumidity;
	}


	@Override
	public int compareTo(WeatherData o) {
		return Double.compare(this.temperature, o.temperature);
	}

}