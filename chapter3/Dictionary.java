package chapter3;

public class Dictionary {
	private static String[] kor = {"사랑","아기","돈","미래","희망"};
	private static String[] eng = {"love","baby","money","future","hope"};
	
	public static String kor2Eng(String word) {
		if(word.equals("그만"))
			return word;
		for(int i=0;i<kor.length;i++) {
			if(word.equals(kor[i]))
				return eng[i];
		}
		return " ";
	}

}
