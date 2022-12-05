import java.util.Comparator;
import java.util.Objects;

public class Person implements Comparable<Person> {
    int age;
    Gender gender;
    double weight;
    double height;
    double neck;
    double waist;
    double hip;
    Activity activity;
    
	public Person(int age, Gender gender, double weight, double height, double neck, double waist, double hip,
			Activity activity) {
		super();
		this.age = age;
		this.gender = gender;
		this.weight = weight;
		this.height = height;
		this.neck = neck;
		this.waist = waist;
		this.hip = hip;
		this.activity = activity;
	}
	
	public Person() {
		this(0,null,0,0,0,0,0,null);
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
	public String toString() {
		return "Person"+","+age+","+gender+","+weight+","+height+","+neck+","+waist+","+hip+","+activity+",";
	}

	@Override
	public int compareTo(Person other) {
		return this.age-other.age;
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
	
}
