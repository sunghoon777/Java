


package chapter5;

import java.util.Calendar;
import java.util.Random;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("문제를 선택하세요");
		Scanner scan = new Scanner(System.in);
		String problem = scan.nextLine();
		if(problem.equals("연습문제")) {
			String a1 = Integer.valueOf(20).toString();
			double a2 = Double.valueOf("35.9");
			boolean a3 = Boolean.valueOf("true");
			String a4 = Integer.valueOf(30).toString();
			String a5 = Character.valueOf('c').toString();
			System.out.println(a1);
			System.out.println(a2);
			System.out.println(a3);
			System.out.println(a4);
			System.out.println(a5);
			
			//스트링 리터럴로 생성된 문자열은 스트링 리터럴 테이블에서 관리됨 , 한편 new 로 생성하는 문자열은 따로 따로 힙메모리안에서 객체로 생성되어 관리됨
			String b1 ="가나다라";
			//a 와 "가나다라"는 같은 주소를 가진다.
			System.out.println(b1 == "가나다라");
			String b2 = new String(b1);
			System.out.println(b2 == b2);
			
			String c1 = new String(" Oh, Happy  ");
			String c2 = c1.trim();
			String c3 = c2.concat(" Day.");
			System.out.println(c3);

			//100에서 255까지 난수 생성
			for(int i=0;i<10;i++) {
				System.out.print((int)(Math.random()*157) + 99);
				System.out.print(" ");
			}
			System.out.println();
			for(int i=0;i<10;i++) {
				Random random = new Random();
				System.out.print(random.nextInt(156) + 100);
				System.out.print(" ");
			}
			System.out.println();
			Calendar date = Calendar.getInstance();;
			date.clear();
			date.set(Calendar.YEAR, 2020);
			date.set(Calendar.MONTH, 11);
			date.set(Calendar.DAY_OF_MONTH, 25);
			System.out.println("약속 날짜는 "+date.get(Calendar.YEAR)+"년 "+(date.get(Calendar.MONTH)+1)+"월 "+date.get(Calendar.DAY_OF_MONTH)+"일");
		}
		//equal override
		else if(problem.equals("1")) {
			MyPoint p = new MyPoint(3,50);
			MyPoint q = new MyPoint(4,50);
			System.out.println(p);
			if(p.equals(q)) {
				System.out.println("같은 점");
			}
			else
				System.out.println("다른 점");
		}
		else if(problem.equals("2")) {
			Circle a = new Circle(2,3,5);
			Circle b = new Circle(2,3,30);
			System.out.println("원 a :"+a);
			System.out.println("원 b :"+b);
			if(a.equals(b)) {
				System.out.println("같은 원");
			}
			else {
				System.out.println("서로 다른 원");
			}
		}
		//Calendar
		else if(problem.equals("3")) {
			Calendar cal = Calendar.getInstance();
			int hour = cal.get(Calendar.HOUR_OF_DAY);
			System.out.println(hour);
			if(hour>=4 && hour < 12 ) {
				System.out.println("Good Morning");
			}
			else if(hour >= 12 && hour < 18) {
				System.out.println("Good Afternoon");
			}
			else if(hour >= 18 && hour < 22) {
				System.out.println("Good Evening");
			}
			else if(hour >= 22|| hour <4) {
				System.out.println("Good Night");
			}
		}
		//10초에 더 가까운 사람이 이기는 게임
		else if(problem.equals("4")) {
			Calendar cal = Calendar.getInstance();
			System.out.println("10초에 가까운 사람이 이기는 게임입니다.");
			int person1;
			int person2;
			System.out.print("황기태 시작 <Enter 키>   >> ");
			System.out.println(cal.get(Calendar.SECOND));
			System.out.print("10초 예상 후 <Enter 키>   >> ");
			scan.nextLine();
			cal = Calendar.getInstance();
			person1 = cal.get(Calendar.SECOND);
			System.out.println(person1);
			System.out.print("이재문 시작 <Enter 키>   >> ");
			System.out.println(cal.get(Calendar.SECOND));
			System.out.print("10초 예상 후 <Enter 키>   >> ");
			scan.nextLine();
			cal = Calendar.getInstance();
			person2 = cal.get(Calendar.SECOND);
			System.out.println(person2);
			System.out.println("황기태 결과 "+person1+" , 이재문의 결과 "+person2+", 승자는 "+(Math.abs(person1-10)<Math.abs(person2-10)?"황기태":"이재문"));
		}
		//어절 세기
		else if(problem.equals("5")) {
			String text = "";
			while(true) {
				System.out.print(">>  ");
				text = scan.nextLine();
				if(text.equals("그만")) {
					System.out.println("종료합니다..");
					break;
				}
				StringTokenizer st = new StringTokenizer(text, " ");
				System.out.println("어절 개수는 "+st.countTokens());
			}
			
			while(true) {
				System.out.print(">>  ");
				text = scan.nextLine();
				if(text.equals("그만")) {
					System.out.println("종료합니다..");
					break;
				}
				String list[] = text.split("\\s+");	
				System.out.println("어절 개수는 "+list.length);
			}
		}
		//문자 회전시키기
		else if(problem.equals("6")) {
			System.out.println("문자열을 입력하세요. 빈칸이 있어도 되고 영어 한글 모두 됩니다.");
			String text = scan.nextLine();
			String list[] = text.split("\\s+");
			if(list.length == 0) {
				System.out.println("아무것도 입력하지 않았습니다.");
			}
			else {
				String subText = text;
				for(int i =0;i<text.length();i++) {
					subText = subText.substring(1)+subText.charAt(0);
					System.out.println(subText);
				}
			}
		}
		//가위 바위보 게임
		else if(problem.equals("7")) {
			while(true) {
				System.out.println("user [가위(1), 바위(2), 보(3), 끝내기(4)] >>  ");
				String a = scan.nextLine();
				if(a.equals("4")) {
					break;
				}
				String b = Integer.valueOf((int) Math.random() * 3 + 1).toString();
				System.out.println("컴퓨터   >> "+b);
				if(a.equals("1")) {
					if(b.equals("1")) {
						System.out.println("비겼습니다.");
					}
					else if(b.equals("2")) {
						System.out.println("졌습니다.");
					}
					else if(b.equals("3")) {
						System.out.println("이겼습니다.");
					}
				}
				else if(a.equals("2")) {
					if(b.equals("1")) {
						System.out.println("이겼습니다.");
					}
					else if(b.equals("2")) {
						System.out.println("비겼습니다.");
					}
					else if(b.equals("3")) {
						System.out.println("졌습니다.");
					}
				}
				else if(a.equals("3")) {
					if(b.equals("1")) {
						System.out.println("졌습니다.");
					}
					else if(b.equals("2")) {
						System.out.println("이겼습니다.");
					}
					else if(b.equals("3")) {
						System.out.println("비겼습니다.");
					}
				}
			}
		}
		//겜블링 게임
		else if(problem.equals("8")) {
			System.out.print("1번째 선수 이름 >> ");
			Person person1 = new Person(scan.nextLine());
			System.out.print("2번째 선수 이름 >> ");
			Person person2 = new Person(scan.nextLine());
			int a,b,c;
			while(true) {
				System.out.print("["+person1.getName()+"]"+" : <Enter> ");
				scan.nextLine();
				a = (int)(Math.random()*3) + 1;
				b =(int)(Math.random()*3) + 1;
				c = (int)(Math.random()*3) + 1;
				if(a == b && a == c && b == c) {
					System.out.println(a+"   "+b+"   "+c+"   "+person1.getName()+"님이 이겼습니다!.");
					break;
				}
				else {
					System.out.println(a+"   "+b+"   "+c+"   "+"아쉽군요!");
				}
				
				System.out.print("["+person2.getName()+"]"+" : <Enter> ");
				scan.nextLine();
				a = (int)(Math.random()*3) + 1;
				b = (int)(Math.random()*3) + 1;
				c = (int)(Math.random()*3) + 1;
				if(a == b && a == c && b == c) {
					System.out.println(a+"   "+b+"   "+c+"   "+person2.getName()+"님이 이겼습니다!.");
					break;
				}
				else {
					System.out.println(a+"   "+b+"   "+c+"   "+"아쉽군요!");
				}
				
			}
		}
		//문자열 수정하기
		else if(problem.equals("9")) {
			System.out.print(">>  ");
			StringBuffer text = new StringBuffer(scan.nextLine());
			while(true) {
				System.out.print("명령 : ");
				String list[] = scan.nextLine().split("!");
				if(list[0].equals("그만")) {
					break;
				}
				String temp = "";
				int index = -1;
				for(int i=0;i<text.length();i++) {
					if(i == text.length()-1 && text.charAt(i) != ' ') {
						temp += text.charAt(i);
						if(temp.equals(list[0])) {
							index = i - temp.length() + 1;
							text.replace(index, i+1, list[1]);
							System.out.println(text);
							break;
						}
						else {
							break;
						}
					}
					else if(text.charAt(i) != ' ') {
						temp += text.charAt(i);
					}
					else {
						if(temp.equals(list[0])) {
							index = i - temp.length();
							text.replace(index, i, list[1]);
							System.out.println(text);
							break;
						}
						else {
							temp = "";
						}
					}
				}
				if(index == -1) {
					System.out.println("찾을 수 없습니다!");
				}
			}
		}
		
		//겜블링 게임
		else if(problem.equals("10")) {
			System.out.print("겜블링 게임에 참여할 선수 숫자 >> ");
			int number = scan.nextInt();
			int a,b,c;
			scan.nextLine();
			Person[] list = new Person[number];
			for(int i=0;i<number;i++) {
				System.out.print((i+1)+"번? 선수 이름 >>");
				list[i] = new Person(scan.nextLine());
			}
			while(true) {
				boolean end = false;
				for(int i=0;i<number;i++) {
					System.out.print(list[i].getName()+" : <Enter>");
					scan.nextLine();
					a = (int)(Math.random()*3) + 1;
					b = (int)(Math.random()*3) + 1;
					c = (int)(Math.random()*3) + 1;
					if(a == b && a == c && b == c) {
						System.out.println(a+"   "+b+"   "+c+"   "+list[i].getName()+"님이 이겼습니다!.");
						end = true;
						break;
					}
					else {
						System.out.println(a+"   "+b+"   "+c+"   "+"아쉽군요!");
					}
				}
				if(end == true) {
					break;
				}
			}
		}
		scan.close();
		 
	}

}
