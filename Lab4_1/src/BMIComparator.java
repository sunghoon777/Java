import java.util.Comparator;

public class BMIComparator implements Comparator<BMICalculator> {

	@Override
	public int compare(BMICalculator p, BMICalculator q) {
		return Double.compare(p.getIndex(), q.getIndex());
	}

}
