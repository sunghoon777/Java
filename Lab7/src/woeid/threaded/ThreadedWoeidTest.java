package woeid.threaded;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import woeid.WOEID;


//32163219 �̼���
public class ThreadedWoeidTest implements Runnable {
// filename�� ó�� ������ �̸��� �����ϱ� ���Ѱ�
//list�� �����尡 ����Ǹ鼭 import�� ���ϵ��� �����͵��� list�� �����ϱ����� �뵵 ��� �����尡 ������ �Ϸ�Ǹ� list�� ��� ���ϵ���� �����͵��� ����ȴ�.
	String filename;
	private static List<WOEID> list = Collections.synchronizedList(new ArrayList()); 	


	public ThreadedWoeidTest(String filename) {
		super();
		this.filename = filename;
	}

	public static void main(String[] args) {

		
		ThreadedWoeidTest threadrunnable1 = new ThreadedWoeidTest("WOEIDLIST1.csv");
		ThreadedWoeidTest threadrunnable2 = new ThreadedWoeidTest("WOEIDLIST2.csv");
		ThreadedWoeidTest threadrunnable3 = new ThreadedWoeidTest("WOEIDLIST3.csv");
		ThreadedWoeidTest threadrunnable4 = new ThreadedWoeidTest("WOEIDLIST4.csv");
		Thread thread1 =  new Thread(threadrunnable1);
		Thread thread2 =  new Thread(threadrunnable2);
		Thread thread3 =  new Thread(threadrunnable3);
		Thread thread4 =  new Thread(threadrunnable4);
		thread1.start();
		thread2.start();
		thread3.start();
		thread4.start();
		
		try {
			thread1.join();
			thread2.join();
			thread3.join();
			thread4.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ThreadSafeWoeidManager manager = new ThreadSafeWoeidManager();
		manager.putList(list);
		manager.print();
		System.out.println("--------------Cairo's data-----------------");
		if(manager.containsKey("Cairo"))
		{
			System.out.println(manager.get("Cairo"));
		}
		System.out.println("--------------Country print------------------");
		List<String> countryData = new ArrayList<String>();
		Set<String> set = manager.hashmap.keySet();
		Iterator<String> iterator = set.iterator();
		while(iterator.hasNext())
		{
			countryData.add(manager.get(iterator.next()).getCountry());
		}
		for(String country:countryData)
		{
			System.out.println(country);
		}
		System.out.println("--------------remove United States-------------");
		Set<String> set2 = manager.hashmap.keySet();
		iterator = set2.iterator();
		List<String> keyList = new ArrayList<String>();
		while(iterator.hasNext())
		{
			String key = iterator.next();
			if(manager.get(key).getCountry().equals("United States"))
				keyList.add(key);
		}
		for(String key:keyList) {
			manager.remove(key);
		}
		manager.print();
		System.out.println("------------------clear--------------------");
		manager.clear();
		manager.print();
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		ThreadSafeWoeidImporter importer = new ThreadSafeWoeidImporter();
		list.addAll(importer.loadCSV(this.filename));
	}
}
