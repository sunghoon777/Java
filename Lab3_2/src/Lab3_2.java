import java.util.Scanner;

public class Lab3_2 {
	public static Scanner scan = new Scanner(System.in);
	public static Inbody bmr = new BMR();
	public static Inbody bmi = new BMI();
	//������ �����͵��� ����ϴ� �޼ҵ�
	public static void printChart(Inbody[] data) {
	    Inbody[] bmical = new BMI[data.length];
	    Inbody[] bmrcal = new BMR[data.length];
	    double age,weight,height;
	    Gender gender;
	    
	    for(int i=0;i<data.length;i++)
	    {
	    	gender = data[i].gender;
	    	age = data[i].age;
	    	weight = data[i].weight;
	    	height = data[i].height;
	    	bmical[i] = new BMI(weight, height, gender);
	    	bmrcal[i] = new BMR(weight, height,  age,  gender);
	    	System.out.println("����  "+bmrcal[i].age+" ����  "+bmrcal[i].gender+" ������  "+bmrcal[i].weight+" Ű "+bmrcal[i].height+" BMI "+bmical[i].calculate()+" BMR "+bmrcal[i].calculate());
	    }
	    //����ڰ�  value�� �������� ����
		System.out.println("1. BMI ���� 2. BMR ����  3. ���� x");
		int a = scan.nextInt();
		if(a==1)
			save(bmical);
		else if(a==2)
			save(bmrcal);
	}
	//������ ���� �޼ҵ�
	public static void save(Inbody[] a) {
		InbodyDataImporter.saveCSV("����1", a);
		
	}

	public static void main(String[] args) {
		System.out.println("1. ���� ������ ��� 2. �Ѿ��");
		int choose = scan.nextInt();
		if(choose==1)
		{
		Inbody[] data =  InbodyDataImporter.loadCSV("�ιٵ�.csv");
		printChart(data);
		}
		while(true) {
		System.out.println("1. BMR  2.  BMI");
		choose = scan.nextInt();
		if(choose==1)
		{
			bmr.userInput();
			System.out.println("bmr	"+bmr.calculate());
		}
		else if(choose==2)
		{
			bmi.calculate();
			System.out.println("bmi	"+bmi.calculate());
			bmi.yourStatus();
		}
		else
		{
			System.out.println("�߸��Է��ϼ̽��ϴ�");
			continue;
		}
		System.out.println("�� �Ի��ϱ� ���Ͻø� q�� ��������");
		String more = scan.next();
		if(more.equals("q"))
			continue;
		else
			break;
		
		}
	}
}
