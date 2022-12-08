package chapter8;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

//리플렉션 연습
public class Main {

    //생성자 가져오기
    public static void ex1() throws Exception{
        Class clazz = Class.forName("chapter8.Car");

        Constructor constructor = clazz.getDeclaredConstructor();
        Car car = (Car) constructor.newInstance();
        System.out.println(car);

        Constructor[] constructors = clazz.getDeclaredConstructors();
        for(Constructor constructor1 : constructors){
            System.out.println(constructor1);
        }
    }

    //메소드 가져오기
    public static void ex2() throws Exception{
        Car car = new Car();
        Class clazz = Class.forName("chapter8.Car");
        Method method = clazz.getDeclaredMethod("setCost", int.class);
        Method method1 = clazz.getDeclaredMethod("getCost");
        method.invoke(car, 10000);
        int cost = (int) method1.invoke(car);
        System.out.println(cost);

        Method[] methods = clazz.getDeclaredMethods();
        for(Method method2 : methods){
            System.out.println(method2);
        }
    }

    //필드 가져오기
    public static void ex3() throws Exception{
        Car car = new Car("kia",0);
        Class clazz = Class.forName("chapter8.Car");
        Field field = clazz.getDeclaredField("cost");
        Field field2 = clazz.getDeclaredField("name");
        field.setAccessible(true);
        field2.setAccessible(true);
        field.set(car,10000);
        int cost = (int) field.get(car);
        String name = (String) field2.get(car);
        System.out.println(cost+"  "+name);
    }

    @MyAnnotation
    public void method1(){
        System.out.println("실행 내용1");
    }

    @MyAnnotation(value = "-", number = 30)
    public void method2(){
        System.out.println("실행 내용2");
    }

    @MyAnnotation(value = "?" , number = 10)
    public void method3(){
        System.out.println("실행 내용3");
    }

    public static void main(String[] args) throws Exception {

        Class clazz = Class.forName("chapter8.Main");
        Method[] methods = clazz.getDeclaredMethods();
        for(Method method : methods){
            //지정한 어노테이션이 적용되었는지 확인
            if(method.isAnnotationPresent(MyAnnotation.class)){
                System.out.println(method.getName());
                MyAnnotation annotation = method.getDeclaredAnnotation(MyAnnotation.class);
                String value = annotation.value();
                int number = annotation.number();
                for(int i=0;i<number;i++){
                    System.out.print(value);
                }
                System.out.println();
            }
        }
    }
}

