
public enum DecompositionIndex {
	 HIGH, NORMAL, LOW;
	 //�������������� ���� ������ �˷��ִ� �޼ҵ�
	 public static DecompositionIndex getIndex(double n) {
		 if(n>=7)
			 return DecompositionIndex.HIGH;
		 if(n>=3&&n<7)
			 return DecompositionIndex.NORMAL;
		 else
			 return DecompositionIndex.LOW;
	 }

}
