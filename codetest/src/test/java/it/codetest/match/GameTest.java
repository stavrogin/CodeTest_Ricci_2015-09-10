package it.codetest.match;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import it.codetest.helper.GameHelper;
import it.codetest.match.Game.Status;

public class GameTest  {

	private Game game;
	private GameHelper gameHelper;
	
    @Before
    public void setUp() {
    	Player player1 = new Player("Djokovic");
    	Player player2 = new Player("Federer");
    	game = new Game(player1, player2);
    	gameHelper = new GameHelper(game);
    }
	
	@Test
	public void testPlayer1WinsWithoutAdvantages() {
		gameHelper.score(game.getPlayer1());
		gameHelper.score(game.getPlayer1());
		gameHelper.score(game.getPlayer1());
		gameHelper.score(game.getPlayer1());
		assertTrue(game.getPlayer1().equals(game.getWinner()));
		assertTrue(game.getStatus().equals(Status.FINISHED));
	}
	
	@Test
	public void testPlayer2WinsWithoutAdvantages() {
		gameHelper.score(game.getPlayer2());
		gameHelper.score(game.getPlayer2());
		gameHelper.score(game.getPlayer2());
		gameHelper.score(game.getPlayer2());
		assertTrue(game.getPlayer2().equals(game.getWinner()));
		assertTrue(game.getStatus().equals(Status.FINISHED));
	}
	
	@Test
	public void testPlayer1IsAdvantage() {
		//15-0
		gameHelper.score(game.getPlayer1());
		//30-0
		gameHelper.score(game.getPlayer1());
		//40-0
		gameHelper.score(game.getPlayer1());
		//40-15
		gameHelper.score(game.getPlayer2());
		//40-30
		gameHelper.score(game.getPlayer2());
		//40-40
		gameHelper.score(game.getPlayer2());
		//A P1
		gameHelper.score(game.getPlayer1());
		//D
		gameHelper.score(game.getPlayer2());
		//A P1
		gameHelper.score(game.getPlayer1());
		assertTrue(game.getWinner() == null);
		assertTrue(game.getPlayer1().getScore() == 5);
		assertTrue(game.getPlayer2().getScore() == 4);
	}
	
	@Test
	public void testPlayer2WinsAfterAdvantage() {
		//15-0
		gameHelper.score(game.getPlayer1());
		//30-0
		gameHelper.score(game.getPlayer1());
		//40-0
		gameHelper.score(game.getPlayer1());
		//40-15
		gameHelper.score(game.getPlayer2());
		//40-30
		gameHelper.score(game.getPlayer2());
		//40-40
		gameHelper.score(game.getPlayer2());
		//A P1
		gameHelper.score(game.getPlayer1());
		//D
		gameHelper.score(game.getPlayer2());
		//A P2
		gameHelper.score(game.getPlayer2());
		//W P2
		gameHelper.score(game.getPlayer2());
		assertTrue(game.getPlayer2().equals(game.getWinner()));
		assertTrue(game.getPlayer1().getScore() == 4);
		assertTrue(game.getPlayer2().getScore() == 6);
	}
	
	@Test
	public void testDeuce() {
		//15-0
		gameHelper.score(game.getPlayer1());
		//30-0
		gameHelper.score(game.getPlayer1());
		//40-0
		gameHelper.score(game.getPlayer1());
		//40-15
		gameHelper.score(game.getPlayer2());
		//40-30
		gameHelper.score(game.getPlayer2());
		//40-40
		gameHelper.score(game.getPlayer2());
		//A P1
		gameHelper.score(game.getPlayer1());
		//D
		gameHelper.score(game.getPlayer2());
		assertTrue(game.getWinner() == null);
		assertTrue(game.getPlayer1().getScore() == 5);
		assertTrue(game.getPlayer2().getScore() == 4);
	}
	
	@After
    public void tearDown() {
		gameHelper = null;
		game = null;
    }

}
