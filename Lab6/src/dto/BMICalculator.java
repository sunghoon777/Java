package dto;

import java.util.Objects;

public class BMICalculator extends Person implements HealthCalculator  {
	
	BMICalculator bmiCalculator = null;
	double index=0;
	BMI bmi=null;
	
	
	
	
	public BMICalculator(double weight, double height, double index, BMI bmi) {
		this.height = height;
		this.weight = weight;
		this.index = index;
		this.bmi = bmi;
	}
	
	public BMICalculator() {
		
	}

	public BMICalculator getBmiCalculator() {
		return bmiCalculator;
	}
	
	public void setBmiCalculator(BMICalculator bmiCalculator) {
		this.bmiCalculator = bmiCalculator;
	}
	// 인덱스를 계산하는 메소드
	public double getIndex() {
		return getWeight()/(getHeight()*getHeight());
	}
	
	public void setIndex(double index) {
		this.index = index;
	}
	
	public BMI getBmi() {
		return bmi;
	}
	
	public void setBmi(BMI bmi) {
		this.bmi = bmi;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(weight, height, index, bmi);
	}

	@Override
	public boolean equals(Object other) {
		if(this==other) return true;
		else if(other instanceof BMICalculator)
		{
			BMICalculator that = (BMICalculator)other;
			return  this.height==that.height&&this.weight==that.weight
					&&this.index==that.index&&this.bmi==that.bmi;
		}
		else
			return false;
	}

	@Override
	public String toString() {
		return "BMICalculator,"+weight+","+height+","+index+","+bmi;
	}
	
	
	
}
