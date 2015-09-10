package it.codetest.match;

import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class GameTest {

	private Game game;
	
    @Before
    public void setUp() {
    	Player player1 = new Player("Novak", "Djokovic");
    	Player player2 = new Player("Roger", "Federer");
    	game = new Game(player1, player2);
    }
	
	@Test
	public void test() {
		fail("Not yet implemented");
	}
	
	@After
    public void tearDown() {
		game = null;
    }

}
