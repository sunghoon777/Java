package dao;

import java.util.List;
import java.util.Scanner;

import dto.BFPCalculator;
import dto.BMICalculator;
import dto.BMRCalculator;
import dto.CICalculator;
import dto.Person;

// 32163219 �̼���
public class Lab6_1 {
	
	public static Scanner scan = new Scanner(System.in);
	
	public static void bfp() {
		Parser parser = new BFPCalculatorParser();
		DataImporter importer = new DataImporter(parser);
		List<BFPCalculator> list = null;
		//load file
		list = importer.loadCSV("bfptest.csv");
		Manager manager = new Manager(parser);
		//manager�� list �߰� 
		manager.addList(list);
		// predicate height�� 175 �̻��� �͸� �ɷ����� list�� ����
		manager.getListBy((p) -> {return ((BFPCalculator) p).getHeight()>=175;});
		// index ���� ���� sort
		manager.sort((p,q)->{return Double.compare(((BFPCalculator)p).getIndex(), ((BFPCalculator)q).getIndex());});
		//skip 5 limit 10
		manager.skip(5);
		manager.limit(10);
		//save file
		importer.saveCSV("����.csv", manager.getList());
	}
	
	public static void bmi() {
		Parser parser = new BMICalculatorParser();
		DataImporter importer = new DataImporter(parser);
		List<BMICalculator> list = null;
		//load file
		list = importer.loadCSV("bmitest.csv");
		Manager manager = new Manager(parser);
		//manager�� list �߰� 
		manager.addList(list);
		// predicate height�� 175 �̻��� �͸� �ɷ����� list�� ����
		manager.getListBy((p) -> {return ((BMICalculator) p).getHeight()>=175;});
		// index ���� ���� sort
		manager.sort((p,q)->{return Double.compare(((BMICalculator)p).getIndex(), ((BMICalculator)q).getIndex());});
		//skip 5 limit 10
		manager.skip(5);
		manager.limit(10);
		//save file
		importer.saveCSV("����.csv", manager.getList());
	}
	
	public static void bmr() {
		Parser parser = new BMRCalculatorParser();
		DataImporter importer = new DataImporter(parser);
		List<BMRCalculator> list = null;
		//load file
		list = importer.loadCSV("bmrtest.csv");
		Manager manager = new Manager(parser);
		//manager�� list �߰�
		manager.addList(list);
		// predicate height�� 175 �̻��� �͸� �ɷ����� list�� ����
		manager.getListBy((p) -> {return ((BMRCalculator) p).getHeight()>=175;});
		// index ���� ���� sort
		manager.sort((p,q)->{return Double.compare(((BMRCalculator)p).getIndex(), ((BMRCalculator)q).getIndex());});
		//skip 5 limit 10
		manager.skip(5);
		manager.limit(10);
		//save file
		importer.saveCSV("����.csv", manager.getList());
	}
	
	public static void ci() {
		Parser parser = new CICalculatorParser();
		DataImporter importer = new DataImporter(parser);
		List<CICalculator> list = null;
		//load file
		list = importer.loadCSV("citest.csv");
		Manager manager = new Manager(parser);
		//manager�� list �߰�
		manager.addList(list);
		// predicate height�� 175 �̻��� �͸� �ɷ����� list�� ����
		manager.getListBy((p) -> {return ((CICalculator) p).getHeight()>=175;});
		// index ���� ���� sort
		manager.sort((p,q)->{return Double.compare(((CICalculator)p).getIndex(), ((CICalculator)q).getIndex());});
		//skip 5 limit 10
		manager.skip(5);
		manager.limit(10);
		//save file
		importer.saveCSV("����.csv", manager.getList());
	}


	public static void main(String[] args) {
		// bfp bmi bmr ci �� � ������ load ���� ����
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
