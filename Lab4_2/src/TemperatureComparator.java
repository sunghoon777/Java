import java.util.Comparator;

public class TemperatureComparator implements Comparator<WeatherData> {
	@Override
	public int compare(WeatherData p, WeatherData q) {
		return Double.compare(p.getTemperature(),q.getTemperature() );
	}
}
