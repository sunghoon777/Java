import java.util.Scanner;
//BMI ���
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
	
	
    //����� �Է� �޼ҵ�
	void userInput() {
		Scanner scan = new Scanner(System.in);
		System.out.println("BMI ����");
		System.out.println("���� ����");
		String a = scan.nextLine();
		gender = Gender.valueOf(a);
		System.out.println("�����Ը� �Է��ϼ���");
		weight = scan.nextDouble();
		System.out.println("Ű�� �Է��ϼ���");
		height = scan.nextDouble();
	}
	//���¸� üũ�ϴ� �޼ҵ� ���� ���� ��ü�� ��ü�� ����ü�� ���
	void yourStatus() {
		// TODO Auto-generated method stub
		if(gender.equals(Gender.����))
		{
			if(calculate()<18.2)
				System.out.println("	��ü���Դϴ�.");
			if(calculate()<=25)
				System.out.println("	��ü���Դϴ�.");
			else
				System.out.println("	����ü���Դϴ�");
		}
		if(gender.equals(Gender.����))
		{
			if(calculate()<17.96)
				System.out.println("	��ü���Դϴ�");
			if(calculate()>=23.98)
				System.out.println("	��ü���Դϴ�");
			else
				System.out.println("	����ü���Դϴ�");
		}
	}

	@Override
	public String toString() {
		return "BMI"+","+gender+","+height+","+weight+","+calculate();
	}
	
	
}
