//숫자를 입력받아 세부 화폐단위로 돈을 출력하기
import java.util.Scanner;

public class Lab1_4 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.printf("금액을 입려하시오>>");
		int a =scan.nextInt();
		System.out.printf("%s %d매\n","오만원권",a/50000);	
		a= a-a/50000*50000;
		System.out.printf("%s %d매\n","만원권",a/10000);	
		a= a-a/10000*10000;
		System.out.printf("%s %d매\n","오천원",a/5000);
		a=a-a/5000*5000;
		System.out.printf("%s %d매\n","천원권",a/1000);
		a= a-a/1000*1000;
		System.out.printf("%s %d매\n","오백원",a/500);
		a= a-a/500*500;
		System.out.printf("%s %d매\n","백원",a/100);
		a= a-a/100*100;
		System.out.printf("%s %d매\n","오십원",a/50);
		a=a-a/50*50;
		System.out.printf("%s %d매\n","십원",a/10);
		a=a-a/10*10;
		System.out.printf("%s %d매\n","일원",a);	
		//나머지 돈 = 기존돈-기존 돈/쓴 화폐단위*쓴 화폐단위 이것을 이용해 구했습니다.
	}
}
