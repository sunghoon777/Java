import java.util.Scanner;

public class Lab2_3 {
	
	
	//산출표를 출력하는 메소드
	public static void showGraph() {
		double[] temperature = {27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43};
		double[] Humidity = {40,45,50,55,60,65,70,75,80,85,90,95,100};
		System.out.print("기온/습도	");
		for(double a : temperature) {
			System.out.print(a+"	");
		}
		System.out.println();
		HeatIndexCalculator cal = new HeatIndexCalculator();
		for(double a:Humidity) {
			cal.setR(a);
			System.out.print(cal.getR()+"	");
			for(double b:temperature) {
				cal.setC(b);
				cal.CtoF();
				System.out.print(cal.calculate(cal.getF(), cal.getR())+"	");
			}
			System.out.println();
		}
	}

	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		showGraph();
		//사용자가 온도 습도를 입력해 열지수를 계산하게함
		while(true) {
		System.out.println("열지수 계산");
		HeatIndexCalculator yourcal = new HeatIndexCalculator();
		System.out.println("섭씨온도?");
		yourcal.setC(scan.nextDouble());
		System.out.println("습도?");
		yourcal.setR(scan.nextDouble());
		yourcal.CtoF();
		double heat = yourcal.calculate(yourcal.getF(), yourcal.getC());
		System.out.println("열지수는 "+heat+" 입니다");
		System.out.println("당신의 열지수 단계는 "+HeatIndex.getIndex(heat)+" 입니다");
		System.out.println("더 게산하기 원하시면 q를 누르세요");
		String more = scan.next();
		if(more.equals("q"))
			continue;
		else
			break;
		}
	}
}
