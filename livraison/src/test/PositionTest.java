package test;

import static org.junit.Assert.*;
import org.junit.Test;

import coeur.*;

public class PositionTest {

    @Test
    public void testGetX() {
        Position position = new Position(3, 5);
        assertEquals(3, position.getX());
    }

    @Test
    public void testGetY() {
        Position position = new Position(3, 5);
        assertEquals(5, position.getY());
    }

    @Test
    public void testSetX() {
        Position position = new Position(3, 5);
        position.setX(7);
        assertEquals(7, position.getX());
    }

    @Test
    public void testSetY() {
        Position position = new Position(3, 5);
        position.setY(9);
        assertEquals(9, position.getY());
    }

    @Test
    public void testAjouterPosition() {
        Position position1 = new Position(3, 5);
        Position position2 = new Position(2, 4);
        position1.ajouter(position2);
        assertEquals(5, position1.getX());
        assertEquals(9, position1.getY());
    }

    @Test
    public void testAjouterCoord() {
        Position position = new Position(3, 5);
        position.ajouter(2, 4);
        assertEquals(5, position.getX());
        assertEquals(9, position.getY());
    }

    @Test
    public void testEquals() {
        Position position1 = new Position(3, 5);
        Position position2 = new Position(3, 5);
        Position position3 = new Position(2, 4);

        assertTrue(position1.equals(position2));
        assertFalse(position1.equals(position3));
    }
}
