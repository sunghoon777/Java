package chapter4_openchallenge;
import java.util.Random;

public class Main {
	
	//화면 출력 메소드
	private static void print(Bear bear , Fish fish) {
		for(int i = 1 ; i<11;i++) {
			for(int j = 1 ; j<21;j++) {
				if(bear.x == j && bear.y == i) {
					System.out.print(bear.getShape());
				}
				else if(fish.x == j && fish.y == i ) {
					System.out.print(fish.getShape());
				}
				else {
					System.out.print("-");
				}
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("** Bear의 Fish 먹기 게임을 시작함니다. **");
		//초기 설정
		Random random = new Random();
		int x1 = random.nextInt(10)+1;
		int x2 = random.nextInt(10)+11;
		int y1 = random.nextInt(5)+1;
		int y2 = random.nextInt(5)+6;
		Bear bear = new Bear(x1, y1);
		Fish fish = new Fish(x2, y2);
		print(bear , fish);
		
		while(true) {
			bear.move();
			fish.move();
			print(bear,fish);
			if(bear.collide(fish)) {
				System.out.println("Bear Wins!!");
				break;
			}
		}
	}

}
