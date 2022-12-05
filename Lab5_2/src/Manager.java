import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;


//stack(linked) 사용
public class Manager  {
	
	Node top=null;
	
	//top이 가리키는 노드 반환
	public Node getTop() {
		return top;
	}
	//top 노드 설정
	public void setTop(Node top) {
		this.top = top;
	}
	
    //추가 메소드 스택은 요소를 위로 추가시킴
	public void add(HeatIndexCalculator data) {
		Node node = new Node(data);
		node.Link=top;
		top=node;
	}
	
	//제거 메소드 스택은 가장 위에 요소를 제거함
	public void remove() {
		if(top==null)
		{
			System.out.println("empty stack");
			return;
		}
		top=top.Link;
	}

	//모두 제거
	public void removeAll() {
		while(top!=null)
		{
			remove();
		}
	}
	
	//대상 찾기
	public Node find(HeatIndexCalculator data) {
		Node pointer=top;
		while(pointer.data.equals(data)==false)
		{
			pointer=pointer.Link;
		}
		return pointer;
	}
	
	//모든 데이터 출력
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
	
	//top에서 바닥까지 차례로 정렬
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
	
	//데이와 링크가 들어있는 Node 내부 클래스 구현
	private class Node{
		HeatIndexCalculator data;
		Node Link;//연결용
		
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
