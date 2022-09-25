package chapter3;

import java.text.DecimalFormat;

public class Circle {
	private double x,y;
	private int radius;
	
	public Circle(double x, double y, int radius) {
		super();
		this.x = x;
		this.y = y;
		this.radius = radius;
	}
	
	public double getX() {
		return x;
	}



	public void setX(double x) {
		this.x = x;
	}



	public double getY() {
		return y;
	}



	public void setY(double y) {
		this.y = y;
	}



	public int getRadius() {
		return radius;
	}



	public void setRadius(int radius) {
		this.radius = radius;
	}
	
	public double getArea() {
		return radius * radius * Math.PI;
	}


	public void show() {
		DecimalFormat f = new DecimalFormat("#.###");
		System.out.printf("좌표는 (%s , %s) 반지름은 %d\n",f.format(this.getX()),f.format(this.getY()),this.getRadius());
	}
	
	

}
