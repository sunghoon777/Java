package chapter7;

import java.io.*;
import java.util.Scanner;

public class Example {

    //파일 읽기
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
            System.out.println("오류발생");
        }
    }
    
    //파일 쓰기, filewriter에는 버퍼가 있긴함. 그래서  flush(버퍼에 남아있는 스트림 모두 write 함) close(flush 후 스트림 닫기) 를 꼭 해줘야 안정적으로 write할수 있다.
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
            System.out.println("오류발생");
        }
    }
    
    //파일 바이트로 읽고 특정 문자셋을 통해 문자 읽어오기  파일 -> FileInputStream -> 바이트 -> InputStreamReader -> 특정 문자셋으로 문자 읽기
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
            System.out.println("오류");
        }
    }

    //특정 문자셋을 통해 문자를 쓰고 그 문자를 바이트로 변환하여 파일에 쓰기   문자-> outputStreamWriter -> 인코딩된 바이트 -> fileOutputStream -> 파일에 저장
    public static void ex4(){
        OutputStreamWriter outputStreamWriter = null;
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream("C:\\Users\\user\\Desktop\\workspace\\Java\\src\\chapter7\\text2.txt");
            outputStreamWriter = new OutputStreamWriter(fileOutputStream,"US-ASCII");
            outputStreamWriter.write("안녕");
            outputStreamWriter.close();
            fileOutputStream.close();
        }catch (Exception e){
            System.out.println("오류");
        }
    }
    
    //파일에 byte를 저장하고 다시 byte를 가져오기
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
            System.out.println("오류발생");
        }
    }

    //buffer 이용 reader,
    // readLine 은 읽을것이 없으면 null 값을 반환하거나 \n\r을 제외한 한줄을 반환
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

    //buffer 이용 outputstream
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

    //파일 메소드 사용해보기
    public static void ex8(){
        File file = new File("C:\\Users\\user\\Desktop\\workspace\\Java\\src\\chapter7");
        File[] files = file.listFiles();
        int index = 0;
        for(int i=0;i< files.length;i++){
            System.out.println("----------------------------------------");
            System.out.println("파일 이름 : "+files[i].getName()+" 파일 절대 경로 : "+files[i].getPath()+" 파일의 종류 : "+(files[i].isFile() == true?"파일":"디렉토리"));
            System.out.println("파일 크기 : "+files[i].length()+"byte");
            long time = files[i].lastModified();
            System.out.printf("파일의 마지막 수정시간 : %tb %td %ta %tT\n",time,time,time,time);
            if(files[i].getName().equals("text2.txt")){
                index = i;
                System.out.println(files[i].getName());
            }
        }
        //test2 를 haha로 변경
        files[index].renameTo(new File("C:\\Users\\user\\Desktop\\workspace\\Java\\src\\text3.txt"));
    }

    //파일 복사하기
    public static void ex9(){
        File file = new File("C:\\Users\\user\\Desktop\\workspace\\Java\\src\\chapter7\\서울상권위치데이터.csv");
        File file2 = new File("C:\\Users\\user\\Desktop\\workspace\\Java\\src\\chapter7\\서울상권위치데이터_복사본.csv");
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

    //파일 복사하기 ,이미지 파일
    public static void ex10(){
        File file = new File("C:\\Users\\user\\Desktop\\workspace\\Java\\src\\chapter7\\심슨.png");
        File file2 = new File("C:\\Users\\user\\Desktop\\workspace\\Java\\src\\chapter7\\심슨_복사본.png");
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

    //파일 고속 복사하기, 버퍼 사용 BufferedOutputStream 같이 버퍼 자체 클래스를 사용하던가 아니면 직접 일정 크기 단위로 읽게 만들어준다.
    public static void ex11(){
        File file = new File("C:\\Users\\user\\Desktop\\workspace\\Java\\src\\chapter7\\서울상권데이터.csv");
        File file2 = new File("C:\\Users\\user\\Desktop\\workspace\\Java\\src\\chapter7\\서울상권데이터_복사본.csv");
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
        File file = new File("C:\\Users\\user\\Desktop\\workspace\\Java\\src\\chapter7\\서울상권데이터.csv");
        System.out.println(file.getName());
        System.out.println(file.getPath());
        System.out.println(file.getParent());
    }
}
