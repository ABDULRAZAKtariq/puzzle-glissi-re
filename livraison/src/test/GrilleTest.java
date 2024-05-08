package test;

import static org.junit.Assert.*;
import org.junit.*;

import coeur.*;

public class GrilleTest {

    // Test du constructeur
    @Test
    public void testConstructeur() {
        Grille grille = new Grille(3, 3, "nombres");
        assertNotNull(grille);
        assertEquals(3, grille.getLargeur());
        assertEquals(3, grille.getHauteur());
        assertNotNull(grille.getPosVide());
    }

    // Test de la méthode de création de la grille
    @Test
    public void testMelangerGrille1() {
        Grille grille = new Grille(3, 3, "nombres");
        // Vérifier que la grille est mélangée
        assertFalse(grille.jeuTerminee());
    }

    // Test de déplacement de la case dans toutes les directions
@Test
public void testDeplacerCase() {
    Grille grille = new Grille(3, 3, "nombres");
    Piece[][] tabAvant = grille.getTab();

    // Déplacement vers le haut
    grille.deplacerCase(0, false);
    assertArrayEquals(tabAvant, grille.getTab()); // Compare les contenus des tableaux

    // Déplacement vers la droite
    grille.deplacerCase(1, false);
    assertArrayEquals(tabAvant, grille.getTab()); // Compare les contenus des tableaux

    // Déplacement vers le bas
    grille.deplacerCase(2, false);
    assertArrayEquals(tabAvant, grille.getTab()); // Compare les contenus des tableaux

    // Déplacement vers la gauche
    grille.deplacerCase(3, false);
    assertArrayEquals(tabAvant, grille.getTab()); // Compare les contenus des tableaux
}
    // Test de la méthode de récupération d'une pièce dans la grille
    @Test
    public void testGetPiece() {
        Grille grille = new Grille(3, 3, "nombres");
        Piece piece = grille.getPiece(1, 1);
        assertNotNull(piece);
    }

    // Test de la méthode indiquant si le jeu est terminé
    @Test
    public void testJeuTerminee() {
        // Crée une grille 2x2 avec des pièces disposées aléatoirement
        Grille grille = new Grille(2, 2, "nombres");

        // Vérifie que le jeu n'est pas terminé initialement
        assertFalse(grille.jeuTerminee());

        // Définit les positions finales pour chaque pièce
        Piece[][] tab = grille.getTab();
        tab[0][0].setPosFinal(new Position(0, 0));
        tab[0][1].setPosFinal(new Position(0, 1));
        tab[1][0].setPosFinal(new Position(1, 0));
        tab[1][1].setPosFinal(new Position(1, 1));

        // Vérifie que le jeu est terminé après avoir défini les positions finales correctement
        assertTrue(grille.jeuTerminee());
    }
}
