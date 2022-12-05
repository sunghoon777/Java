package dto;

import java.util.Objects;

public class CICalculator extends Person implements HealthCalculator{
	
	CICalculator ciCalculator = null;
	double index;
	
	public CICalculator(int age, Gender gender, double weight,double height, Activity activity , double index) {
		this.age = age;
		this.gender = gender;
		this.weight = weight;
		this.height = height;
		this.activity= activity;
		this.index = index;
	}

	public CICalculator getCiCalculator() {
		return ciCalculator;
	}
	
	public void setCiCalculator(CICalculator ciCalculator) {
		this.ciCalculator = ciCalculator;
	}
	
	public Activity getActivity() {
		return activity;
	}
	
	public void setActivity(Activity activity) {
		this.activity = activity;
	}
	// 인덱스를 계산하는 메소드
	public double getIndex() {
		if(this.gender.equals(Gender.MALE))
		{
			return 66.4730 + (13.7516 * getWeight()) + (5.0033 * height) - (6.7550 * getAge());
		}
		else
		{
			return  655.0955 + (9.5634 * getWeight()) + (1.8496 * height) - (4.6756 * getAge()); 
		}
	}
	
	public void setIndex(double index) {
		this.index = index;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(age,gender,weight, height, activity,index);
	}

	@Override
	public boolean equals(Object other) {
		if(this==other) return true;
		else if(other instanceof CICalculator)
		{
			CICalculator that = (CICalculator)other;
			return  this.age==that.age&&this.gender==that.gender&&this.height==that.height&&this.weight==that.weight
					&&this.index==that.index&&this.activity==that.activity;
		}
		else
			return false;
	}

	@Override
	public String toString() {
		return "CICalculator,"+age+","+gender+","+weight+","+height+","+activity+","+index;
	}
	
	
	

}
