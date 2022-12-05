import java.util.Scanner;
//BMR 계산
public class BMR extends Inbody {
	
	
	public BMR(double weight, double height, double age, Gender gender) {
		super();
		this.weight = weight;
		this.height = height;
		this.gender = gender;
		this.age = age;
	}
	
	public BMR() {
		super();
	}
	
	
	double calculate() {
		double a;
		if(gender.equals(Gender.남자)) {
			a = 66+(13.8*weight)+(5*height)-(6.8*age);
			return Math.round(a*10)/10;
		}
		else {
			a = 655+(9.6*weight)+(1.8*height)-(4.7*age);
			return Math.round(a*10)/10;
		}
		}

	void userInput() {
		Scanner scan = new Scanner(System.in);
		System.out.println("BMR 계산");
		System.out.println("남자 여자");
		String a = scan.nextLine();
		gender = Gender.valueOf(a);
		System.out.println("몸무게를 입력하세요");
		weight = scan.nextDouble();
		System.out.println("키를 입력하세요");
		height = scan.nextDouble();
		System.out.println("나이를 입력하세요");
		age = scan.nextDouble();
	}
	@Override
	public String toString() {
		return "BMR"+","+age+","+gender+","+height+","+weight+","+calculate();
	}

}
