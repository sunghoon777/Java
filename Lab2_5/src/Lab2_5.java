import java.util.Scanner;

public class Lab2_5 {
	
	
	
	
	public static void main(String[] args) {
		//����ڰ� ���� �µ��� �Է��� �������� �Ի�
		Scanner scan = new Scanner(System.in);
		while(true) {
			System.out.println("�������� ���");
			DIscomfortIndexCalculator yourcal = new DIscomfortIndexCalculator();
			System.out.println("�����µ�?");
			yourcal.setT(scan.nextDouble());
			System.out.println("����?");
			yourcal.setRH(scan.nextDouble());
			double trash = yourcal.calculate(yourcal.getRH(), yourcal.getT());
			System.out.println("���������� "+trash+" �Դϴ�");
			System.out.println("����� �������� �ܰ�� "+DiscomfortIndex.getIndex(trash)+" �Դϴ�");
			System.out.println("�� �Ի��ϱ� ���Ͻø� q�� ��������");
			String more = scan.next();
			if(more.equals("q"))
				continue;
			else
				break;
			}
		
	}

}
