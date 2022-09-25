package chapter3;

import java.util.Scanner;

public class Reservation {
	private Seat seatArray[][];
	private Scanner scan;

	public Reservation() {
		super();
		scan = new Scanner(System.in);
		this.seatArray = new Seat[3][10];
		for (int i = 0; i < seatArray.length; i++) {
			for (int j = 0; j < seatArray[i].length; j++) {
				seatArray[i][j] = new Seat(true, "");
			}
		}
	}

	private void reservate() {
		//number은 좌석구분 번호 number2는 좌석 번호 name은 이름 isFoolSeat은 좌석인 꽉차있나 확인용도 변수
		String name = "";
		int number = 0;
		int number2 = 0;
		int isFoolSeat = 0;
		//좌석 입력받음
		while (true) {
			System.out.printf("좌석구분 A(1) B(2) C(3) >> ");
			try {
				number = scan.nextInt();
			} catch (Exception e) {
				//정수 아니면 다시 입력
				System.out.println("잘못입력하셨습니다.");
				scan.nextLine();
				continue;
			}
			//좌석이 1보다 작거나 3보다 크면 다시입력
			if (number < 1 || number > 3) {
				System.out.println("잘못입력하셨습니다.");
				scan.nextLine();
				continue;
			}
			//좌석이 꽊차면 다시 입력
 			for(int i=0;i<seatArray[number-1].length;i++){
				if(seatArray[number-1][i].getSeatAvailable() == false)
					isFoolSeat += 1;
			}
			if(isFoolSeat == seatArray[number-1].length) {
				System.out.println("좌석이 꽉찾습니다.");
				isFoolSeat = 0;
				continue;
			}
			scan.nextLine();
			break;
		}
		//좌석 출력
		if (number == 1) {
			System.out.printf("A>> ");
		} else if (number == 2) {
			System.out.printf("B>> ");
		} else if (number == 3) {
			System.out.printf("C>> ");
		}
		for(int i=0;i<seatArray[number-1].length;i++) {
			if(seatArray[number-1][i].getSeatAvailable() == true)
				System.out.printf("--- ");
			else 
				System.out.printf("%s ",seatArray[number-1][i].getUserName());
		}
		System.out.println();
		//이름 입력
		System.out.printf("이름 >>");
		name = scan.nextLine();
		while(true) {
			//번호 입력
			System.out.printf("번호 >>");
			try {
				number2 = scan.nextInt();
			} catch (Exception e) {
				//정수 아니면 다시 입력
				System.out.println("잘못입력하셨습니다.");
				scan.nextLine();
				continue;
			}
			//좌석이 1보다 작거나 10 크면 다시 입력 
			if (number2 < 1 || number2 > 10) {
				System.out.println("잘못입력하셨습니다.");
				scan.nextLine();
				continue;
			}
			//예약된 좌석이면 다시 입력
			if(seatArray[number-1][number2-1].getSeatAvailable() == false) {
				System.out.println("이미 예약된 좌석입니다..");
				scan.nextLine();
				continue;
			}
			scan.nextLine();
			break;
		}
		seatArray[number-1][number2-1].setUserName(name);
		seatArray[number-1][number2-1].setSeatAvailable(false);
	}

	private void look() {
		//좌석출력
		for (int i = 0; i < seatArray.length; i++) {
			if (i == 0) {
				System.out.printf("A>> ");
			} else if (i == 1) {
				System.out.printf("B>> ");
			} else if (i == 2) {
				System.out.printf("C>> ");
			}
			for (int j = 0; j < seatArray[i].length; j++) {
				if (seatArray[i][j].getSeatAvailable() == true) {
					System.out.printf("--- ");
				} else {
					System.out.printf("%s ", seatArray[i][j].getUserName());
				}
			}
			System.out.println();
		}
	}

	private void cancel() {
		//number은 좌석구분 번호 name은 이름 isEmptySeat 좌석이 비었나 용도
		int number = 0;
		String name;
		int isEmptySeat = 0;
		while (true) {
			System.out.printf("좌석 A(1) B(2) C(3) >> ");
			try {
				number = scan.nextInt();
			} catch (Exception e) {
				//정수아니면 다시 입력
				System.out.println("잘못입력하셨습니다.");
				scan.nextLine();
				continue;
			}
			//좌석구분번호를 잘못 입력시 다시 입력
			if (number < 1 || number > 3) {
				System.out.println("잘못입력하셨습니다.");
				scan.nextLine();
				continue;
			}
			scan.nextLine();
			break;
		}
		//좌석 출력
		if (number == 1) {
			System.out.printf("A>> ");
		} else if (number == 2) {
			System.out.printf("B>> ");
		} else if (number == 3) {
			System.out.printf("C>> ");
		}
		for(int i=0;i<seatArray[number-1].length;i++) {
			if(seatArray[number-1][i].getSeatAvailable() == true) {
				System.out.printf("--- ");
				isEmptySeat += 1;
			}
			else {
				System.out.printf("%s ",seatArray[number-1][i].getUserName());
			}
		}
		System.out.println();
		//이미 빈좌석이면 취소 과정 종료
		if(isEmptySeat == seatArray[number-1].length) {
			System.out.println("이미 빈좌석입니다.");
			return;
		}
		//취소 로직
		while(true) {
			System.out.printf("이름 >> ");
			name = scan.nextLine();
			for(int i=0;i<seatArray[number-1].length;i++) {
				if(seatArray[number-1][i].getUserName().equals(name) && seatArray[number-1][i].getSeatAvailable()==false) {
					seatArray[number-1][i].setSeatAvailable(true);
					seatArray[number-1][i].setUserName("");
					System.out.println("취소되었습니다.");
					return;
				}
			}
			System.out.println("없는 사람입니다. 다시 입력하세요");
		}
		
	}

	public void run() {
		int number = 0;
		System.out.println("명품콘서트홀 예약 시스템입니다.");
		while (true) {
			System.out.printf("예약:1 조회:2 취소: 3 끝내기:4 >> ");
			try {
				number = scan.nextInt();
			} catch (Exception e) {
				System.out.println("잘못입력하셨습니다.");
				scan.nextLine();
				continue;
			}
			if (number < 1 || number > 4) {
				System.out.println("잘못입력하셨습니다.");
				scan.nextLine();
				continue;
			}
			scan.nextLine();
			if (number == 1) {
				reservate();
			} else if (number == 2) {
				look();
			} else if (number == 3) {
				cancel();
			} else if (number == 4) {
				System.out.println("종료");
				break;
			}
		}
	}

}
