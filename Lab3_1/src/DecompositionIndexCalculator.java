import java.util.Date;
import java.util.Scanner;
//부패지수 계산
public class DecompositionIndexCalculator extends  WeatherIndexCaclculator {

	public DecompositionIndexCalculator(Date dateTime, double temperature, double relativeHumidity,
			double windVelocity) {
		super(dateTime, temperature, relativeHumidity, windVelocity);
		// TODO Auto-generated constructor stub
	}
	
	public DecompositionIndexCalculator() {
		super();
	}
	


	@Override
	double calculate() {
		double a = ((relativeHumidity - 65)/14) * Math.pow(1.054, temperature);
		return Math.round(a*100)/100d;
	}

	@Override
	void printTable() {
		double[] temperature = {5,10,15,20,25,30,35,40};
		double[] Humidity = {66,68,70,72,74,76,78,80,82,84,86,88,90,92,94,96,98,100};
		System.out.print("기온/습도	");
		for(double a : temperature) {
			System.out.print(a+"	");
		}
		System.out.println();
		WeatherIndexCaclculator cal = new DecompositionIndexCalculator();
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
		System.out.println("부패 지수");
		System.out.println("습도를 입력하세요");
		relativeHumidity = scan.nextDouble();
		System.out.println("온도를 입력하세요(섭씨)");
		temperature = scan.nextDouble();
	}

	@Override
	public String toString() {
		return "DecompositionIndexCalculator"+","+relativeHumidity+","+temperature+","+value+","+DecompositionIndex.getIndex(value);
	}
	
	
}
