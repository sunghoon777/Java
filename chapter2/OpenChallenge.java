
/*
 * 숨겨진 카드의 수 맞추기 게임
 */

package chapter2;
import java.util.Scanner;

public class OpenChallenge {
	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		int range_min= 0;
		int range_max = 99;
		int user_number = 0;
		String user_opinion = "";
		int count = 0;
		while(true) {
			int random_number = (int)(Math.random()*100);
			System.out.println("수를 결정했습니다. 맞추어 보세요");
			System.out.printf("%d-%d\n",range_min,range_max);
			
			while(true) {
				count++;
				System.out.printf("%d>> ",count);
				try {
					user_number = scan.nextInt();
					if(user_number<0&&user_number>100) {
						System.out.println("잘못입력하셨습니다 0-99 사이의 정수 값을 입력해주세요");
						continue;
					}

				}
				catch(Exception e) {
					System.out.println("잘못입력하셨습니다 0-99 사이의 정수 값을 입력해주세요");
					continue;
				}
				if(user_number<random_number) {
					range_min = user_number;
					System.out.println("더 높게");
					System.out.printf("%d-%d\n",range_min,range_max);
				}
				else if(user_number>random_number) {
					range_max = user_number;
					System.out.println("더 낮게");
					System.out.printf("%d-%d\n",range_min,range_max);
				}
				else {
					System.out.println("맞았습니다");
					break;
				}
			}
			scan.nextLine();
			/*/
			 * scan.nextInt() 메소드는 개행문자까지만 문자를 읽고  사용자가 입력한 가장 마지막의 개행문자를 제거하지 않는다 그래서 nextInt()가 숫자를 입력받고 ,개행문자는
			 * 제거하지 않은채 그대로 남겨둔다. 남겨진 개행문자로 인하여 다음에 쓰여지는 scan.nextLine()이 제대로 쓰여지지 않을 수 
			 * 있으므로 중간에 scan.nextLine()을 한번 작성해줘야한다.
			 */
			while(true) {
				System.out.printf("다시 하겠습니까?(y/n) >> ");
				user_opinion = scan.nextLine();
				if(user_opinion.equals("y")||user_opinion.equals("n"))
					break;
				else {
					System.out.println("다시 입력해주세요");
					continue;
				}
			}
			
			if(user_opinion.equals("n"))
				break;
			count = 0;
		}
		System.out.println("종료");
	}
	

}
