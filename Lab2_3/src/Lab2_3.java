import java.util.Scanner;

public class Lab2_3 {
	
	
	//����ǥ�� ����ϴ� �޼ҵ�
	public static void showGraph() {
		double[] temperature = {27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43};
		double[] Humidity = {40,45,50,55,60,65,70,75,80,85,90,95,100};
		System.out.print("���/����	");
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
		//����ڰ� �µ� ������ �Է��� �������� ����ϰ���
		while(true) {
		System.out.println("������ ���");
		HeatIndexCalculator yourcal = new HeatIndexCalculator();
		System.out.println("�����µ�?");
		yourcal.setC(scan.nextDouble());
		System.out.println("����?");
		yourcal.setR(scan.nextDouble());
		yourcal.CtoF();
		double heat = yourcal.calculate(yourcal.getF(), yourcal.getC());
		System.out.println("�������� "+heat+" �Դϴ�");
		System.out.println("����� ������ �ܰ�� "+HeatIndex.getIndex(heat)+" �Դϴ�");
		System.out.println("�� �Ի��ϱ� ���Ͻø� q�� ��������");
		String more = scan.next();
		if(more.equals("q"))
			continue;
		else
			break;
		}
	}
}
