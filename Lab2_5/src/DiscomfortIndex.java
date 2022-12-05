
public enum DiscomfortIndex {
	
	VERY_HIGH,HIGH,NORMAL,LOW;
	
	 public static DiscomfortIndex getIndex(double n) {
		
		 if(n>=80)
			 return DiscomfortIndex.VERY_HIGH;
		 if(n>=75&&n<80)
			 return DiscomfortIndex.HIGH;
		 if(n>=68&&n<75)
			 return DiscomfortIndex.NORMAL;
		 else
			 return DiscomfortIndex.LOW;
	 }
	
	

}
