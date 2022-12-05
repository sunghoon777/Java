
public class HeatIndexCalculator {
	//���� ���� C(�����µ�),R(����),F(ȭ���µ�) ���� 
	double C,R,F;
	
   public HeatIndexCalculator() {
    	
	}
	
    public double getC() {
		return C;
	}

	public void setC(double c) {
		C = c;
	}

	public double getR() {
		return R;
	}

	public void setR(double r) {
		R = r;
	}
	
	public double getF() {
		return F;
	}

	public void setF(double f) {
		F = f;
	}
	
	//������ ȭ���� �������־� ȭ���µ��� �������ִ� �޼ҵ�

	public void CtoF() {
		this.F=(this.C*1.8)+32;
	}
	


	
	//������ ��� �޼ҵ�
	double calculate(double F, double R) {
		 double a =  -42.379 + (2.04901523*F) + (10.14333127*R) - (0.22475541*F*R) -
				 (0.00683770*F*F) - (0.05481717*R*R) + (0.00122874*F*F*R) + (0.00085282*F*R*R) -
				 (0.00000199*F*F*R*R);
		 a = (a-32)/1.8;
		 return Math.round(a*10)/10;
	}

}
