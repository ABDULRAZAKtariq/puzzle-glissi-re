package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

import coeur.*;

public class PieceTest {

    private Piece piece;
    private Position posInit;
    private Position posFinal;

    @Before
    public void setUp() {
        posInit = new Position(0, 0);
        posFinal = new Position(1, 1);
        piece = new Piece("TestPiece", posInit, posFinal);
    }

    @Test
    public void testGetId() {
        assertEquals("TestPiece", piece.getId());
    }

    @Test
    public void testGetPos() {
        assertEquals(posInit, piece.getPos());
    }

    @Test
    public void testGetPosFinal() {
        assertEquals(posFinal, piece.getPosFinal());
    }

    @Test
    public void testGetEstTrou() {
        assertFalse(piece.getEstTrou());
    }

    @Test
    public void testSetPos() {
        Position newPos = new Position(2, 2);
        piece.setPos(newPos);
        assertEquals(newPos, piece.getPos());
    }

    @Test
    public void testSetPosFinal() {
        Position newPosFinal = new Position(3, 3);
        piece.setPosFinal(newPosFinal);
        assertEquals(newPosFinal, piece.getPosFinal());
    }

    @Test
    public void testSetEstTrou() {
        piece.setEstTrou(true);
        assertTrue(piece.getEstTrou());
    }

    @Test
    public void testToString() {
        String expected = "Piece [id=TestPiece, posX=0, posY=0, posFinalX=1, posFinalY=1, est_trou=false]";
        assertEquals(expected, piece.toString());
    }
}
