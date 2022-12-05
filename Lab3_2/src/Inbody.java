
public class Inbody {
	double weight;
	double height;
	double age;
	Gender gender;
	
	public Inbody(double weight, double height, double age, Gender gender) {
		super();
		this.weight = weight;
		this.height = height;
		this.gender = gender;
		this.age=age;
	}
	
	public Inbody() {
		super();
	}
	
	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}
	
	public double CMtoM() {
		return 0.01*height;
	}
	// 이후 메소드들은 서브 클래스에서 재구현
	double calculate() {
		return 0;
	}
	void userInput() {
		
	}
	void yourStatus() {
		
	}

	@Override
	public String toString() {
		return "Inbody [weight=" + weight + ", height=" + height + ", gender=" + gender+ "]";
	}
	
	
}
