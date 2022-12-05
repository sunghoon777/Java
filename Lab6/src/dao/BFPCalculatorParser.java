package dao;

import dto.Activity;
import dto.BFPCalculator;
import dto.BMI;
import dto.Gender;

public class BFPCalculatorParser implements Parser<BFPCalculator> {


	@Override
	public BFPCalculator parse(String[] items) {
     	Gender gender = Gender.valueOf(items[1]);
     	double height = Double.parseDouble(items[2]);
     	double neck = Double.parseDouble(items[3]);
     	double waist = Double.parseDouble(items[4]);
     	double hip = Double.parseDouble(items[5]);
     	double index = Double.parseDouble(items[6]);
		return new BFPCalculator(gender, height, neck, waist, hip, index);
	}
}
