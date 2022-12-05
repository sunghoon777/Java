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
	
	//index�� �޾� data�� ��ȯ
	public T get(int index) {
		return list.get(index);
	}
	//list ��ȯ
	public List<T> getList() {
		return list;
	}
	//predicate �� ���� true �� �Ǵ°͸� �̾� list�� �籸�� �ϰ� list ��ȯ
    public List<T> getListBy(Predicate<? super T> predicate){
    	this.list = this.list.stream().filter(predicate).collect(Collectors.toList());
    	return list;
    }
    //list�� data�� add ��
	public void add(T t) {
		this.list.add(t);
	}
	//list�� ������ list ��ü�� �� add��
	public void addList(List<T> list) {
		this.list.addAll(list);
	}
	//index�� data�� �������
	public void insert(int index, T data) {
		list.add(index, data);
	}
	//list ������ ��� ����
	public void removeAll() {
		list.clear();
	}
	//data ���� list���� ����
	public void remove(T data) {
		list.remove(data);
	}
	//�ε����� ��ġ�� �����͸� list���� ����
	public void remove(int index) {
		list.remove(index);
	}
	//����Ʈ�� �ִ� �����͸� ã�� ��ȯ
	public T find(T data) {
		for(int i =0;i<list.size();i++) {
			if(list.get(i).equals(data))
				return list.get(i);
		}
		return null;
	}
	//������ �����͸� �� �����ͷ� ��ü
	public void replace(T olddata, T newdata) {
		int index = list.indexOf(find(olddata));
		list.set(index, newdata);
	}
	//sort 
	public void sort(Comparator<? super T> comparator) {
		list.sort(comparator);
	}
	//ó�� n���� ��ҷ� ���� list ����
	public void limit(long n) {
		this.list = list.stream().limit(n).collect(Collectors.toList());
	}
	//ó�� n���� ���� �� ������ ��ҷ� list ����
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
