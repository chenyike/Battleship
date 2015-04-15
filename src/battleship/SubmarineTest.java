package battleship;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class SubmarineTest {
    private Submarine sub;

    @Before
    public void setUp() throws Exception {
        sub = new Submarine();
    }

    @Test
    public void testGetShipType() {
        assertTrue(sub.getShipType().equals("submarine"));
    }

}

