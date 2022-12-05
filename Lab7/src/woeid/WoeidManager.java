package woeid;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;


public class WoeidManager {
	
	HashMap<String, WOEID> hashmap = new HashMap<String, WOEID>();
	
	//key�� ���� value ��ȯ
	public WOEID get(String key) {
		return this.hashmap.get(key);
	}
	//hashmap ��ȯ
	public HashMap<String,WOEID> getMap() {
		return this.hashmap;
	}
	//key�� �����ϴ���?
	public boolean containsKey(String key) {
		return hashmap.containsKey(key);
	}
	//list�� �޾ƿ� hashmap�� ������
	public void putList(List<WOEID> list) {
		for(WOEID data:list)
		{
			hashmap.put(data.getCity(), data);
		}
	}
	//key, value�� �޾ƿ� hashmap�� ����
	public void put(String key , WOEID value) {
		this.hashmap.put(key, value);
	}
	

	//value ���� �޾Ƽ� �ؽ��ʿ� �Ȱ��� value�� ������  �ű⿡ �´� key�� ��ȯ����
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
	//key�� �޾ƿ� key�� ���� value ����
	public void remove(String key) {
		hashmap.remove(key);
	}
	//value �� hashmap���� ����
	public void remove(WOEID value)
	{
		String key = find(value);
		this.hashmap.remove(key);
	}
	// ���� �����͸� �� �����ͷ� ����
	public void replace(WOEID olddata, WOEID  newdata) {
		hashmap.replace(find(olddata), olddata, newdata);
	}
	// ��� ����
	public void clear() {
		hashmap.clear();
	}
	// ��� ���
	public void print() {
		Set<String> set = hashmap.keySet();
		Iterator<String> iterator = set.iterator();
		while(iterator.hasNext())
		{
			System.out.println(hashmap.get(iterator.next()));
		}
	}
}
