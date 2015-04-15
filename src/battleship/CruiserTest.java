package battleship;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CruiserTest {
    private Cruiser cru;

    @Before
    public void setUp() throws Exception {
        cru = new Cruiser();
    }

    @Test
    public void testGetShipType() {
        assertTrue(cru.getShipType().equals("cruiser"));
    }

}