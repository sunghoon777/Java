package chapter3;

public class Tv {
	private String name;
	private int date;
	private int size;
	
	public Tv(String name, int date, int size) {
		this.name = name;
		this.date = date;
		this.size = size;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getDate() {
		return date;
	}

	public void setDate(int date) {
		this.date = date;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return getName()+"에서 만든 "+getDate()+"년형 "+getSize()+"인치 TV";
	}
	
	
	
	
	

}
