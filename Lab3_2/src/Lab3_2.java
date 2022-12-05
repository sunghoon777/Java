import java.util.Scanner;

public class Lab3_2 {
	public static Scanner scan = new Scanner(System.in);
	public static Inbody bmr = new BMR();
	public static Inbody bmi = new BMI();
	//파일의 데이터들을 출력하는 메소드
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
	    	System.out.println("나이  "+bmrcal[i].age+" 성별  "+bmrcal[i].gender+" 몸무게  "+bmrcal[i].weight+" 키 "+bmrcal[i].height+" BMI "+bmical[i].calculate()+" BMR "+bmrcal[i].calculate());
	    }
	    //사용자가  value를 저장할지 결정
		System.out.println("1. BMI 저장 2. BMR 저장  3. 저장 x");
		int a = scan.nextInt();
		if(a==1)
			save(bmical);
		else if(a==2)
			save(bmrcal);
	}
	//데이터 저장 메소드
	public static void save(Inbody[] a) {
		InbodyDataImporter.saveCSV("저장1", a);
		
	}

	public static void main(String[] args) {
		System.out.println("1. 파일 데이터 출력 2. 넘어간다");
		int choose = scan.nextInt();
		if(choose==1)
		{
		Inbody[] data =  InbodyDataImporter.loadCSV("인바디.csv");
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
			System.out.println("잘못입력하셨습니다");
			continue;
		}
		System.out.println("더 게산하기 원하시면 q를 누르세요");
		String more = scan.next();
		if(more.equals("q"))
			continue;
		else
			break;
		
		}
	}
}
