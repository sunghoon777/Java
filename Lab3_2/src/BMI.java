import java.util.Scanner;
//BMI 계산
public class BMI extends Inbody {
	
	public BMI(double weight, double height, Gender gender) {
		super();
		this.weight = weight;
		this.height = height;
		this.gender = gender;
	}
	
	public BMI() {
		super();
	}

	double calculate() {
		double a =weight/(CMtoM()*CMtoM());
		return Math.round(a*10)/10;
	}
	
	
    //사용자 입력 메소드
	void userInput() {
		Scanner scan = new Scanner(System.in);
		System.out.println("BMI 측정");
		System.out.println("남자 여자");
		String a = scan.nextLine();
		gender = Gender.valueOf(a);
		System.out.println("몸무게를 입력하세요");
		weight = scan.nextDouble();
		System.out.println("키를 입력하세요");
		height = scan.nextDouble();
	}
	//상태를 체크하는 메소드 값의 따라 저체중 과체중 정상체중 출력
	void yourStatus() {
		// TODO Auto-generated method stub
		if(gender.equals(Gender.남자))
		{
			if(calculate()<18.2)
				System.out.println("	저체중입니다.");
			if(calculate()<=25)
				System.out.println("	과체중입니다.");
			else
				System.out.println("	정상체중입니다");
		}
		if(gender.equals(Gender.여자))
		{
			if(calculate()<17.96)
				System.out.println("	저체중입니다");
			if(calculate()>=23.98)
				System.out.println("	과체중입니다");
			else
				System.out.println("	정상체중입니다");
		}
	}

	@Override
	public String toString() {
		return "BMI"+","+gender+","+height+","+weight+","+calculate();
	}
	
	
}
