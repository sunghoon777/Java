import java.util.*;


public class Lab5 {
	//3216329 이성훈
	//person : int age, Gender gender, double weight, double height, double neck, double waist, double hip, Activity activity

	//add 
	public static void add(PersonManager list,PersonArrayManager array) {
		list.add(new Person(20, Gender.MALE, 65, 175, 14, 35, 40, Activity.MODERATE_EXERCISE));
		list.add(new Person(30, Gender.FEMALE, 56, 165, 14, 32, 39, Activity.HEAVY_EXERCISE));
		list.add(new Person(40, Gender.FEMALE, 50, 163, 14, 33, 44, Activity.LIGHT_EXERCISE));
		list.add(new Person(50, Gender.FEMALE, 49, 158, 14, 35, 45, Activity.MODERATE_EXERCISE));
		list.add(new Person(60, Gender.MALE, 55, 173, 12, 31, 39, Activity.LITTLE_TO_NO_EXERCISE));
		array.add(new Person(20, Gender.MALE, 65, 175, 14, 35, 40, Activity.MODERATE_EXERCISE));
		array.add(new Person(30, Gender.FEMALE, 56, 165, 14, 32, 39, Activity.HEAVY_EXERCISE));
		array.add(new Person(40, Gender.FEMALE, 50, 163, 14, 33, 44, Activity.LIGHT_EXERCISE));
		array.add(new Person(50, Gender.FEMALE, 49, 158, 14, 35, 45, Activity.MODERATE_EXERCISE));
		array.add(new Person(60, Gender.MALE, 55, 173, 12, 31, 39, Activity.LITTLE_TO_NO_EXERCISE));
		
		System.out.println("-----------------add-----------------------");
		System.out.println("ArrayList");
		list.print();
		System.out.println("-------------------------------------------");
		System.out.println("Dynamic Array");
		array.print();
		System.out.println();
	}
	//remove
	public static void remove(PersonManager list,PersonArrayManager array) {
		System.out.println("-----------------remove index 2-----------------------");
		list.remove(2);
		array.remove(2);
		System.out.println("ArrayList");
		list.print();
		System.out.println("-------------------------------------------");
		System.out.println("Dynamic Array");
		array.print();
		System.out.println();
	}
	//insert
	public static void insert(PersonManager list,PersonArrayManager array) {
		System.out.println("-----------------insert index 2-----------------------");
		list.insert(2 , new Person(10, Gender.MALE, 55, 171, 12, 31, 39, Activity.LITTLE_TO_NO_EXERCISE) );
		array.insert(2 , new Person(10, Gender.MALE, 55, 171, 12, 31, 39, Activity.LITTLE_TO_NO_EXERCISE) );
		System.out.println("ArrayList");
		list.print();
		System.out.println("-------------------------------------------");
		System.out.println("Dynamic Array");
		array.print();
		System.out.println();
	}
	
	public static void replace(PersonManager list,PersonArrayManager array) {
		System.out.println("-----------------replace last element-----------------------");
		list.replace(new Person(60, Gender.MALE, 55, 173, 12, 31, 39, Activity.LITTLE_TO_NO_EXERCISE),new Person(30, Gender.MALE, 55, 173, 12, 31, 39, Activity.LITTLE_TO_NO_EXERCISE) );
		array.replace(new Person(60, Gender.MALE, 55, 173, 12, 31, 39, Activity.LITTLE_TO_NO_EXERCISE),new Person(30, Gender.MALE, 55, 173, 12, 31, 39, Activity.LITTLE_TO_NO_EXERCISE) );
		System.out.println("ArrayList");
		list.print();
		System.out.println("-------------------------------------------");
		System.out.println("Dynamic Array");
		array.print();
		System.out.println();
	}
	//sort
	public static void sort(PersonManager list,PersonArrayManager array) {
		System.out.println("-----------------sort by Height-----------------------");
		list.sort((p,q)  ->  {return Double.compare(((Person)p).getHeight(), ((Person)q).getHeight());});
		array.sort((p,q)  ->  {return Double.compare(((Person)p).getHeight(), ((Person)q).getHeight());});
		System.out.println("ArrayList");
		list.print();
		System.out.println("-------------------------------------------");
		System.out.println("Dynamic Array");
		array.print();
		System.out.println();
	}
	//iterator 모든 데이터 제거
	public static void iterator(PersonManager list,PersonArrayManager array) {
		System.out.println("-----------------iterator remove All Elements-----------------------");
		Iterator<Person> iter = list.iterator();
		Iterator<Person> iter2 = array.iterator();
		while(iter.hasNext())
		{
			iter.next();
			iter.remove();
		}
		while(iter2.hasNext())
		{
			iter2.next();
			iter2.remove();
		}
		System.out.println("ArrayList");
		list.print();
		System.out.println("-------------------------------------------");
		System.out.println("Dynamic Array");
		array.print();
		System.out.println();
	}
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//ArrayList Dynamic Array 비교
		PersonManager list = new PersonManager();
		PersonArrayManager array = new PersonArrayManager();
		add(list, array);
		replace(list,array);
		remove(list,array);
		insert(list,array);
		sort(list,array);
		iterator(list,array);
		
		//==, equals, hashCode
		Person person =new Person(20, Gender.MALE, 65, 175, 14, 35, 40, Activity.MODERATE_EXERCISE);
		Person person2 =new Person(20, Gender.MALE, 65, 175, 14, 35, 40, Activity.MODERATE_EXERCISE);
		Person person3 = person;
		System.out.println("person == person2 " +(person==person2));
		System.out.println("person == person3 " +(person==person3));
		System.out.println("person equals person2 " +(person.equals(person2)));
		System.out.println("person equals person3 " +(person.equals(person3)));
		System.out.println("person hashcode == person2 hashcode " +(person.hashCode()==person2.hashCode()));
		System.out.println("person hashcode == person3 hashcode " +(person.hashCode()==person3.hashCode()));
	
		//Vector, ArrayList, LinkedList, HashSet, HashMap
		Vector<Person> vector= new Vector<Person>();
		vector.add(person);
		vector.add(person2);
		vector.add(person3);
		System.out.println("Vector");
		for(var v:vector)System.out.println(v);
		
		ArrayList<Person> arraylist = new ArrayList<Person>();
		arraylist.add(person);
		arraylist.add(person2);
		arraylist.add(person3);
		System.out.println("ArrayList");
		for(var v:arraylist)System.out.println(v);
		
		LinkedList<Person> linkedlist = new LinkedList<Person>();
		linkedlist.add(person);
		linkedlist.add(person2);
		linkedlist.add(person3);
		System.out.println("LinkedList");
		for(var v:linkedlist)System.out.println(v);
		
		HashSet<Person> hashset = new HashSet<Person>();
		hashset.add(person);
		hashset.add(person2);
		hashset.add(person3);
		System.out.println("HashSet");
		for(var v:hashset)System.out.println(v);
		
		HashMap<Person, String> hashmap = new HashMap<Person, String>();
		hashmap.put(person, "person");
		hashmap.put(person2, "person2");
		hashmap.put(person3, "person3");
		System.out.println("HashMap");
		hashmap.forEach((key, value) -> System.out.println(key+"  "+value));
	}
}

