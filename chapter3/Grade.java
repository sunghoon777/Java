package chapter3;

public class Grade {
	private int mathScore;
	private int scienceScore;
	private int englishScore;
	
	public Grade(int mathScore, int scienceScore, int englishScore) {
		super();
		this.mathScore = mathScore;
		this.scienceScore = scienceScore;
		this.englishScore = englishScore;
	}
	
	public int getMathScore() {
		return mathScore;
	}
	public void setMathScore(int mathScore) {
		this.mathScore = mathScore;
	}
	public int getScienceScore() {
		return scienceScore;
	}
	public void setScienceScore(int scienceScore) {
		this.scienceScore = scienceScore;
	}
	public int getEnglishScore() {
		return englishScore;
	}
	public void setEnglishScore(int englishScore) {
		this.englishScore = englishScore;
	}
	
	public double getAverage() {
		return (double)(getMathScore()+ getScienceScore()+ getEnglishScore()) /3;
	}

	
	
}
