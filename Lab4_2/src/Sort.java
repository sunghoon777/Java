import java.util.Comparator;
import java.util.List;

public class Sort {
	
   Comparator comparator = null;
	   
	public Sort(Comparator comparator) {
	
	this.comparator = comparator;
	}
	
	public void bubbleSort1(List<WeatherData> Ldata) {
		Object[] data = Ldata.toArray();
		Object temp = null;
		for (int i = 0; i < data.length - 1; i++)
		{
			for (int j = 0; j < data.length - 1; j++)
			{
		
				if (comparator.compare(data[j], data[j + 1]) > 0)
				{ // strategy pattern
					temp = data[j];
					data[j] = data[j + 1];
					data[j + 1] = temp;
				}
			}
		}
		Ldata.clear();
		for(int i=0;i<data.length;i++) {
			Ldata.add((WeatherData)data[i]);
		}
	}
	
	public void bubbleSort2(List<HeatIndexCalculator> Ldata) {
		Object[] data = Ldata.toArray();
		Object temp = null;
		for (int i = 0; i < data.length - 1; i++)
		{
			for (int j = 0; j < data.length - 1; j++)
			{
		
				if (comparator.compare(data[j], data[j + 1]) > 0)
				{ // strategy pattern
					temp = data[j];
					data[j] = data[j + 1];
					data[j + 1] = temp;
				}
			}
		}
		Ldata.clear();
		for(int i=0;i<data.length;i++) {
			Ldata.add((HeatIndexCalculator) data[i]);
		}
	}
	
	
}