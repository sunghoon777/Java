package chapter4;

public class Point {
	private int x,y;
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	protected void move(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	@Override 
	public int hashCode() {
		return x+y;
	}
	
	@Override 
	public boolean equals(Object obj) {
		if(obj instanceof Point) {
			Point point = (Point)obj;	
			return point.x == x && point.y == y;
		}
		return false;
	}
	
	@Override
	public String toString() {
		return "Point [x=" + x + ", y=" + y + "]";
	}
	
	
}
