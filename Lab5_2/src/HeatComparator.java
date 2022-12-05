import java.util.Comparator;

public class HeatComparator implements Comparator<HeatIndexCalculator> {
	
	@Override
	public int compare(HeatIndexCalculator p, HeatIndexCalculator q) {
		return Double.compare(p.calculate(),q.calculate() );
	}

}
