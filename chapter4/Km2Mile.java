package chapter4;

public class Km2Mile extends Converter{
	
	public Km2Mile(double ratio) {
		this.ratio = ratio;
	}

	@Override
	protected double convert(double src) {
		// TODO Auto-generated method stub
		return src / ratio;
	}

	@Override
	protected String getSrcString() {
		// TODO Auto-generated method stub
		return "Km";
	}

	@Override
	protected String getDestString() {
		// TODO Auto-generated method stub
		return "mile";
	}

}
