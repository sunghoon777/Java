package chapter4;

public interface Shapeable {
	final double PI = 3.14;
	void draw();
	double getArea();
	default public void redraw() {
		System.out.println("__ 다시 그립니다. ");
		draw();
	}

}
