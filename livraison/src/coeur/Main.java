package coeur;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.println("1. Jouer avec des nombres");
        System.out.println("2. Jouer avec des lettres");
        System.out.print("Mon choix : ");

        Scanner scanner = new Scanner(System.in);

        int choix;
        while (true) {
            try {
                choix = scanner.nextInt();
                if (choix == 1 || choix == 2) {
                    break;
                } else {
                    System.out.println("Choix invalide. Veuillez entrer 1 ou 2.");
                }
            } catch (Exception e) {
                System.out.println("Entrée invalide. Veuillez entrer un nombre.");
                scanner.next(); // Pour consommer l'entrée invalide
            }
        }
        // Configuration du jeu en fonction du choix de l'utilisateur
        Grille grille = null;
        if (choix == 1) {
            // Mode jeu avec des nombres
            grille = new Grille(2, 2, "nombres"); // Exemple : une grille de 2x2
        } else if (choix == 2) {
            // Mode jeu avec des lettres
            grille = new Grille(2, 2, "lettres"); // Exemple : une grille de 2x2 avec des lettres
        }

        grille.melangerGrille();

        ConsoleGrille consoleGrille = new ConsoleGrille(grille);
        consoleGrille.nouveauJeu();

        scanner.close();
    }
}

