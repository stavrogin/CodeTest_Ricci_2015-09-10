package it.codetest.match;

/**
 * 
 * Describes a tennis player, including name and current game score
 * @author Flavio
 *
 */
public class Player {
	
	private String name;
	private int score;
	
	/**
	 * Constructor: sets player's name and surname and sets score to 0
	 * @param name the player's name
	 */
	public Player(String name) {
		this.name = name;
		this.score = 0;
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
	
	@Override
	public boolean equals(Object other) {
		
		if (this == other) return true;
		if (other == null) return false;
		if (getClass() != other.getClass()) return false;
		
		Player otherPlayer = (Player) other;
		if (name != null && !name.equals(otherPlayer.getName())){
			return false;
		}
		if (name == null && otherPlayer.getName() != null){
			return false;
		}
		if (score != otherPlayer.getScore()){
			return false;
		}
		
		return true;
	}
	
	@Override
	public String toString() {
		return name + " " + score;
	}
	
}
