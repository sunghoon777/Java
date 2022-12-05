import java.util.Comparator;
import java.util.List;

public class BMIIndexComparator implements Comparator<BMICalculator> {

	@Override
	public int compare(BMICalculator p , BMICalculator q) {
		return p.getBmi().compareTo(q.getBmi());
	}

}
