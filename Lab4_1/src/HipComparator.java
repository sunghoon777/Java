import java.util.Comparator;

public class HipComparator implements Comparator<Person> {

	@Override
	public int compare(Person p, Person q) {
		
		return Double.compare(p.getHip(), q.getHip());
	}

}
