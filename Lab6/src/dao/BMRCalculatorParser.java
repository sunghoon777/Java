package dao;

import dto.BMRCalculator;
import dto.Gender;

public class BMRCalculatorParser implements Parser<BMRCalculator>  {

	@Override
	public BMRCalculator parse(String[] items) {
		int age =  Integer.parseInt(items[1]);
		Gender gender = Gender.valueOf(items[2]);
     	double weight = Double.parseDouble(items[3]);
     	double height = Double.parseDouble(items[4]);
     	double index = Double.parseDouble(items[5]);
		return new  BMRCalculator(age, gender, weight, height, index);
	}

}
