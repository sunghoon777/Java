package chapter6;

import chapter5.A;

import java.lang.reflect.Member;
import java.net.CookieHandler;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

public class ActivateCommand {

    //command를 담는 commandList
    private static ArrayList<Command> commandList = new ArrayList<Command>();
    //variable를 담는 variable 해쉬맵
    private static HashMap<String,Float> variableMap = new HashMap<String,Float>();

    //명령어 입력받는 메소드
    public static void inputCommand(){
        System.out.println("수퍼컴이 작동합니다. 프로그램을 입력해주세요. go를 입력하면 작동합니다.");
        Scanner scan = new Scanner(System.in);
        while (true){
            System.out.print(">> ");
            String method = scan.next();
            //go를 누르면 입력 종료
            if(method.equals("go")){
                break;
            }
            String firstParameter = scan.next();
            String secondParameter = scan.next();
            if(method.equals("mov")){
                //첫 번째 인자가 숫자이거나 두 번째 인자가 숫자가 아니면 잘못입력한거기 때문에 경고 발생
               if(isNumber(firstParameter) || (!isNumber(secondParameter))){
                   System.out.println("잘못입력하셨습니다.");
                   scan.nextLine();
                   continue;
               }
            }
            else{
                //첫 번쨰 인자는 숫자가 될수 없으므로 경고 발생
                if(isNumber(firstParameter)){
                    System.out.println("잘못입력하셨습니다.");
                    scan.nextLine();
                    continue;
                }
            }
            scan.nextLine();
            commandList.add(new Command(method,firstParameter,secondParameter));
        }
    }

    /*
    명령어 실행 메소드
    mov 는 = add + sub - jn0 이전 명령어들 반복(for, while)과 같은 기능을 한다.
     */
    public static void activateCommand(){
        //variable list에 값 저장.
        for(Command command : commandList){
            String method = command.getMethod();
            //mov일때 변수를 맵에 넣는다.
            if(method.equals("mov")){
                if(variableMap.get(method) == null){
                    variableMap.put(command.getFirstParameter(),Float.valueOf(command.getSecondParameter()));
                }
            }
        }
        //명령 실행
        for(int i =0;i<commandList.size();i++){
            String method = commandList.get(i).getMethod();
            if(method.equals("add")){
                add(i);
            }
            else if(method.equals("sub")){
                sub(i);
            }
            else if(method.equals("jn0")){
                jn0(i);
            }
            else if(method.equals("prt")){
                prt(i);
            }
        }
        //마지막으로 변수 모두 출력
        Iterator<String> it = variableMap.keySet().iterator();
        while (it.hasNext()){
            String key = it.next();
            //변수가 정수이면 정수로 출력
            if(Float.compare(variableMap.get(key)-variableMap.get(key).intValue(),0) == 0){
                System.out.print(key+":"+variableMap.get(key).intValue()+"  ");
            }
            //실수이면 실수로 출력
            else{
                System.out.print(key+":"+variableMap.get(key)+"  ");
            }
        }
        System.out.println("\n프로그램 실행 끝");
    }

    /*
    add + sub - jn0 이전 명령어들 반복(for, while)과 같은 기능을 한다.
        ex) mov sum 0   sum = 0;
            add sum i   sum += i;
            sub n   1   n   -= 1;
            jno n   3   3번째이전 명령어로 돌아가 1번쨰 이전 명령어까지 n이 0이 될때까지 반복
            prt 출력
     */


    //add command 실행 메소드
    private static void add(int index){
        Command command = commandList.get(index);
        String firstParameter = command.getFirstParameter();
        float firstParameterValue = variableMap.get(firstParameter);
        String secondParameter = command.getSecondParameter();
        //두 번째 인자가 리터럴일 때
        if(isNumber(secondParameter)){
            firstParameterValue += Float.valueOf(secondParameter);
            variableMap.put(firstParameter,firstParameterValue);
        }
        //두 번째 인자가 변수일 때
        else{
            Float value = variableMap.get(secondParameter);
            if(value != null){
                firstParameterValue += value;
                variableMap.put(firstParameter,firstParameterValue);
            }
        }
    }

    //sub command 실행 메소드
    private static void sub(int index){
        Command command = commandList.get(index);
        String firstParameter = command.getFirstParameter();
        float firstParameterValue = variableMap.get(firstParameter);
        String secondParameter = command.getSecondParameter();
        //두 번째 인자가 리터럴일 때
        if(isNumber(secondParameter)){
            firstParameterValue -= Float.valueOf(secondParameter);
            variableMap.put(firstParameter,firstParameterValue);
        }
        //두 번째 인자가 변수일 때
        else{
            Float value = variableMap.get(secondParameter);
            if(value != null){
                firstParameterValue -= value;
                variableMap.put(firstParameter,firstParameterValue);
            }
        }
    }

    //jn0 command 실행 메소드
    private static void jn0(int index){
        //index에 해당되는 command를 받아온다
        Command command = commandList.get(index);
        String firstParameter = command.getFirstParameter();
        //만약 firstPameter가 map에 존재하지 않으면 리턴
        if(variableMap.get(firstParameter) == null){
            System.out.println("first parameter is null");
            return;
        }
        String secondParameter = command.getSecondParameter();
        int secondParameterValue = 0;
        //secondParameter 값 받아와서 secondParameterValue 에 저장 , secondParameter가 리터럴이거나 변수일때 받아오는 방식이 다르다.
        //secondParameter가 리터럴일때
        if(isNumber(secondParameter)){
            secondParameterValue = Integer.parseInt(secondParameter);
        }
        //secondParameter가 변수일때
        else{
            try {
                secondParameterValue = variableMap.get(secondParameter).intValue();
            }
            catch (Exception e){
                System.out.println("jn0 Exception occur");
                return;
            }
        }
        //index-secondParameterValue 계산 값이 0보다 작으면 논리적 오류가 발생한거기 때문에 리턴
        if(index-secondParameterValue<0){
            System.out.println("jn0 index Exception occur");
            return;
        }
        //secondParameterValue가 0이면 동작을 할 의미가 없으므로 리턴, 변수 firstParameter의 값도 0이면 리턴
        if(secondParameterValue == 0 || variableMap.get(firstParameter).intValue() == 0)
            return;
        //변수 firstParameter의 값이 0이 될때까지 동작 반복
        while (true){
            for(int i = index-secondParameterValue;i<index;i++){
                String method = commandList.get(i).getMethod();
                if(method.equals("add")){
                    add(i);
                }
                else if(method.equals("sub")){
                    sub(i);
                }
                else if(method.equals("jn0")){
                    jn0(i);
                }
                else if(method.equals("prt")){
                    prt(i);
                }
            }
            //변수 firstParameter가 0이 되면 리턴
            if(variableMap.get(firstParameter).intValue() == 0){
                break;
            }
        }
    }

    //prt command 실행 메소드
    private static void prt(int index){
        String key = commandList.get(index).getFirstParameter();
        if(variableMap.get(key) != null){
            //변수가 정수이면 정수로 출력
            if(Float.compare(variableMap.get(key)-variableMap.get(key).intValue(),0) == 0){
                System.out.print(key+":"+variableMap.get(key).intValue()+"  ");
            }
            //실수이면 실수로 출력
            else{
                System.out.print(key+":"+variableMap.get(key)+"  ");
            }
        }
        System.out.println();
    }




    /*
    해당 문자열이 숫자인지 아닌지 판별하는 메소드
     */
    private static boolean isNumber(String data){
        for(int i=0;i<data.length();i++){
            if(!Character.isDigit(data.charAt(i))){
                return false;
            }
        }
        return true;
    }

}
