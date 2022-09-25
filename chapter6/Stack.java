package chapter6;
//스택 자료구조 제네릭으로 구현
public class Stack <T>{
    
    //현재 스택의 위치를 가리키는 pointer 변수
    int pointer;
    //스택의 총 수용 개수
    int size;
    //stack 배열 , Object 타입을 통해 모든 타입을 가리키게 하였음
    Object[] stack;

    //생성자, 처음에 총 수용개수는 5로 하였음(이유는 딱히 없음),  pointer는 스택이 비어있으면 -1을 가리킴
    public Stack(){
        size = 5;
        pointer = -1;
        stack = new Object[size];
    }

    /*
    pop 메소드
    만약 size가 꽉차면 size를 2배 늘려준다.
     */
    public void push(T item){
        pointer++;
        if(pointer >= size){
            System.out.println("full!!");
            size = size * 2;
            Object[] tmp_stack = stack;
            stack = new Object[size];
            for(int i = 0;i<tmp_stack.length;i++){
                stack[i] = tmp_stack[i];
            }
        }
        stack[pointer] = item;
        System.out.println("push "+item);
    }

    /*
    pop 메소드
    pointer 가 0보다 작으면 비어있다는 것이므로 null를 return 해준다.
     */
    public T pop(){
        if(pointer < 0){
            System.out.println("empty!!");
            return null;
        }
        T item = (T)stack[pointer];
        stack[pointer] = null;
        pointer -= 1;
        System.out.println("pop "+item);
        return item;
    }

    //stack안에 있는 모든 요소들을 출력해주는 메소드
    public void printStack(){
        if(pointer >= 0){
            for(int i=0;i<pointer+1;i++){
                System.out.println(stack[i]);
            }
        }
    }

}
