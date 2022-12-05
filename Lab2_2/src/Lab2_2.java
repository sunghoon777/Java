import java.util.Scanner;

public class Lab2_2 {
	
	
	//����ǥ�� ����ϴ� �޼ҵ�
	public static void showGraph() {
		double[] temperature = {0,-5,-10,-15,-20,-25,-30,-35,-40,-45,-50};
		double[] windSpeed = {1.4,2.8,4.2,5.6,6.9,8.3,9.7,11.1,12.5,13.9,15.3,16.7};
		System.out.print("ǳ��\\���	");
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
		System.out.println("ü��ǥ");
		showGraph();
		//ü���µ� ����ڰ� �Է��� ����� �� ����ϱ�
		while(true) {
		System.out.println("�µ�(����)");
		double a = scan.nextDouble();
		System.out.println("ǳ��(m/s)");
		double b = 3.6*scan.nextDouble();
		double yourtem = WindChillTemperatureIndexCalculator.calculate(a,b);
		System.out.println("����� ü���µ���"+yourtem);
		System.out.println("ü���µ��� �ܰ��"+WindChillTemperatureIndex.getIndex(yourtem));
		System.out.println("�� ����ϱ� ���Ͻʴϱ�?(���Ͻø� q�� ��������)");
		String more = scan.next();
		if(more.equals("q"))
			continue;
		else
			break;
		}
	}
}
