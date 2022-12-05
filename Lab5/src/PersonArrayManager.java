import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class PersonArrayManager implements Iterable<Person> {
	
	Scanner scan = new Scanner(System.in);
	
	private Person[] data = null;
	private int count = 0;
	private int size = 0;
	
	public PersonArrayManager() {
		
	}
	
	public Person[] getData() {
		return data;
	}

	public void setData(Person[] data) {
		this.data = data;
		this.size= data.length;
		this.count= data.length;
	}
	
	public Person get(int index){
		return this.data[index];
	}
	
	// count , size
	public void add(Person person) {
		count++;
		if(count>=size)
		{
			size++;
			Person[] data = new Person[size];
			for(int i=0;i<data.length;i++) {
				if(i==data.length-1)
					data[i]=person;
				else
					data[i]=this.data[i];
			}
			this.data=data;
		}
		else
		{
			this.data[count-1] = person;
		}
	}
	
	//insert
	public void insert(int index,Person persondata) {
		count++;
		if(count>=size)
		{
			size++;
			Person[] data = new Person[size];
			for(int i=0;i<count;i++)
			{
				if(i==index)
					data[i]=persondata;
				else
				{
					if(i<index)
						data[i]=this.data[i];
					else
						data[i]=this.data[i-1];
				}
			}
			this.data=data;
		} 
		else
		{
			Person[] data = new Person[size];
			for(int i=0;i<count;i++)
			{
				if(i==index)
					data[i]=persondata;
				else
				{
					if(i<index)
						data[i]=this.data[i];
					else
						data[i]=this.data[i-1];
				}
			}
			this.data=data;
		}
	}
	
	//remove 
	public void remove(Person other) {
		count--;
		int index = -1;
		if(count==0)
		{
			System.out.println("배열에 아무 정보가 없습니다");
            return;
		}
		for(int i=0;i<size;i++) {
			if(this.data[i].equals(other))
				index = i;
		}
		if(index==-1)
		{
			System.out.println("배열안에 똑같은 정보가 존재하지 않습니다");
			return;
		}
		Person data[] = new Person[size];
		for(int i=0;i<size;i++) {
			if(i<index)
				data[i]=this.data[i];
			else
			{
				if(index==i)
					continue;
				else
					data[i-1]=this.data[i];
			}
		}
		this.data=data;
	}
	
	//remove
	public void remove(int index) {
		if(count==0)
		{
			System.out.println("배열에 아무 정보가 없습니다");
            return;
		}
		count--;
		Person data[] = new Person[size];
		for(int i=0;i<size;i++) {
				if(i<index)
					data[i]=this.data[i];
				else
				{
					if(index==i)
						continue;
					else
						data[i-1]=this.data[i];
				}
		}
		this.data=data;
	}
	
	// remove all 
	public void removeAll() {
		for(int i=0;i<count;i++)
			remove(i);
	}
	
	//find
	public int find(Person person) {
		int index=-1;
		for(int i=0;i<count;i++) {
			if(this.data[i].equals(person))
				index=i;
		}
		return index;
	}
	
	//print
	public void print() {
		for (var d : data) {
			if(d!=null)
			System.out.println(d);
		}
	}
	
	//replace
	public void replace(Person oldone, Person newone) {
		data[find(oldone)] = newone;
	}

	//sort
	public void sort(Comparator comparator) {
		Person[] data = new Person[count];
		for(int i=0;i<count;i++) {
			data[i]=this.data[i];
		}
		Arrays.sort(data, comparator);
		for(int i=0;i<count;i++) {
			this.data[i]=data[i];
		}
	}
	
	@Override
	public Iterator<Person> iterator() {
		// TODO Auto-generated method stub
		return new PersonArrayManagerIterator();
	}
	
	

	private class  PersonArrayManagerIterator implements Iterator<Person>{

		int index=0;
		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return index<count;
		}

		@Override
		public Person next() {
			if(!hasNext()) {
				throw new NoSuchElementException();
			}
			return get(index++);
		}
		
		public void remove() {
			PersonArrayManager.this.remove(--index);
		}
		
	}

}

