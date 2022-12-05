import java.util.Comparator;

public class NeckComparator implements Comparator<Person>{

	@Override
	public int compare(Person p, Person q) {
		return Double.compare(p.getNeck(), q.getNeck());
	}

}
