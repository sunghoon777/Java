import java.util.Scanner;

public class Lab2_2 {
	
	
	//산출표를 출력하는 메소드
	public static void showGraph() {
		double[] temperature = {0,-5,-10,-15,-20,-25,-30,-35,-40,-45,-50};
		double[] windSpeed = {1.4,2.8,4.2,5.6,6.9,8.3,9.7,11.1,12.5,13.9,15.3,16.7};
		System.out.print("풍속\\기온	");
		for(double a:temperature) {
			System.out.print(a+"	");
		}
		System.out.println();
		for(double a:windSpeed) {
			System.out.print(a+"	");
			for(double b:temperature) 
				System.out.print(WindChillTemperatureIndexCalculator.calculate(b, a*3.6)+"	");
		System.out.println();
		}
	}
	
	

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("체감표");
		showGraph();
		//체감온도 사용자가 입력해 계산한 값 출력하기
		while(true) {
		System.out.println("온도(섭씨)");
		double a = scan.nextDouble();
		System.out.println("풍속(m/s)");
		double b = 3.6*scan.nextDouble();
		double yourtem = WindChillTemperatureIndexCalculator.calculate(a,b);
		System.out.println("당신의 체감온도는"+yourtem);
		System.out.println("체감온도의 단계는"+WindChillTemperatureIndex.getIndex(yourtem));
		System.out.println("더 계산하기 원하십니까?(원하시면 q를 누르세요)");
		String more = scan.next();
		if(more.equals("q"))
			continue;
		else
			break;
		}
	}
}
