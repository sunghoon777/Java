import java.util.Comparator;
import java.util.Objects;

public class Person implements Comparable<Person> {
    protected int age;
    protected Gender gender;
    protected double weight; // (kg)
    protected double height; // (cm)
    protected double neck; // (cm)
    protected double waist; // (cm)
    protected double hip; // (cm)
    protected Activity activity;
    
    public Person() { 
    	this(0, null, 0.0, 0.0, 0.0, 0.0, 0.0, null); 
	}
    
    public Person(Person other) {
		this(other.age, other.gender, other.weight, other.height, other.neck, other.waist, other.hip, other.activity);
    }
    
    public Person(int age, Gender gender, double weight, double height, double neck, double waist, double hip, Activity activity) {
        this.age = age;
        this.gender = gender;
        this.weight = weight;
        this.height = height;
        this.neck = neck;
        this.waist = waist;
        this.hip = hip;
        this.activity = activity;
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

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
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

	public Activity getActivity() {
		return activity;
	}

	public void setActivity(Activity activity) {
		this.activity = activity;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(age,gender,weight,height,gender);
	}

	@Override
	public boolean equals(Object other) {
		if(this==other) return true;
		else if(other instanceof Person)
		{
			Person that = (Person)other;
			return this.age==that.age&&this.gender==that.gender
					&&this.weight==that.weight&&
					this.height==that.height&&this.neck==that.neck
					&&this.waist==that.waist&&this.hip==that.hip&&
					this.activity==that.activity;
		}
		else
			return false;
	}

	@Override
	public String toString() {
		return "Person," + age + "," + gender + "," + weight + "," + height + "," + neck + "," + waist + "," + hip + "," + activity;
	}

	@Override
	public int compareTo(Person other) {
		return this.age - other.age;
	}
}

class AgeComparator implements Comparator<Person> {
	public int compare(Person p1, Person p2) {
		//ascending order
		return p1.age - p2.age;	
		//descending order
		//return p2.age - p1.age;
	}
}

class GenderComparator implements Comparator<Person> {
	public int compare(Person p1, Person p2) {
		return p1.gender.compareTo(p2.gender);	
	}
}

class WeightComparator implements Comparator<Person> {
	public int compare(Person p1, Person p2) {
		return Double.compare(p1.weight, p2.weight);	
	}
}

class HeightComparator implements Comparator<Person> {
	public int compare(Person p1, Person p2) {
		return Double.compare(p1.height, p2.height);
	}
}

class NeckComparator implements Comparator<Person> {
	public int compare(Person p1, Person p2) {
		return Double.compare(p1.neck, p2.neck);
	}
}

class WaistComparator implements Comparator<Person> {
	public int compare(Person p1, Person p2) {
		return Double.compare(p1.waist, p2.waist);
	}
}

class HipComparator implements Comparator<Person> {
	public int compare(Person p1, Person p2) {
		return Double.compare(p1.hip, p2.hip);
	}
}

class ActivityComparator implements Comparator<Person> {
	public int compare(Person p1, Person p2) {
		return p1.activity.compareTo(p2.activity);	
	}
}

