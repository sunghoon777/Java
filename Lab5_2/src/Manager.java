import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;


//stack(linked) ���
public class Manager  {
	
	Node top=null;
	
	//top�� ����Ű�� ��� ��ȯ
	public Node getTop() {
		return top;
	}
	//top ��� ����
	public void setTop(Node top) {
		this.top = top;
	}
	
    //�߰� �޼ҵ� ������ ��Ҹ� ���� �߰���Ŵ
	public void add(HeatIndexCalculator data) {
		Node node = new Node(data);
		node.Link=top;
		top=node;
	}
	
	//���� �޼ҵ� ������ ���� ���� ��Ҹ� ������
	public void remove() {
		if(top==null)
		{
			System.out.println("empty stack");
			return;
		}
		top=top.Link;
	}

	//��� ����
	public void removeAll() {
		while(top!=null)
		{
			remove();
		}
	}
	
	//��� ã��
	public Node find(HeatIndexCalculator data) {
		Node pointer=top;
		while(pointer.data.equals(data)==false)
		{
			pointer=pointer.Link;
		}
		return pointer;
	}
	
	//��� ������ ���
	public void print() {
		Node pointer = top;
		while(pointer!=null)
		{
			System.out.println(pointer.data);
			pointer=pointer.Link;
		}
	}
	
	//replace
	public void replace(HeatIndexCalculator oldone, HeatIndexCalculator newone) {
		find(oldone).data=newone;
	}
	
	//top���� �ٴڱ��� ���ʷ� ����
	public void sort(Comparator comparator) {
		int size=0;
		Node pointer = top;
		while(pointer!=null)
		{
			size++;
			pointer=pointer.Link;
		}
		if(size==0)
		{
			System.out.println("empty stack");
			return;
		}
		pointer = top;
		HeatIndexCalculator[] data = new HeatIndexCalculator[size];
		for(int i=0;i<size;i++)
		{
			data[i]=pointer.data;
			pointer=pointer.Link;
		}
		Arrays.sort(data, comparator);
		pointer = top;
		for(int i=0;i<size;i++)
		{
			pointer.data=data[i];
			pointer=pointer.Link;
		}
	}
	
	//���̿� ��ũ�� ����ִ� Node ���� Ŭ���� ����
	private class Node{
		HeatIndexCalculator data;
		Node Link;//�����
		
		public Node(HeatIndexCalculator input) {
			this.data=input;
			this.Link=null;
		}
		
		public Node() {
			
		}

		@Override
		public String toString() {
			return "Node data=" + data;
		}		
	}
}
