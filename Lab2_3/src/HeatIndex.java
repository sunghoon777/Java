
public enum HeatIndex {
	VERY_HIGH, HIGH, USUAL, LOW;
	//������ ������ ���� ���� ������ �˷��ִ� �޼ҵ�
	public static HeatIndex getIndex(double n) {
		if(54<=n)
			return HeatIndex.VERY_HIGH;
		if(41<=n&&n<54)
			return HeatIndex.HIGH;
		if(32<=n&&n<41)
			return HeatIndex.USUAL;
		else
			return HeatIndex.LOW;
	}
}
