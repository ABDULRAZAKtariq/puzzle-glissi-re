package coeur;

import util_observeur.*;

import java.util.Scanner;

public class ConsoleGrille implements EcouteurModele {

    private Grille grille;

    /**
     * Constructeur de la classe ConsoleGrille .
     *
     * @param grille La grille de jeu
     */
    public ConsoleGrille(Grille grille) {
        this.grille = grille;
        this.grille.ajoutEcouteur(this);
    }


    /**
     * Méthode pour démarrer un nouveau jeu sur la grille.
     *
     * @ensures Un nouveau jeu est démarré sur la grille.
     */
    public void nouveauJeu() {

        afficherGrille();

        Scanner scanner = new Scanner(System.in);

        while (!grille.jeuTerminee()) {
            System.out.println("0) haut\n1) droite\n2) bas\n3) gauche\n");
            System.out.print("Entrez le numéro du déplacement : ");
            int choix;
            while (true) {
                try {
                    choix = scanner.nextInt();
                    if (choix >= 0 && choix <= 3) {
                        break;
                    } else {
                        System.out.println("Choix invalide. Veuillez entrer un nombre entre 0 et 3.");
                    }
                } catch (Exception e) {
                    System.out.println("Entrée invalide. Veuillez entrer un nombre.");
                    scanner.next(); // Pour consommer l'entrée invalide
                }
            }
            grille.deplacerCase(choix, false);
            System.out.println();
        }

        System.out.println("Félicitations, vous avez terminé le jeu !");
        scanner.close();
    }


    /**
     * Méthode pour afficher la grille de jeu dans la console.
     *
     * @ensures La grille de jeu est affichée dans la console.
     */
    private void afficherGrille() {
        for (int x = 0; x < grille.getLargeur(); x++) {
            for (int y = 0; y < grille.getHauteur(); y++) {
                Piece piece = grille.getPiece(x, y);
                if (piece.getEstTrou()) {
                    System.out.print("    |"); // Case vide
                } else {
                    System.out.printf(" %2s |", piece.getId()); // Numéro de la pièce
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    @Override
    public void modeleMisAJour(Object source) {
        afficherGrille();
    }
}

