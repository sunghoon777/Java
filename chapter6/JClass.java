package chapter6;

public class JClass {
    public <T> T take(T s[] , int index){
        if(index > s.length){
            System.out.println("�ε��� ������ ������ϴ�.");
            return  null;
        }
        return  s[index];
    }

}
