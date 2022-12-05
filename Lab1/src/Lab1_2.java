//두 수를 입력받고 나눗셈 곱셈 나누기 나머지 연산중 1개를 선택하여 계산하고 화면에 출력하기
import java.util.Scanner;

public class Lab1_2 {

	public static void main(String[] args) {
		System.out.println("정수 두 개를 입력하세요");
		Scanner scan = new Scanner(System.in);
		int a= scan.nextInt();
		int b= scan.nextInt();
		System.out.println("원하는 연신을 고르시오");
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
