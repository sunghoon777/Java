import java.util.Comparator;
import java.util.List;

public class PersonManager {
	 List<Person> data; 
	 List<BMICalculator> data2;
	 public List<Person> getList() {
		return data;
	}
	 
	 public void setList(List<Person> list) {
		 data = list;
	 }
	 
	 public void add(Person obj) {
		 data.add(obj);
	 }
	 
	 public void insert(int index, Person obj) {
		data.add(index,obj);
	 }
	 Person get(int index) {
		return data.get(index);
	 }
	 
	 Person find(Person obj) {
		 int i=0;
		 for(;i<data.size();i++) {
			 if(data.get(i).equals(obj))
				 break;
		 }
		 return data.get(i);
	 }
	 void replace(Person oldobj, Person newobj) {
		 int i=0;
		 for(;i<data.size();i++) {
			 if(data.get(i).equals(oldobj))
			 {
				 data.remove(i);
				 data.add(i,newobj);
			 }
		 }
	 }
	 
	 void remove(Person obj)
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
