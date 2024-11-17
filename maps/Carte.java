package maps;

import destructibles.Boss;
import destructibles.Monster;
import destructibles.Obstacle;

// Classe qui gère la création de la map.

public class Carte {
    // Création de la matrice et définir la taille de la matrice (carte)
    private Object[][] carte; // Matrice pour représenter le donjon
    private static final int LARGEUR = 30; 
    private static final int HAUTEUR = 15;
   
    public Carte() {
        carte = new Object[HAUTEUR][LARGEUR];
        initialiserCarte();
    }

    private void initialiserCarte() {
        // Création de la map
        for (int i = 0; i < HAUTEUR; i++) {
            for (int j = 0; j < LARGEUR; j++) {
                // Remplir les bords de la carte avec des murs
                if (i == 0 || i == HAUTEUR - 1 || j == 0 || j == LARGEUR - 1) {
                    // Bordure de map
                    carte[i][j] = "X"; 
                } else {
                    //Si ce n'est pas une bordure avoir 1 chance sur 10 de placer un mob ou un obstacle
                    double chance = Math.random();
                    if (chance < 0.1) {
                        carte[i][j] = new Obstacle(); // 10% chance de placer un obstacle
                    } else if (chance < 0.2) {
                        carte[i][j] = new Monster(); // 10% chance de placer un monstre
                    } else {
                        carte[i][j] = null; // Espace vide
                    }
                }
            }
        }
        // Placer le joueur
        carte[1][1] = "J"; 
        // Placer le boss (fin du jeu)
        carte[HAUTEUR - 2][LARGEUR - 2] = new Boss();
    }

    // fonction de la map
    public void afficherCarte(int joueurX, int joueurY) {
        for (int i = 0; i < HAUTEUR; i++) {
            for (int j = 0; j < LARGEUR; j++) {
                if (i == joueurX && j == joueurY) {
                    System.out.print("J "); // Représente le joueur
                } else if (carte[i][j] instanceof Obstacle) {
                    System.out.print("O "); // Représente un obstacle
                } else if (carte[i][j] instanceof Monster) {
                    System.out.print("M "); // Représente un monstre
                } else if (carte[i][j] instanceof Boss) {
                    System.out.print("B "); // Boss (sortie)
                } else if (carte[i][j] == "X") {
                    System.out.print("X "); // Mur
                } else {
                    System.out.print(". "); // Espace vide
                }
            }
            //Afficher la map
            System.out.println();
        }
    }

    // Obtenir la valeur de la case
    public Object obtenirCase(int x, int y) {
        return carte[x][y];
    }

    // Vider la case après destruction de l'obstacle ou du monstre
    public void viderCase(int x, int y) {
        carte[x][y] = null; 
    }
}
