//���ڸ� �Է¹޾� ���� ȭ������� ���� ����ϱ�
import java.util.Scanner;

public class Lab1_4 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.printf("�ݾ��� �Է��Ͻÿ�>>");
		int a =scan.nextInt();
		System.out.printf("%s %d��\n","��������",a/50000);	
		a= a-a/50000*50000;
		System.out.printf("%s %d��\n","������",a/10000);	
		a= a-a/10000*10000;
		System.out.printf("%s %d��\n","��õ��",a/5000);
		a=a-a/5000*5000;
		System.out.printf("%s %d��\n","õ����",a/1000);
		a= a-a/1000*1000;
		System.out.printf("%s %d��\n","�����",a/500);
		a= a-a/500*500;
		System.out.printf("%s %d��\n","���",a/100);
		a= a-a/100*100;
		System.out.printf("%s %d��\n","���ʿ�",a/50);
		a=a-a/50*50;
		System.out.printf("%s %d��\n","�ʿ�",a/10);
		a=a-a/10*10;
		System.out.printf("%s %d��\n","�Ͽ�",a);	
		//������ �� = ������-���� ��/�� ȭ�����*�� ȭ����� �̰��� �̿��� ���߽��ϴ�.
	}
}
