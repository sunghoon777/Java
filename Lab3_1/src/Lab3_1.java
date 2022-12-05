import java.util.Date;
import java.util.Scanner;

public class Lab3_1
{
	public static Scanner scan = new Scanner(System.in);
	public static WeatherIndexCaclculator decomcal = new DecompositionIndexCalculator();
	public static WeatherIndexCaclculator heatcal = new HeatIndexCalculator();
	public static WeatherIndexCaclculator windcal = new WindChillTemperatureIndexCalculator();
	// 파일의 데이터를 출력해주는 메소드
	public static void printchart(WeatherData[] data ) {
		//WeatherIndexCaclculator 배열 3개 선언
		WeatherIndexCaclculator[] Decomposition = new DecompositionIndexCalculator[data.length];
		WeatherIndexCaclculator[] HeatIndex = new HeatIndexCalculator[data.length];
		WeatherIndexCaclculator[] WindChillTemperature = new WindChillTemperatureIndexCalculator[data.length];
		 //for문을 통해 data연속 출력
		for(int i=0;i<data.length;i++) 
		{
			Date datetime = data[i].dateTime;
			double temperature = data[i].temperature;
			double relativeHumidity = data[i].relativeHumidity;
			double windVelocity = data[i].windVelocity;
			Decomposition[i] = new DecompositionIndexCalculator(datetime, temperature, relativeHumidity, windVelocity);
			HeatIndex[i] = new HeatIndexCalculator(datetime, temperature, relativeHumidity, windVelocity);
			WindChillTemperature[i]  = new WindChillTemperatureIndexCalculator(datetime, temperature, relativeHumidity, windVelocity);
            System.out.println(datetime+"	부패지수 	"+Decomposition[i].calculate()+"	열지수 	"+HeatIndex[i].calculate()+"	"
            + "체감온도	"+WindChillTemperature[i].calculate());
		}
		//데이터를 파일에 저장하는 save 메소드 호출
		System.out.println("1. 열지수 저장 2. 부패지수 저장 3. 체감온도 저장 4. 저장 x");
		int a = scan.nextInt();
		if(a==1)
			save(HeatIndex);
		else if(a==2)
			save(Decomposition);
		else if(a==3)
			save(WindChillTemperature);
	}
	//파일에 저장하는 save 메소드
	public static void save(WeatherIndexCaclculator[] a) {
		WeatherDataImporter.saveCSV("저장1", a);
		
	}
	
	
	public static void main(String[] args)
	{
		
		System.out.println("원하는 출력표 1. 부패지수  2. 열지수 3. 체감온도 ");
		int choose = scan.nextInt();
		//산출표 출력
		switch(choose)
		{
		case 1 : decomcal.printTable();
			break;
		case 2 : heatcal.printTable();
			break;
		case 3 : windcal.printTable();
		}
		
		
	
		System.out.println("원하는 표 1.2018년 2. 2019년");
		choose = scan.nextInt();
		//파일 데이터 출력을 위한 printchart 메소드 호출
		switch(choose)
		{
		case 1 : 	WeatherData[] data1 = WeatherDataImporter.loadCSV("2018.csv");
	             	printchart(data1);
			break;
		case 2 : 	WeatherData[] data2 = WeatherDataImporter.loadCSV("2019.csv");
	             	printchart(data2);
			break;
		}
		
		//사용자 입력
		while(true) 
		{
			System.out.println("원하시는 지수 계산 1. 부패지수 2. 열지수 3. 체감온도");
			choose = scan.nextInt();
			switch(choose)
			{
			case 1 : decomcal.getUserInput();
			         System.out.println("부패지수	"+decomcal.calculate());
				break;
			case 2 : heatcal.getUserInput();
			         System.out.println("열지수	"+heatcal.calculate());
				break;
			case 3  : windcal.getUserInput();
			          System.out.println("체감온도	"+windcal.calculate());
				break;
			}
			System.out.println("더 게산하기 원하시면 q를 누르세요");
			String more = scan.next();
			if(more.equals("q"))
				continue;
			else
				break;
		}
	}
}
