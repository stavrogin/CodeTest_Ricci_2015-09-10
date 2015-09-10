package it.codetest.match;

/**
 * 
 * Describes a game, composed by two players and the current result
 * @author Flavio
 *
 */
public class Game {
	
	private Player player1;
	private Player player2;
	private int status;
	
	
	/**
	 * Game constructor setting up a new game with both players
	 * @param player1 the player 1
	 * @param player2 the player 2
	 */
	public Game(Player player1, Player player2) {
		this.player1 = player1;
		this.player2 = player2;
	}
	
	/**
	 * Gets the player1
	 * @return the player1
	 */
	public Player getPlayer1() {
		return player1;
	}
	
	/**
	 * Sets the player1
	 * @param player1 the player1
	 */
	public void setPlayer1(Player player1) {
		this.player1 = player1;
	}
	
	/**
	 * Gets the player2
	 * @return the player2
	 */
	public Player getPlayer2() {
		return player2;
	}
	
	/**
	 * Sets the player2
	 * @param player2
	 */
	public void setPlayer2(Player player2) {
		this.player2 = player2;
	}
	
	/**
	 * Gets the game status
	 * @return the game status
	 */
	public int getStatus() {
		return status;
	}
	
	/**
	 * Sets the game status
	 * @param status the game status
	 */
	public void setStatus(int status) {
		this.status = status;
	}
	
}
