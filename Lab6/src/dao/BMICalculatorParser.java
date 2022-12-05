package dao;
import dto.*;

public class BMICalculatorParser  implements Parser<BMICalculator> {

	@Override
	public BMICalculator parse(String[] items) {
     	double weight = Double.parseDouble(items[1]);
     	double height = Double.parseDouble(items[2]);
        double index = Double.parseDouble(items[3]);
        BMI bmi = BMI.valueOf(items[4]);
		return new  BMICalculator(weight, height, index, bmi);
	}

}
