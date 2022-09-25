package chapter2;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Practice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		System.out.printf("문제를 선택하세요 >> ");
		int problem = Integer.valueOf(scan.nextLine());

		/*
		 * 짝수 합 구하기 for while do while 로 모두 구현
		 */
		if (problem == 1) {
			int sum = 0;
			for (int i = 0; i < 100; i += 2) {
				sum += i;
			}
			System.out.println("for문으로 : 0에서 99까지 짝수들의 합은 " + sum + " 입니다");
			int i = 0;
			sum = 0;
			while (true) {
				if (i >= 100)
					break;
				sum += i;
				i += 2;
			}
			System.out.println("while문으로 : 0에서 99까지 짝수들의 합은 " + sum + " 입니다");
			i = 0;
			sum = 0;
			do {
				sum += i;
				i += 2;
				if (i >= 100)
					break;
			} while (true);
			System.out.println("do while문으로 : 0에서 99까지 짝수들의 합은 " + sum + " 입니다");
		}

		/*
		 * 2차원 배열 출력 문제
		 */
		else if (problem == 2) {
			int n[][] = { { 1 }, { 1, 2, 3 }, { 1 }, { 1, 2, 3, 4 }, { 1, 2 } };
			for (int i = 0; i < n.length; i++) {
				for (int j = 0; j < n[i].length; j++) {
					System.out.printf(n[i][j] + " ");
				}
				System.out.println();
			}
		}

		/*
		 * ***** **** *** ** * 출력하기
		 */

		else if (problem == 3) {
			System.out.printf("정수를 입력하시오 >> ");
			int number = Integer.valueOf(scan.nextLine());
			for (int i = number; i > 0; i--) {
				for (int j = 0; j < i; j++) {
					System.out.printf("*");
				}
				System.out.println();
			}
		}

		/*
		 * abcde abcd abc ab a 출력하기
		 */

		else if (problem == 4) {
			System.out.printf("소문자 알파벳 하나를 입력하시오 >> ");
			char alphabet = scan.nextLine().charAt(0);
			for (char i = alphabet; i >= 'a'; i--) {
				for (char j = 'a'; j <= i; j++) {
					System.out.printf("%c", j);
				}
				System.out.println();
			}
		}

		/*
		 * 정수를 입력받고 3의 배수만 출력하기
		 */

		else if (problem == 5) {
			System.out.printf("양의 정수 10개를 입력하시오 >>");
			int num[] = new int[10];
			for (int i = 0; i < num.length; i++) {
				num[i] = scan.nextInt();
			}
			System.out.printf("3의 배수는");
			for (int i : num) {
				if (i % 3 == 0)
					System.out.printf(" %d", i);
			}
		}

		/*
		 * 배열을 이용하여 환전하기
		 */

		else if (problem == 6) {
			int unit[] = { 50000, 10000, 1000, 500, 100, 50, 10, 1 };
			System.out.printf("금액을 입력하시오 >> ");
			int money = scan.nextInt();
			int money_left = 0;
			int money_bill[] = new int[8];
			for (int i = 0; i < unit.length; i++) {
				if (i == 0) {
					money_bill[i] = money / unit[i];
					money_left = money - money_bill[i] * unit[i];
				} else {
					money_bill[i] = money_left / unit[i];
					money_left = money_left - money_bill[i] * unit[i];
				}
			}
			for (int i = 0; i < unit.length; i++) {
				if (money_bill[i] != 0)
					System.out.printf("%d원 짜리 : %d개\n", unit[i], money_bill[i]);
			}
		}
		/*
		 * 랜덤한 정수들의 평균 구하기
		 */
		else if (problem == 7) {
			int sum = 0;
			int numArray[] = new int[10];
			DecimalFormat f = new DecimalFormat("#.###");
			System.out.printf("랜덤한 정수들 :");
			for (int i = 0; i < numArray.length; i++) {
				numArray[i] = (int) (Math.random() * 10 + 1);
				System.out.printf(" %d", numArray[i]);
				sum += numArray[i];
			}

			System.out.printf("\n평균은 %s", f.format((double) sum / numArray.length));
		}
		/*
		 * 
		 * 중복없는 램덤 숫자 저장하기
		 */
		else if (problem == 8) {
			System.out.printf("정수를(1-100) 몇 개 생성하시겠습니까? >> ");
			int number = scan.nextInt();
			int numArray[] = new int[number];
			int count = 0;
			int isSame = 0;
			while (true) {
				numArray[count] = (int) (Math.random() * 100 + 1);
				for (int j = 0; j < count; j++) {
					if (numArray[count] == numArray[j]) {
						isSame = -1;
						break;
					}
				}
				if (isSame == -1) {
					isSame = 0;
					continue;
				}
				count++;
				if (count >= numArray.length)
					break;
			}
			count = 0;
			for (int i : numArray) {
				if (count % 10 == 0) {
					System.out.println();
				}
				System.out.printf("%3d", i);
				count++;
			}
		}

		/*
		 * 2차원 배열에 랜덤한 수 저장하기
		 */

		else if (problem == 9) {
			int numArray[][] = new int[4][4];
			for (int i = 0; i < numArray.length; i++) {
				for (int j = 0; j < numArray[i].length; j++) {
					numArray[i][j] = (int) (Math.random() * 10 + 1);
				}
			}
			for (int i[] : numArray) {
				for (int j : i) {
					System.out.printf("%4d", j);
				}
				System.out.println();
			}
		}

		/*
		 * 2차원 배열의 랜덤값 대입 하지만 0이 6개가 무조건 들어가야함.
		 */
		else if (problem == 10) {
			int numArray[][] = new int[4][4];
			int isSame = 0;
			int zero_count = 0;
			int numArray_left = numArray.length * numArray[0].length;
			for (int i = 0; i < numArray.length; i++) {
				for (int j = 0; j < numArray[i].length; j++) {
					numArray[i][j] = (int) (Math.random() * 11);
					/*
					 * ramdom 값이 0이면 zero_count 중가
					 */
					if (numArray[i][j] == 0)
						zero_count++;
					/*
					 * 0의 개수가 6보다 크면 다른 랜덤 숫자 대입
					 */
					if (zero_count > 6) {
						while (true) {
							numArray[i][j] = (int) (Math.random() * 11);
							if (numArray[i][j] != 0)
								break;
						}
					}
					/*
					 * 0의 개수가 6보다 부족하면서 배열의 남은 자리가 6개 이하이고 random값도 0이 아니라면 값을 0으로 바꾸어줘야한다.
					 */
					if (zero_count < 6 && numArray_left <= 6 && numArray[i][j] != 0) {
						numArray[i][j] = 0;
						zero_count++;
					}

					numArray_left -= 1;
				}
			}
			for (int i[] : numArray) {
				for (int j : i) {
					System.out.printf("%-4d", j);
				}
				System.out.println();
			}
		}
		/*
		 * 명령행 인자를 대입받고 평균구하기
		 */
		else if (problem == 11) {
			int sum = 0;
			for (String i : args) {
				sum += Integer.parseInt(i);
			}
			System.out.println("평균 : " + (double) sum / args.length);

		}
		/*
		 * 명령행 인자를 대입받고 평균구하기 정수가 아닌것은 에러 처리
		 */
		else if (problem == 12) {
			int sum = 0;
			int count = 0;
			DecimalFormat f = new DecimalFormat("#.###");
			for (String i : args) {
				try {
					sum += Integer.parseInt(i);
				} catch (Exception e) {
					continue;
				}
				System.out.println(i);
				count++;
			}
			System.out.println("평균 : " + f.format((double) sum / count));
		}
		/*
		 * 369게임 반복문을 통해 구현
		 */
		else if (problem == 13) {
			for (int i = 1; i < 100; i++) {
				int first = i / 10;
				int second = i % 10;
				if ((first == 3) || (first == 6) || (first == 9)) {
					if ((second == 3) || (second == 6) || (second == 9)) {
						System.out.printf("%-3d박수짝짝\n", i);
					} else {
						System.out.printf("%-3d박수짝\n", i);
					}
				} else if ((second == 3) || (second == 6) || (second == 9)) {
					System.out.printf("%-3d박수짝\n", i);
				}
			}
		}
		/*
		 * 배열 반복문 응용 문제
		 */
		else if (problem == 14) {
			String course[] = { "Java", "C++", "HTML5", "컴퓨터구조", "안드로이드" };
			int score[] = { 95, 88, 76, 62, 55 };
			int count = 0;
			while (true) {
				System.out.printf("과목 이름>> ");
				String subject = scan.nextLine();
				if (subject.equals("그만"))
					break;
				for (String i : course) {
					if (subject.equals(i)) {
						System.out.printf("%s의 점수는 %d\n", subject, score[count]);
						break;
					}
					count++;
				}
				if (count >= course.length)
					System.out.println("없는 과목입니다");
				count = 0;
			}
		}
		/*
		 * 예외 처리 문제
		 */
		else if (problem == 15) {
			int n = 0;
			int m = 0;
			while (true) {
				try {
					System.out.printf("곱하고자 하는 두수 입력>> ");
					n = scan.nextInt();
					m = scan.nextInt();
				} catch (Exception e) {
					System.out.println("실수는 입력하면 안됩니다.");
					scan.nextLine();
					continue;
				}
				break;
			}
			System.out.printf("%dx%d=%d", n, m, n * m);
		}
		/*
		 * 가위 바위 보 게임
		 */
		else if (problem == 16) {
			String rps[] = { "가위", "바위", "보" };
			System.out.println("컴퓨터와 가위 바위 보 게임을 시작합니다.");
			while (true) {
				System.out.printf("가위 바위 보!>> ");
				String user_pick = scan.nextLine();
				int random_value = (int) (Math.random() * 3);
				if (user_pick.equals("가위")) {
					if(rps[random_value].equals("가위")) {
						System.out.printf("사용자 = %s 컴퓨터 = %s 비겼습니다.\n",user_pick,rps[random_value]);
					}
					else if(rps[random_value].equals("바위")) {
						System.out.printf("사용자 = %s 컴퓨터 = %s 졌습니다.\n",user_pick,rps[random_value]);
					}
					else if(rps[random_value].equals("보")) {
						System.out.printf("사용자 = %s 컴퓨터 = %s 이겼습니다.\n",user_pick,rps[random_value]);
					}
					
				} else if (user_pick.equals("바위")) {
					if(rps[random_value].equals("가위")) {
						System.out.printf("사용자 = %s 컴퓨터 = %s 이겼습니다.\n",user_pick,rps[random_value]);
					}
					else if(rps[random_value].equals("바위")) {
						System.out.printf("사용자 = %s 컴퓨터 = %s 비겼습니다.\n",user_pick,rps[random_value]);
					}
					else if(rps[random_value].equals("보")) {
						System.out.printf("사용자 = %s 컴퓨터 = %s 졌습니다.\n",user_pick,rps[random_value]);
					}
				} else if (user_pick.equals("보")) {
					if(rps[random_value].equals("가위")) {
						System.out.printf("사용자 = %s 컴퓨터 = %s 졌습니다.\n",user_pick,rps[random_value]);
					}
					else if(rps[random_value].equals("바위")) {
						System.out.printf("사용자 = %s 컴퓨터 = %s 이겼습니다.\n",user_pick,rps[random_value]);
					}
					else if(rps[random_value].equals("보")) {
						System.out.printf("사용자 = %s 컴퓨터 = %s 비겼습니다.\n",user_pick,rps[random_value]);
					}
				}
				else if(user_pick.equals("그만")){
					System.out.println("게임을 종료합니다...");
					break;
				}
				else {
					System.out.println("잘못입력하셨습니다.");
				}
			}
		}

	}
}
