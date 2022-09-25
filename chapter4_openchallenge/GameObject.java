package chapter4_openchallenge;

public abstract class GameObject {
	
	protected int x, y; // 위치
	
	//초기 위치와 이동거리 설정
	public GameObject(int startX, int startY) {
		this.x = startX;
		this.y = startY;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	//이 객체와 충돌했으면 true 리턴
	public boolean collide(GameObject p) {
		if(this.x == p.getX() && this.y == p.getY())
			return true;
		else
			return false;
	}
	
	//이동후 x,y변경
	public abstract void move();
	//객체 모양을 나타내는 문자 리턴
	public abstract char getShape();
	
	

}
