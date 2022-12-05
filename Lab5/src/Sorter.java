import java.util.Comparator;

public class Sorter {
	Comparator comparator = null;
	
	public Sorter() {
		this(null);
	}
		
	public Sorter(Comparator comparator) {
		this.comparator = comparator;
	}

	public void setComparator(Comparator comparator) {
		this.comparator = comparator;
	}

	public void bubbleSort(Object[] data) {
		Object temp = null;
		for (int i = 0; i < data.length - 1; i++) {
            for (int j = 0; j < data.length - 1; j++) {
                if (comparator.compare(data[j], data[j + 1]) > 0) { // strategy pattern
                    temp = data[j];
                    data[j] = data[j + 1];
                    data[j + 1] = temp;
                }
            }
        }
	}
	
	public void bubbleSort2(Object[] data) {
		Object temp = null;
		for (int i = data.length; i > 0; i--) {
            for (int j = 0; j < i - 1; j++) {
                if (comparator.compare(data[j], data[j + 1]) > 0) { // strategy pattern
                    temp = data[j];
                    data[j] = data[j + 1];
                    data[j + 1] = temp;
                }
            }
        }
	}
	
	public void bubbleSort3(Object[] data) {
		Object temp = null;
		for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data.length - i - 1; j++) {
                if (comparator.compare(data[j], data[j + 1]) > 0) { // strategy pattern
                    temp = data[j];
                    data[j] = data[j + 1];
                    data[j + 1] = temp;
                }
            }
        }
	}
	
}
