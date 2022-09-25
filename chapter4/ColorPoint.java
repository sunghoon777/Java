package chapter4;

public class ColorPoint  extends Point{

	private String color;
	
	public ColorPoint (int x, int y, String color) {
		super(x, y);
		// TODO Auto-generated constructor stub
		this.color = color;
	}
	
	public ColorPoint () {
		this(0, 0, "BLACK");
	}
	
	public ColorPoint (int x, int y) {
		this(x, y, "BLACK");
	}
	
	
	public void setXY(int x, int y) {
		move(x,y);
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	@Override
	public String toString() {
		return getColor()+"색의 "+"("+getX()+","+getY()+")"+"의 점입니다.";
	}
	
	
}
