import java.util.Date;
import java.util.Objects;
import java.util.Scanner;
//열지수 계산
public class HeatIndexCalculator   {
	
	HeatIndex index;
	double temperature;
	double relativeHumidity;
	
	public HeatIndexCalculator(double temperature, double relativeHumidity) {
		super();
		this.temperature = temperature;
		this.relativeHumidity = relativeHumidity;
		this.index =   getIndex();
	}
	
	public HeatIndexCalculator() {
		
	}
	
	double calculate() {
		double F = fromCelsiusTOfahrenheit(temperature);
		 double a =  -42.379 + (2.04901523*F) + (10.14333127*relativeHumidity) - (0.22475541*F*relativeHumidity) -
				 (0.00683770*F*F) - (0.05481717*relativeHumidity*relativeHumidity) + (0.00122874*F*F*relativeHumidity) + (0.00085282*F*relativeHumidity*relativeHumidity) -
				 (0.00000199*F*F*relativeHumidity*relativeHumidity);
		 a = (a-32)/1.8;
		 return Math.round(a*10)/10;
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
	public int hashCode() {
		return Objects.hash(index, temperature,relativeHumidity);
	}
	
	@Override
	public boolean equals(Object other) {
		if(this==other) return true;
		else if(other instanceof HeatIndexCalculator)
		{
			HeatIndexCalculator that = (HeatIndexCalculator)other;
			return this.index==that.index&&this.temperature==that.temperature
					&&this.relativeHumidity==that.relativeHumidity;
		}
		else
			return false;
	}

	@Override
	public String toString() {
		return "HeatIndexCalculator [index=" + index + ", temperature=" + temperature + ", relativeHumidity="
				+ relativeHumidity + ", HeatIndexcalculate=" + calculate() + "]";
	}
}
	

