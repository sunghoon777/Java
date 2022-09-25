package chapter3_openChallenge;

import java.util.Scanner;
/*
 * 끝말잇기 게임 
 * run 메소드를 통해 끝말잇기 게임이 진행된다.
 * 만약 참가자 중에 한명이 끝말잇기를 실패한다면 게임이 종료되고 패배자를 출력한다.
 */
public class WordGameApp {

	public Player run(int users, Scanner scan) {
		Player playerArray[] = new Player[users];
		int startCount = 1;
		for(int i=0;i<users;i++) {
			System.out.printf("참가자의 이름을 입력하세요 >> ");
			playerArray[i] = new Player(scan.nextLine());
		}
		System.out.println("시작하는 단어는 아버지입니다.");
		while(true) {
			for(int i=0;i<users;i++) {
				System.out.printf("%s>> ",playerArray[i].getName());
				playerArray[i].setUser_word(scan.nextLine(	));
				if(startCount == 1) {
					playerArray[i].checkSuccess("아버지");
					if(playerArray[i].getUser_state() == false)
						return playerArray[i];
					startCount = 0;
				}
				else {
					if(i==0) {
						playerArray[i].checkSuccess(playerArray[users-1].getUser_word());
						if(playerArray[i].getUser_state() == false)
							return playerArray[i];
					}
					else {
						playerArray[i].checkSuccess(playerArray[i-1].getUser_word());
						if(playerArray[i].getUser_state() == false)
							return playerArray[i];
					}
				}
			}
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		System.out.println("끝말밋기 게임을 시작합니다.");
		System.out.printf("게임에 참가하는 인원은 몇명입니까 >> ");
		int users = scan.nextInt();
		scan.nextLine();
		WordGameApp game = new WordGameApp();
		Player lose_player = game.run(users, scan);
		System.out.printf("%s 가 졌습니다",lose_player.getName());
	}
}
