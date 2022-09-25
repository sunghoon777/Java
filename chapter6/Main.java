package chapter6;


import chapter5.A;
import chapter6_openchallenge.WordQuiz;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        System.out.println("문제를 선택하세요");
        Scanner scan = new Scanner(System.in);
        String problem = scan.nextLine();
        /*
        문제1
        정수 입력받아서 가장 큰 수 출력, Collections의 max 메소드 사용
         */
        if(problem.equals("1")){
            ArrayList<Integer> list = new ArrayList<Integer>();
            System.out.print("정수(-1이 입력될 때까지)>> ");
            while (true){
                int element = scan.nextInt();
                if(element == -1)
                    break;
                else
                    list.add(element);
            }
            scan.nextLine();
            System.out.println("가장 큰 수는 "+Collections.max(list));
        }
        /*
        문제2
        6개의 과목의 학점을 입력받아서 점수로 치환하고 평균점수 출력
         */
        else if(problem.equals("2")){
            ArrayList<Character> list = new ArrayList<Character>();
            System.out.print("6개의 학점을 빈 칸으로 분리 입력(A/B/C/D/F) >> ");
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
        문제3
        나라 검색 HashMap 연습
         */
        else if(problem.equals("3")){
            HashMap<String, Integer> nations = new HashMap<String, Integer>();
            System.out.println("나라 이름과 인구를 입력하세요.(예 : korea 5000)");
            while (true){
                System.out.print("나라 이름,인구 >> ");
                String nationName = scan.next();
                if(nationName.equals("그만")){
                    scan.nextLine();
                    break;
                }
                int population = scan.nextInt();
                scan.nextLine();
                nations.put(nationName,population);
            }
            while (true){
                System.out.print("인구 검색 >> ");
                String searchNationName = scan.nextLine();
                if(searchNationName.equals("그만")){
                    break;
                }
                Integer population = nations.get(searchNationName);
                if(population != null){
                    System.out.println(searchNationName+"의 인구는 "+population);
                }
                else{
                    System.out.println(searchNationName+" 나라는 없습니다.");
                }
            }
        }
        /*
        문제4
        강수량 평균 계산 Vector 연습
         */
        else if(problem.equals("4")){
             Vector<Integer> vector = new Vector<Integer>();
             while (true){
                 System.out.print("강수량 입력 (0 입력시 종료) >>");
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
                 System.out.println("현재 평균 "+sum/vector.size());
             }
        }
        /*
        문제5
        ArrayList를 이용해 Person 객체 저장하기
        같은 방법으로 HashMap을 이용해 Person 객체 저장하기
        사용자는 학생 이름을 통해 학생 정보를 찾을수있다.
         */
        else if(problem.equals("5-1")){
            ArrayList<Student> studentList = new ArrayList<Student>();
            System.out.println("학점 이름,학과,학번,학점평균 입력하세요.");
            //사용자에게 정보를 입력받아 person 객체 4개 생성
            for(int i =0;i<4;i++){
                System.out.print(">> ");
                String name = scan.next();
                String major = scan.next();
                int id = scan.nextInt();
                float GradePointAverage = scan.nextFloat();
                scan.nextLine();
                studentList.add(new Student(name,major,id,GradePointAverage));
            }

            //생성한 person 객체들 출력
            for (Student student : studentList){
                System.out.println("----------------");
                System.out.println(student);
            }
            //학생 이름을 통해 학생 정보 출력
            while (true){
                System.out.print("학생 이름 >> ");
                String name = scan.nextLine();
                if(name.equals("그만"))
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
            System.out.println("학점 이름,학과,학번,학점평균 입력하세요.");
            //사용자에게 정보를 입력받아 person 객체 4개 생성
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
                System.out.print("학생 이름 >> ");
                String name = scan.nextLine();
                if(name.equals("그만"))
                    break;
                System.out.println(studentMap.get(name));
            }
        }
        /*
        문제6
        도시 이름,위도,경도 정보를 가진 Location 객체를 통해 도시 정보를 저장하고
        사용자가 이름을 입력하면 도시 정보를 출력
         */
        else if(problem.equals("6")){
            HashMap<String,Location> locationMap = new HashMap<String, Location>();
            System.out.println("도시, 경도 위도를 입력하세요.");
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
                System.out.print("도시 이름 >> ");
                String name = scan.nextLine();
                if(name.equals("그만"))
                    break;
                Location location = locationMap.get(name);
                if(location != null){
                    System.out.println(location);
                }
                else{
                    System.out.println(name+"은 없습니다.");
                }
            }
        }
        /*
        문제7
        장학생 뽑기, 학생, 학점을 입력하고 장학생 선출하기
         */
        else if(problem.equals("7")){
            HashMap<String,Float> studentMap = new HashMap<String, Float>();
            System.out.println("장학금관리 시스템입니다.");
            for(int i = 0;i<5;i++){
                System.out.print("이름과 학점 >> ");
                String name = scan.next();
                float grade = scan.nextFloat();
                scan.nextLine();
                studentMap.put(name,grade);
            }
            System.out.print("장학생 선발 학점 기준 입력 >> ");
            Float standardGrade = scan.nextFloat();
            scan.nextLine();
            System.out.print("장학생 명단 : ");
            Iterator<String> it = studentMap.keySet().iterator();
            while (it.hasNext()){
                String name = it.next();
                if(studentMap.get(name) >= standardGrade)
                    System.out.print(name+"  ");
            }
        }
        /*
        문제8
        HashMap을 통한 고객 포인트 관리
         */
        else if(problem.equals("8")){
            HashMap<String,Integer> customerMap = new HashMap<String, Integer>();
            Set<String> set = customerMap.keySet();
            System.out.println("** 포인트 관리 프로그램입니다 **");
            while (true){
                System.out.print("이름과 포인트 입력 >> ");
                String name = scan.next();
                if(name.equals("그만"))
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
        문제9
        제네릭으로 스택 구현
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
        문제10
        나라와 수도 맞추기 게임
        나라와 수도를 입력하고 퀴즈를 낸다.
         */
        else if(problem.equals("10")){
            HashMap<String,String> capitalMap = new HashMap<String,String>();
            while (true){
                System.out.println("**** 수도 맞추기 게임을 시작합니다. ****");
                System.out.print("입력 : 1 퀴즈 : 2 종료 : 3 >> ");
                String select = scan.nextLine();
                //퀴즈 입력하기
                if(select.equals("1")){
                    while (true){
                        System.out.print("나라와 수도 입력"+(capitalMap.size()+1)+">>  ");
                        String countryName = scan.next();
                        if(countryName.equals("그만")){
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
                            System.out.println(countryName+"은 이미 있습니다!!");
                        }
                    }
                }
                //퀴즈 내기
                else if(select.equals("2")){
                    ArrayList<String> keys = new ArrayList<String>(capitalMap.keySet());
                    Iterator<String> it = capitalMap.keySet().iterator();
                    int[] order = WordQuiz.RandomSelect(keys.size(),keys.size());
                    for(int i=0;i<keys.size();i++){
                        String countryName = keys.get(order[i]);
                        System.out.print(countryName+"의 수도는?");
                        String answer = scan.nextLine();
                        if(answer.equals("그만"))
                            break;
                        if(capitalMap.get(countryName).equals(answer))
                            System.out.println("정답!");
                        else
                            System.out.println("아닙니다!!");
                    }
                }
                else if(select.equals("3")){
                    break;
                }
                else{
                    System.out.println("잘못입력했습니다.");
                }
            }
        }
        /*
        문제11
        mov add sub jn0 prt 명령을 실행하는 프로그램 작성
        mov 는 = add + sub - jn0 이전 명령어들 반복(for, while)과 같은 기능을 한다.
        ex) mov sum 0   sum = 0;
            add sum i   sum += i;
            sub n   1   n   -= 1;
            jno n   3   3번째이전 명령어로 돌아가 1번쨰 이전 명령어까지 n이 0이 될때까지 반복
            prt sum 0   sum을 출력 3번째 인자는 아무 의미 없음.
         */
        else if(problem.equals("11")){
            //ActivateCommand 클래스 참조.
            ActivateCommand.inputCommand();
            ActivateCommand.activateCommand();
        }
        scan.close();
    }
}
