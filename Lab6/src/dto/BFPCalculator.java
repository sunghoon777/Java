package dto;

import java.util.Objects;

public class BFPCalculator extends Person implements HealthCalculator  {
	
	/*
	 Body Fat (women) = 495 / (1.29579 - .35004 * log10(Waist + Hip - Neck) + 0.22100 * log10(Height)) - 450
     Body Fat (men) = 495 / (1.29579 - .35004 * log10(Waist - Neck) + 0.22100 * log10(Height)) - 450
	 */
	
	BFPCalculator bfpCalculator = null;
	double index;
	
	public BFPCalculator(Gender gender, double height, double neck, double waist,
			double hip, double index) {
		this.gender = gender;
		this.height = height;
		this.neck = neck;
		this.waist = waist;
		this.hip = hip;
		this.index = index;
	}
	
	public BFPCalculator() {
		
	}
	

	public BFPCalculator getBfpCalculator() {
		return bfpCalculator;
	}
	
	public void setBfpCalculator(BFPCalculator bfpCalculator) {
		this.bfpCalculator = bfpCalculator;
	}
	// 인덱스를 계산하는 메소드
	public double getIndex() {
		if(this.gender==Gender.MALE)
		{
			return 495 / (1.29579 - .35004 * Math.log10(getWaist() - getNeck()) + 0.22100 * Math.log10(getHeight())) - 450;
		}
		else
		{
			return 495 / (1.29579 - .35004 * Math.log10(getWaist() + getHip() - getNeck()) + 0.22100 * Math.log10(getHeight())) - 450;
		}
	}
	
	public void setIndex(double index) {
		this.index = index;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(gender,height,neck,waist,hip,index);
	}

	@Override
	public boolean equals(Object other) {
		if(this==other) return true;
		else if(other instanceof BFPCalculator)
		{
			BFPCalculator that = (BFPCalculator)other;
			return  this.gender==that.gender&&this.height==that.height&&this.neck==that.neck
					&&this.waist==that.waist&&this.hip==that.hip&&this.index==that.index;	
		}
		else
			return false;
	}

	@Override
	public String toString() {
		return "BFPCalculator,"+gender+","+height+","+neck+","+waist+","+hip+","+index;
	}
	
	
	
}
