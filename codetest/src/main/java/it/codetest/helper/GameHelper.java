package it.codetest.helper;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import it.codetest.match.Game;
import it.codetest.match.Game.Status;
import it.codetest.match.Player;

/**
 * 
 * Helper class for game
 * @author Flavio
 *
 */
public class GameHelper {
	
	/**
	 * Mapping between progressive points and tennis points
	 */
	private static final Map<Integer, String> pointsMap;
    static {
        Map<Integer, String> map = new HashMap<>();
        map.put(0, "love");
        map.put(1, "fifteen");
        map.put(2, "thirty");
        map.put(3, "fourty");
        pointsMap = Collections.unmodifiableMap(map);
    }
	
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
		int score = player.getScore();
		player.setScore(score++);
	}
	
	/**
	 * Gets the game status
	 * @return the game status
	 */
	public void updateGameStatus() {
		int player1Score = game.getPlayer1().getScore();
		int player2Score = game.getPlayer2().getScore();
		
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
