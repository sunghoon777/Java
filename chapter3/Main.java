package chapter3;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		DecimalFormat f = new DecimalFormat("#.##");
		System.out.printf("문제를 선택하세요 >>");
		int problem = scan.nextInt();
		scan.nextLine();
		// 객체 연습 tv 객체 생성하기
		if (problem == 1) {
			System.out.printf("TV의 제조업자 몇년형 사이즈를 입력하세요 >> ");
			String name = scan.next();
			int date = scan.nextInt();
			int size = scan.nextInt();
			Tv tv = new Tv(name, date, size);
			System.out.println(tv);
		}
		// 객체 연습 평균 구하기
		else if (problem == 2) {
			System.out.printf("수학 과학 영어 점수를 입력하세요 >> ");
			int mathScore = scan.nextInt();
			int scienceScore = scan.nextInt();
			int englishScore = scan.nextInt();
			Grade grade = new Grade(mathScore, scienceScore, englishScore);
			System.out.println("평균은 " + f.format(grade.getAverage()));
		}
		// 객체 연습 노래 객체 생성하기
		else if (problem == 3) {
			Song song = new Song("Dancing Queen", "ABBA", 1978, "스웨덴");
			song.show();
		}
		// 객체 연습 직사각형 충돌 문제
		else if (problem == 4) {
			Rectangle r1 = new Rectangle(2, 2, 8, 7);
			Rectangle r2 = new Rectangle(5, 5, 6, 6);
			Rectangle r3 = new Rectangle(1, 1, 10, 10);
			if (r3.contains(r1))
				System.out.println("r3은 r1을 포함합니다.");
			if (r3.contains(r2))
				System.out.println("r3은 r2을 포함합니다.");
		}
		// 객체 연습 원 생성
		else if (problem == 5) {
			System.out.printf("몇 개의 원을 생성시겠습니까?");
			int number = scan.nextInt();
			scan.nextLine();
			Circle circleArray[] = new Circle[number];
			for (int i = 0; i < number; i++) {
				System.out.printf("x y radius >> ");
				double x = scan.nextDouble();
				double y = scan.nextDouble();
				int radius = scan.nextInt();
				scan.nextLine();
				circleArray[i] = new Circle(x, y, radius);
			}
			for (Circle circle : circleArray) {
				circle.show();
			}
		}
		// 객체 연습 원 생성 후 가장 면적이 큰 원 구하기
		else if (problem == 6) {
			Circle maxCircle = new Circle(0, 0, 0);
			System.out.printf("몇 개의 원을 생성시겠습니까?");
			int number = scan.nextInt();
			scan.nextLine();
			Circle circleArray[] = new Circle[number];
			for (int i = 0; i < number; i++) {
				System.out.printf("x y radius >> ");
				double x = scan.nextDouble();
				double y = scan.nextDouble();
				int radius = scan.nextInt();
				scan.nextLine();
				circleArray[i] = new Circle(x, y, radius);
			}
			for (Circle circle : circleArray) {
				if (maxCircle.getArea() < circle.getArea()) {
					maxCircle = circle;
				}
			}
			System.out.printf("가장 면적이 큰 원은 ");
			maxCircle.show();
		}
		// 일정 관리 문제
		else if (problem == 7) {
			MonthSchedule s = new MonthSchedule();
			s.setSchedule();
		}
		// 전화번호 찾기
		else if (problem == 8) {
			PhoneBook phoneBook = new PhoneBook();
			phoneBook.setPhoneBook();
			phoneBook.phoneSearch();
		}
		// 배열 합치기
		else if (problem == 9) {
			int array1[] = { 1, 5, 7, 9 };
			int array2[] = { 3, 6, -1, 100, 77 };
			int array3[] = ArrayUtil.concat(array1, array2);
			ArrayUtil.print(array3);
		}
		// 한영 단어 검색
		else if (problem == 10) {
			DicApp app = new DicApp();
			app.run();
		}
		// 계산기
		else if (problem == 11) {
			System.out.printf("두 정수와 연산자를 입력하시오 >> ");
			int a = scan.nextInt();
			int b = scan.nextInt();
			String cal = scan.next();
			if (cal.equals("+")) {
				Add add = new Add();
				add.setValue(a, b);
				System.out.println(add.calculate());

			} else if (cal.equals("-")) {
				Sub sub = new Sub();
				sub.setValue(a, b);
				System.out.println(sub.calculate());

			} else if (cal.equals("*")) {
				Mul mul = new Mul();
				mul.setValue(a, b);
				System.out.println(mul.calculate());

			} else if (cal.equals("/")) {
				Div div = new Div();
				div.setValue(a, b);
				System.out.println(div.calculate());
			}
		}
		
		else if(problem == 12) {
			Reservation reservation = new Reservation();
			reservation.run();
			
		}

	}

}
