import java.util.Scanner;

public class Lab2_4 {
	
	public static void showGraph() {
		double[] temperature = {5,10,15,20,25,30,35,40};
		double[] Humidity = {66,68,70,72,74,76,78,80,82,84,86,88,90,92,94,96,98,100};
		System.out.print("���/����	");
		for(double a : temperature) {
			System.out.print(a+"	");
		}
		System.out.println();
		DecompositionIndexCalculator cal = new DecompositionIndexCalculator();
		for(double a:Humidity) {
			cal.setRH(a);
			System.out.print(cal.getRH()+"	");
			for(double b:temperature) {
				cal.setT(b);
				System.out.print(cal.calculate(cal.getRH(), cal.getT())+"	");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		showGraph();
		while(true) {
		System.out.println("�������� ���");
		DecompositionIndexCalculator yourcal = new DecompositionIndexCalculator();
		System.out.println("�����µ�?");
		yourcal.setT(scan.nextDouble());
		System.out.println("����?");
		yourcal.setRH(scan.nextDouble());
		double trash = yourcal.calculate(yourcal.getRH(), yourcal.getT());
		System.out.println("���������� "+trash+" �Դϴ�");
		System.out.println("����� �������� �ܰ�� "+DecompositionIndex.getIndex(trash)+" �Դϴ�");
		System.out.println("�� �Ի��ϱ� ���Ͻø� q�� ��������");
		String more = scan.next();
		if(more.equals("q"))
			continue;
		else
			break;
		}

	}

}
