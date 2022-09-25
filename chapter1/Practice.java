package chapter1;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Practice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		System.out.println("문제 번호를 입력하시오");
		int problem = scan.nextInt();
		/*
		 * 환전 문제
		 */
		if (problem == 1) {
			float rate = 1100;
			System.out.printf("원화를 입력하세요(단위 원)>>");
			int money_won = scan.nextInt();
			float money_dollor = money_won / rate;
			System.out.println(money_won + "원은 $" + money_dollor + "입니다");
		}
		/*
		 * 자리수 비교 문제
		 */
		else if (problem == 2) {
			System.out.printf("2자리수 정수 입력 >>");
			int number = scan.nextInt();
			if (number / 10 == number % 10) {
				System.out.println("yes! 10의 자리와 1의 자리가 같습니다.");
			} else {
				System.out.println("no! 10의 자리와 1의 자리가 다릅니다.");
			}
		}
		/*
		 * 거스름돈 문제
		 */
		else if (problem == 3) {
			System.out.printf("금액을 입력하세요 >>");
			int money = scan.nextInt();
			int money_left = 0;
			int money_50000, money_10000, money_1000, money_100, money_10, money_50, money_1;
			if (money / 50000 > 0) {
				money_50000 = money / 50000;
				money_left = money - 50000 * (money_50000);
				money_10000 = money_left / 10000;
				money_left = money_left - 10000 * (money_10000);
				money_1000 = money_left / 1000;
				money_left = money_left - 1000 * (money_1000);
				money_100 = money_left / 100;
				money_left = money_left - 100 * (money_100);
				money_50 = money_left / 50;
				money_left = money_left - 50 * (money_50);
				money_10 = money_left / 10;
				money_left = money_left - 10 * (money_10);
				money_1 = money_left;
				System.out.printf("오만원권 %d매\n 만원권 %d매\n 천원권 %d매\n 백원 %d개\n 오십원 %d매\n 십원 %d개\n 일원 %d개\n", money_50000,
						money_10000, money_1000, money_100, money_50, money_10, money_1);
			} else if (money / 10000 > 0) {
				money_10000 = money / 10000;
				money_left = money - 10000 * (money_10000);
				money_1000 = money_left / 1000;
				money_left = money_left - 1000 * (money_1000);
				money_100 = money_left / 100;
				money_left = money_left - 100 * (money_100);
				money_50 = money_left / 50;
				money_left = money_left - 50 * (money_50);
				money_10 = money_left / 10;
				money_left = money_left - 10 * (money_10);
				money_1 = money_left;
				System.out.printf("만원권 %d매\n 천원권 %d매\n 백원 %d개\n 오십원 %d매\n 십원 %d개\n 일원 %d개\n", money_10000, money_1000,
						money_100, money_50, money_10, money_1);
			} else if (money / 1000 > 0) {
				money_1000 = money / 1000;
				money_left = money - 1000 * (money_1000);
				money_100 = money_left / 100;
				money_left = money_left - 100 * (money_100);
				money_50 = money_left / 50;
				money_left = money_left - 50 * (money_50);
				money_10 = money_left / 10;
				money_left = money_left - 10 * (money_10);
				money_1 = money_left;
				System.out.printf("천원권 %d매\n 백원 %d개\n 오십원 %d매\n 십원 %d개\n 일원 %d개\n", money_1000, money_100, money_50,
						money_10, money_1);
			} else if (money / 100 > 0) {
				money_100 = money / 100;
				money_left = money - 100 * (money_100);
				money_50 = money_left / 50;
				money_left = money_left - 50 * (money_50);
				money_10 = money_left / 10;
				money_left = money_left - 10 * (money_10);
				money_1 = money_left;
				System.out.printf("백원 %d개\n 오십원 %d매\n 십원 %d개\n 일원 %d개\n", money_100, money_10, money_50, money_1);

			} else if (money / 50 > 0) {
				money_50 = money / 50;
				money_left = money - 50 * (money_50);
				money_10 = money_left / 10;
				money_left = money_left - 10 * (money_10);
				money_1 = money_left;
				System.out.printf("오십원 %d매\n 십원 %d개\n 일원 %d개\n", money_50, money_10, money_1);

			} else if (money / 10 > 0) {
				money_10 = money / 10;
				money_left = money - 10 * (money_10);
				money_1 = money_left;
				System.out.printf("십원 %d개\n 일원 %d개\n", money_10, money_1);
			} else {
				System.out.printf("일원 %d개\n", money);
			}
		}
		/*
		 * 3개의 숫자 중 중간 크기 수 출력 문제
		 */
		else if (problem == 4) {
			System.out.printf("정수 3개 입력 >>");
			int number1 = scan.nextInt();
			int number2 = scan.nextInt();
			int number3 = scan.nextInt();
			if (number1 > number2) {
				if (number1 < number3) {
					System.out.println(number1);
				} else if (number1 == number3) {
					System.out.println(number1);
				} else if (number1 > number3) {
					if (number3 > number2) {
						System.out.println(number3);
					} else if (number3 == number2) {
						System.out.println(number3);
					} else if (number3 < number2) {
						System.out.println(number2);
					}
				}
			} else if (number1 == number2) {
				System.out.println(number1);
			} else if (number1 < number2) {
				if (number2 < number3) {
					System.out.println(number2);
				} else if (number2 == number3) {
					System.out.println(number2);
				} else if (number2 > number3) {
					if (number1 < number3) {
						System.out.println(number3);
					} else if (number3 == number1) {
						System.out.println(number1);
					} else if (number1 > number3) {
						System.out.println(number1);
					}
				}
			}
		}

		/*
		 * 삼각형 판별 문제
		 */
		else if (problem == 5) {
			System.out.printf("정수 3개 입력 >>");
			int number1 = scan.nextInt();
			int number2 = scan.nextInt();
			int number3 = scan.nextInt();
			int number_max = number1;
			if (number1 + number2 > number3) {
				if (number1 + number3 > number2) {
					if (number2 + number3 > number1) {
						System.out.println("삼각형이 됩니다.");
					} else {
						System.out.println("삼각형이 아닙니다");
					}
				} else {
					System.out.println("삼각형이 아닙니다");
				}
			} else {
				System.out.println("삼각형이 아닙니다");
			}

		}

		/*
		 * 369게임
		 */
		else if (problem == 6) {
			System.out.printf("1-99 사이의 정수를 입력하시오 >>");
			int number = scan.nextInt();
			int first = number / 10;
			int second = number % 10;
			if ((first == 3) || (first == 6) || (first == 9)) {
				if ((second == 3) || (second == 6) || (second == 9)) {
					System.out.println("박수짝짝");
				} else {
					System.out.println("박수짝");
				}
			} else if ((second == 3) || (second == 6) || (second == 9)) {
				System.out.println("박수짝");
			} else {
				System.out.println("박수");
			}
		}

		/*
		 * 점이 사각형 안에 있는지에 대한 문제
		 */
		else if (problem == 7) {
			System.out.printf("점 (x,y)의 좌표를 입력하시오 >>");
			int number1 = scan.nextInt();
			int number2 = scan.nextInt();
			if ((number1 >= 100) && (number1 <= 200) && (number2 >= 100) && (number2 <= 200)) {
				System.out.printf("(%d, %d)사각형 안에 있습니다", number1, number2);
			} else {
				System.out.printf("(%d, %d)사각형 안에 없습니다.", number1, number2);
			}
		}

		/*
		 * 두 사각형을 입력받고 충돌하는지 대한 문제
		 */
		else if (problem == 8) {
			System.out.printf("첫번째 점 (x,y)의 좌표를 입력하시오 >>");
			int coordinate1_x = scan.nextInt();
			int coordinate1_y = scan.nextInt();
			System.out.printf("두번 점 (x,y)의 좌표를 입력하시오 >>");
			int coordinate2_x = scan.nextInt();
			int coordinate2_y = scan.nextInt();
			if (((coordinate1_x < 100 && coordinate2_x < 100) || (coordinate1_x > 200 && coordinate2_x > 200))
					|| ((coordinate1_y < 100 && coordinate2_y < 100) || (coordinate1_y > 200 && coordinate2_y > 200))) {
				System.out.println("두 사각형이 충돌하지 않습니다.");
			} else {
				System.out.println("두 사각형이 충돌합니다.");
			}
		}

		/*
		 * 점이 원안에 있는지에 대한 문제
		 */
		else if (problem == 9) {
			System.out.printf("원의 중심과 반지름 입력 >>");
			double circle_x = scan.nextDouble();
			double circle_y = scan.nextDouble();
			double radius = scan.nextDouble();
			System.out.printf("점 입력 >>");
			double x = scan.nextDouble();
			double y = scan.nextDouble();
			double distance = Math.sqrt((x - circle_x) * (x - circle_x) + (y - circle_y) * (y - circle_y));
			if (distance <= radius) {
				System.out.printf("점 (%d,%d)는 원 안에 있다", x, y);
			} else {
				System.out.printf("점 (%d,%d)는 원 안에 없다", x, y);
			}
		}
		/*
		 * 두 원을 입력받고 충돌하는지에 대한 문제
		 */
		else if (problem == 10) {
			System.out.printf("첫번 원의 중심과 반지름 입력 >>");
			double x1 = scan.nextDouble();
			double y1 = scan.nextDouble();
			double radius1 = scan.nextDouble();
			System.out.printf("두번 원의 중심과 반지름 입력 >>");
			double x2 = scan.nextDouble();
			double y2 = scan.nextDouble();
			double radius2 = scan.nextDouble();
			double distance = Math.sqrt(Math.pow((x1 - x2), 2) + Math.pow((y1 - y2), 2));
			if (distance > radius1 + radius2) {
				System.out.println("두 원은 겹치지 않는다.");
			} else {
				System.out.println("두 원은 겹친다.");
			}
		}

		/*
		 * 달을 입력시 계절을 출력해주는 문제
		 */
		else if (problem == 11) {
			System.out.printf("달을 입력하세요(1-12) >>");
			int month = scan.nextInt();
			switch (month) {
			case 3:
			case 4:
			case 5:
				System.out.println("봄");
				break;
			case 6:
			case 7:
			case 8:
				System.out.println("여름");
				break;
			case 9:
			case 10:
			case 11:
				System.out.println("가을");
				break;
			default:
				System.out.println("겨울");
				break;
			}
		}

		/*
		 * 계산기 프로그램
		 */
		else if (problem == 12) {
			System.out.printf("연산 >>");
			double number1 = scan.nextDouble();
			String operator = scan.next();
			double number2 = scan.nextDouble();

			DecimalFormat df = new DecimalFormat("#.#####");
			if (operator.equals("+")) {
				System.out.printf("%s%s%s의 계산결과는 %s", df.format(number1), operator, df.format(number2),
						df.format(number1 + number2));
			} else if (operator.equals("-")) {
				System.out.printf("%s%s%s의 계산결과는 %s", df.format(number1), operator, df.format(number2),
						df.format(number1 - number2));

			} else if (operator.equals("*")) {
				System.out.printf("%s%s%s의 계산결과는 %s", df.format(number1), operator, df.format(number2),
						df.format(number1 * number2));

			} else if (operator.equals("/")) {
				if (Float.compare((float) number2, 0) == 0) {
					System.out.println("0으로 나눌수 없습니다.");
				} else {
					System.out.printf("%s%s%s의 계산결과는 %s", df.format(number1), operator, df.format(number2),
							df.format(number1 / number2));
				}
			}
		}
		/*
		 * DecimalFormat 클래스 #.## ##.## ###.## ...... # ## ###은 정수부분을 타나내고 .##은 소수부분을
		 * 나타낸다. 여기서 정수부분은 #이 몇개이든 정수를 모두 나타내게 되있는데 소수부분은 #의 개수만큼 표시하게 된다. ex) 1234.5678
		 * 이면 #.#### ##.#### ###.#### ####.####은 1234.5678을 나타내게 된다. #.#은 1234.5 #.##은
		 * 1234.56 #.###은 1234.567로 나타내게 된다. 0.00 00.00 000.00 ..... 0 00 000은 정수 부분
		 * .00은 소수 부분을 나타낸다. 위와 다르게 0은 빈자리를 0으로 채우게 된다. ex) 1234.5678이면 00000.0000은
		 * 01234.5678 0000.00000은 1234.56780으로 나타내게 된다.
		 */

		scan.close();
	}
}