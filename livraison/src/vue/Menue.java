package vue;

import javax.swing.*;

import coeur.Grille;

import java.awt.*;
import java.awt.event.*;

public class Menue extends JFrame implements ActionListener {
    private ButtonGroup radio1,radio2;
    private JButton  boutonJouer = new JButton("JOUER");;
    private Grille grille;
    private boolean aUneGrille = false;
    private JPanel panel = new JPanel(new GridLayout(5, 1));;


    /**
    * Constructeur de la classe Menue.
    * @ensures Un menu principal est créé avec des boutons.
    */
    public Menue() {
        setTitle("Jeu de Puzzle à glissières (Taquin)");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        // Panneau pour les éléments du centre

        panel.setBackground(new Color(204, 0, 204)); //back-ground du texte

        JLabel text1 = text_couleur("CHOISIR LE TYPE DU JEU", Color.WHITE);
        panel.add(text1);

        JPanel typeCellule = new JPanel(new FlowLayout(FlowLayout.CENTER));
        typeCellule.setBackground(new Color(204, 0, 204)); // back-ground  du boutton 1
        JRadioButton boutonNombre = new JRadioButton("Nombres");
        boutonNombre.setActionCommand("nombres");
        JRadioButton boutonLettre = new JRadioButton("Lettres");
        boutonLettre.setActionCommand("lettres");

        radio1 = new ButtonGroup();
        radio1.add(boutonNombre);
        radio1.add(boutonLettre);
        typeCellule.add(boutonNombre);
        typeCellule.add(boutonLettre);
        panel.add(typeCellule);

        // Label pour choisir la taille de la grille
        JLabel text2 = text_couleur("CHOISIR LA TAILLE DE LA GRILLE", Color.WHITE);
        panel.add(text2);

        // Boutons radio pour choisir la taille de la grille
        JPanel tailleGrille = new JPanel(new FlowLayout(FlowLayout.CENTER));
        tailleGrille.setBackground(new Color(204, 0, 204)); 

        JRadioButton grilleDe3 = new JRadioButton("3 x 3");
        grilleDe3.setActionCommand("3");
        JRadioButton grilleDe4 = new JRadioButton("4 x 4");
        grilleDe4.setActionCommand("4");
        radio2 = new ButtonGroup();
        radio2.add(grilleDe3);
        radio2.add(grilleDe4);
        tailleGrille.add(grilleDe3);
        tailleGrille.add(grilleDe4);
        panel.add(tailleGrille);

        // Ajout du panneau du centre à la fenêtre
        add(panel, BorderLayout.CENTER);

        // Bouton "Jouer"
        boutonJouer.setBackground(new Color(128, 0, 128));
        boutonJouer.setForeground(Color.WHITE);
        boutonJouer.setPreferredSize(new Dimension(100, 40));
        boutonJouer.setFont(new Font("Arial", Font.BOLD, 14));

        boutonJouer.addActionListener(this);
        add(boutonJouer, BorderLayout.SOUTH);

        // Rendre la fenêtre visible
        setVisible(true);
    }

    public Menue(Grille grille){
        boutonJouer.addActionListener(this);
        this.grille = grille;
        new GrilleFrame(this,this.grille);
        
    }

    /**
    * Méthode pour créer un texte et une couleur spécifiée.
    * @param text Le texte à afficher.
    * @param color La couleur du texte.
    * @return Un JLabel avec le texte et la couleur spécifiés.
    */
    private JLabel text_couleur(String text, Color color) {
        JLabel label = new JLabel(text, SwingConstants.CENTER);
        label.setForeground(color);
        label.setFont(new Font("Arial", Font.BOLD, 16));
        return label;
    }
    /**
    * Méthode pour activer ou désactiver le bouton "Jouer".
    * @param active true pour activer le bouton, false pour le désactiver.
    */
    public void activeBoutton(boolean active){
        boutonJouer.setEnabled(active);
    }


    /**
     * Méthode quand une action est détecté, comme le clic sur le bouton "Jouer".
     * @param e L'événement d'action détecté.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        int hauteur,largeur;
        String type;

        if(aUneGrille){
            new GrilleFrame(this,this.grille);
            activeBoutton(false);

        }else if (radio1.getSelection() != null && radio2.getSelection() != null) {
           
          hauteur = Integer.parseInt(radio2.getSelection().getActionCommand());
          largeur = hauteur;
          type = radio1.getSelection().getActionCommand();
          this.grille = new Grille(largeur, hauteur, type);

          new GrilleFrame(this,this.grille);
          activeBoutton(false);

        }else{
            System.out.println("nothing selected");
        }
    }


    public static void main(String[] args) {
        new Menue();
    }

}
