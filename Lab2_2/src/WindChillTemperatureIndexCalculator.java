
public class WindChillTemperatureIndexCalculator {
	// ü���µ��� ����ϴ� �޼ҵ�
	public static double calculate(double T, double V) {
		double a = 13.12+0.6215*T-11.37*Math.pow(V, 0.16)+0.3965*Math.pow(V, 0.16)*T;
		return Math.round(a*10)/10;
	}
	
	

}
