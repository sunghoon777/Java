package chapter4;

public class IPTV extends ColorTV{
	
	private String ip;

	public IPTV(String ip, int size, int color) {
		super(size, color);
		// TODO Auto-generated constructor stub
		this.ip = ip;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}
	
	@Override
	public void printProperty() {
		System.out.println("나의 IPTV는 "+getIp()+" 주소의 "+getSize()+"인치 "+getColor()+"컬러");
	}

}
