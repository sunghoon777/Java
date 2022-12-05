
public class DecompositionIndexCalculator {
	//전역변수 T(섭씨온도),RH(습도)선언
	double T,RH;
	
	public DecompositionIndexCalculator() {
		
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
	//부패지수 계산하는 메소드
	public double calculate(double RH, double T) {
		double a = ((RH - 65)/14) * Math.pow(1.054, T);
		return Math.round(a*100)/100d;
	}
	
	
	

}
