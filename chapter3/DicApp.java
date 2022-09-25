package chapter3;

import java.util.Scanner;

public class DicApp {
	Scanner scan;
	
	
	
	public DicApp(){
	
		this.scan = new Scanner(System.in);
	}

	public void run() {
		String name;
		String eng_name;
		System.out.println("한영 단어 검색 프로그램입니다.");
		while(true) {
			System.out.printf("한글 단어 >> ");
			name = scan.nextLine();
			eng_name = Dictionary.kor2Eng(name);
			if(eng_name.equals("그만")) {
				System.out.println("종료");
				break;
			}
			else if(eng_name.equals(" ")) {
				System.out.printf("%s는 저의 사전에 없습니다.\n",name);
			}
			else {
				System.out.printf("%s는 %s\n",name,eng_name);
			}
		}
	}

}
