
public class DecompositionIndexCalculator {
	//�������� T(�����µ�),RH(����)����
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
	//�������� ����ϴ� �޼ҵ�
	public double calculate(double RH, double T) {
		double a = ((RH - 65)/14) * Math.pow(1.054, T);
		return Math.round(a*100)/100d;
	}
	
	
	

}
