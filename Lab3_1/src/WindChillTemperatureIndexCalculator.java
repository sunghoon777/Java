import java.util.Date;
import java.util.Scanner;
//체감온도 계산
public class WindChillTemperatureIndexCalculator extends  WeatherIndexCaclculator {

	public WindChillTemperatureIndexCalculator(Date dateTime, double temperature, double relativeHumidity, double windVelocity) {
		super(dateTime, temperature, relativeHumidity, windVelocity);
	}
	
	public WindChillTemperatureIndexCalculator() {
		super();
	}

	@Override
	double calculate() {
		double V = WeatherIndexCaclculator.fromMStoKMH(windVelocity);
		double a = 13.12+0.6215*temperature-11.37*Math.pow(V, 0.16)+0.3965*Math.pow(V, 0.16)*temperature;
		return Math.round(a*10)/10;
	}

	@Override
	void printTable() {
		double[] temperature = {0,-5,-10,-15,-20,-25,-30,-35,-40,-45,-50};
		double[] windSpeed = {1.4,2.8,4.2,5.6,6.9,8.3,9.7,11.1,12.5,13.9,15.3,16.7};
		System.out.print("기온/풍속	");
		for(double a : temperature) {
			System.out.print(a+"	");
		}
		System.out.println();
		WeatherIndexCaclculator cal = new WindChillTemperatureIndexCalculator();
		for(double a:windSpeed) {
			cal.setWindVelocity(a);
			System.out.print(cal.getWindVelocity()+"	");
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
		System.out.println("체감온도");
		System.out.println("풍속을 입력하세요(m/s)");
		relativeHumidity = scan.nextDouble();
		System.out.println("온도를 입력하세요(섭씨)");
		temperature = scan.nextDouble();
	}

	@Override
	public String toString() {
		return "WindChillTemperatureIndexCalculator"+","+relativeHumidity+","+temperature+","+value+","+WindChillTemperatureIndex.getIndex(value);
	}
	
	

}
