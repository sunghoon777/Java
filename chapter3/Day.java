package chapter3;

public class Day {
	private String work;
	
	

	public Day(String work) {
		super();
		this.work = work;
	}

	public String getWork() {
		return work;
	}

	public void setWork(String work) {
		this.work = work;
	}
	
	public void show() {
		if(work == null)
			System.out.println("없습니다.");
		else 
			System.out.println(work + "입니다.");
	}
}
