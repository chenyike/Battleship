package battleship;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class OceanTest {
	private Ship[][] ships = new Ship[10][10];
	private Ship emptySea = new EmptySea();
	private Ocean ocean = new Ocean();
	private Battleship battleship1 = new Battleship();

	@Before
	public void setUp() throws Exception {
		for(int i = 0; i < 10; i++){
			for(int j = 0; j < 10; j++){
				this.ships[i][j] = emptySea;
			}
		}
		this.ocean.getShipArray()[0][0]=battleship1;
		this.ocean.getShipArray()[1][0]=battleship1;
		this.ocean.getShipArray()[2][0]=battleship1;
		this.ocean.getShipArray()[3][0]=battleship1;
	}

	@Test
	public void testisOccupied() {
		assertTrue(ocean.isOccupied(0,0));
		assertFalse(ocean.isOccupied(0,9));
		assertFalse(ocean.isOccupied(9,9));
		assertFalse(ocean.isOccupied(4,4));
	}

	@Test
	public void testShootAt() {
		ocean.getShotsFired();
		ocean.getHitCount();
		ocean.getShipsSunk();
		
		//check if the ship has been hit but not sunk yet, shootAt will return true
		ocean.shootAt(0, 0);
		ocean.shootAt(1, 0);
		assertTrue(ocean.shootAt(2, 0));
		assertEquals(ocean.getShotsFired(),3);
		assertEquals(ocean.getShipsSunk(),0);
		assertEquals(ocean.getHitCount(),3);

		//check if the ship has been hit on the same spot, shootAt will return true
		assertTrue(ocean.shootAt(2, 0));
		assertEquals(ocean.getShotsFired(),4);
		assertEquals(ocean.getShipsSunk(),0);
		assertEquals(ocean.getHitCount(),4);

		//check if the ship has not been hit, shootAt will return false
		assertFalse(ocean.shootAt(2, 2));
		assertEquals(ocean.getShotsFired(),5);
		assertEquals(ocean.getShipsSunk(),0);
		assertEquals(ocean.getHitCount(),4);

		//check if the ship is been hit and sunk, shootAt will return true 
		boolean isShot = ocean.shootAt(3, 0);
		assertTrue(isShot);
		assertEquals(ocean.getShotsFired(),6);
		assertEquals(ocean.getShipsSunk(),1);
		assertEquals(ocean.getHitCount(),5);

		//check if the ship is been sunk, shootAt will return false 
		boolean isShot2 = ocean.shootAt(3, 0);
		assertFalse(isShot2);	
		assertEquals(ocean.getShotsFired(),7);
		assertEquals(ocean.getShipsSunk(),1);
		assertEquals(ocean.getHitCount(),5);
	}


	public void testIsGameOver(){
		ocean.setShipsSunk(1);
		assertFalse(ocean.isGameOver());
		ocean.setShipsSunk(10);
		assertTrue(ocean.isGameOver());
	}


}
