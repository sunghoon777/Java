package chapter6;

import chapter5.A;

import java.lang.reflect.Member;
import java.net.CookieHandler;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

public class ActivateCommand {

    //command�� ��� commandList
    private static ArrayList<Command> commandList = new ArrayList<Command>();
    //variable�� ��� variable �ؽ���
    private static HashMap<String,Float> variableMap = new HashMap<String,Float>();

    //��ɾ� �Է¹޴� �޼ҵ�
    public static void inputCommand(){
        System.out.println("�������� �۵��մϴ�. ���α׷��� �Է����ּ���. go�� �Է��ϸ� �۵��մϴ�.");
        Scanner scan = new Scanner(System.in);
        while (true){
            System.out.print(">> ");
            String method = scan.next();
            //go�� ������ �Է� ����
            if(method.equals("go")){
                break;
            }
            String firstParameter = scan.next();
            String secondParameter = scan.next();
            if(method.equals("mov")){
                //ù ��° ���ڰ� �����̰ų� �� ��° ���ڰ� ���ڰ� �ƴϸ� �߸��Է��Ѱű� ������ ��� �߻�
               if(isNumber(firstParameter) || (!isNumber(secondParameter))){
                   System.out.println("�߸��Է��ϼ̽��ϴ�.");
                   scan.nextLine();
                   continue;
               }
            }
            else{
                //ù ���� ���ڴ� ���ڰ� �ɼ� �����Ƿ� ��� �߻�
                if(isNumber(firstParameter)){
                    System.out.println("�߸��Է��ϼ̽��ϴ�.");
                    scan.nextLine();
                    continue;
                }
            }
            scan.nextLine();
            commandList.add(new Command(method,firstParameter,secondParameter));
        }
    }

    /*
    ��ɾ� ���� �޼ҵ�
    mov �� = add + sub - jn0 ���� ��ɾ�� �ݺ�(for, while)�� ���� ����� �Ѵ�.
     */
    public static void activateCommand(){
        //variable list�� �� ����.
        for(Command command : commandList){
            String method = command.getMethod();
            //mov�϶� ������ �ʿ� �ִ´�.
            if(method.equals("mov")){
                if(variableMap.get(method) == null){
                    variableMap.put(command.getFirstParameter(),Float.valueOf(command.getSecondParameter()));
                }
            }
        }
        //��� ����
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
        //���������� ���� ��� ���
        Iterator<String> it = variableMap.keySet().iterator();
        while (it.hasNext()){
            String key = it.next();
            //������ �����̸� ������ ���
            if(Float.compare(variableMap.get(key)-variableMap.get(key).intValue(),0) == 0){
                System.out.print(key+":"+variableMap.get(key).intValue()+"  ");
            }
            //�Ǽ��̸� �Ǽ��� ���
            else{
                System.out.print(key+":"+variableMap.get(key)+"  ");
            }
        }
        System.out.println("\n���α׷� ���� ��");
    }

    /*
    add + sub - jn0 ���� ��ɾ�� �ݺ�(for, while)�� ���� ����� �Ѵ�.
        ex) mov sum 0   sum = 0;
            add sum i   sum += i;
            sub n   1   n   -= 1;
            jno n   3   3��°���� ��ɾ�� ���ư� 1���� ���� ��ɾ���� n�� 0�� �ɶ����� �ݺ�
            prt ���
     */


    //add command ���� �޼ҵ�
    private static void add(int index){
        Command command = commandList.get(index);
        String firstParameter = command.getFirstParameter();
        float firstParameterValue = variableMap.get(firstParameter);
        String secondParameter = command.getSecondParameter();
        //�� ��° ���ڰ� ���ͷ��� ��
        if(isNumber(secondParameter)){
            firstParameterValue += Float.valueOf(secondParameter);
            variableMap.put(firstParameter,firstParameterValue);
        }
        //�� ��° ���ڰ� ������ ��
        else{
            Float value = variableMap.get(secondParameter);
            if(value != null){
                firstParameterValue += value;
                variableMap.put(firstParameter,firstParameterValue);
            }
        }
    }

    //sub command ���� �޼ҵ�
    private static void sub(int index){
        Command command = commandList.get(index);
        String firstParameter = command.getFirstParameter();
        float firstParameterValue = variableMap.get(firstParameter);
        String secondParameter = command.getSecondParameter();
        //�� ��° ���ڰ� ���ͷ��� ��
        if(isNumber(secondParameter)){
            firstParameterValue -= Float.valueOf(secondParameter);
            variableMap.put(firstParameter,firstParameterValue);
        }
        //�� ��° ���ڰ� ������ ��
        else{
            Float value = variableMap.get(secondParameter);
            if(value != null){
                firstParameterValue -= value;
                variableMap.put(firstParameter,firstParameterValue);
            }
        }
    }

    //jn0 command ���� �޼ҵ�
    private static void jn0(int index){
        //index�� �ش�Ǵ� command�� �޾ƿ´�
        Command command = commandList.get(index);
        String firstParameter = command.getFirstParameter();
        //���� firstPameter�� map�� �������� ������ ����
        if(variableMap.get(firstParameter) == null){
            System.out.println("first parameter is null");
            return;
        }
        String secondParameter = command.getSecondParameter();
        int secondParameterValue = 0;
        //secondParameter �� �޾ƿͼ� secondParameterValue �� ���� , secondParameter�� ���ͷ��̰ų� �����϶� �޾ƿ��� ����� �ٸ���.
        //secondParameter�� ���ͷ��϶�
        if(isNumber(secondParameter)){
            secondParameterValue = Integer.parseInt(secondParameter);
        }
        //secondParameter�� �����϶�
        else{
            try {
                secondParameterValue = variableMap.get(secondParameter).intValue();
            }
            catch (Exception e){
                System.out.println("jn0 Exception occur");
                return;
            }
        }
        //index-secondParameterValue ��� ���� 0���� ������ ���� ������ �߻��Ѱű� ������ ����
        if(index-secondParameterValue<0){
            System.out.println("jn0 index Exception occur");
            return;
        }
        //secondParameterValue�� 0�̸� ������ �� �ǹ̰� �����Ƿ� ����, ���� firstParameter�� ���� 0�̸� ����
        if(secondParameterValue == 0 || variableMap.get(firstParameter).intValue() == 0)
            return;
        //���� firstParameter�� ���� 0�� �ɶ����� ���� �ݺ�
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
            //���� firstParameter�� 0�� �Ǹ� ����
            if(variableMap.get(firstParameter).intValue() == 0){
                break;
            }
        }
    }

    //prt command ���� �޼ҵ�
    private static void prt(int index){
        String key = commandList.get(index).getFirstParameter();
        if(variableMap.get(key) != null){
            //������ �����̸� ������ ���
            if(Float.compare(variableMap.get(key)-variableMap.get(key).intValue(),0) == 0){
                System.out.print(key+":"+variableMap.get(key).intValue()+"  ");
            }
            //�Ǽ��̸� �Ǽ��� ���
            else{
                System.out.print(key+":"+variableMap.get(key)+"  ");
            }
        }
        System.out.println();
    }




    /*
    �ش� ���ڿ��� �������� �ƴ��� �Ǻ��ϴ� �޼ҵ�
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
