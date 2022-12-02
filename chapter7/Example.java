package chapter7;

import java.io.*;
import java.util.Scanner;

public class Example {

    //���� �б�
    public static void ex1(){
        FileReader fileReader = null;
        try{
            fileReader = new FileReader("C:\\Users\\user\\Desktop\\workspace\\Java\\src\\chapter7\\text.txt");
            char[] buf = new char[10];
            int c;
            while ((c = fileReader.read(buf)) != -1){
                System.out.print(new String(buf));
            }
            fileReader.close();
        }catch (IOException e){
            System.out.println("�����߻�");
        }
    }
    
    //���� ����, filewriter���� ���۰� �ֱ���. �׷���  flush(���ۿ� �����ִ� ��Ʈ�� ��� write ��) close(flush �� ��Ʈ�� �ݱ�) �� �� ����� ���������� write�Ҽ� �ִ�.
    public static void ex2(){
        FileWriter fileWriter = null;
        Scanner scanner = new Scanner(System.in);
        try {
            fileWriter = new FileWriter("C:\\Users\\user\\Desktop\\workspace\\Java\\src\\chapter7\\text2.txt");
            while (true){
                String line = scanner.nextLine();
                if(line.length() == 0){
                    break;
                }
                fileWriter.write(line+"\r\n");
            }
            fileWriter.close();
        }catch(IOException e){
            System.out.println("�����߻�");
        }
    }
    
    //���� ����Ʈ�� �а� Ư�� ���ڼ��� ���� ���� �о����  ���� -> FileInputStream -> ����Ʈ -> InputStreamReader -> Ư�� ���ڼ����� ���� �б�
    public static void ex3(){
        InputStreamReader in = null;
        FileInputStream fin = null;
        try {
            fin = new FileInputStream("C:\\Users\\user\\Desktop\\workspace\\Java\\src\\chapter7\\text.txt");
            in = new InputStreamReader(fin,"MS949");
            char[] buf = new char[100];
            int c;
            while ((c = in.read(buf)) != -1){
                System.out.print(new String(buf));
            }
            in.close();
            fin.close();
        }catch (IOException e){
            System.out.println("����");
        }
    }

    //Ư�� ���ڼ��� ���� ���ڸ� ���� �� ���ڸ� ����Ʈ�� ��ȯ�Ͽ� ���Ͽ� ����   ����-> outputStreamWriter -> ���ڵ��� ����Ʈ -> fileOutputStream -> ���Ͽ� ����
    public static void ex4(){
        OutputStreamWriter outputStreamWriter = null;
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream("C:\\Users\\user\\Desktop\\workspace\\Java\\src\\chapter7\\text2.txt");
            outputStreamWriter = new OutputStreamWriter(fileOutputStream,"US-ASCII");
            outputStreamWriter.write("�ȳ�");
            outputStreamWriter.close();
            fileOutputStream.close();
        }catch (Exception e){
            System.out.println("����");
        }
    }
    
    //���Ͽ� byte�� �����ϰ� �ٽ� byte�� ��������
    public static void ex5(){
        byte b[] = {7,51,3,4,-1,24};
        try {
            FileOutputStream fileOutputStream = new FileOutputStream("C:\\Users\\user\\Desktop\\workspace\\Java\\src\\chapter7\\test.out");
            fileOutputStream.write(b);
            fileOutputStream.close();
            FileInputStream fileInputStream = new FileInputStream("C:\\Users\\user\\Desktop\\workspace\\Java\\src\\chapter7\\test.out");
            int c;
            while ((c=fileInputStream.read()) != -1){
                System.out.println((byte)c);
            }
            fileInputStream.close();
        }catch (Exception e){
            System.out.println("�����߻�");
        }
    }

    //buffer �̿� reader,
    // readLine �� �������� ������ null ���� ��ȯ�ϰų� \n\r�� ������ ������ ��ȯ
    public static void ex6(){
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("C:\\Users\\user\\Desktop\\workspace\\Java\\src\\chapter7\\text.txt"),100);
            int c;
            String data;
            while ((data = bufferedReader.readLine()) != null){
                System.out.println(data);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //buffer �̿� outputstream
    public static void ex7(){
        try {
            FileReader fileReader = new FileReader("C:\\Users\\user\\Desktop\\workspace\\Java\\src\\chapter7\\text2.txt");
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(System.out,100);
            int c;
            while ((c=fileReader.read()) != -1){
                bufferedOutputStream.write(c);
            }
            fileReader.close();
            bufferedOutputStream.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    //���� �޼ҵ� ����غ���
    public static void ex8(){
        File file = new File("C:\\Users\\user\\Desktop\\workspace\\Java\\src\\chapter7");
        File[] files = file.listFiles();
        int index = 0;
        for(int i=0;i< files.length;i++){
            System.out.println("----------------------------------------");
            System.out.println("���� �̸� : "+files[i].getName()+" ���� ���� ��� : "+files[i].getPath()+" ������ ���� : "+(files[i].isFile() == true?"����":"���丮"));
            System.out.println("���� ũ�� : "+files[i].length()+"byte");
            long time = files[i].lastModified();
            System.out.printf("������ ������ �����ð� : %tb %td %ta %tT\n",time,time,time,time);
            if(files[i].getName().equals("text2.txt")){
                index = i;
                System.out.println(files[i].getName());
            }
        }
        //test2 �� haha�� ����
        files[index].renameTo(new File("C:\\Users\\user\\Desktop\\workspace\\Java\\src\\text3.txt"));
    }

    //���� �����ϱ�
    public static void ex9(){
        File file = new File("C:\\Users\\user\\Desktop\\workspace\\Java\\src\\chapter7\\��������ġ������.csv");
        File file2 = new File("C:\\Users\\user\\Desktop\\workspace\\Java\\src\\chapter7\\��������ġ������_���纻.csv");
        try {
            FileReader fileReader = new FileReader(file);
            FileWriter fileWriter = new FileWriter(file2);
            int c;
            while ((c=fileReader.read()) != -1){
                fileWriter.write(c);
            }
            fileReader.close();
            fileWriter.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //���� �����ϱ� ,�̹��� ����
    public static void ex10(){
        File file = new File("C:\\Users\\user\\Desktop\\workspace\\Java\\src\\chapter7\\�ɽ�.png");
        File file2 = new File("C:\\Users\\user\\Desktop\\workspace\\Java\\src\\chapter7\\�ɽ�_���纻.png");
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            FileOutputStream fileOutputStream = new FileOutputStream(file2);
            int c;
            while ((c=fileInputStream.read()) != -1){
                fileOutputStream.write(c);
            }
            fileInputStream.close();
            fileOutputStream.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //���� ��� �����ϱ�, ���� ��� BufferedOutputStream ���� ���� ��ü Ŭ������ ����ϴ��� �ƴϸ� ���� ���� ũ�� ������ �а� ������ش�.
    public static void ex11(){
        File file = new File("C:\\Users\\user\\Desktop\\workspace\\Java\\src\\chapter7\\�����ǵ�����.csv");
        File file2 = new File("C:\\Users\\user\\Desktop\\workspace\\Java\\src\\chapter7\\�����ǵ�����_���纻.csv");
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            FileOutputStream fileOutputStream = new FileOutputStream(file2);
            BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
            int c;
            byte[] buf = new byte[9999];
            while ((c=bufferedInputStream.read(buf)) > 0){
                bufferedOutputStream.write(buf,0,c-1);
            }
            bufferedInputStream.close();
            bufferedOutputStream.close();
        }catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        File file = new File("C:\\Users\\user\\Desktop\\workspace\\Java\\src\\chapter7\\�����ǵ�����.csv");
        System.out.println(file.getName());
        System.out.println(file.getPath());
        System.out.println(file.getParent());
    }
}
