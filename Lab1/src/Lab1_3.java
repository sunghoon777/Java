//원하는 만큼의 숫자를 입력받아 가장 큰값 작은 값 중앙 값 평균 값 구하기

import java.sql.Array;
import java.util.Arrays;
import java.util.Scanner;



public class Lab1_3 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("숫자를 입력하시오");
		String numbers = scan.nextLine();
		String[] array = numbers.split(" ");
		Arrays.sort(array);
		//숫자를 입력받은 후에 split함수를 이용하여 공백마다 숫자를 잘라 배열을 만들었습니다.
			double maxnumber=Integer.parseInt(array[0]),minnumber=Integer.parseInt(array[0]),sumnumber=0;
			for(int q = 0;q<array.length;q++)
			{
				if(maxnumber<Integer.parseInt(array[q]))
					maxnumber=Integer.parseInt(array[q]);
				if(minnumber>Integer.parseInt(array[q]))
					minnumber=Integer.parseInt(array[q]);
			}
			// 최대값 최소값을 for을 이용해 동시해 구했습니다.
			for(int q = 0;q<array.length;q++) {
				sumnumber=sumnumber+Integer.parseInt(array[q]);
			}
			//평균값을 구할떄 사용할 숫자들의 총합을 sumnumber에 저장했습니다.
			System.out.println("최소값 : "+minnumber);
			System.out.println("촤댓값 : "+maxnumber);
			int n = array.length;
			if(n%2==0)
			{
			double median = (Integer.parseInt(array[n/2])+Integer.parseInt(array[(n-1)/2]))/2;
			System.out.println("중앙값 : "+median);
			}
			else
			{
			double median = Integer.parseInt(array[n/2]);	
			System.out.println("중앙값 : "+median);
			}
			//과제의 힌트를 이용하여 홀수일때 짝수일때를 나눠 중앙값을 구했습니다
			System.out.println("평균값 : "+sumnumber/n);
			//평균값
	}

}
