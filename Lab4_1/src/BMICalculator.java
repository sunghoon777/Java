import java.util.Comparator;

public class BMICalculator extends Person {
	double index=0;
	BMI bmi=null;
	
	public BMICalculator(int age, Gender gender, double weight, double height, double neck, double waist, double hip,
			Activity activity) {
		super(age,gender,weight,height,neck, waist,hip,activity);
	}
	
	public BMICalculator(double index, BMI bmi) {
		super();
		this.index = index;
		this.bmi = bmi;
	}
	
	public BMICalculator() {
		this(0,null);
	}
	
	public static double calculate(double weight, double height) {
		return weight / (height * 0.01) / (height * 0.01);
	}
	
	public double getIndex() {
		return calculate(weight, height);
	}
	public void setIndex(double index) {
		this.index = index;
	}
	public BMI getBmi() {
		return bmi.getIndex(getIndex()); 
	}
	public void setBmi(BMI bmi) {
		this.bmi = bmi;
	}
	
    
	@Override
	public String toString() {
		return "BMICalculator"+","+index+","+bmi;
	}
}
