import java.util.Date;
import java.util.Scanner;
//열지수 계산
public class HeatIndexCalculator extends WeatherData  {
	
	HeatIndex index;

	public HeatIndexCalculator(double temperature, double relativeHumidity) {
		super(temperature, relativeHumidity);
		// TODO Auto-generated constructor stub
	}
	
	public HeatIndexCalculator() {
		super();
	}

	double calculate() {
		double F = fromCelsiusTOfahrenheit(temperature);
		 double a =  -42.379 + (2.04901523*F) + (10.14333127*relativeHumidity) - (0.22475541*F*relativeHumidity) -
				 (0.00683770*F*F) - (0.05481717*relativeHumidity*relativeHumidity) + (0.00122874*F*F*relativeHumidity) + (0.00085282*F*relativeHumidity*relativeHumidity) -
				 (0.00000199*F*F*relativeHumidity*relativeHumidity);
		 a = (a-32)/1.8;
		 return Math.round(a*10)/10;
	}
	
	public static double fromFahrenheitTOCelsius(double f) {
		return (f-32)/1.8;
	}
	
	public static double fromCelsiusTOfahrenheit(double c) {
		return (c*1.8)+32;
	}
	
	
	
	
	public HeatIndex getIndex() {
		return HeatIndex.getIndex(calculate());
	}


	@Override
	public String toString() {
		return "HeatIndexCalculator"+","+relativeHumidity+","+temperature+","+this.calculate()+","+HeatIndex.getIndex(calculate());
	}
	
	

}