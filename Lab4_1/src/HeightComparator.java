import java.util.Comparator;

public class HeightComparator implements Comparator<Person> {

	@Override
	public int compare(Person p, Person q) {
		// TODO Auto-generated method stub
		return Double.compare(p.getHeight(), q.getHeight());
	}

}
