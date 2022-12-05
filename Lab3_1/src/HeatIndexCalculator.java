import java.util.Date;
import java.util.Scanner;
//열지수 계산
public class HeatIndexCalculator extends  WeatherIndexCaclculator {

	public HeatIndexCalculator(Date dateTime, double temperature, double relativeHumidity, double windVelocity) {
		super(dateTime, temperature, relativeHumidity, windVelocity);
		// TODO Auto-generated constructor stub
	}
	
	public HeatIndexCalculator() {
		super();
	}

	@Override
	double calculate() {
		double F = WeatherIndexCaclculator.fromCelsiusTOfahrenheit(temperature);
		 double a =  -42.379 + (2.04901523*F) + (10.14333127*relativeHumidity) - (0.22475541*F*relativeHumidity) -
				 (0.00683770*F*F) - (0.05481717*relativeHumidity*relativeHumidity) + (0.00122874*F*F*relativeHumidity) + (0.00085282*F*relativeHumidity*relativeHumidity) -
				 (0.00000199*F*F*relativeHumidity*relativeHumidity);
		 a = (a-32)/1.8;
		 return Math.round(a*10)/10;
	}

	@Override
	void printTable() {
		double[] temperature = {27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43};
		double[] Humidity = {40,45,50,55,60,65,70,75,80,85,90,95,100};
		System.out.print("기온/습도	");
		for(double a : temperature) {
			System.out.print(a+"	");
		}
		System.out.println();
		WeatherIndexCaclculator cal = new HeatIndexCalculator();
		for(double a:Humidity) {
			cal.setRelativeHumidity(a);
			System.out.print(cal.getRelativeHumidity()+"	");
			for(double b:temperature) {
				cal.setTemperature(b);
				System.out.print(cal.calculate()+"	");
			}
			System.out.println();
		}
	}

	@Override
	public void getUserInput() {
		Scanner scan = new Scanner(System.in);
		System.out.println("열지수");
		System.out.println("습도를 입력하세요");
		relativeHumidity = scan.nextDouble();
		System.out.println("온도를 입력하세요(섭씨)");
		temperature = scan.nextDouble();
	}

	@Override
	public String toString() {
		return "HeatIndexCalculator"+","+relativeHumidity+","+temperature+","+value+","+HeatIndex.getIndex(value);
	}
	
	

}
