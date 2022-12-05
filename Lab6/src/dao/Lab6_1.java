package dao;

import java.util.List;
import java.util.Scanner;

import dto.BFPCalculator;
import dto.BMICalculator;
import dto.BMRCalculator;
import dto.CICalculator;
import dto.Person;

// 32163219 이성훈
public class Lab6_1 {
	
	public static Scanner scan = new Scanner(System.in);
	
	public static void bfp() {
		Parser parser = new BFPCalculatorParser();
		DataImporter importer = new DataImporter(parser);
		List<BFPCalculator> list = null;
		//load file
		list = importer.loadCSV("bfptest.csv");
		Manager manager = new Manager(parser);
		//manager에 list 추가 
		manager.addList(list);
		// predicate height가 175 이상인 것만 걸러내어 list에 넣음
		manager.getListBy((p) -> {return ((BFPCalculator) p).getHeight()>=175;});
		// index 값의 따라 sort
		manager.sort((p,q)->{return Double.compare(((BFPCalculator)p).getIndex(), ((BFPCalculator)q).getIndex());});
		//skip 5 limit 10
		manager.skip(5);
		manager.limit(10);
		//save file
		importer.saveCSV("저장.csv", manager.getList());
	}
	
	public static void bmi() {
		Parser parser = new BMICalculatorParser();
		DataImporter importer = new DataImporter(parser);
		List<BMICalculator> list = null;
		//load file
		list = importer.loadCSV("bmitest.csv");
		Manager manager = new Manager(parser);
		//manager에 list 추가 
		manager.addList(list);
		// predicate height가 175 이상인 것만 걸러내어 list에 넣음
		manager.getListBy((p) -> {return ((BMICalculator) p).getHeight()>=175;});
		// index 값의 따라 sort
		manager.sort((p,q)->{return Double.compare(((BMICalculator)p).getIndex(), ((BMICalculator)q).getIndex());});
		//skip 5 limit 10
		manager.skip(5);
		manager.limit(10);
		//save file
		importer.saveCSV("저장.csv", manager.getList());
	}
	
	public static void bmr() {
		Parser parser = new BMRCalculatorParser();
		DataImporter importer = new DataImporter(parser);
		List<BMRCalculator> list = null;
		//load file
		list = importer.loadCSV("bmrtest.csv");
		Manager manager = new Manager(parser);
		//manager에 list 추가
		manager.addList(list);
		// predicate height가 175 이상인 것만 걸러내어 list에 넣음
		manager.getListBy((p) -> {return ((BMRCalculator) p).getHeight()>=175;});
		// index 값의 따라 sort
		manager.sort((p,q)->{return Double.compare(((BMRCalculator)p).getIndex(), ((BMRCalculator)q).getIndex());});
		//skip 5 limit 10
		manager.skip(5);
		manager.limit(10);
		//save file
		importer.saveCSV("저장.csv", manager.getList());
	}
	
	public static void ci() {
		Parser parser = new CICalculatorParser();
		DataImporter importer = new DataImporter(parser);
		List<CICalculator> list = null;
		//load file
		list = importer.loadCSV("citest.csv");
		Manager manager = new Manager(parser);
		//manager에 list 추가
		manager.addList(list);
		// predicate height가 175 이상인 것만 걸러내어 list에 넣음
		manager.getListBy((p) -> {return ((CICalculator) p).getHeight()>=175;});
		// index 값의 따라 sort
		manager.sort((p,q)->{return Double.compare(((CICalculator)p).getIndex(), ((CICalculator)q).getIndex());});
		//skip 5 limit 10
		manager.skip(5);
		manager.limit(10);
		//save file
		importer.saveCSV("저장.csv", manager.getList());
	}


	public static void main(String[] args) {
		// bfp bmi bmr ci 중 어떤 파일을 load 할지 선택
		System.out.println("1. bfp 2. bmi 3. bmr 4. ci ");
		int a = scan.nextInt();
		if(a==1)
			bfp();
		else if(a==2)
			bmi();
		else if(a==3)
			bmr();
		else if(a==4)
			ci();
	}
}
