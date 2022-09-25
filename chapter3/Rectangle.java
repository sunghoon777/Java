package chapter3;

public class Rectangle {
	private int x;
	private int y;
	private int width;
	private int height;
	
	public Rectangle(int x, int y, int width, int height) {
		super();
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}
	
	public int square() {
		return getWidth() * getHeight();
	}
	
	public void show() {
		System.out.printf("사각형의 좌표는 (%d, %d) 넓이는 %d",getX(), getY(), square());
	}
	
	boolean contains(Rectangle r) {
		if(r.getX()>this.getX() && r.getX()+r.getWidth()<this.getX()+this.getWidth() && r.getY()>this.getY() && r.getY()+r.getHeight() < this.getY() + this.getHeight()) {
			return true;
		}
		else {
			return false;
		}
	}
	
	

}
