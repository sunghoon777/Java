package chapter3;

public class Seat {
	private Boolean seatAvailable;
	private String userName;

	public Seat(Boolean seatAvailable, String userName) {
		this.seatAvailable = seatAvailable;
		this.userName = userName;
	}
	
	public Boolean getSeatAvailable() {
		return seatAvailable;
	}
	
	public void setSeatAvailable(Boolean seatAvailable) {
		this.seatAvailable = seatAvailable;
	}
	
	public String getUserName() {
		return userName;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
}
