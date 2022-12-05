import java.util.Comparator;

public class RelativeHumidityComparator implements Comparator<WeatherData> {

	@Override
	public int compare(WeatherData p, WeatherData q) {
		return Double.compare(p.getRelativeHumidity(),q.getRelativeHumidity() );
	}

}
