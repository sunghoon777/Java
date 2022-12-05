package dto;

import java.util.Objects;

public class Person {
	
	protected int age;
	protected Gender gender;
	protected double height; // (kg)
	protected double weight; // (cm)
	protected double neck; // (cm)
	protected double waist; // (cm)
    protected double hip; // (cm)
    protected Activity activity;
    
    
    
	public Person(int age, Gender gender, double height, double weight, double neck, double waist,
			double hip, Activity activity) {
		this.age = age;
		this.gender = gender;
		this.height = height;
		this.weight = weight;
		this.neck = neck;
		this.waist = waist;
		this.hip = hip;
		this.activity = activity;
	}
	
	public Person() {
		
	}
	
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Gender getGender() {
		return gender;
	}
	public void setGender(Gender gender) {
		this.gender = gender;
	}
	public double getHeight() {
		return height;
	}
	public void setHeight(double height) {
		this.height = height;
	}
	public double getWeight() {
		return weight*0.01;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	public double getNeck() {
		return neck;
	}
	public void setNeck(double neck) {
		this.neck = neck;
	}
	public double getWaist() {
		return waist;
	}
	public void setWaist(double waist) {
		this.waist = waist;
	}
	public double getHip() {
		return hip;
	}
	public void setHip(double hip) {
		this.hip = hip;
	}
    
	@Override
	public int hashCode() {
		return Objects.hash(age,gender,weight,height,neck,waist,hip);
	}

	@Override
	public boolean equals(Object other) {
		if(this==other) return true;
		else if(other instanceof Person)
		{
			Person that = (Person)other;
			return  this.age==that.age&&this.gender==that.gender
					&&this.weight==that.weight&&
					this.height==that.height&&this.neck==that.neck
					&&this.waist==that.waist&&this.hip==that.hip;
					
		}
		else
			return false;
	}
	
	@Override
	public String toString() {
		return "Person," + age + "," + gender + "," + height + ","
				+ weight + "," + neck + "," + waist + "," + hip+","+activity;
	}
	
	

}
