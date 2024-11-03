package maps;

import destructibles.Boss;
import destructibles.Monster;
import destructibles.Obstacle;

public class Carte {

    private static final int LARGEUR = 30; // Largeur du donjon
    private static final int HAUTEUR = 15; // Hauteur du donjon
    private Object[][] carte; // Matrice pour représenter le donjon

    public Carte() {
        carte = new Object[HAUTEUR][LARGEUR];
        initialiserCarte();
    }

    private void initialiserCarte() {
        // Remplir les bords de la carte avec des murs
        for (int i = 0; i < HAUTEUR; i++) {
            for (int j = 0; j < LARGEUR; j++) {
                if (i == 0 || i == HAUTEUR - 1 || j == 0 || j == LARGEUR - 1) {
                    carte[i][j] = "X"; // Mur indestructible
                } else {
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
        carte[1][1] = "J"; // Position initiale du joueur en haut à gauche
        carte[HAUTEUR - 2][LARGEUR - 2] = new Boss(); // Sortie en bas à droite
    }

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
                    System.out.print("B "); // Sortie
                } else if (carte[i][j] == "X") {
                    System.out.print("X "); // Mur
                } else {
                    System.out.print(". "); // Espace vide
                }
            }
            System.out.println();
        }
    }

    public Object obtenirCase(int x, int y) {
        return carte[x][y];
    }

    public void viderCase(int x, int y) {
        carte[x][y] = null; // Vider la case après destruction de l'obstacle ou du monstre
    }
}
