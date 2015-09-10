package it.codetest.helper;

import it.codetest.match.Game;
import it.codetest.match.Player;

/**
 * 
 * Helper class for game
 * @author Flavio
 *
 */
public class GameHelper {
	
	private Game game;
	
	/**
	 * The helper constructor
	 * @param game the game
	 */
	public GameHelper(Game game) {
		this.game = game;
	}
	
	/**
	 * The argument player scores a point
	 * @param player the player who scores
	 */
	public void score(Player player) {
		if (game.getWinner() == null){
			int score = player.getScore();
			score++;
			player.setScore(score);
			updateGameStatus();
		}
	}
	
	/**
	 * Gets the game status
	 * @return the game status
	 */
	private void updateGameStatus() {
		int player1Score = game.getPlayer1().getScore();
		int player2Score = game.getPlayer2().getScore();
		
		//check if one of the two players has scored enough points to win the game
		if (player1Score > 3 || player2Score > 3) {
			//if so, then check if he scored at least two points more than the opponent
			int difference = Math.abs(player1Score - player2Score);
			if (difference >= 2) {
				if (player1Score > player2Score) {
					game.setWinner(game.getPlayer1());
				} else {
					game.setWinner(game.getPlayer2());
				}
			}
		}
	}
	
}
