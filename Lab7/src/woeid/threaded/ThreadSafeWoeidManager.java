package woeid.threaded;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import woeid.WOEID;

public class ThreadSafeWoeidManager {
	ConcurrentHashMap<String, WOEID> hashmap = new ConcurrentHashMap<String, WOEID>();
	
	public  WOEID get(String key) {
		return this.hashmap.get(key);
	}
	
	public ConcurrentHashMap<String, WOEID> getList() {
		return this.hashmap;
	}
	
	public void  setHashMap(ConcurrentHashMap<String, WOEID> hashmap) {
		this.hashmap = hashmap;
	}
	
	public   boolean containsKey(String key) {
		return hashmap.containsKey(key);
	}
	
	public  void  putList(List<WOEID> list) {
			for(WOEID data:list)
			{
				hashmap.put(data.getCity(), data);
			}
		
	}
	
	public   void put(String key , WOEID value) {
		this.hashmap.put(key, value);
	}
	

	//value 값을 받아서 해쉬맵에 똑같은 value가 있으면  거기에 맞는 key를 반환해줌
	public  String find(WOEID value) {
		Set<String> set = hashmap.keySet();
		Iterator<String> iterator = set.iterator();
		while(iterator.hasNext())
		{
			String key = iterator.next();
			if(hashmap.get(key).equals(value))
			{
				return key;
			}
		}
		return null;
	}
	
	public  void remove(String key) {
		hashmap.remove(key);
	}
	
	public   void remove(WOEID value)
	{
		String key = find(value);
		this.hashmap.remove(key);
	}
	
	public void replace(WOEID olddata, WOEID  newdata) {
		hashmap.replace(find(olddata), olddata, newdata);
	}
	
	public  void clear() {
		hashmap.clear();
	}
	
	public void print() {
		Set<String> set = hashmap.keySet();
		Iterator<String> iterator = set.iterator();
		while(iterator.hasNext())
		{
			System.out.println(hashmap.get(iterator.next()));
		}
	}

}
