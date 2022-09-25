package chapter4;

public class Circle2 implements Shapeable {
	
	private double radius;
	
	public Circle2(double radius) {
		this.radius = radius;
	}

	@Override
	public void draw() {
		// TODO Auto-generated method stub
		System.out.println("반지름이 "+radius+"인 원입니다.");
	}

	@Override
	public double getArea() {
		// TODO Auto-generated method stub
		return radius * radius * PI;
	}

}
