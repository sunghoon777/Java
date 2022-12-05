import java.util.Comparator;

public class ActivityComparator implements Comparator<Person> {

	@Override
	public int compare(Person p, Person q) {
		return p.getActivity().compareTo(q.getActivity());
	}
	
	

}
