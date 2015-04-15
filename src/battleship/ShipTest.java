package battleship;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ShipTest {
	private Ship battleship1 = new Battleship();
	private Ship cruiser1 = new Cruiser();
	private Ship cruiser2 = new Cruiser();
	private Ship destroyer1 = new Destroyer();
	private Ship destroyer2 = new Destroyer();
	private Ship destroyer3 = new Destroyer();
	private Ship submarine1 = new Submarine();
	private Ship submarine2 = new Submarine();
	private Ship submarine3 = new Submarine();
	private Ship submarine4 = new Submarine();
	private Ship emptySea = new EmptySea();
	private Ocean ocean = new Ocean();


	@Before
	public void setUp() throws Exception {
		//lay 1 battleship and 1 cruiser in the ocean
		for(int i = 0; i < 10; i++){
			for(int j = 0; j < 10; j++){
				this.ocean.getShipArray()[i][j] = emptySea;
			}
		}
		cruiser1.setBowRow(2);
		cruiser1.setBowColumn(3);
		cruiser1.setHorizontal(true);
		this.ocean.getShipArray()[2][3]=cruiser1;
		this.ocean.getShipArray()[2][4]=cruiser1;
		this.ocean.getShipArray()[2][5]=cruiser1;

		battleship1.setBowColumn(0);
		battleship1.setBowRow(0);
		battleship1.setHorizontal(false);
		this.ocean.getShipArray()[0][0]=battleship1;
		this.ocean.getShipArray()[1][0]=battleship1;
		this.ocean.getShipArray()[2][0]=battleship1;
		this.ocean.getShipArray()[3][0]=battleship1;


	}


	@Test
	public void testOkToPlaceShipAt() {
		//test the overlapping case
		assertFalse(cruiser2.okToPlaceShipAt(0, 0, false, ocean));
		assertFalse(cruiser2.okToPlaceShipAt(1, 0, false, ocean));
		assertFalse(cruiser2.okToPlaceShipAt(2, 0, true, ocean));
		assertFalse(cruiser2.okToPlaceShipAt(3, 0, false, ocean));
		assertFalse(cruiser2.okToPlaceShipAt(4, 0, true, ocean));
		//test the adjacent type
		assertFalse(destroyer1.okToPlaceShipAt(2, 1, false, ocean));
		assertFalse(destroyer1.okToPlaceShipAt(1, 3, false, ocean));
		assertFalse(destroyer1.okToPlaceShipAt(2, 6, false, ocean));
		//test the diagonal cases
		assertFalse(destroyer2.okToPlaceShipAt(1, 1, false, ocean));
		assertFalse(destroyer2.okToPlaceShipAt(3, 6, false, ocean));
		//test successful cases
		assertTrue(destroyer3.okToPlaceShipAt(5, 1, true, ocean));
		assertTrue(destroyer3.okToPlaceShipAt(4, 6, true, ocean));
		assertTrue(destroyer3.okToPlaceShipAt(0, 8, true, ocean));
		assertTrue(submarine1.okToPlaceShipAt(0, 9, false, ocean));
		assertTrue(submarine1.okToPlaceShipAt(0, 9, true, ocean));
		assertTrue(submarine2.okToPlaceShipAt(6, 8, true, ocean));
		assertTrue(submarine3.okToPlaceShipAt(9, 0, true, ocean));
		assertTrue(submarine4.okToPlaceShipAt(9, 0, false, ocean));
	}


	@Test
	public void testPlaceShipAt() {
		submarine1.placeShipAt(0, 2, true, ocean);
		assertTrue(ocean.getShipArray()[0][2].getShipType().equals("submarine"));
		cruiser2.placeShipAt(5, 1, true, ocean);
		assertTrue(ocean.getShipArray()[5][1].getShipType().equals("cruiser"));
		assertTrue(ocean.getShipArray()[5][2].getShipType().equals("cruiser"));
		assertTrue(ocean.getShipArray()[5][3].getShipType().equals("cruiser"));
	}


	@Test
	public void testShootAt() {
		//test horizontal case
		assertTrue(battleship1.shootAt(0, 0));
		assertTrue(battleship1.shootAt(1, 0));
		assertTrue(battleship1.shootAt(2, 0));
		assertTrue(battleship1.shootAt(3, 0));
		//test horizontal's sunk case
		assertFalse(battleship1.shootAt(0, 0));
		assertFalse(battleship1.shootAt(1, 0));
		assertFalse(battleship1.shootAt(2, 0));
		assertFalse(battleship1.shootAt(3, 0));		
		//test vertical case
		assertTrue(cruiser1.shootAt(2, 3));
		assertTrue(cruiser1.shootAt(2, 4));
		assertTrue(cruiser1.shootAt(2, 5));
		//test vertical's sunk case
		assertFalse(cruiser1.shootAt(2, 3));
		assertFalse(cruiser1.shootAt(2, 4));
		assertFalse(cruiser1.shootAt(2, 5));

	}


	@Test
	public void testIsSunk() {
		//test horizontal case
		assertFalse(battleship1.isSunk());
		battleship1.shootAt(0, 0);
		battleship1.shootAt(1, 0);
		battleship1.shootAt(2, 0);
		battleship1.shootAt(3, 0);
		assertTrue(battleship1.isSunk());
		//test vertical case
		assertFalse(cruiser1.isSunk());
		cruiser1.shootAt(2, 3);
		cruiser1.shootAt(2, 4);
		cruiser1.shootAt(2, 5);
		assertTrue(cruiser1.isSunk());
	}


	@Test
	public void testToString() {
		battleship1.shootAt(0, 0);
		battleship1.shootAt(1, 0);
		battleship1.shootAt(2, 0);
		battleship1.shootAt(3, 0);
		assertTrue(battleship1.toString().equals("x"));
		cruiser1.shootAt(2, 3);
		assertTrue(cruiser1.toString().equals("S"));
		
	}


}
