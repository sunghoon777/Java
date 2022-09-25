package chapter4;

abstract public class Cal {
	protected int a;
	protected int b;
	public void setValue(int a , int b) {
		this.a = a;
		this.b = b;
	}
	abstract public int calculate();
}
