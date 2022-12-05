import java.util.Comparator;

public class HeatIndexComparator implements Comparator<HeatIndexCalculator> {

	@Override
	public int compare(HeatIndexCalculator p, HeatIndexCalculator q) {
		return p.getIndex().compareTo(q.getIndex());
	}

	

}
