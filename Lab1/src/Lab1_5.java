//���ڸ� �Է¹޾� 3�� ��� ���� ����ϱ�
import java.util.Scanner;

public class Lab1_5 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("���ϴ� ���ڸ� �Է��ϼ���");
		String numbers = scan.nextLine();
		String[] array = numbers.split(" ");
		
		System.out.println("3�� �����");
		for(int i=0;i<array.length;i++) 
		{
			if(Integer.parseInt(array[i])%3==0)
				System.out.print(Integer.parseInt(array[i])+" ");
		}

	}

}
