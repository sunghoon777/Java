
public enum BMI {
	UNDERWEIGHT, NORMAL, OVERWEIGHT, OBESITY;
	
	public static BMI getIndex(double cal) {
		if(cal<18.5)
			return UNDERWEIGHT;
		else if(cal>=18.5&&cal<25)
			return NORMAL;
		else if(cal>=25&&cal<30)
			return OVERWEIGHT;
		else
			return OBESITY;
	}
}
