import java.util.Comparator;

public class AgeComparator implements Comparator<Person> {

	@Override
	public int compare(Person p, Person q) {
		// TODO Auto-generated method stub
		return p.getAge() - q.getAge(); 
	}

}
