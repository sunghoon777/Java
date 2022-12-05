public enum BMI {
	UNDERWEIGHT, NORMAL, OVERWEIGHT, OBESITY;

	public static BMI getIndex(double bmi) {
        if (bmi >= 0.0 && bmi < 20.0) 
			return BMI.UNDERWEIGHT;
		else if (bmi >= 20.0 && bmi < 24.0) 
			return BMI.NORMAL;
		else if (bmi >= 24.0 && bmi < 30.0) 
			return BMI.OVERWEIGHT;
		else 
			return BMI.OBESITY;		
    }

	public static String[] names() {
		String[] names = new String[BMI.values().length];
		for (BMI t : BMI.values()) 
			names[t.ordinal()] = t.toString();
		return names;
	}
}
