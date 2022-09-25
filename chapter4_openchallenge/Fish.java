package chapter4_openchallenge;
import java.util.Random;

public class Fish extends GameObject {
	
	private int cycle;
	private Random random;
	private int moveCount;

	public Fish(int startX, int startY) {
		super(startX, startY);
		cycle = 0;
		random = new Random();
		moveCount = 0;
		// TODO Auto-generated constructor stub
	}

	@Override
	public void move() {
		// TODO Auto-generated method stub
		int value = random.nextInt(2);
		int move = -1;
		//value가 0이면 가만히있는다.
		if(value == 0) {
			//value가 0이지만 5번중에 2번은 이동해야하기 때문에 cycle이 끝나기 전에 move를 2번은 최소 해주게 하는 로직
			if(cycle >= 3 && moveCount <= 1 ) {
				move = random.nextInt(4);
				//0이면 왼쪽으로 이동 만약 끝에 있으면 오른쪽으로
				if(move == 0) {
					if(x==1) {
						x = x+1;
					}
					else {
						x = x-1;
					}
				}
				//1이면 오른쪽으로 이동 만약 끝에 있으면 왼쪽으로
				else if(move == 1) {
					if(x==20) {
						x = x-1;
					}
					else {
						x = x+1;
					}
				}
				//2이면 위쪽으로 이동 만약 끝에 있으면 아래쪽으로
				else if(move == 2) {
					if(y == 1) {
						y = y+1;
					}
					else {
						y = y-1;
					}
				}
				//3이면 아래쪽으로 이동 만약 끝에 있으면 위쪽으로
				else if(move == 3) {
					if(y == 10) {
						y = y-1;
					}
					else {
						y = y+1;
					}
				}
				moveCount += 1;
				cycle += 1;
			}
			//가만히있는다.
			else {
				cycle += 1;
			}
		}
		//value가 1이면 움직인다.
		else if(value == 1) {
			//moveCount가 2미만이여만 움직인다.
			if(moveCount < 2) {
				move = random.nextInt(4);
				//0이면 왼쪽으로 이동 만약 끝에 있으면 오른쪽으로
				if(move == 0) {
					if(x==1) {
						x = x+1;
					}
					else {
						x = x-1;
					}
				}
				//1이면 오른쪽으로 이동 만약 끝에 있으면 왼쪽으로
				else if(move == 1) {
					if(x==20) {
						x = x-1;
					}
					else {
						x = x+1;
					}
				}
				//2이면 위쪽으로 이동 만약 끝에 있으면 아래쪽으로
				else if(move == 2) {
					if(y == 1) {
						y = y+1;
					}
					else {
						y = y-1;
					}
				}
				//3이면 아래쪽으로 이동 만약 끝에 있으면 위쪽으로
				else if(move == 3) {
					if(y == 10) {
						y = y-1;
					}
					else {
						y = y+1;
					}
				}
				cycle += 1;
				moveCount += 1;
			}
			//이미 싸이클안에 2번 다 움직였으면 가만히있는다.
			else {
				cycle += 1;
			}
		}
		else {
			System.out.println("오류남");
			return;
		}
		
		//싸이클이 5이면 다시 싸이클 초기화
		if(cycle == 5) {
			cycle = 0;
			moveCount = 0;
		}
	}

	@Override
	public char getShape() {
		// TODO Auto-generated method stub
		return '@';
	}

}
