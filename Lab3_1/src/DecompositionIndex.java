
public enum DecompositionIndex {
	 HIGH, NORMAL, LOW;
	 //부패지수에따라 높음 낮음을 알려주는 메소드
	 public static DecompositionIndex getIndex(double n) {
		 if(n>=7)
			 return DecompositionIndex.HIGH;
		 if(n>=3&&n<7)
			 return DecompositionIndex.NORMAL;
		 else
			 return DecompositionIndex.LOW;
	 }

}
