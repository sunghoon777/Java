package chapter4;

public class PositivePoint extends Point {

	public PositivePoint(int x, int y) {
		super(x, y);
		if(getX()<0) {
			super.move(0, getY());
		}
		if(getY()<0) {
			super.move(getX(), 0);
		}
		// TODO Auto-generated constructor stub
	}
	
	public PositivePoint() {
		super(0,0);
	}
	
	@Override
	protected void move(int x, int y) {
		if(x < 0 && y < 0) {
			
		}
		else if(x<0) {
			super.move(getX(), y);
		}
		else if(y<0) {
			super.move(x, getY());
		}
		else {
			super.move(x, y);
		}
	}
	

	@Override
	public String toString() {
		return "("+getX()+","+getY()+")"+"의 점입니다.";
	}

}
