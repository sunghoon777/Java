import java.util.Comparator;
import java.util.Objects;

// Class: BMICalculator
public class BMICalculator extends Person {
	double index = 0.0;
	BMI bmi = null;
	
	public BMICalculator() {
		this(0, null, 0.0, 0.0, 0.0, 0.0, 0.0, null);
	}
	
    public BMICalculator(Person other) {
		super(other);
		index = getIndex();
		bmi = getBMI();
    }
    
	public BMICalculator(int age, Gender gender, double weight, double height, double neck, double waist, double hip, Activity activity) {
		super(age, gender, weight, height, neck, waist, hip, activity);
		index = getIndex();
		bmi = getBMI();
	}
	
	public BMICalculator(double weight, double height) {
		this(0, null, weight, height, 0.0, 0.0, 0.0, null);
    }

	public BMICalculator(double weight, double height, double index, BMI bmi) {
		super(0, null, weight, height, 0.0, 0.0, 0.0, null);
		this.index = index;
		this.bmi = bmi;
    }

	// https://bmi-calories.com/bmi-calculator.html
    public static double calculate(double weight, double height) {
        return weight / (height * 0.01) / (height * 0.01);	    	
    }
    
	public double getIndex() {
        return calculate(weight, height);	
    }

    public BMI getBMI() {
    	return BMI.getIndex(getIndex());
    }
    
	public void setBmi() {
		this.bmi = BMI.getIndex(index);
	}

	public void setIndex(double index) {
		this.index = calculate(weight, height);
	}

	public void printTable() {
        // weight (kg)
		System.out.printf("\t");
        for (int weight = 40; weight <= 130; weight += 5) {
            System.out.printf("%d\t", weight);
        }
        System.out.println();

        // height (cm)
        for (double height = 142.2; height <= 212.2; height += 2.5) {
            System.out.printf("%.1f\t", height);
            // weight (kg)
            for (int weight = 40; weight <= 130; weight += 5) {
                System.out.printf("%.1f\t", calculate(height, weight));
            }
            System.out.println();
        }
        System.out.println();
	}
	
	@Override 
	public String toString() { 
		return "BMICalculator," + weight + "," + height + "," + index + "," + bmi; 
	}

	@Override
	public int hashCode() {
		return Objects.hash(index,bmi);
	}
	
	@Override
	public boolean equals(Object other) {
		if(this==other) return true;
		else if(other instanceof Person)
		{
			BMICalculator that = (BMICalculator)other;
			return this.index==that.index&&this.bmi==that.bmi;			
		}
		else
			return false;
	}
}

class BMIIndexComparator implements Comparator<BMICalculator> {
	public int compare(BMICalculator p1, BMICalculator p2) {
		return Double.compare(p1.index, p2.index);	// index
	}
}

class BMIComparator implements Comparator<BMICalculator> {
	public int compare(BMICalculator p1, BMICalculator p2) {
		return p1.bmi.compareTo(p2.bmi);	// BMI
	}
}