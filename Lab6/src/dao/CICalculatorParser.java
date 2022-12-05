package dao;

import dto.*;


public class CICalculatorParser  implements Parser<CICalculator> {

	@Override
	public CICalculator parse(String[] items) {
		int age =  Integer.parseInt(items[1]);
		Gender gender = Gender.valueOf(items[2]);
     	double weight = Double.parseDouble(items[3]);
     	double height = Double.parseDouble(items[4]);
     	Activity activity = Activity.valueOf(items[5]);
     	double index = Double.parseDouble(items[6]);
		return new CICalculator(age, gender, weight, height, activity, index);
	}

}
