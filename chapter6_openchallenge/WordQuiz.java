package chapter6_openchallenge;

import java.util.Scanner;
import java.util.Vector;

public class WordQuiz {

    //단어를 담는 list
    static Vector<Word> v = new Vector<Word>();

    //단어 세팅 메소드, 총 17개 단어를 추가하였음
    static void SettingQuiz(){
        v.add(new Word("사랑","love"));
        v.add(new Word("동물","animal"));
        v.add(new Word("사과","apple"));
        v.add(new Word("핸드폰","phone"));
        v.add(new Word("연필","pencil"));
        v.add(new Word("책","book"));
        v.add(new Word("곰","bear"));
        v.add(new Word("그림","painting"));
        v.add(new Word("장난감","toy"));
        v.add(new Word("사회","society"));
        v.add(new Word("인간","human"));
        v.add(new Word("병원","hospital"));
        v.add(new Word("언어","language"));
        v.add(new Word("나무","tree"));
        v.add(new Word("사진","picture"));
        v.add(new Word("습관","custom"));
        v.add(new Word("새","bird"));
    }

    //퀴즈 시작 메소드
    static void StartQuiz(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("**** 영어 단어 테스트 프로그램입니다. ****");
        while (true){
            //사용자에게 무엇을 할지 선택지를 받는다.
            System.out.print("단어 테스트 : 1 , 단어 삽입 : 2 , 종료 : 3 >> ");
            int select = -1;
            try {
                select = scanner.nextInt();
            }
            catch (Exception e){
                //숫자를 입력안하면 경고를 출력하고 다시 입력받는다.
                System.out.println("숫자를 입력하세요.");
                scanner.nextLine();
                continue;
            }
            scanner.nextLine();
            //단어 테스트
            if(select == 1){
                System.out.println("단어 테스트를 시작합니다. -1 을 입력하면 종료합니다.");
                System.out.println("현재 "+v.size()+"개의 단어가 들어 있습니다.");
                while (true){
                    //17개 단어에서 랜덤선택 4개
                    int[] example = RandomSelect(v.size(),4);
                    //선택된 4개를 무작위로 순서를 정하기 위해 랜덤선택
                    int[] exampleOrder = RandomSelect(4,4);
                    int answerIndex = example[0];
                    //문제 출력
                    System.out.println(v.get(answerIndex).getEnglishWord()+"?");
                    for(int i=0;i<example.length;i++){
                        int index = example[exampleOrder[i]];
                        System.out.print("("+i+")"+v.get(index).getKoreanWord()+" ");
                    }
                    System.out.print(">>   ");
                    //사용자 입력 받아오기
                    int i = Integer.parseInt(scanner.nextLine());
                    //만약 -1 입력하면 종료하기
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
            //단어 삽입
            else if(select == 2){
                System.out.println("영어 단어에 그만을 입력하면 입력을 종료합니다.");
                while (true){
                    System.out.print("한글 영어 입력 >> ");
                    String koreanWord = scanner.next();
                    if(koreanWord.equals("그만")){
                        scanner.nextLine();
                        break;
                    }
                    String englishWord = scanner.next();
                    scanner.nextLine();
                    v.add(new Word(koreanWord,englishWord));
                }
            }
            //종료
            else if(select == 3){
                System.out.println("종료");
                break;
            }
            //잘못 입력했을때
            else{
                System.out.println("잘못입력하셧습니다.");
            }
        }
    }

    //0<=x<maxNumber 범위에서 totalNumber만큼의 숫자를 랜덤으로 안겹치게 골라주는 메소드.
    public static int[] RandomSelect(int maxNumber,int totalNumber){
        int count = 0;
        int[] randomIndex = new int[totalNumber];
        for(int i = 0;i<totalNumber;i++){
            randomIndex[i] = -1;
        }
        while (true){
            //isSameIndex는 선택을 겹치지 않게 위한 확인 변수
            boolean isSameIndex = false;
            //랜덤 선택
            int selectExample = (int)(Math.random() * maxNumber);
            for(int i=0;i<count+1;i++){
                //선택이 겹치면 loop break
                if(randomIndex[i] == selectExample){
                    isSameIndex = true;
                    break;
                }
            }
            //선택이 겹치지 않으면 randomIndex 배열에 선택된 값을 넣어준다.
            if(isSameIndex == false){
                randomIndex[count] = selectExample;
                count++;
            }
            //totalNumber 만큼 랜덤 선택을 완료하면 종료
            if(count >= totalNumber){
                return randomIndex;
            }
        }
    }
}
