package chapter4_openchallenge;

import java.util.Scanner;

public class Bear extends GameObject {
	
	private Scanner scan = new Scanner(System.in);

	public Bear(int startX, int startY) {
		super(startX, startY);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void move() {
		// TODO Auto-generated method stub
		System.out.printf("왼쪽(a), 아래(s), 위(w), 오른쪽(d) >>");
		String input = scan.nextLine();
		if(input.equals("a")) {
			if(x >1) {
				x = x-1;
			}
		}
		else if(input.equals("d")) {
			if(x < 20) {
				x = x+1;
			}
		}

		else if(input.equals("w")) {
			if(y > 1) {
				y = y-1;
			}
		}

		else if(input.equals("s")) {
			if(y < 10) {
				y = y+1;
			}
		}
	}

	@Override
	public char getShape() {
		// TODO Auto-generated method stub
		return 'B';
	}

}
