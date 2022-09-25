package chapter3;

import java.util.Scanner;

public class MonthSchedule {
	private Day dayArray[];

	public MonthSchedule() {
		this.dayArray = new Day[30];
	}

	public Day[] getDayArray() {
		return dayArray;
	}

	public void setDayArray(Day[] dayArray) {
		this.dayArray = dayArray;
	}

	public void setDay(int date,Day day) {
		dayArray[date-1] = day;
	}
	
	public void setSchedule() {
		Scanner scan = new Scanner(System.in);
		while(true) {
			System.out.printf("할일( 입력: 1 보기 : 2 끝내기 : 3) >> ");
			String command = scan.nextLine();
			if(command.equals("1")) {
				System.out.printf("날짜(1~30) >> ");
				int date = scan.nextInt();
				scan.nextLine();
				System.out.printf("할일(빈칸없이입력) >> ");
				String work = scan.nextLine();
				setDay(date, new Day(work));
			}
			else if(command.equals("2") ) {
				System.out.printf("날짜(1~30) >> ");
				int date = scan.nextInt();
				scan.nextLine();
				System.out.printf("%d일 의 할 일은",date);
				getDayArray()[date-1].show();
			}
			else if(command.equals("3")) {
				System.out.println("프로그램을 종료합니다.");
				return;
			}
			else {
				System.out.println("잘못입력했습니다 다시 입력하세요");
			}
			
		}
	}
}
