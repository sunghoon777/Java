package chapter5_openchallenge;

import java.util.Scanner;

class CharacterHistogram {
	
	String histogram;
	int[] alphabetCount;
	
	public CharacterHistogram() {
		readString();
		alphabetCount = new int[26];
		for(int i=0; i<alphabetCount.length;i++) {
			alphabetCount[i] = 0;
		}
	}
	
	
	public void readString() {
		System.out.println("영문 텍스트를 입력하고 세미클론을 입력하세요.");
		StringBuffer sb = new StringBuffer();
		Scanner scan = new Scanner(System.in);
		while(true) {
			String a = scan.nextLine();
			sb.append(a);
			if(a.length() == 1 && a.equals(";")) {
				break;
			}
		}
		System.out.println();
		histogram = sb.toString();
	}
	
	public void CountAlphabet() {
		for(int i = 0 ;i < histogram.length()-1;i++) {
			char a = histogram.charAt(i);
			if((a>=65 && a <=90) || (a>=97 && a<=122)) {
				if(a>=97 && a<=122) {
					a -= 97;
					alphabetCount[a] += 1; 
				}
				else {
					a -= 65;
					alphabetCount[a] += 1; 
				}
			}
		}
	}
	
	public void print() {
		for(int i = 0;i < alphabetCount.length;i++) {
			char a = 65;
			a += i;
			System.out.print(a);
			for(int j =0; j < alphabetCount[i];j++) {
				System.out.print("-");
			}
			System.out.println();
		}
	}

}
