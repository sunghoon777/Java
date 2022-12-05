import java.util.Comparator;

public class WeightComparator implements Comparator<Person> {

	@Override
	public int compare(Person p, Person q) {
	
		return Double.compare(p.getWeight(), q.getWeight());
	}

}
