package chapter6;

public class JClass {
    public <T> T take(T s[] , int index){
        if(index > s.length){
            System.out.println("인데스 범위를 벗어났습니다.");
            return  null;
        }
        return  s[index];
    }

}
