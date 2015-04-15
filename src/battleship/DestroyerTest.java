package battleship;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class DestroyerTest {
    private Destroyer des;

    @Before
    public void setUp() throws Exception {
        des = new Destroyer();
    }

    @Test
    public void testGetShipType() {
        assertTrue(des.getShipType().equals("destroyer"));
    }

}
