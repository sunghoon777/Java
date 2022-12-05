import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Lab4_1 {
	
	public static Scanner scan = new Scanner(System.in);
	public static PersonManager manage =new PersonManager();
	
	public static void printchart(List<Person> list) {
		for(int i=0;i<list.size();i++) {
			System.out.println(list.get(i).toString());
		}
		System.out.println("1. 저장 2. X");
		int a = scan.nextInt();
		if(a==1)
			PersonImporter.saveCSV("저장.csv", list);
	}
	
	public static Person InputData(){
		System.out.println("데이터 생성");
		System.out.println("나이,성별,몸무게,키,목,허리,엉덩이,활동량");
		String data = scan.next();
		String[] array = data.split(",");
		int age = Integer.parseInt(array[0]);
		Gender gender = Gender.valueOf(array[1]);
		double weight = Double.parseDouble(array[2]);
		double height = Double.parseDouble(array[3]);
		double neck = Double.parseDouble(array[4]);
		double waist = Double.parseDouble(array[5]);
		double hip = Double.parseDouble(array[6]);
		Activity activity = Activity.valueOf(array[7]);
		return new Person(age,gender,weight,height,neck, waist,hip,activity);
		
	}
	
	public static void ManageList(List<Person> list) {
		PersonManager manage = new PersonManager();
		manage.data=list;
		System.out.println("1.데이터 추가 2.데이터 삭제 3.데이터 교체  4.모든 요소 삭제");
		int a=scan.nextInt();
		Person person=null;
		Person person2=null;
		switch(a)
		{
		case 1:
			person = InputData();
			manage.add(person);
		break;
		case 2: 
			person = InputData();
			manage.remove(person);
		break;
		case 3: 
			System.out.println("기존 데이터");
			person = InputData();
			System.out.println("새 데이터");
			person2 = InputData();
			manage.replace(person, person2);
		break;
		case 4:
		    manage.removeAll();
		break;
		default :
		break;
		}
		if(a!=4)
		{
			for(int i=0;i<list.size();i++)
			{
				System.out.println(list.get(i).toString());
			}
		}
		else
		{
			System.out.println("요소가 제거됨");
		}
		
	}
	
	public static List<BMICalculator> BMI(List<Person> list){
		List<BMICalculator> bmi= new ArrayList<BMICalculator>();
		for(int i=0;i<list.size();i++) {
			int age = list.get(i).age;
			Gender gender = list.get(i).gender;
			double height = list.get(i).height;
			double weight = list.get(i).weight;
			double neck = list.get(i).neck;
			double waist = list.get(i).waist;
			double hip = list.get(i).hip;
			Activity activity = list.get(i).activity;
			bmi.add(new BMICalculator(age,gender,weight,height,neck, waist,hip,activity));
			bmi.get(i).index=bmi.get(i).getIndex();
			bmi.get(i).bmi=bmi.get(i).getBmi();
		}
		return bmi;
	}
	
	public static void Sort(List<Person> list){
		List<BMICalculator> bmi = BMI(list);	
		Sort sort=null;
		System.out.println("정렬 기준 선택");
		System.out.println("1. 나이 2. 성별  3. 키  4 .몸무게  5. 목  6. 허리둘레  7. 엉덩이둘레  8. 활동량 9. BMI결과값 10.BMI지수 ");
		int a =scan.nextInt();
		switch(a) {
		case 1: 
			sort = new Sort(new AgeComparator());
			sort.bubbleSort1(list);
			break;
		case 2:
			sort = new Sort(new GenderComparator());
			sort.bubbleSort1(list);
			break;
		case 3:
		    sort = new Sort(new WeightComparator());
			sort.bubbleSort1(list);
			break;
		case 4:
			sort = new Sort(new HeightComparator());
			sort.bubbleSort1(list);
			break;
		case 5:
			sort = new Sort(new NeckComparator());
			sort.bubbleSort1(list);
			break;
		case 6:
			sort = new Sort(new WaistComparator());
			sort.bubbleSort1(list);
			break;
		case 7:
			sort = new Sort(new  HipComparator());
			sort.bubbleSort1(list);
			break;
		case 8:
			sort = new Sort(new ActivityComparator());
			sort.bubbleSort1(list);
			break;
		case 9:
			sort = new Sort(new BMIComparator());
			sort.bubbleSort2(bmi);
			break;
		case 10:
			sort = new Sort(new BMIIndexComparator());
			sort.bubbleSort2(bmi);
			break;
		default : break;
		}
		if(a==9||a==10)
		{
		for(int i=0;i<bmi.size();i++)
		{
			System.out.println(bmi.get(i).toString());
		}
		}
		else
		{
			for(int i=0;i<list.size();i++)
			{
				System.out.println(list.get(i).toString());
			}
		}
	}

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("파일 읽기");
		List<Person> list = PersonImporter.loadCSV("people.csv");
		
		System.out.println("1. 출력  2. X");
		int a = scan.nextInt();
		if(a==1)
			printchart(list);
		System.out.println("1. list 변경  2. X");
		a = scan.nextInt();
		if(a==1)
			ManageList(list);
		System.out.println("1. 정렬 2. X");
		a = scan.nextInt();
		if(a==1)
			Sort(list);
	}
}
