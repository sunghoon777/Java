//���ϴ� ��ŭ�� ���ڸ� �Է¹޾� ���� ū�� ���� �� �߾� �� ��� �� ���ϱ�

import java.sql.Array;
import java.util.Arrays;
import java.util.Scanner;



public class Lab1_3 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("���ڸ� �Է��Ͻÿ�");
		String numbers = scan.nextLine();
		String[] array = numbers.split(" ");
		Arrays.sort(array);
		//���ڸ� �Է¹��� �Ŀ� split�Լ��� �̿��Ͽ� ���鸶�� ���ڸ� �߶� �迭�� ��������ϴ�.
			double maxnumber=Integer.parseInt(array[0]),minnumber=Integer.parseInt(array[0]),sumnumber=0;
			for(int q = 0;q<array.length;q++)
			{
				if(maxnumber<Integer.parseInt(array[q]))
					maxnumber=Integer.parseInt(array[q]);
				if(minnumber>Integer.parseInt(array[q]))
					minnumber=Integer.parseInt(array[q]);
			}
			// �ִ밪 �ּҰ��� for�� �̿��� ������ ���߽��ϴ�.
			for(int q = 0;q<array.length;q++) {
				sumnumber=sumnumber+Integer.parseInt(array[q]);
			}
			//��հ��� ���ҋ� ����� ���ڵ��� ������ sumnumber�� �����߽��ϴ�.
			System.out.println("�ּҰ� : "+minnumber);
			System.out.println("�Ҵ� : "+maxnumber);
			int n = array.length;
			if(n%2==0)
			{
			double median = (Integer.parseInt(array[n/2])+Integer.parseInt(array[(n-1)/2]))/2;
			System.out.println("�߾Ӱ� : "+median);
			}
			else
			{
			double median = Integer.parseInt(array[n/2]);	
			System.out.println("�߾Ӱ� : "+median);
			}
			//������ ��Ʈ�� �̿��Ͽ� Ȧ���϶� ¦���϶��� ���� �߾Ӱ��� ���߽��ϴ�
			System.out.println("��հ� : "+sumnumber/n);
			//��հ�
	}

}
