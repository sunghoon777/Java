
public enum WindChillTemperatureIndex {
	 DANGER, WARNING, CAUTION, AWARE;
	//크기에 따라 위험도 정도 반환
	public static WindChillTemperatureIndex getIndex(double n)
	{
		if(n<-45)
			return WindChillTemperatureIndex.DANGER;
		if(-45<=n&&n<-25)
			return WindChillTemperatureIndex.WARNING;
		if(-25<=n&&n<-10)
			return WindChillTemperatureIndex.CAUTION;
		else
			return WindChillTemperatureIndex.AWARE;
	}
}
