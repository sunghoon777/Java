package chapter3;

public class Song {
	private String title;
	private String artist;
	private int year;
	private String country;
	
	public Song(String title, String artist, int year, String country) {
		this.title = title;
		this.artist = artist;
		this.year = year;
		this.country = country;
	}

	public Song() {
		
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
	
	public void show() {
		System.out.printf("노래 제목 : %s 가수 : %s 출시일 : %d 국적 : %s",getTitle(), getArtist(), getYear(), getCountry());
	}
	
	
	
	

}
