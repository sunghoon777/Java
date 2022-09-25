package chapter4;

import java.util.Scanner;

public class StackApp implements Stack {
	
	private int capacity; //용량
	private int top; // 가장 끝을 가리키는 포인터
	private Scanner scan; // 스캐너 변수
	private String[] list; // 데이터를 담는 배열
	
	//초기화
	public StackApp() {
		System.out.printf("총 스택 저장공간의 크기 입력 >>");
		scan = new Scanner(System.in);
		capacity = Integer.parseInt(scan.nextLine());
		list = new String[capacity];
		top = -1;
	}

	//길이
	@Override
	public int length() {
		// TODO Auto-generated method stub
		return top + 1;
	}

	//총 용량
	@Override
	public int capacity() {
		// TODO Auto-generated method stub
		return capacity;
	}

	//데이터 빼기
	@Override
	public String pop() {
		// TODO Auto-generated method stub
		if(top >= 0) {
			String data = list[top];
			list[top] = null;
			top -= 1;
			return data;
		}
		else {
			return "";
		}
	}

	//데이터 넣기
	@Override
	public boolean push(String val) {
		// TODO Auto-generated method stub
		if(top < list.length-1) {
			top += 1;
			list[top] = val;
			return true;
		}
		else {
			return false;
		}
	}

}
