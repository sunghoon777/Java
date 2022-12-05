import java.util.Comparator;
import java.util.List;

public class Manager {
	 List<WeatherData> data; 
	 List<HeatIndexCalculator> data2;
	 public List<WeatherData> getList() {
		return data;
	}
	 
	 public void setList(List<WeatherData> list) {
		 data = list;
	 }
	 
	 public void add(WeatherData obj) {
		 data.add(obj);
	 }
	 
	 public void insert(int index, WeatherData obj) {
		data.add(index,obj);
	 }
	 WeatherData get(int index) {
		return data.get(index);
	 }
	 
	 WeatherData find(WeatherData obj) {
		 int i=0;
		 for(;i<data.size();i++) {
			 if(data.get(i).equals(obj))
				 break;
		 }
		 return data.get(i);
	 }
	 void replace(WeatherData oldobj, WeatherData newobj) {
		 int i=0;
		 for(;i<data.size();i++) {
			 if(data.get(i).equals(oldobj))
			 {
				 data.remove(i);
				 data.add(i,newobj);
			 }
		 }
	 }
	 
	 void remove(WeatherData obj)
	 {
		 int i=0;
		 for(;i<data.size();i++) {
			 if(data.get(i).equals(obj))
			 {
				 data.remove(i);
			 }
		 }
	 }
	 void removeAll()
	 {
		 data.clear();
	 }
	 void sort1(Comparator comparator)
	 {
		 Sort sort = new Sort(comparator);
		 sort.bubbleSort1(data);
	 }
	
	 void sort2(Comparator comparator)
	 {
		 Sort sort = new Sort(comparator);
		 sort.bubbleSort2(data2);
	 }
}
