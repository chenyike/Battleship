package battleship;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class EmptySeaTest {
    private int row1;
    private int column1;
    private EmptySea es;

    @Before
    public void setUp() throws Exception {
        row1 = 1;
        column1 = 2;
        es = new EmptySea();
    }

    @Test
    public void testGetShipType() {
        assertTrue(es.getShipType().equals("empty"));
    }

    @Test
    public void testShootAt() {
         assertFalse(es.shootAt(row1, column1));
    }

    @Test
    public void testIsSunk() {
        assertFalse(es.isSunk());
    }

    @Test
    public void testToString() {
        assertTrue(es.toString().equals("."));
    }

}
