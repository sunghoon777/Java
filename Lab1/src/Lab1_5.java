//숫자를 입력받아 3의 배수 숫자 출력하기
import java.util.Scanner;

public class Lab1_5 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("원하는 숫자를 입력하세요");
		String numbers = scan.nextLine();
		String[] array = numbers.split(" ");
		
		System.out.println("3의 배수는");
		for(int i=0;i<array.length;i++) 
		{
			if(Integer.parseInt(array[i])%3==0)
				System.out.print(Integer.parseInt(array[i])+" ");
		}

	}

}
