package dao;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Manager<T> implements Iterable<T> {
	
	List<T> list = null;
	private Parser<T> parser = null;
	
	public Manager(Parser parser) {
		this.parser = parser;
		this.list = new ArrayList<T>();
	}
	
	//index를 받아 data를 반환
	public T get(int index) {
		return list.get(index);
	}
	//list 반환
	public List<T> getList() {
		return list;
	}
	//predicate 에 따라 true 가 되는것만 뽑아 list를 재구성 하고 list 반환
    public List<T> getListBy(Predicate<? super T> predicate){
    	this.list = this.list.stream().filter(predicate).collect(Collectors.toList());
    	return list;
    }
    //list에 data를 add 함
	public void add(T t) {
		this.list.add(t);
	}
	//list에 가져온 list 자체를 다 add함
	public void addList(List<T> list) {
		this.list.addAll(list);
	}
	//index에 data를 집어넣음
	public void insert(int index, T data) {
		list.add(index, data);
	}
	//list 데이터 모두 제거
	public void removeAll() {
		list.clear();
	}
	//data 값을 list에서 제거
	public void remove(T data) {
		list.remove(data);
	}
	//인덱스에 위치한 데이터를 list에서 제거
	public void remove(int index) {
		list.remove(index);
	}
	//리스트에 있는 데이터를 찾아 반환
	public T find(T data) {
		for(int i =0;i<list.size();i++) {
			if(list.get(i).equals(data))
				return list.get(i);
		}
		return null;
	}
	//기존에 데이터를 새 데이터로 대체
	public void replace(T olddata, T newdata) {
		int index = list.indexOf(find(olddata));
		list.set(index, newdata);
	}
	//sort 
	public void sort(Comparator<? super T> comparator) {
		list.sort(comparator);
	}
	//처음 n개의 요소로 새로 list 생성
	public void limit(long n) {
		this.list = list.stream().limit(n).collect(Collectors.toList());
	}
	//처음 n개를 버린 후 나머지 요소로 list 생성
    public void skip(long n) {
    	this.list = list.stream().skip(n).collect(Collectors.toList());
	}
    
	
	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return new  ManagerIterator<T>();
	}
	
	private class ManagerIterator<T> implements Iterator<T>{

		int index = 0;
		
		@Override
		public boolean hasNext() {
			
			return index<list.size();
		}

		@Override
		public T next() {
			if(!hasNext()) {
				throw new NoSuchElementException();
			}
			return (T) get(index++);
		}
		
		public void remove() {
			Manager.this.remove(--index);
		}
	}
}
