package chapter4;

public interface Stack {
	int length(); // 현재 스택에 저장된 개수 리턴
	int capacity(); // 스택의 전체 저장 가능한 개수 리턴
	String pop(); //빼기
	boolean push(String val); //넣기 

}
