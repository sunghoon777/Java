package chapter7;

import chapter6.Person;

import java.io.*;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Vector;

public class Main {

    public static Scanner scanner = new Scanner(System.in);

    //전화번호 입력받아서 파일에 저장하기
    public static void problem1(){
        System.out.println("전화번호 입력 프로그램입니다.");
        FileWriter fileWriter;
        try {
            fileWriter = new FileWriter("C:\\Users\\user\\Desktop\\workspace\\Java\\src\\chapter7\\phone.txt");
            while (true){
                System.out.print("이름 전화번호 >> ");
                String information = scanner.nextLine();
                if(information.equals("그만")){
                    break;
                }
                fileWriter.write(information+"\n");
            }
            fileWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println("phone.txt 파일에 정보를 저장했습니다.");
    }

    //파일에서 전화번호 읽어오기
    public static void problem2(){
        System.out.println("phone.txt 에서 정보를 가져옵니다.");
        FileReader fileReader;
        BufferedReader bufferedReader;
        try {
            fileReader = new FileReader("C:\\Users\\user\\Desktop\\workspace\\Java\\src\\chapter7\\phone.txt");
            bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine()) != null){
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //파일을 읽어서 소문자를 모두 대문자로 만들기
    public static void problem3(){
        System.out.println("파일안에 영어 문자들을 모두 대문자로 출력해보기");
        FileReader fileReader;
        BufferedReader bufferedReader;
        try {
            fileReader = new FileReader("C:\\Users\\user\\Desktop\\workspace\\Java\\src\\chapter7\\problem3.txt");
            bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine()) != null){
                System.out.println(line.toUpperCase());
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //파일을 읽어서 라인마다 넘버링 붙여서 출력해주기
    public static void problem4(){
        System.out.println("넘버링 붙이기");
        FileReader fileReader;
        BufferedReader bufferedReader;
        try {
            fileReader = new FileReader("C:\\Users\\user\\Desktop\\workspace\\Java\\src\\chapter7\\서울상권데이터.csv");
            bufferedReader = new BufferedReader(fileReader);
            String line;
            int count = 1;
            while ((line = bufferedReader.readLine()) != null){
                System.out.println(count+": "+line);
                count++;
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //두개의 파일이 완전히 동일한지 비교
    public static void problem5(){
        System.out.println("파일이 동일한지 비교한다.");
        FileInputStream fileInputStream1;
        FileInputStream fileInputStream2;
        try {
            fileInputStream1 = new FileInputStream("C:\\Users\\user\\Desktop\\workspace\\Java\\src\\chapter7\\심슨_복사본.png");
            fileInputStream2 = new FileInputStream("C:\\Users\\user\\Desktop\\workspace\\Java\\src\\chapter7\\심슨.png");
            int c;
            int c2;
            while (true){
                c = fileInputStream1.read();
                c2 = fileInputStream2.read();
                if(c != c2){
                    System.out.println("두 개의 파일은 다릅니다.");
                    break;
                }
                if(c == -1 || c2 == -1){
                    break;
                }
            }
            System.out.println("두 개의 파일은 같습니다.");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //2개의 텍스트 파일을 덧붙이기
    public static void problem6(){
        System.out.println("2개의 텍스트 파일을 덧붙여서 합치기");
        System.out.println("첫 번째 파일 이름을 입력하세요");
        File file1 = new File("C:\\Users\\user\\Desktop\\workspace\\Java\\src\\chapter7\\"+scanner.nextLine());
        System.out.println("두 번째 파일 이름을 입력하세요");
        File file2 = new File("C:\\Users\\user\\Desktop\\workspace\\Java\\src\\chapter7\\"+scanner.nextLine());
        File appendFile = new File("C:\\Users\\user\\Desktop\\workspace\\Java\\src\\chapter7\\"+"append.txt");
        try {
            FileReader fileReader1 = new FileReader(file1);
            FileReader fileReader2 = new FileReader(file2);
            BufferedReader bufferedReader1 = new BufferedReader(fileReader1);
            BufferedReader bufferedReader2 = new BufferedReader(fileReader2);
            FileWriter fileWriter = new FileWriter(appendFile);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            String line;
            while ((line = bufferedReader1.readLine()) != null){
                bufferedWriter.write(line+"\n");
            }
            while ((line = bufferedReader2.readLine()) != null){
                bufferedWriter.write(line+"\n");
            }
            fileReader1.close();
            fileReader2.close();
            bufferedReader1.close();
            bufferedReader2.close();
            bufferedWriter.close();
            fileWriter.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    //바이너리 파일 복사 이미지 복사가 10% 진행될떄마다 "*" 출력 ,
    public static void problem7(){
        File file = new File("C:\\Users\\user\\Desktop\\workspace\\Java\\src\\chapter7\\심슨.png");
        File file2 = new File("C:\\Users\\user\\Desktop\\workspace\\Java\\src\\chapter7\\심슨_복사본.png");
        long fileLength = file.length();
        byte[] buf = new byte[1024];
        long fileKB = fileLength/1024;
        double progressPerWrite = ((double)1/fileKB * 100);
        double print = 0;
        int progress = 0;
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            FileOutputStream fileOutputStream = new FileOutputStream(file2);
            if(fileKB <= 0){
                int c = fileInputStream.read(buf);
                fileOutputStream.write(buf,0,c);
                System.out.println("**********");
            }
            else{
                int c;
                while ((c=fileInputStream.read(buf)) >= 1024){
                    print += progressPerWrite;
                    if(print >= 10){
                        int a = (int)(print/10);
                        for(int i=0;i<a;i++){
                            System.out.print("*");
                            progress++;
                        }
                        print -= (a*10);
                    }
                }
                if((c=fileInputStream.read(buf))!=-1){
                    fileOutputStream.write(buf,0,c);
                    for(int i=0;i<(10-progress);i++){
                        System.out.print("*");
                    }
                }
            }
            fileInputStream.close();
            fileOutputStream.close();
        } catch (FileNotFoundException e) {
            System.out.println("오류");
            throw new RuntimeException(e);
        } catch (IOException e) {
            System.out.println("오류");
            throw new RuntimeException(e);
        }

    }

    //c:\ 파일에서 가장 큰 파일 찾기
    public static void problem8(){
        File file = new File("C:\\");
        File[] files = file.listFiles();
        long max = 0;
        int maxIndex = 0;
        for(int i=0;i<files.length;i++){
            if(max < files[i].length()){
                max = files[i].length();
                maxIndex = i;
            }
        }
        System.out.println("가장 큰 파일은 "+files[maxIndex].getPath()+" "+((double)files[maxIndex].length()/(1024*1024))+"MB");
    }

    //problem9 디렉토리에 들어있는 txt 파일 모두 지우기
    public static void problem9(){
        File rootPath = new File(".");
        File file = new File(rootPath.getAbsolutePath()+"\\src\\chapter7\\problem9");
        File[] files = file.listFiles();
        for(File i : files){
            if(i.isFile()){
                String name = i.getName();
                if(name.length()>=4&&name.substring(name.length()-4).equals(".txt")){
                    i.delete();
                }
            }
        }
    }

    //phone.txt를 읽어서 해쉬맵에 저장하고 이름에 따라 전화번호 출력해주기
    public static void problem10(){
        File rootPath = new File(".");
        File file = new File(rootPath.getAbsolutePath()+"\\src\\chapter7\\phone.txt");
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            HashMap<String,String> hashMap = new HashMap<String, String>();
            while ((line=bufferedReader.readLine()) != null){
                String a[] = line.split(" ");
                hashMap.put(a[0],a[1]);
            }
            System.out.println("총 "+hashMap.size()+" 개의 전화번호를 읽었습니다.");
            while (true){
                System.out.print("이름 >> ");
                String key = scanner.nextLine();
                if(key.equals("그만"))
                    break;
                System.out.println(hashMap.get(key));
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //시작 단어 입력하고 해당되는 단어 출력해주기
    public static void problem11(){
        File rootPath = new File(".");
        File file = new File(rootPath.getAbsolutePath()+"\\src\\chapter7_openchallenge\\words.txt");
        FileReader fileReader = null;
        try {
            fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            Vector<String> wordList = new Vector<String>();
            while ((line=bufferedReader.readLine()) != null){
                wordList.add(line);
            }
            System.out.println("words.txt 를 읽었습니다.");
            while (true){
                System.out.print("단어>>");
                String findWord = scanner.nextLine();
                if(findWord.equals("그만"))
                    break;
                boolean flag = false;
                for(String word : wordList){
                    if(word.startsWith(findWord)){
                        System.out.println(word);
                        flag = true;
                    }
                }
                if(flag == false){
                    System.out.println("단어를 발견 못함");
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //파일내 단어 찾고 그 단어를 포함하고있는 줄 출력하기
    public static void problem12(){
        System.out.println("파일 이름을 입력하세요");
        File rootPath = new File(".");
        File rootParent = new File(rootPath.getAbsolutePath()+"\\src\\chapter7");
        System.out.print("파일명 입력 >> ");
        File file = new File(rootParent,scanner.nextLine());
        FileReader fileReader = null;
        try {
            fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            Vector<String> list = new Vector<String>();
            while ((line = bufferedReader.readLine()) != null){
                list.add(line);
            }
            String findWord;
            while (true){
                System.out.print("검색할 단어나 문장 >>");
                findWord = scanner.nextLine();
                if(findWord.equals("그만"))
                    break;
                int count = 1;
                boolean flag = false;
                for(String i : list){
                    if(i.lastIndexOf(findWord) != -1){
                        System.out.println(count+" : "+i);
                        flag = true;
                    }
                    count++;
                }
                if(flag == false){
                    System.out.println("발견할 수 없음");
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //간단한 파일 탐색기, c:\ 에서 부터 파일을 탐색한다. ..를 누르면 부모로 가고 디렉토리명을 입력하면 해당 디렉토리명으로 이동하고 디렉토리안에 파일들을 출력해준다.
    public static void problem13(){
        System.out.println("********파일 탐색기********");
        File currentDirectory = new File("C:\\");
        File currentDirectoryFiles[] = currentDirectory.listFiles();
        System.out.println(currentDirectory.getAbsolutePath());
        for(File file : currentDirectoryFiles){
            System.out.printf("%-15s  %-15s  %-15s\n",(file.isFile()?"file":"directory"),(file.length()/1024)+"KB",file.getName());
        }
        while (true){
            System.out.print(">>");
            String command = scanner.nextLine();
            if(command.equals("그만"))
                break;
            if(command.equals("..")){
                if(currentDirectory.getParentFile() != null){
                    currentDirectory = currentDirectory.getParentFile();
                    currentDirectoryFiles = currentDirectory.listFiles();
                    System.out.println(currentDirectory.getAbsolutePath());
                    for(File file : currentDirectoryFiles){
                        System.out.printf("%-15s  %-15s  %-15s\n",(file.isFile()?"file":"directory"),(file.length()/1024)+"KB",file.getName());
                    }
                }
                else{
                    System.out.println("최상위 디렉토리입니다.");
                }
            }
            else{
                for(File file : currentDirectoryFiles){
                    if(file.getName().equals(command)){
                        if(file.isDirectory()){
                            currentDirectory = file;
                            currentDirectoryFiles = currentDirectory.listFiles();
                            System.out.println(currentDirectory.getAbsolutePath());
                            for(File file1 : currentDirectoryFiles){
                                System.out.printf("%-15s  %-15s  %-15s\n",(file1.isFile()?"file":"directory"),(file1.length()/1024)+"KB",file1.getName());
                            }
                            break;
                        }
                        else{
                            System.out.println("파일로는 이동 못합니다.");
                            break;
                        }
                    }
                }
            }
        }
    }

    //간단한 파일 탐색기 problem13에 명령어를 추가해서 rename mkdir 명령어 추가 ex) rename a.txt b.txt -> a.txt의 이름을 b.txt로 변경하기
    //ex) mkdir aaa  -> 현재 디렉토리에서 aaa 디렉토리 생성
    public static void problem14(){
        System.out.println("********파일 탐색기********");
        File currentDirectory = new File("C:\\");
        File currentDirectoryFiles[] = currentDirectory.listFiles();
        System.out.println(currentDirectory.getAbsolutePath());
        for(File file : currentDirectoryFiles){
            System.out.printf("%-15s  %-15s  %-15s\n",(file.isFile()?"file":"directory"),(file.length()/1024)+"KB",file.getName());
        }
        while (true){
            System.out.print(">>");
            String command = scanner.nextLine();
            if(command.equals("그만"))
                break;

            //상위 디렉토리로
            if(command.equals("..")){
                if(currentDirectory.getParentFile() != null){
                    currentDirectory = currentDirectory.getParentFile();
                    currentDirectoryFiles = currentDirectory.listFiles();
                    System.out.println(currentDirectory.getAbsolutePath());
                    for(File file : currentDirectoryFiles){
                        System.out.printf("%-15s  %-15s  %-15s\n",(file.isFile()?"file":"directory"),(file.length()/1024)+"KB",file.getName());
                    }
                }
                else{
                    System.out.println("최상위 디렉토리입니다.");
                }
            }

            //파일 이름 바꾸기
            else if(command.startsWith("rename")){
                String list[] = command.split(" ");
                for(File file : currentDirectoryFiles){
                    if(file.getName().equals(list[1])){
                        file.renameTo(new File(currentDirectory.getAbsolutePath()+"\\"+list[2]));
                        break;
                    }
                }
                System.out.println(currentDirectory.getAbsolutePath());
                currentDirectoryFiles = currentDirectory.listFiles();
                for(File file : currentDirectoryFiles){
                    System.out.printf("%-15s  %-15s  %-15s\n",(file.isFile()?"file":"directory"),(file.length()/1024)+"KB",file.getName());
                }
            }

            //디렉토리 만들기
            else if(command.startsWith("mkdir")){
                String list[] = command.split(" ");
                File file1 = new File(currentDirectory.getAbsolutePath()+"\\"+list[1]);
                if(!(file1.exists())){
                    file1.mkdir();
                    System.out.println(currentDirectory.getAbsolutePath());
                    currentDirectoryFiles = currentDirectory.listFiles();
                    for(File file : currentDirectoryFiles){
                        System.out.printf("%-15s  %-15s  %-15s\n",(file.isFile()?"file":"directory"),(file.length()/1024)+"KB",file.getName());
                    }
                }
                else{
                    System.out.println("이미 존재하는 디렉토리입니다.");
                }
            }

            //해당 디렉토리로 이동
            else{
                for(File file : currentDirectoryFiles){
                    if(file.getName().equals(command)){
                        if(file.isDirectory()){
                            currentDirectory = file;
                            currentDirectoryFiles = currentDirectory.listFiles();
                            System.out.println(currentDirectory.getAbsolutePath());
                            for(File file1 : currentDirectoryFiles){
                                System.out.printf("%-15s  %-15s  %-15s\n",(file1.isFile()?"file":"directory"),(file1.length()/1024)+"KB",file1.getName());
                            }
                            break;
                        }
                        else{
                            System.out.println("파일로는 이동 못합니다.");
                            break;
                        }
                    }
                }
            }
        }
    }



    public static void main(String[] args) {
        problem14();
    }

}
