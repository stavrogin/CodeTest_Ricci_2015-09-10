package it.codetest.match;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import it.codetest.helper.Constants;
import it.codetest.helper.GameHelper;

public class GameTest  {
	
	private static final String PLAYER_1_NAME = "Djokovic";
	private static final String PLAYER_2_NAME = "Federer";
	
	private Game game;
	private GameHelper gameHelper;
	
    @Before
    public void setUp() {
    	Player player1 = new Player(PLAYER_1_NAME);
    	Player player2 = new Player(PLAYER_2_NAME);
    	game = new Game(player1, player2);
    	gameHelper = new GameHelper(game);
    }
	
	@Test
	public void testPlayer1WinsWithoutAdvantages() {
		gameHelper.score(game.getPlayer1());
		gameHelper.score(game.getPlayer1());
		gameHelper.score(game.getPlayer1());
		gameHelper.score(game.getPlayer1());
		assertEquals(game.getPlayer1(), game.getWinner());
		assertEquals(game.getStatusDescription(), Constants.GAME + Constants.SPACE + PLAYER_1_NAME);
	}
	
	@Test
	public void testPlayer2WinsWithoutAdvantages() {
		gameHelper.score(game.getPlayer2());
		gameHelper.score(game.getPlayer2());
		gameHelper.score(game.getPlayer2());
		gameHelper.score(game.getPlayer2());
		assertEquals(game.getPlayer2(), game.getWinner());
		assertEquals(game.getStatusDescription(), Constants.GAME + Constants.SPACE + PLAYER_2_NAME);
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
		assertEquals(game.getStatusDescription(), Constants.ADVANTAGE + Constants.SPACE + PLAYER_1_NAME);
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
		assertEquals(game.getPlayer2(), game.getWinner());
		assertTrue(game.getPlayer1().getScore() == 4);
		assertTrue(game.getPlayer2().getScore() == 6);
		assertEquals(game.getStatusDescription(), Constants.GAME + Constants.SPACE + PLAYER_2_NAME);
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
		assertTrue(game.getPlayer1().getScore() == 4);
		assertTrue(game.getPlayer2().getScore() == 4);
		assertEquals(game.getStatusDescription(), Constants.DEUCE);
	}
	
	@Test
	public void testLongMatch() {
		gameHelper.score(game.getPlayer1());
		gameHelper.score(game.getPlayer1());
		gameHelper.score(game.getPlayer1());
		gameHelper.score(game.getPlayer2());
		gameHelper.score(game.getPlayer2());
		gameHelper.score(game.getPlayer2());
		gameHelper.score(game.getPlayer1());
		gameHelper.score(game.getPlayer2());
		gameHelper.score(game.getPlayer1());
		gameHelper.score(game.getPlayer2());
		gameHelper.score(game.getPlayer2());
		gameHelper.score(game.getPlayer1());
		gameHelper.score(game.getPlayer1());
		gameHelper.score(game.getPlayer1());
		assertEquals(game.getPlayer1(), game.getWinner());
		assertTrue(game.getPlayer1().getScore() == 8);
		assertTrue(game.getPlayer2().getScore() == 6);
		assertEquals(game.getStatusDescription(), Constants.GAME + Constants.SPACE + PLAYER_1_NAME);
	}
	
	@Test
	public void testFifteenThirty() {
		gameHelper.score(game.getPlayer1());
		gameHelper.score(game.getPlayer2());
		gameHelper.score(game.getPlayer2());
		assertTrue(game.getPlayer1().getScore() == 1);
		assertTrue(game.getPlayer2().getScore() == 2);
		assertTrue(game.getWinner() == null);
		assertEquals(game.getStatusDescription(), Constants.FIFTEEN + Constants.SPACE + Constants.THIRTY);
	}
	
	@Test
	public void testThirtyLove() {
		gameHelper.score(game.getPlayer1());
		gameHelper.score(game.getPlayer1());
		assertTrue(game.getPlayer1().getScore() == 2);
		assertTrue(game.getPlayer2().getScore() == 0);
		assertTrue(game.getWinner() == null);
		assertEquals(game.getStatusDescription(), Constants.THIRTY + Constants.SPACE + Constants.LOVE);
	}
	
	@Test
	public void testFourtyThirty() {
		gameHelper.score(game.getPlayer1());
		gameHelper.score(game.getPlayer1());
		gameHelper.score(game.getPlayer2());
		gameHelper.score(game.getPlayer2());
		gameHelper.score(game.getPlayer1());
		assertTrue(game.getPlayer1().getScore() == 3);
		assertTrue(game.getPlayer2().getScore() == 2);
		assertTrue(game.getWinner() == null);
		assertEquals(game.getStatusDescription(), Constants.FOURTY + Constants.SPACE + Constants.THIRTY);
	}
	
	@Test
	public void testGameStatuses() {
		gameHelper.score(game.getPlayer1());
		assertEquals(game.getStatusDescription(), Constants.FIFTEEN + Constants.SPACE + Constants.LOVE);
		gameHelper.score(game.getPlayer1());
		assertEquals(game.getStatusDescription(), Constants.THIRTY + Constants.SPACE + Constants.LOVE);
		gameHelper.score(game.getPlayer2());
		assertEquals(game.getStatusDescription(), Constants.THIRTY + Constants.SPACE + Constants.FIFTEEN);
		gameHelper.score(game.getPlayer2());
		assertEquals(game.getStatusDescription(), Constants.THIRTY + Constants.SPACE + Constants.THIRTY);
		gameHelper.score(game.getPlayer1());
		assertEquals(game.getStatusDescription(), Constants.FOURTY + Constants.SPACE + Constants.THIRTY);
		gameHelper.score(game.getPlayer2());
		assertEquals(game.getStatusDescription(), Constants.FOURTY + Constants.SPACE + Constants.FOURTY);
		gameHelper.score(game.getPlayer2());
		assertEquals(game.getStatusDescription(), Constants.ADVANTAGE + Constants.SPACE + PLAYER_2_NAME);
		gameHelper.score(game.getPlayer1());
		assertEquals(game.getStatusDescription(), Constants.DEUCE);
		gameHelper.score(game.getPlayer1());
		assertEquals(game.getStatusDescription(), Constants.ADVANTAGE + Constants.SPACE + PLAYER_1_NAME);
		gameHelper.score(game.getPlayer1());
		assertEquals(game.getStatusDescription(), Constants.GAME + Constants.SPACE + PLAYER_1_NAME);
		assertEquals(game.getWinner(), game.getPlayer1());
	}
	
	@After
    public void tearDown() {
		gameHelper = null;
		game = null;
    }

}
