package it.codetest.match;

/**
 * 
 * Describes a tennis player, including name, surname and current game score
 * @author Flavio
 *
 */
public class Player {
	
	private String name;
	private String surname;
	private int score;
	
	/**
	 * Constructor: sets player's name and surname and sets score to 0
	 * @param name the player's name
	 * @param surname the player's surname
	 */
	public Player(String name, String surname) {
		this.name = name;
		this.surname = surname;
		this.score = 0;
	}
	
	/**
	 * Called when a player scores a point
	 */
	public void score(){
		score++;
	}
	
	/**
	 * Gets player's name
	 * @return the player name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Sets the player's name
	 * @param name the player name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	
	/**
	 * Gets the player's surname
	 * @return the player's surname
	 */
	public String getSurname() {
		return surname;
	}
	
	/**
	 * Sets the player's surname
	 * @param surname the player's surname
	 */
	public void setSurname(String surname) {
		this.surname = surname;
	}
	
	
	/**
	 * Gets the current player's score
	 * @return the current player's score
	 */
	public int getScore() {
		return score;
	}
	
	/**
	 * Sets the player's score
	 * @param score the player's score
	 */
	public void setScore(int score) {
		this.score = score;
	}

}
