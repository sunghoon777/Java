package chapter7;

import chapter6.Person;

import java.io.*;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Vector;

public class Main {

    public static Scanner scanner = new Scanner(System.in);

    //��ȭ��ȣ �Է¹޾Ƽ� ���Ͽ� �����ϱ�
    public static void problem1(){
        System.out.println("��ȭ��ȣ �Է� ���α׷��Դϴ�.");
        FileWriter fileWriter;
        try {
            fileWriter = new FileWriter("C:\\Users\\user\\Desktop\\workspace\\Java\\src\\chapter7\\phone.txt");
            while (true){
                System.out.print("�̸� ��ȭ��ȣ >> ");
                String information = scanner.nextLine();
                if(information.equals("�׸�")){
                    break;
                }
                fileWriter.write(information+"\n");
            }
            fileWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println("phone.txt ���Ͽ� ������ �����߽��ϴ�.");
    }

    //���Ͽ��� ��ȭ��ȣ �о����
    public static void problem2(){
        System.out.println("phone.txt ���� ������ �����ɴϴ�.");
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

    //������ �о �ҹ��ڸ� ��� �빮�ڷ� �����
    public static void problem3(){
        System.out.println("���Ͼȿ� ���� ���ڵ��� ��� �빮�ڷ� ����غ���");
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

    //������ �о ���θ��� �ѹ��� �ٿ��� ������ֱ�
    public static void problem4(){
        System.out.println("�ѹ��� ���̱�");
        FileReader fileReader;
        BufferedReader bufferedReader;
        try {
            fileReader = new FileReader("C:\\Users\\user\\Desktop\\workspace\\Java\\src\\chapter7\\�����ǵ�����.csv");
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

    //�ΰ��� ������ ������ �������� ��
    public static void problem5(){
        System.out.println("������ �������� ���Ѵ�.");
        FileInputStream fileInputStream1;
        FileInputStream fileInputStream2;
        try {
            fileInputStream1 = new FileInputStream("C:\\Users\\user\\Desktop\\workspace\\Java\\src\\chapter7\\�ɽ�_���纻.png");
            fileInputStream2 = new FileInputStream("C:\\Users\\user\\Desktop\\workspace\\Java\\src\\chapter7\\�ɽ�.png");
            int c;
            int c2;
            while (true){
                c = fileInputStream1.read();
                c2 = fileInputStream2.read();
                if(c != c2){
                    System.out.println("�� ���� ������ �ٸ��ϴ�.");
                    break;
                }
                if(c == -1 || c2 == -1){
                    break;
                }
            }
            System.out.println("�� ���� ������ �����ϴ�.");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //2���� �ؽ�Ʈ ������ �����̱�
    public static void problem6(){
        System.out.println("2���� �ؽ�Ʈ ������ ���ٿ��� ��ġ��");
        System.out.println("ù ��° ���� �̸��� �Է��ϼ���");
        File file1 = new File("C:\\Users\\user\\Desktop\\workspace\\Java\\src\\chapter7\\"+scanner.nextLine());
        System.out.println("�� ��° ���� �̸��� �Է��ϼ���");
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

    //���̳ʸ� ���� ���� �̹��� ���簡 10% ����ɋ����� "*" ��� ,
    public static void problem7(){
        File file = new File("C:\\Users\\user\\Desktop\\workspace\\Java\\src\\chapter7\\�ɽ�.png");
        File file2 = new File("C:\\Users\\user\\Desktop\\workspace\\Java\\src\\chapter7\\�ɽ�_���纻.png");
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
            System.out.println("����");
            throw new RuntimeException(e);
        } catch (IOException e) {
            System.out.println("����");
            throw new RuntimeException(e);
        }

    }

    //c:\ ���Ͽ��� ���� ū ���� ã��
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
        System.out.println("���� ū ������ "+files[maxIndex].getPath()+" "+((double)files[maxIndex].length()/(1024*1024))+"MB");
    }

    //problem9 ���丮�� ����ִ� txt ���� ��� �����
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

    //phone.txt�� �о �ؽ��ʿ� �����ϰ� �̸��� ���� ��ȭ��ȣ ������ֱ�
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
            System.out.println("�� "+hashMap.size()+" ���� ��ȭ��ȣ�� �о����ϴ�.");
            while (true){
                System.out.print("�̸� >> ");
                String key = scanner.nextLine();
                if(key.equals("�׸�"))
                    break;
                System.out.println(hashMap.get(key));
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //���� �ܾ� �Է��ϰ� �ش�Ǵ� �ܾ� ������ֱ�
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
            System.out.println("words.txt �� �о����ϴ�.");
            while (true){
                System.out.print("�ܾ�>>");
                String findWord = scanner.nextLine();
                if(findWord.equals("�׸�"))
                    break;
                boolean flag = false;
                for(String word : wordList){
                    if(word.startsWith(findWord)){
                        System.out.println(word);
                        flag = true;
                    }
                }
                if(flag == false){
                    System.out.println("�ܾ �߰� ����");
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //���ϳ� �ܾ� ã�� �� �ܾ �����ϰ��ִ� �� ����ϱ�
    public static void problem12(){
        System.out.println("���� �̸��� �Է��ϼ���");
        File rootPath = new File(".");
        File rootParent = new File(rootPath.getAbsolutePath()+"\\src\\chapter7");
        System.out.print("���ϸ� �Է� >> ");
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
                System.out.print("�˻��� �ܾ ���� >>");
                findWord = scanner.nextLine();
                if(findWord.equals("�׸�"))
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
                    System.out.println("�߰��� �� ����");
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //������ ���� Ž����, c:\ ���� ���� ������ Ž���Ѵ�. ..�� ������ �θ�� ���� ���丮���� �Է��ϸ� �ش� ���丮������ �̵��ϰ� ���丮�ȿ� ���ϵ��� ������ش�.
    public static void problem13(){
        System.out.println("********���� Ž����********");
        File currentDirectory = new File("C:\\");
        File currentDirectoryFiles[] = currentDirectory.listFiles();
        System.out.println(currentDirectory.getAbsolutePath());
        for(File file : currentDirectoryFiles){
            System.out.printf("%-15s  %-15s  %-15s\n",(file.isFile()?"file":"directory"),(file.length()/1024)+"KB",file.getName());
        }
        while (true){
            System.out.print(">>");
            String command = scanner.nextLine();
            if(command.equals("�׸�"))
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
                    System.out.println("�ֻ��� ���丮�Դϴ�.");
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
                            System.out.println("���Ϸδ� �̵� ���մϴ�.");
                            break;
                        }
                    }
                }
            }
        }
    }

    //������ ���� Ž���� problem13�� ��ɾ �߰��ؼ� rename mkdir ��ɾ� �߰� ex) rename a.txt b.txt -> a.txt�� �̸��� b.txt�� �����ϱ�
    //ex) mkdir aaa  -> ���� ���丮���� aaa ���丮 ����
    public static void problem14(){
        System.out.println("********���� Ž����********");
        File currentDirectory = new File("C:\\");
        File currentDirectoryFiles[] = currentDirectory.listFiles();
        System.out.println(currentDirectory.getAbsolutePath());
        for(File file : currentDirectoryFiles){
            System.out.printf("%-15s  %-15s  %-15s\n",(file.isFile()?"file":"directory"),(file.length()/1024)+"KB",file.getName());
        }
        while (true){
            System.out.print(">>");
            String command = scanner.nextLine();
            if(command.equals("�׸�"))
                break;

            //���� ���丮��
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
                    System.out.println("�ֻ��� ���丮�Դϴ�.");
                }
            }

            //���� �̸� �ٲٱ�
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

            //���丮 �����
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
                    System.out.println("�̹� �����ϴ� ���丮�Դϴ�.");
                }
            }

            //�ش� ���丮�� �̵�
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
                            System.out.println("���Ϸδ� �̵� ���մϴ�.");
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
