package combats;

import destructibles.Monster;
import destructibles.Boss;
import personnages.Personnage;

// Classe qui gère les différents types d'attaques disponibles pour le joueur.

public class Attaques {

    // Execute une attaque classique contre un monstre et verifie si l'utilisateur possède une arme pour attaquer
    public void attaqueClassique(Personnage joueur, Monster monstre) {
        if (joueur.getArmeEquiper() != null) {
            joueur.getArmeEquiper().attack(monstre);
            System.out.println("Vous attaquez le monstre avec une attaque classique !");
        } else {
            System.out.println("Vous n'avez pas d'arme équipée. Aucun dégât n'est infligé.");
        }
    }

    // Execute une attaque spécial contre un monstre et verifie si l'utilisateur possède une arme pour attaquer
    public void attaqueSpeciale(Personnage joueur, Monster monstre) {
        if (joueur.getMana() >= 20) {
            joueur.setMana(joueur.getMana() - 20);
            if (joueur.getArmeEquiper() != null) {
                //Degat special et x1.5 plus puissante qu'une attaque classique
                double degatsSpecial = joueur.getArmeEquiper().getDamage() * 1.5;
                monstre.hit(degatsSpecial);
                System.out.println("Vous utilisez une attaque spéciale !");
            } else {
                System.out.println("Vous n'avez pas d'arme, l'attaque spéciale est inefficace.");
            }
        } else {
            System.out.println("Pas assez de mana pour l'attaque spéciale.");
        }
    }

    // Execute une attaque classique contre un boss et verifie si l'utilisateur possède une arme pour attaquer
    public void attaqueClassique(Personnage joueur, Boss boss) {
        if (joueur.getArmeEquiper() != null) {
            joueur.getArmeEquiper().attack(boss);
            System.out.println("Vous attaquez le boss avec une attaque classique !");
        } else {
            System.out.println("Vous n'avez pas d'arme équipée. Aucun dégât n'est infligé.");
        }
    }

    // Execute une attaque spécial contre le boss et verifie si l'utilisateur possède une arme pour attaquer
    public void attaqueSpeciale(Personnage joueur, Boss boss) {
        if (joueur.getMana() >= 20) {
            joueur.setMana(joueur.getMana() - 20);
            if (joueur.getArmeEquiper() != null) {
                //Degat special et x1.5 plus puissante qu'une attaque classique
                double degatsSpecial = joueur.getArmeEquiper().getDamage() * 1.5;
                boss.hit(degatsSpecial);
                System.out.println("Vous utilisez une attaque spéciale !");
            } else {
                System.out.println("Vous n'avez pas d'arme, l'attaque spéciale est inefficace.");
            }
        } else {
            System.out.println("Pas assez de mana pour l'attaque spéciale.");
        }
    }
}