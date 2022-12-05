
public class DIscomfortIndexCalculator {
	//온도 습도를 저장하는 전역변수 T,RH
	double T,RH;

	public DIscomfortIndexCalculator() {
		
	}

	public double getT() {
		return T;
	}

	public void setT(double t) {
		T = t;
	}

	public double getRH() {
		return RH;
	}

	public void setRH(double rH) {
		RH = rH;
	}
	//불쾌지수를 계산하는 메소드
	public double calculate(double RH, double T) {
		double a = 9/5*T-0.55*(1-RH)*(9/5*T-26)+32;
		return Math.round(a);
	}
	
	

}
