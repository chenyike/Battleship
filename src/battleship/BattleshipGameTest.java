package battleship;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class BattleshipGameTest {
	BattleshipGame gb = new BattleshipGame(true);
	
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testShootAt() {
		fail("Not yet implemented");
	}

	@Test
	public void testDisplay() {
		fail("Not yet implemented");
	}

	@Test
	public void testFinalResult() {
		fail("Not yet implemented");
	}

	@Test
	public void testCheckInput() {
		System.out.println(gb.checkInput("a"));
	}

}
