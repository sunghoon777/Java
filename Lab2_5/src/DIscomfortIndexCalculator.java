
public class DIscomfortIndexCalculator {
	//�µ� ������ �����ϴ� �������� T,RH
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
	//���������� ����ϴ� �޼ҵ�
	public double calculate(double RH, double T) {
		double a = 9/5*T-0.55*(1-RH)*(9/5*T-26)+32;
		return Math.round(a);
	}
	
	

}
