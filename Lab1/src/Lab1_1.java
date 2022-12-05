//입력받은 숫자를 반올림 내림 올림을 하여 화면에 출력하기
//round floor ceil 함수 사용
import java.util.ArrayList;
import java.util.Scanner;

public class Lab1_1 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		double a = scan.nextDouble();
		System.out.println(Math.round(a*10)/10d);
	}

}
