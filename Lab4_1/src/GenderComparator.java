import java.util.Comparator;

public class GenderComparator implements Comparator<Person> {

	@Override
	public int compare(Person p, Person q) {
		return p.getGender().compareTo(q.getGender());
	}

}
