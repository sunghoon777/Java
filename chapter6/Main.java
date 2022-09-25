package chapter6;


import chapter5.A;
import chapter6_openchallenge.WordQuiz;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        System.out.println("������ �����ϼ���");
        Scanner scan = new Scanner(System.in);
        String problem = scan.nextLine();
        /*
        ����1
        ���� �Է¹޾Ƽ� ���� ū �� ���, Collections�� max �޼ҵ� ���
         */
        if(problem.equals("1")){
            ArrayList<Integer> list = new ArrayList<Integer>();
            System.out.print("����(-1�� �Էµ� ������)>> ");
            while (true){
                int element = scan.nextInt();
                if(element == -1)
                    break;
                else
                    list.add(element);
            }
            scan.nextLine();
            System.out.println("���� ū ���� "+Collections.max(list));
        }
        /*
        ����2
        6���� ������ ������ �Է¹޾Ƽ� ������ ġȯ�ϰ� ������� ���
         */
        else if(problem.equals("2")){
            ArrayList<Character> list = new ArrayList<Character>();
            System.out.print("6���� ������ �� ĭ���� �и� �Է�(A/B/C/D/F) >> ");
            for (int i = 0;i<6;i++){
                list.add(scan.next().charAt(0));
            }
            scan.nextLine();
            int sum = 0;
            for (int i = 0;i<6;i++){
                char element = list.get(i);
                if(element == 'A'){
                    sum += 4;
                }
                else if(element == 'B'){
                    sum += 3;
                }
                else if(element == 'C'){
                    sum += 2;
                }
                else if(element == 'D'){
                    sum += 1;
                }
                else if(element == 'F'){
                    sum += 0;
                }
            }
            System.out.println((sum/6.0F));
        }
        /*
        ����3
        ���� �˻� HashMap ����
         */
        else if(problem.equals("3")){
            HashMap<String, Integer> nations = new HashMap<String, Integer>();
            System.out.println("���� �̸��� �α��� �Է��ϼ���.(�� : korea 5000)");
            while (true){
                System.out.print("���� �̸�,�α� >> ");
                String nationName = scan.next();
                if(nationName.equals("�׸�")){
                    scan.nextLine();
                    break;
                }
                int population = scan.nextInt();
                scan.nextLine();
                nations.put(nationName,population);
            }
            while (true){
                System.out.print("�α� �˻� >> ");
                String searchNationName = scan.nextLine();
                if(searchNationName.equals("�׸�")){
                    break;
                }
                Integer population = nations.get(searchNationName);
                if(population != null){
                    System.out.println(searchNationName+"�� �α��� "+population);
                }
                else{
                    System.out.println(searchNationName+" ����� �����ϴ�.");
                }
            }
        }
        /*
        ����4
        ������ ��� ��� Vector ����
         */
        else if(problem.equals("4")){
             Vector<Integer> vector = new Vector<Integer>();
             while (true){
                 System.out.print("������ �Է� (0 �Է½� ����) >>");
                 int number = scan.nextInt();
                 scan.nextLine();
                 if(number == 0){
                     break;
                 }
                 vector.add(number);
                 int sum = 0;
                 for(int i : vector){
                     System.out.print(i+" ");
                     sum += i;
                 }
                 System.out.println();
                 System.out.println("���� ��� "+sum/vector.size());
             }
        }
        /*
        ����5
        ArrayList�� �̿��� Person ��ü �����ϱ�
        ���� ������� HashMap�� �̿��� Person ��ü �����ϱ�
        ����ڴ� �л� �̸��� ���� �л� ������ ã�����ִ�.
         */
        else if(problem.equals("5-1")){
            ArrayList<Student> studentList = new ArrayList<Student>();
            System.out.println("���� �̸�,�а�,�й�,������� �Է��ϼ���.");
            //����ڿ��� ������ �Է¹޾� person ��ü 4�� ����
            for(int i =0;i<4;i++){
                System.out.print(">> ");
                String name = scan.next();
                String major = scan.next();
                int id = scan.nextInt();
                float GradePointAverage = scan.nextFloat();
                scan.nextLine();
                studentList.add(new Student(name,major,id,GradePointAverage));
            }

            //������ person ��ü�� ���
            for (Student student : studentList){
                System.out.println("----------------");
                System.out.println(student);
            }
            //�л� �̸��� ���� �л� ���� ���
            while (true){
                System.out.print("�л� �̸� >> ");
                String name = scan.nextLine();
                if(name.equals("�׸�"))
                    break;
                Student student = null;
                for(Student st : studentList){
                    if(st.getName().equals(name)){
                        student = st;
                        break;
                    }
                }
                if(student != null){
                    System.out.println(student);
                }
            }
        }
        else if(problem.equals("5-2")){
            HashMap<String,Student> studentMap = new HashMap<String, Student>();
            System.out.println("���� �̸�,�а�,�й�,������� �Է��ϼ���.");
            //����ڿ��� ������ �Է¹޾� person ��ü 4�� ����
            for(int i =0;i<4;i++){
                System.out.print(">> ");
                String name = scan.next();
                String major = scan.next();
                int id = scan.nextInt();
                float GradePointAverage = scan.nextFloat();
                scan.nextLine();
                studentMap.put(name,new Student(name,major,id,GradePointAverage));
            }
            Set<String> set = studentMap.keySet();
            Iterator<String> it = set.iterator();
            while (it.hasNext()){
                System.out.println("----------------");
                System.out.println(studentMap.get(it.next()));
            }
            while (true){
                System.out.print("�л� �̸� >> ");
                String name = scan.nextLine();
                if(name.equals("�׸�"))
                    break;
                System.out.println(studentMap.get(name));
            }
        }
        /*
        ����6
        ���� �̸�,����,�浵 ������ ���� Location ��ü�� ���� ���� ������ �����ϰ�
        ����ڰ� �̸��� �Է��ϸ� ���� ������ ���
         */
        else if(problem.equals("6")){
            HashMap<String,Location> locationMap = new HashMap<String, Location>();
            System.out.println("����, �浵 ������ �Է��ϼ���.");
            for(int i =0;i<4;i++){
                System.out.print(">> ");
                String name = scan.next();
                int longitude = scan.nextInt();
                int latitude = scan.nextInt();
                scan.nextLine();
                locationMap.put(name,new Location(name,longitude,latitude));
            }
            Iterator<String> it = locationMap.keySet().iterator();
            while (it.hasNext()){
                System.out.println(locationMap.get(it.next()));
            }
            while (true){
                System.out.print("���� �̸� >> ");
                String name = scan.nextLine();
                if(name.equals("�׸�"))
                    break;
                Location location = locationMap.get(name);
                if(location != null){
                    System.out.println(location);
                }
                else{
                    System.out.println(name+"�� �����ϴ�.");
                }
            }
        }
        /*
        ����7
        ���л� �̱�, �л�, ������ �Է��ϰ� ���л� �����ϱ�
         */
        else if(problem.equals("7")){
            HashMap<String,Float> studentMap = new HashMap<String, Float>();
            System.out.println("���бݰ��� �ý����Դϴ�.");
            for(int i = 0;i<5;i++){
                System.out.print("�̸��� ���� >> ");
                String name = scan.next();
                float grade = scan.nextFloat();
                scan.nextLine();
                studentMap.put(name,grade);
            }
            System.out.print("���л� ���� ���� ���� �Է� >> ");
            Float standardGrade = scan.nextFloat();
            scan.nextLine();
            System.out.print("���л� ��� : ");
            Iterator<String> it = studentMap.keySet().iterator();
            while (it.hasNext()){
                String name = it.next();
                if(studentMap.get(name) >= standardGrade)
                    System.out.print(name+"  ");
            }
        }
        /*
        ����8
        HashMap�� ���� �� ����Ʈ ����
         */
        else if(problem.equals("8")){
            HashMap<String,Integer> customerMap = new HashMap<String, Integer>();
            Set<String> set = customerMap.keySet();
            System.out.println("** ����Ʈ ���� ���α׷��Դϴ� **");
            while (true){
                System.out.print("�̸��� ����Ʈ �Է� >> ");
                String name = scan.next();
                if(name.equals("�׸�"))
                    break;
                int point = scan.nextInt();
                if(customerMap.get(name) == null){
                    customerMap.put(name,point);
                }
                else{
                    customerMap.put(name,customerMap.get(name)+point);
                }
                Iterator<String> it = set.iterator();
                while (it.hasNext()){
                    String i = it.next();
                    System.out.print("("+i+","+customerMap.get(i)+")");
                }
                System.out.println();
            }
        }
        /*
        ����9
        ���׸����� ���� ����
         */
        else if(problem.equals("9")){
            Stack<Integer> stack = new Stack<Integer>();
            stack.push(0);
            stack.push(3);
            stack.push(1);
            stack.push(6);
            stack.push(12);
            stack.push(-5);
            stack.push(33);
            stack.printStack();
            stack.pop();
            stack.pop();
            stack.pop();
            stack.pop();
            stack.printStack();
        }
        /*
        ����10
        ����� ���� ���߱� ����
        ����� ������ �Է��ϰ� ��� ����.
         */
        else if(problem.equals("10")){
            HashMap<String,String> capitalMap = new HashMap<String,String>();
            while (true){
                System.out.println("**** ���� ���߱� ������ �����մϴ�. ****");
                System.out.print("�Է� : 1 ���� : 2 ���� : 3 >> ");
                String select = scan.nextLine();
                //���� �Է��ϱ�
                if(select.equals("1")){
                    while (true){
                        System.out.print("����� ���� �Է�"+(capitalMap.size()+1)+">>  ");
                        String countryName = scan.next();
                        if(countryName.equals("�׸�")){
                            scan.nextLine();
                            break;
                        }
                        String capital = scan.next();
                        scan.nextLine();
                        System.out.println(countryName+"   "+capital);
                        if(capitalMap.get(countryName) == null){
                            capitalMap.put(countryName,capital);
                        }
                        else{
                            System.out.println(countryName+"�� �̹� �ֽ��ϴ�!!");
                        }
                    }
                }
                //���� ����
                else if(select.equals("2")){
                    ArrayList<String> keys = new ArrayList<String>(capitalMap.keySet());
                    Iterator<String> it = capitalMap.keySet().iterator();
                    int[] order = WordQuiz.RandomSelect(keys.size(),keys.size());
                    for(int i=0;i<keys.size();i++){
                        String countryName = keys.get(order[i]);
                        System.out.print(countryName+"�� ������?");
                        String answer = scan.nextLine();
                        if(answer.equals("�׸�"))
                            break;
                        if(capitalMap.get(countryName).equals(answer))
                            System.out.println("����!");
                        else
                            System.out.println("�ƴմϴ�!!");
                    }
                }
                else if(select.equals("3")){
                    break;
                }
                else{
                    System.out.println("�߸��Է��߽��ϴ�.");
                }
            }
        }
        /*
        ����11
        mov add sub jn0 prt ����� �����ϴ� ���α׷� �ۼ�
        mov �� = add + sub - jn0 ���� ��ɾ�� �ݺ�(for, while)�� ���� ����� �Ѵ�.
        ex) mov sum 0   sum = 0;
            add sum i   sum += i;
            sub n   1   n   -= 1;
            jno n   3   3��°���� ��ɾ�� ���ư� 1���� ���� ��ɾ���� n�� 0�� �ɶ����� �ݺ�
            prt sum 0   sum�� ��� 3��° ���ڴ� �ƹ� �ǹ� ����.
         */
        else if(problem.equals("11")){
            //ActivateCommand Ŭ���� ����.
            ActivateCommand.inputCommand();
            ActivateCommand.activateCommand();
        }
        scan.close();
    }
}
