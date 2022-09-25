package chapter6_openchallenge;

import java.util.Scanner;
import java.util.Vector;

public class WordQuiz {

    //�ܾ ��� list
    static Vector<Word> v = new Vector<Word>();

    //�ܾ� ���� �޼ҵ�, �� 17�� �ܾ �߰��Ͽ���
    static void SettingQuiz(){
        v.add(new Word("���","love"));
        v.add(new Word("����","animal"));
        v.add(new Word("���","apple"));
        v.add(new Word("�ڵ���","phone"));
        v.add(new Word("����","pencil"));
        v.add(new Word("å","book"));
        v.add(new Word("��","bear"));
        v.add(new Word("�׸�","painting"));
        v.add(new Word("�峭��","toy"));
        v.add(new Word("��ȸ","society"));
        v.add(new Word("�ΰ�","human"));
        v.add(new Word("����","hospital"));
        v.add(new Word("���","language"));
        v.add(new Word("����","tree"));
        v.add(new Word("����","picture"));
        v.add(new Word("����","custom"));
        v.add(new Word("��","bird"));
    }

    //���� ���� �޼ҵ�
    static void StartQuiz(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("**** ���� �ܾ� �׽�Ʈ ���α׷��Դϴ�. ****");
        while (true){
            //����ڿ��� ������ ���� �������� �޴´�.
            System.out.print("�ܾ� �׽�Ʈ : 1 , �ܾ� ���� : 2 , ���� : 3 >> ");
            int select = -1;
            try {
                select = scanner.nextInt();
            }
            catch (Exception e){
                //���ڸ� �Է¾��ϸ� ��� ����ϰ� �ٽ� �Է¹޴´�.
                System.out.println("���ڸ� �Է��ϼ���.");
                scanner.nextLine();
                continue;
            }
            scanner.nextLine();
            //�ܾ� �׽�Ʈ
            if(select == 1){
                System.out.println("�ܾ� �׽�Ʈ�� �����մϴ�. -1 �� �Է��ϸ� �����մϴ�.");
                System.out.println("���� "+v.size()+"���� �ܾ ��� �ֽ��ϴ�.");
                while (true){
                    //17�� �ܾ�� �������� 4��
                    int[] example = RandomSelect(v.size(),4);
                    //���õ� 4���� �������� ������ ���ϱ� ���� ��������
                    int[] exampleOrder = RandomSelect(4,4);
                    int answerIndex = example[0];
                    //���� ���
                    System.out.println(v.get(answerIndex).getEnglishWord()+"?");
                    for(int i=0;i<example.length;i++){
                        int index = example[exampleOrder[i]];
                        System.out.print("("+i+")"+v.get(index).getKoreanWord()+" ");
                    }
                    System.out.print(">>   ");
                    //����� �Է� �޾ƿ���
                    int i = Integer.parseInt(scanner.nextLine());
                    //���� -1 �Է��ϸ� �����ϱ�
                    if(i == -1){
                        System.out.println("END");
                        break;
                    }
                    int userAnswer = example[exampleOrder[i]];
                    if(userAnswer == answerIndex){
                        System.out.println("Excellent!!");
                    }
                    else{
                        System.out.println("NO!!");
                    }
                }
            }
            //�ܾ� ����
            else if(select == 2){
                System.out.println("���� �ܾ �׸��� �Է��ϸ� �Է��� �����մϴ�.");
                while (true){
                    System.out.print("�ѱ� ���� �Է� >> ");
                    String koreanWord = scanner.next();
                    if(koreanWord.equals("�׸�")){
                        scanner.nextLine();
                        break;
                    }
                    String englishWord = scanner.next();
                    scanner.nextLine();
                    v.add(new Word(koreanWord,englishWord));
                }
            }
            //����
            else if(select == 3){
                System.out.println("����");
                break;
            }
            //�߸� �Է�������
            else{
                System.out.println("�߸��Է��ϼ˽��ϴ�.");
            }
        }
    }

    //0<=x<maxNumber �������� totalNumber��ŭ�� ���ڸ� �������� �Ȱ�ġ�� ����ִ� �޼ҵ�.
    public static int[] RandomSelect(int maxNumber,int totalNumber){
        int count = 0;
        int[] randomIndex = new int[totalNumber];
        for(int i = 0;i<totalNumber;i++){
            randomIndex[i] = -1;
        }
        while (true){
            //isSameIndex�� ������ ��ġ�� �ʰ� ���� Ȯ�� ����
            boolean isSameIndex = false;
            //���� ����
            int selectExample = (int)(Math.random() * maxNumber);
            for(int i=0;i<count+1;i++){
                //������ ��ġ�� loop break
                if(randomIndex[i] == selectExample){
                    isSameIndex = true;
                    break;
                }
            }
            //������ ��ġ�� ������ randomIndex �迭�� ���õ� ���� �־��ش�.
            if(isSameIndex == false){
                randomIndex[count] = selectExample;
                count++;
            }
            //totalNumber ��ŭ ���� ������ �Ϸ��ϸ� ����
            if(count >= totalNumber){
                return randomIndex;
            }
        }
    }
}
