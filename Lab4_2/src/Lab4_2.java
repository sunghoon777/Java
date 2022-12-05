import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;





public class Lab4_2 {
	

	public static Manager manage =new Manager();

	public static Scanner scan = new Scanner(System.in);
	public static void printchart(List<WeatherData> list) {
		for(int i=0;i<list.size();i++) {
			System.out.println(list.get(i).toString());
		}
		System.out.println("1. 저장 2. X");
		int a = scan.nextInt();
		if(a==1)
			DataImporter.saveCSV("저장.csv", list);
	}
	
	public static WeatherData InputData(){
		System.out.println("데이터 생성");
		System.out.println("날짜,습도");
		String data = scan.next();
		String[] array = data.split(",");
		double temperature = Double.parseDouble(array[0]);
		double relativeHumidity = Double.parseDouble(array[1]);
		return new WeatherData(temperature,relativeHumidity);
		
	}
	
	public static void ManageList(List<WeatherData> list) {
		Manager manage = new Manager();
		manage.data=list;
		System.out.println("1.데이터 추가 2.데이터 삭제 3.데이터 교체  4.모든 요소 삭제");
		int a=scan.nextInt();
		WeatherData WeatherData=null;
		WeatherData WeatherData2=null;
		switch(a)
		{
		case 1:
			WeatherData = InputData();
			manage.add(WeatherData);
		break;
		case 2: 
			WeatherData = InputData();
			manage.remove(WeatherData);
		break;
		case 3: 
			System.out.println("기존 데이터");
			WeatherData = InputData();
			System.out.println("새 데이터");
			WeatherData2 = InputData();
			manage.replace(WeatherData, WeatherData2);
		break;
		case 4:
		    manage.removeAll();
		break;
		default :
		break;
		}
		if(a!=4)
		{
			for(int i=0;i<list.size();i++)
			{
				System.out.println(list.get(i).toString());
			}
		}
		else
		{
			System.out.println("요소가 제거됨");
		}
		
	}
	
	public static List<HeatIndexCalculator> BMI(List<WeatherData> list){
		List<HeatIndexCalculator> heat= new ArrayList<HeatIndexCalculator>();
		for(int i=0;i<list.size();i++) {
			double temperature = list.get(i).temperature;
			double relativeHumidity = list.get(i).relativeHumidity;
			heat.add(new HeatIndexCalculator(temperature,relativeHumidity));
			heat.get(i).index=heat.get(i).getIndex();
		}
		return heat;
	}
	
	public static void Sort(List<WeatherData> list){
		List<HeatIndexCalculator> heat = BMI(list);	
		Sort sort=null;
		System.out.println("정렬 기준 선택");
		System.out.println("1. 온도 2. 습도  3. 열지수값  4 .열지수정도   ");
		int a =scan.nextInt();
		switch(a) {
		case 1: 
			sort = new Sort(new TemperatureComparator());
			sort.bubbleSort1(list);
			break;
		case 2:
			sort = new Sort(new RelativeHumidityComparator());
			sort.bubbleSort1(list);
			break;
		case 3:
		    sort = new Sort(new HeatComparator());
		    sort.bubbleSort2(heat);
			break;
		case 4:
			sort = new Sort(new HeatIndexComparator());
			sort.bubbleSort2(heat);
			break;
		default : break;
		}
		if(a==3||a==4)
		{
		for(int i=0;i<heat.size();i++)
		{
			System.out.println(heat.get(i).toString());
		}
		}
		else
		{
			for(int i=0;i<list.size();i++)
			{
				System.out.println(list.get(i).toString());
			}
		}
	}

	public static void main(String[] args) {
		System.out.println("파일 읽기");
		List<WeatherData> list = DataImporter.loadCSV("날씨.csv");
		System.out.println("1. 출력  2. X");
		int a = scan.nextInt();
		if(a==1)
			printchart(list);
		System.out.println("1. list 변경  2. X");
		a = scan.nextInt();
		if(a==1)
			ManageList(list);
		System.out.println("1. 정렬 2. X");
		a = scan.nextInt();
		if(a==1)
			Sort(list);
		
		
	}
}
