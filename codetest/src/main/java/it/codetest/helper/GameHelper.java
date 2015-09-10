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
			// we are at advantages status: check if it is deuce or one player is in advantage, or if we have a winner			
			if (difference == 0) {
				//deuce
				game.setStatusDescription(Constants.DEUCE);
			} else if (difference ==1) {
				//one player is in advantage
				if (player1Score > player2Score) {
					game.setStatusDescription(Constants.ADVANTAGE + Constants.SPACE + game.getPlayer1().getName());
				} else {
					game.setStatusDescription(Constants.ADVANTAGE + Constants.SPACE + game.getPlayer2().getName());
				}
			} else {
				//there are two points of difference: we have a winner
				if (player1Score > player2Score) {
					game.setWinner(game.getPlayer1());
				} else {
					game.setWinner(game.getPlayer2());
				}
				game.setStatusDescription(Constants.GAME + Constants.SPACE + game.getWinner().getName());			
			}
		} else {
			//case in which the score is lower or equals than 3 for both players
			if (player1Score == 3 && player2Score == 3) {
				//40-40 is deuce by specification
				game.setStatusDescription(Constants.DEUCE);
			} else {
				game.setStatusDescription(Constants.POINTS_MAP.get(game.getPlayer1().getScore()) + Constants.SPACE + Constants.POINTS_MAP.get(game.getPlayer2().getScore()));
			}
		}
	}
	
}
