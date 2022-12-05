import java.util.Date;
import java.util.Scanner;

public class Lab3_1
{
	public static Scanner scan = new Scanner(System.in);
	public static WeatherIndexCaclculator decomcal = new DecompositionIndexCalculator();
	public static WeatherIndexCaclculator heatcal = new HeatIndexCalculator();
	public static WeatherIndexCaclculator windcal = new WindChillTemperatureIndexCalculator();
	// ������ �����͸� ������ִ� �޼ҵ�
	public static void printchart(WeatherData[] data ) {
		//WeatherIndexCaclculator �迭 3�� ����
		WeatherIndexCaclculator[] Decomposition = new DecompositionIndexCalculator[data.length];
		WeatherIndexCaclculator[] HeatIndex = new HeatIndexCalculator[data.length];
		WeatherIndexCaclculator[] WindChillTemperature = new WindChillTemperatureIndexCalculator[data.length];
		 //for���� ���� data���� ���
		for(int i=0;i<data.length;i++) 
		{
			Date datetime = data[i].dateTime;
			double temperature = data[i].temperature;
			double relativeHumidity = data[i].relativeHumidity;
			double windVelocity = data[i].windVelocity;
			Decomposition[i] = new DecompositionIndexCalculator(datetime, temperature, relativeHumidity, windVelocity);
			HeatIndex[i] = new HeatIndexCalculator(datetime, temperature, relativeHumidity, windVelocity);
			WindChillTemperature[i]  = new WindChillTemperatureIndexCalculator(datetime, temperature, relativeHumidity, windVelocity);
            System.out.println(datetime+"	�������� 	"+Decomposition[i].calculate()+"	������ 	"+HeatIndex[i].calculate()+"	"
            + "ü���µ�	"+WindChillTemperature[i].calculate());
		}
		//�����͸� ���Ͽ� �����ϴ� save �޼ҵ� ȣ��
		System.out.println("1. ������ ���� 2. �������� ���� 3. ü���µ� ���� 4. ���� x");
		int a = scan.nextInt();
		if(a==1)
			save(HeatIndex);
		else if(a==2)
			save(Decomposition);
		else if(a==3)
			save(WindChillTemperature);
	}
	//���Ͽ� �����ϴ� save �޼ҵ�
	public static void save(WeatherIndexCaclculator[] a) {
		WeatherDataImporter.saveCSV("����1", a);
		
	}
	
	
	public static void main(String[] args)
	{
		
		System.out.println("���ϴ� ���ǥ 1. ��������  2. ������ 3. ü���µ� ");
		int choose = scan.nextInt();
		//����ǥ ���
		switch(choose)
		{
		case 1 : decomcal.printTable();
			break;
		case 2 : heatcal.printTable();
			break;
		case 3 : windcal.printTable();
		}
		
		
	
		System.out.println("���ϴ� ǥ 1.2018�� 2. 2019��");
		choose = scan.nextInt();
		//���� ������ ����� ���� printchart �޼ҵ� ȣ��
		switch(choose)
		{
		case 1 : 	WeatherData[] data1 = WeatherDataImporter.loadCSV("2018.csv");
	             	printchart(data1);
			break;
		case 2 : 	WeatherData[] data2 = WeatherDataImporter.loadCSV("2019.csv");
	             	printchart(data2);
			break;
		}
		
		//����� �Է�
		while(true) 
		{
			System.out.println("���Ͻô� ���� ��� 1. �������� 2. ������ 3. ü���µ�");
			choose = scan.nextInt();
			switch(choose)
			{
			case 1 : decomcal.getUserInput();
			         System.out.println("��������	"+decomcal.calculate());
				break;
			case 2 : heatcal.getUserInput();
			         System.out.println("������	"+heatcal.calculate());
				break;
			case 3  : windcal.getUserInput();
			          System.out.println("ü���µ�	"+windcal.calculate());
				break;
			}
			System.out.println("�� �Ի��ϱ� ���Ͻø� q�� ��������");
			String more = scan.next();
			if(more.equals("q"))
				continue;
			else
				break;
		}
	}
}
