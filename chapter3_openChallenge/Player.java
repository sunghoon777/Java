package chapter3_openChallenge;
/*
 * 참가자를 표현하는 클래스
 * 이름은 name 참가자의 단어는 user_word 참가자의 패배여부는 user_state에 담겨진다.
 * checkSuccess 메소드를 통해 낱말잇기의 성공여부를 구현한다.
 */
class Player {
	private String name;
	private String user_word;
	private Boolean user_state;
	
	public Player(String name) {
		this.name = name;
		this.user_state = true;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUser_word() {
		return user_word;
	}

	public void setUser_word(String user_word) {
		this.user_word = user_word;
	}

	public Boolean getUser_state() {
		return user_state;
	}

	public void setUser_state(Boolean user_state) {
		this.user_state = user_state;
	}
	
	public void checkSuccess(String prior_user_word) {
		if(prior_user_word.charAt(prior_user_word.length()-1) == user_word.charAt(0)) {
			user_state = true;
		}
		else {
			user_state = false;
		}
	}
}
