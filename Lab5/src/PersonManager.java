
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class PersonManager implements Iterable<Person> {
	private List<Person> data = null;

	private static PersonManager instance = new PersonManager();
	
	public static PersonManager getInstance() {
		return instance;
	}
	
	public PersonManager() {
		this.data = new ArrayList<Person>();
	}
	
	// get
	public Person get(int index){
		return this.data.get(index);
	}
	
	// getList
	public List<Person> getList() {
		return this.data;
	}

	// setList
	public void setList(List<Person> list) {
		this.data = list;
	}
	
	// add 
	public void add(Person person) {
		this.data.add(person);
	}
	
	// insert
	void insert(int index, Person data){
		this.data.add(index, data);
	}	
	
	public void remove(int index) {
		this.data.remove(index);
	}

	// remove 
	public void remove(Person other) {
		Iterator<Person> it = this.data.iterator();
		while (it.hasNext()) {
		    Person p = it.next();
		    if (p.equals(other)) {
				it.remove();
		    }
		}
	}
	
	// remove all 
	public void removeAll() {
		this.data.clear();
	}
	
	// get 
	public Person find(Person other) {
		Person person = null;
		for (Person p : this.data) {
			if (p != null && p.equals(other)) {
				person = p;
				break;
			}
		}
		return person;
	}

	// replace
	public void replace(Person oldone, Person newone) {
		int index = this.data.indexOf(find(oldone));
		this.data.set(index, newone);
	}

	// print
	public void print() {
		for (var d : data) {
			System.out.println(d);
		}
	}
	
	// sort, public void sort(Comparator<? super T> comparator)가 잘안되서 
	// Comparator<Person> comparator로 했습니다
	public  void sort(Comparator<Person> comparator) {
		this.data.sort(comparator);
	}
	
	public  boolean contains(Person data) {
		return find(data)!=null;
	}
	
	public void sort() {
		Collections.sort(data);
	}
	
	@Override
	public Iterator<Person> iterator() {
		return new  PersonManagerIterator();
	}
	
	private class PersonManagerIterator implements Iterator<Person>{

		int index=0;
		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return index<data.size();
		}

		@Override
		public Person next() {
			if(!hasNext()) {
				throw new NoSuchElementException();
			}
			return get(index++);
		}
		
		public void remove() {
			PersonManager.this.remove(--index);
		}
		
	}
	
	

}