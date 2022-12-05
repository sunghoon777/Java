package woeid;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
//32163219 ¿Ãº∫»∆
public class WoeidTest {
	
	public static void main(String[] args) {
		WoeidImporter importer = new WoeidImporter();
		WoeidManager manager = new WoeidManager();
		manager.putList(importer.loadCSV("WOEIDLIST1.csv"));
		manager.putList(importer.loadCSV("WOEIDLIST2.csv"));
		manager.putList(importer.loadCSV("WOEIDLIST3.csv"));
		manager.putList(importer.loadCSV("WOEIDLIST4.csv"));		
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
}
