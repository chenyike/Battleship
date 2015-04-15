package battleship;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class BattleshipTest {
    private Battleship bat;

    @Before
    public void setUp() throws Exception {
        bat = new Battleship();
    }

    @Test
    public void testGetShipType() {
        assertTrue(bat.getShipType().equals("battleship"));
    }

}


