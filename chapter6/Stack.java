package chapter6;
//���� �ڷᱸ�� ���׸����� ����
public class Stack <T>{
    
    //���� ������ ��ġ�� ����Ű�� pointer ����
    int pointer;
    //������ �� ���� ����
    int size;
    //stack �迭 , Object Ÿ���� ���� ��� Ÿ���� ����Ű�� �Ͽ���
    Object[] stack;

    //������, ó���� �� ���밳���� 5�� �Ͽ���(������ ���� ����),  pointer�� ������ ��������� -1�� ����Ŵ
    public Stack(){
        size = 5;
        pointer = -1;
        stack = new Object[size];
    }

    /*
    pop �޼ҵ�
    ���� size�� ������ size�� 2�� �÷��ش�.
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
    pop �޼ҵ�
    pointer �� 0���� ������ ����ִٴ� ���̹Ƿ� null�� return ���ش�.
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

    //stack�ȿ� �ִ� ��� ��ҵ��� ������ִ� �޼ҵ�
    public void printStack(){
        if(pointer >= 0){
            for(int i=0;i<pointer+1;i++){
                System.out.println(stack[i]);
            }
        }
    }

}
