package battleship;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class BattleshipGameTest {
    private String Int1;
    private String Int2;
    private String Int3;
    BattleshipGame gb;

    @Before
    public void setUp() throws Exception {
        Int1 = "this";
        Int2 = "12";
        Int3 = "0";
        gb = new BattleshipGame(true);
    }

    @Test
    public void testIsInteger() {
        assertTrue(gb.isInteger(Int2));
        assertFalse(gb.isInteger(Int1));
    }

    @Test
    public void testCheckInput() {
        assertTrue(gb.checkInput(Int3));
        assertFalse(gb.checkInput(Int2));
        assertFalse(gb.checkInput(Int1));
    }

}