package chapter7_openchallenge;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

//단어 맞추기 게임, 단어가 주어지는데 2개의 글자를 숨긴도록 주어진다. 유저는 그 글자를 맞춰야한다.
public class HangManGame {

    private Vector<String> wordVector; // word 를 담는 리스트
    private int selectWordIndex; // 선택된 word 인덱스
    private int[] blankIndexList; // word 의 빈칸에 해당되는 인덱스 리스트
    private int blankCount; // 빈칸갯수

    public HangManGame() {
        wordVector = new Vector<String>();
        selectWordIndex = -1;
        blankCount = 2;
    }

    //게임시작
    public void startGame(){
        setGame();
        Scanner scanner = new Scanner(System.in);
        System.out.println("지금부터 행맨 게임을 시작합니다.");
        String word;
        char[] charBlankWord;
        String blankWord;
        while (true){
            selectWord();
            word = wordVector.get(selectWordIndex);
            charBlankWord = word.toCharArray();
            for(int i=0;i< blankIndexList.length;i++){
                charBlankWord[blankIndexList[i]] = '_';
            }
            blankWord = new String(charBlankWord);
            int answerCount = 0;
            int tryCount = 0;
            while (true){
                System.out.println(blankWord);
                char a = scanner.nextLine().charAt(0);
                tryCount++;
                if(word.charAt(blankIndexList[answerCount])== a){
                    charBlankWord[blankIndexList[answerCount]] = a;
                    blankWord = new String(charBlankWord);
                    answerCount++;
                }
                if(blankCount <= answerCount){
                    break;
                }
                else if(tryCount >= 5){
                    System.out.println("5번 실패 하였습니다.");
                    break;
                }
            }
            System.out.println("Next(Y/N)?");
            if(scanner.nextLine().equals("N")){
                break;
            }
        }
    }

    //게임 세팅
    private void setGame(){
        try {
            FileReader wordDictionaryReader = new FileReader("C:\\Users\\user\\Desktop\\workspace\\Java\\src\\chapter7_openchallenge\\words.txt");
            BufferedReader bufferedReader = new BufferedReader(wordDictionaryReader);
            String word;
            while ((word = bufferedReader.readLine()) != null){
                wordVector.add(word);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //단어를 선택해주고 단어의 blank 가 달린 자리의 인덱스 리스트를 리턴한다.
    private void selectWord(){
        Random random = new Random();
        int bound = wordVector.size() - 1;
        int index;
        while (true){
            index = random.nextInt(bound);
            if(index != selectWordIndex)
                break;
        }
        selectWordIndex = index;
        String word =  wordVector.get(selectWordIndex);
        System.out.println(word);
        bound = word.length()-1;
        blankIndexList = new int[blankCount];
        for (int i=0;i<blankCount;i++){
            while (true){
                boolean flag = true;
                index = random.nextInt(bound);
                for (int j=0;j<i;j++){
                    if(blankIndexList[j] == index){
                        flag = false;
                        break;
                    }
                }
                if(flag == true){
                    blankIndexList[i] = index;
                    break;
                }
            }
        }
        bubbleSort(blankIndexList);
    }

    //버블 정렬
    public static void bubbleSort(int []a){
        int i = 0;
        int n = a.length;
        while (i<n-1){
            int last = n-1;
            for(int j=n-1;j>i;j--){
                if(a[j] < a[j-1]){
                    int temp = a[j-1];
                    a[j-1] = a[j];
                    a[j] = temp;
                    last = j;
                }
            }
            i = last;
        }
    }

    public Vector<String> getWordVector() {
        return wordVector;
    }

    public void setWordVector(Vector<String> wordVector) {
        this.wordVector = wordVector;
    }
}
