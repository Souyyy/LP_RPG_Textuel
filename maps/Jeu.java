package maps;

import destructibles.Monster;
import destructibles.Obstacle;
import java.util.Scanner;
import personnages.Personnage;
import weapons.Weapon;
import weapons.WeaponStore;

public class Jeu {

    private static final int LARGEUR = 30; // Largeur du donjon
    private static final int HAUTEUR = 15; // Hauteur du donjon
    private int joueurX = 0;
    private int joueurY = 0;
    private Carte carte;
    private Personnage joueur;
    private WeaponStore store;

    public Jeu(Personnage joueur) {
        this.joueur = joueur;
        carte = new Carte();
        this.store = new WeaponStore();
        this.joueurX = 1; // Position initiale du joueur (1, 1)
        this.joueurY = 1;
    }

    public void jouer() {
        Scanner scanner = new Scanner(System.in);
        while (!(joueurX == HAUTEUR - 2 && joueurY == LARGEUR - 2)) { // Tant que le joueur n'a pas atteint la sortie
            carte.afficherCarte(joueurX, joueurY);
            joueur.afficherStats();
            System.out.println("\nDéplacez-vous : Z (haut), S (bas), Q (gauche), D (droite)");
            System.out.println("Ouvrir le menu : F (Armes), E (l'inventaire) \n");
            String deplacement = scanner.nextLine().toUpperCase();

            int nouvelleX = joueurX;
            int nouvelleY = joueurY;

            switch (deplacement) {
                case "Z" -> nouvelleX = joueurX - 1; // Déplacer vers le haut
                case "S" -> nouvelleX = joueurX + 1; // Déplacer vers le bas
                case "Q" -> nouvelleY = joueurY - 1; // Déplacer vers la gauche
                case "D" -> nouvelleY = joueurY + 1; // Déplacer vers la droite
                case "E" -> {
                    joueur.afficherInventaire(); // Display player's inventory
                    continue; // Skip the rest of the loop
                }
                case "F" -> {
                    store.printWeapons(); // Display available weapons
                    System.out.println("Entrez le numéro de l'arme à acheter (ou -1 pour annuler) :");
                    int choix = Integer.parseInt(scanner.nextLine());
                    if (choix >= 0 && choix < store.getWeapons().size()) {
                        Weapon selectedWeapon = store.getWeapons().get(choix);
                        joueur.acheterArme(selectedWeapon); // Purchase the selected weapon
                    } else if (choix != -1) {
                        System.out.println("Choix invalide.");
                    }
                    continue; // Skip the rest of the loop
                }
                default -> {
                    System.out.println("Commande invalide !");
                    continue;
                }
            }

            // Vérifie si la nouvelle position est valide (dans les limites et pas un mur)
            if (nouvelleX < 0 || nouvelleX >= HAUTEUR || nouvelleY < 0 || nouvelleY >= LARGEUR
                    || "X".equals(carte.obtenirCase(nouvelleX, nouvelleY))) {
                System.out.println("Vous ne pouvez pas traverser cet obstacle !");
                continue;
            }

            // Mettre à jour la position du joueur
            joueurX = nouvelleX;
            joueurY = nouvelleY;

            // Vérifie la case où le joueur se trouve
            Object caseActuelle = carte.obtenirCase(joueurX, joueurY);
            if (caseActuelle instanceof Obstacle obstacle) {
                System.out.println("Un obstacle bloque le chemin !");
                interagirAvecObstacle(obstacle);
            } else if (caseActuelle instanceof Monster monster) {
                System.out.println("Un monstre surgit !");
                // combattreMonstre(monster);
            }
        }

        // Combat avec le boss à la sortie
        System.out.println("Vous avez atteint la sortie ! Un boss vous attend !");
        // combattreBoss((Boss) carte.obtenirCase(joueurX, joueurY));

        System.out.println("Félicitations ! Vous avez terminé le jeu !");
        scanner.close();
    }

    // private void combattreBoss(Boss boss) {
    // System.out.println("Le boss surgit ! Préparez-vous au combat !");
    // Scanner scanner = new Scanner(System.in);
    // while (boss.health > 0) {
    // System.out.println("Choisissez votre action :");
    // System.out.println("1. Attaquer");
    // System.out.println("2. Fuir");
    // String choix = scanner.nextLine();
    // if ("1".equals(choix)) {
    // joueur.utiliserPouvoir(0); // Utilise un pouvoir pour attaquer le boss
    // boss.hit(20); // Inflige des dégâts au boss
    // System.out.println("Vous infligez des dégâts au boss !");
    // if (boss.health <= 0) {
    // System.out.println("Vous avez vaincu le boss !");
    // joueur.xp += 50; // Gagnez plus d'XP pour avoir vaincu le boss
    // break;
    // }
    // // Le boss attaque le joueur
    // System.out.println("Le boss vous attaque !");
    // joueur.hit(10); // Le joueur reçoit des dégâts
    // } else if ("2".equals(choix)) {
    // System.out.println("Vous avez choisi de fuir le combat !");
    // break; // Sort du combat
    // } else {
    // System.out.println("Choix invalide !");
    // }
    // }
    // }

    private void interagirAvecObstacle(Obstacle obstacle) {
        System.out.println("Voulez-vous détruire l'obstacle ? (Oui/Non)");
        Scanner scanner = new Scanner(System.in);
        String reponse = scanner.nextLine().toUpperCase();

        if ("OUI".equals(reponse)) {
            while (obstacle.isAlive()) {
                // joueur.utiliserPouvoir(0); // Utilise un pouvoir pour réduire la vie de
                // l'obstacle
                obstacle.hit(10); // Inflige des dégâts à l'obstacle
            }
            carte.viderCase(joueurX, joueurY);
            System.out.println("Obstacle détruit !");
        } else {
            System.out.println("Vous décidez de revenir en arrière.");
            deplacerEnArriere();
        }
    }

    // private void combattreMonstre(Monster monstre) {
    // System.out.println("Voulez-vous combattre le monstre ? (Oui/Non)");
    // Scanner scanner = new Scanner(System.in);
    // String reponse = scanner.nextLine().toUpperCase();
    // if ("OUI".equals(reponse)) {
    // while (monstre.health > 0) {
    // joueur.utiliserPouvoir(0); // Utilise un pouvoir pour attaquer le monstre
    // monstre.hit(10); // Réduit la vie du monstre
    // if (monstre.health <= 0) {
    // joueur.xp += 20; // Le joueur gagne de l'XP pour avoir vaincu le monstre
    // System.out.println("Monstre vaincu ! Vous gagnez 20 points d'XP.");
    // carte.viderCase(joueurX, joueurY);
    // break;
    // }
    // }
    // } else {
    // System.out.println("Vous fuyez le monstre.");
    // deplacerEnArriere();
    // }
    // }
    private void deplacerEnArriere() {
        // Déplace le joueur d'une case en arrière
        if (joueurX > 1) {
            joueurX--; // Empêche le joueur de revenir dans le mur
        } else if (joueurY > 1) {
            joueurY--; // Empêche le joueur de revenir dans le mur

        }
    }
}
