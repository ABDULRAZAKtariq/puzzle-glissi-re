package coeur;

import util_observeur.*;
import java.util.Random;



public class Grille extends AbstractModeleEcoutable  {
    private static final char[] ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
    private Piece[][] tab; // Tableau représentant la grille
    private int largeur; // Largeur de la grille
    private int hauteur; // Hauteur de la grille
    private Position posVide; // Position en x et y de la case vide
    private String choix = "nombres"; // choix entre les lettres et les chiffres
    private int nbCoups = 0;
    
    /**
     * Constructeur de la grille avec la largeur et la hauteur.
     * @param largeur La largeur de la grille.
     * @param hauteur La hauteur de la grille.
     * @param choix Le choix entre les lettres et les chiffres.
     * @requires largeur et hauteur doivent être positifs. choix doit être "lettres" ou "nombres".
     */
    public Grille(int largeur, int hauteur, String choix) {
        this.largeur = largeur;
        this.hauteur = hauteur;
        this.choix = choix;
        posVide = new Position(0, 0);
        creerGrille();
        melangerGrille();
    }

    /**
    /* Méthode pour récupérer le tableau représentant la grille.
    /* @return Le tableau représentant la grille.
    /*/
    public Piece[][] getTab() {
        return tab;
    }

    /**
     * Méthode pour récupérer la largeur de la grille.
     * @return La largeur de la grille.
     */
    public int getLargeur() {
        return largeur;
    }
    /**
     * Méthode pour récupérer la hauteur de la grille.
     * @return La hauteur de la grille.
     */
    public int getHauteur() {
        return hauteur;
    }
    /**
     * Méthode pour récupérer la position de la case vide.
     * @return La position de la case vide.
     */
    public Position getPosVide() {
        return posVide;
    }

    /**
    * Méthode pour définir le tableau représentant la grille.
    * @param tab Le tableau représentant la grille.
    */
    public void setTab(Piece[][] tab) {
        this.tab = tab;
    }

    /**
    * Méthode pour définir la largeur de la grille.
    * 
    * @param largeur La largeur de la grille.
    */
    public void setLargeur(int largeur) {
        this.largeur = largeur;
    }
    /**
    * Méthode pour définir la hauteur de la grille.
    * 
    * @param hauteur La hauteur de la grille.
    */
    public void setHauteur(int hauteur) {
        this.hauteur = hauteur;
    }
    /**
     * Méthode pour définir la position de la case vide.
     * 
     * @param posVide La position de la case vide.
     */
    public void setPosVide(Position posVide) {
        this.posVide = posVide;
    }

    
    /**
     * Méthode pour créer la grille avec des pièces et une case vide.
     */
    public void creerGrille() {
        tab = new Piece[largeur][hauteur]; // Initialise le tableau représentant la grille
        int id = 0; // Calcule l'identifiant de la pièce

        // Affectation d'un chiffre à chaque case de la grille
        for (int x = 0; x < largeur; x++) {
            for (int y = 0; y < hauteur; y++) {
                // Crée une nouvelle pièce normale avec les positions initiale et finale
                Position posInit = new Position(x, y);
                Position posFinal = new Position(x, y);
                if(choix == "nombres"){
                    tab[x][y] = new Piece(Integer.toString(++id), posInit, posFinal);
                }else if(choix == "lettres"){
                    getTab()[x][y] = new Piece(Character.toString(ALPHABET[id]), posInit, posFinal);
                    id = (id + 1) % ALPHABET.length; // Passage à la lettre suivante dans l'alphabet
                }
               
               
            }
        }

    // Affecter la position finale pour la case vide
    posVide = new Position(largeur - 1, hauteur - 1); // Position en x et y de la case vide (trou)
    tab[posVide.getX()][posVide.getY()].setEstTrou(true);
}

    
        
    /**
     * Méthode pour mélanger aléatoirement les pièces dans la grille.
     */
    public void melangerGrille() {
        Random rand = new Random();
        for (int i = 0; i < largeur * hauteur * 100; i++) {
            int dir = rand.nextInt(4); // 0: haut, 1: droite, 2: bas, 3: gauche
            deplacerCase(dir,true);
        }
    }
    
    /**
     * Méthode pour déplacer la case vide dans une direction donnée.
     * @param direction La direction pour déplacer la case vide.
     * @param estInit Indique si le déplacement est initial ou non.
     */
    public void deplacerCase(int direction,boolean estInit) {
        int dx = 0, dy = 0; // Variables pour stocker le décalage horizontal (dx) et vertical (dy)
    
        // Détermination du décalage en fonction de la direction spécifiée
        if (direction == 0 && posVide.getX() > 0) { // Si la direction est "haut" et la case vide n'est pas sur la première ligne
            dx = -1; // Décalage vertical vers le haut
        } else if (direction == 1 && posVide.getY() < largeur - 1) { // Si la direction est "droite" et la case vide n'est pas sur la dernière colonne
            dy = 1; // Décalage horizontal vers la droite
        } else if (direction == 2 && posVide.getX() < hauteur - 1) { // Si la direction est "bas" et la case vide n'est pas sur la dernière ligne
            dx = 1; // Décalage vertical vers le bas
        } else if (direction == 3 && posVide.getY() > 0) { // Si la direction est "gauche" et la case vide n'est pas sur la première colonne
            dy = -1; // Décalage horizontal vers la gauche
        }else{return;}

    
        // Stocke la pièce adjacente à la case vide
        Piece pieceAdjacente = tab[posVide.getX() + dx][posVide.getY() + dy];
        pieceAdjacente.setPos(posVide.getX(), posVide.getY());



        // Échange les positions de la case vide et de la pièce adjacente
        tab[posVide.getX() + dx][posVide.getY() + dy] = tab[posVide.getX()][posVide.getY()];
        tab[posVide.getX()][posVide.getY()] = pieceAdjacente;
        tab[posVide.getX() + dx][posVide.getY() + dy].setPos(posVide.getX() +dx,posVide.getY() +dy);

        // Met à jour les positions de la case vide après le déplacement
        posVide.ajouter(dx, dy);

        if(!estInit){
            nbCoups++;
            fireChangement();
           
            if(jeuTerminee()){
                tab[posVide.getX()][posVide.getY()].setEstTrou(false);
            }
        }

    }  
    
    
    /**
     * Méthode pour récupérer la pièce à une position donnée dans la grille.
     * @param x La position en x de la pièce.
     * @param y La position en y de la pièce.
     * @requires Les positions x et y doivent être valides dans la grille.
     * @return La pièce à la position spécifiée dans la grille.
     */
    public Piece getPiece(int x, int y) {
        if (x < 0 || x >= largeur || y < 0 || y >= hauteur) {
            return null;
        }
        return tab[x][y];
    }


        /**
         * Méthode pour indiquer si le jeu est terminé.
         * @return true si toutes les pièces sont à leur position finale, false sinon.
         * @ensures Retourne true si toutes les pièces sont à leur position finale, sinon false.
         */
    public boolean jeuTerminee() {
        // Parcours de toutes les pièces de la grille
        for (int x = 0; x < largeur; x++) {
            for (int y = 0; y < hauteur; y++) {
                Piece piece = tab[x][y];
                if (!piece.getPos().equals(piece.getPosFinal())) {
                    return false; // Si la pièce n'est pas à la bonne position, le jeu n'est pas terminé
                }

            }
        }
        return true; // Si toutes les pièces sont à leur position finale, le jeu est terminé
    }   

    /**
     * Méthode pour obtenir le nombre de coups .
     */
    public int getNbCoup(){
        return this.nbCoups;
    }

    /**
    * Méthode pour définir le nombre de coups .
    * @param n Le nombre de coups à définir.
    */
    public void setNbCoup(int n){
        this.nbCoups= n;
    }

    /**
    * Méthode pour mettre à jour la grille après un déplacement.
    * 
    * @ensures La grille est mise à jour après un déplacement.
    */
    public void update(){
        fireChangement();
    }
}
