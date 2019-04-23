package snakeuser.model;

public class UserScore {
	String userName;
	int score;
	
	public UserScore() {
		userName = "";
		score = 0;
			
	}
	
	
	public UserScore(String userName, int score) {
		
		this.userName = userName;
		this.score = score;
		
	}
	
	public void setuserName(String userName) {
		this.userName = userName;
	}
	public void setScore(int score) {
		this.score = score;
	}
	
	public String getuserName() {
		return userName;
	}
	public int getScore() {
		return score;
	}
	

}
