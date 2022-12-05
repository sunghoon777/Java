package dto;

import java.util.Objects;

public class BMRCalculator extends Person implements HealthCalculator {
	
	BMRCalculator bmrCalculator = null;
	double index;
	
	public BMRCalculator(int age, Gender gender, double weight, double height, double index) {
		this.age = age;
		this.gender = gender;
		this.weight = weight;
		this.height = height;
		this.index = index;
	}
	
	public BMRCalculator() {
		
	}

	public BMRCalculator getBmrCalculator() {
		return bmrCalculator;
	}
	
	public void setBmrCalculator(BMRCalculator bmrCalculator) {
		this.bmrCalculator = bmrCalculator;
	}
	
	// 인덱스를 계산하는 메소드
	public double getIndex() {
		if(this.gender==Gender.MALE)
		{
			return 66.4730 + (13.7516 * getWeight()) + (5.0033 * height) - (6.7550 * getAge());
		}
		else
		{
			return 655.0955 + (9.5634 * getWeight()) + (1.8496 * height) - (4.6756 * getAge());
		}	
	}
	
	public void setIndex(double index) {
		this.index = index;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(age,gender,weight, height, index);
	}

	@Override
	public boolean equals(Object other) {
		if(this==other) return true;
		else if(other instanceof BMRCalculator)
		{
			BMRCalculator that = (BMRCalculator)other;
			return  this.age==that.age&&this.gender==that.gender&&this.height==that.height&&this.weight==that.weight
					&&this.index==that.index;
		}
		else
			return false;
	}

	@Override
	public String toString() {
		return "BMRCalculator,"+age+","+gender+","+weight+","+height+","+index;
	}
	
	
	
}
