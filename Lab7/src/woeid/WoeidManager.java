package woeid;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;


public class WoeidManager {
	
	HashMap<String, WOEID> hashmap = new HashMap<String, WOEID>();
	
	//key를 통해 value 반환
	public WOEID get(String key) {
		return this.hashmap.get(key);
	}
	//hashmap 반환
	public HashMap<String,WOEID> getMap() {
		return this.hashmap;
	}
	//key를 포함하는지?
	public boolean containsKey(String key) {
		return hashmap.containsKey(key);
	}
	//list를 받아와 hashmap에 저장함
	public void putList(List<WOEID> list) {
		for(WOEID data:list)
		{
			hashmap.put(data.getCity(), data);
		}
	}
	//key, value를 받아와 hashmap에 저장
	public void put(String key , WOEID value) {
		this.hashmap.put(key, value);
	}
	

	//value 값을 받아서 해쉬맵에 똑같은 value가 있으면  거기에 맞는 key를 반환해줌
	public String find(WOEID value) {
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
	//key를 받아와 key를 가진 value 제거
	public void remove(String key) {
		hashmap.remove(key);
	}
	//value 값 hashmap에서 제거
	public void remove(WOEID value)
	{
		String key = find(value);
		this.hashmap.remove(key);
	}
	// 기존 데이터를 새 데이터로 변경
	public void replace(WOEID olddata, WOEID  newdata) {
		hashmap.replace(find(olddata), olddata, newdata);
	}
	// 모두 제거
	public void clear() {
		hashmap.clear();
	}
	// 모두 출력
	public void print() {
		Set<String> set = hashmap.keySet();
		Iterator<String> iterator = set.iterator();
		while(iterator.hasNext())
		{
			System.out.println(hashmap.get(iterator.next()));
		}
	}
}
