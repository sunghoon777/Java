//�� ���� �Է¹ް� ������ ���� ������ ������ ������ 1���� �����Ͽ� ����ϰ� ȭ�鿡 ����ϱ�
import java.util.Scanner;

public class Lab1_2 {

	public static void main(String[] args) {
		System.out.println("���� �� ���� �Է��ϼ���");
		Scanner scan = new Scanner(System.in);
		int a= scan.nextInt();
		int b= scan.nextInt();
		System.out.println("���ϴ� ������ ���ÿ�");
		char c = scan.next().charAt(0);
		switch(c)
		{
		case '+' : System.out.println(a+b);
		break;
		case '-' : System.out.println(a-b);
		break;
		case '/' : System.out.println(a/b);
		break;
		case '%' : System.out.println(a%b);
		break;
		}
		
	}

}
