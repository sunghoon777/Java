package chapter4;

public class Point3D extends Point {
	
	private int z;

	public Point3D(int x, int y , int z) {
		super(x, y);
		this.z = z;
		// TODO Auto-generated constructor stub
	}

	public int getZ() {
		return z;
	}

	public void setZ(int z) {
		this.z = z;
	}
	
	public void moveUp() {
		z += 1;
	}
	
	public void moveDown() {
		z -= 1;
	}
	
	public void move(int x, int y, int z) {
		move(x,y);
		setZ(z);
	}
	
	@Override
	public String toString() {
		return "("+getX()+","+getY()+","+getZ()+")"+"의 점입니다.";
	}

}
