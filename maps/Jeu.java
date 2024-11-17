package maps;

import destructibles.Boss;
import destructibles.Monster;
import destructibles.Obstacle;
import java.util.Scanner;
import personnages.Personnage;
import weapons.Weapon;
import weapons.WeaponStore;
import combats.CombatMonstre;
import consommables.Potion;
import combats.CombatBoss;

// Classe qui gère la logique du jeu.

public class Jeu {

    private static final int LARGEUR = 30; 
    private static final int HAUTEUR = 15;
    private int joueurX = 0;
    private int joueurY = 0;
    private Carte carte;
    private Personnage joueur;
    private WeaponStore store;
    private CombatMonstre combatMonstre;
    private CombatBoss combatBoss;

    public Jeu(Personnage joueur) {
        this.joueur = joueur;
        carte = new Carte();
        this.store = new WeaponStore();
        this.joueurX = 1;
        this.joueurY = 1;
        this.combatMonstre = new CombatMonstre(carte);
        this.combatBoss = new CombatBoss(carte);
    }

    public void jouer() {
        Scanner scanner = new Scanner(System.in);
        // Tant que le joueur n'a pas atteint la sortie
        while (!(joueurX == HAUTEUR - 2 && joueurY == LARGEUR - 2)) { 
            carte.afficherCarte(joueurX, joueurY);
            joueur.afficherStats();
            System.out.println("\n Déplacez-vous : Z (haut), S (bas), Q (gauche), D (droite)");
            System.out.println("        Ouvrir le menu : F (Armes), E (l'inventaire)");
            System.out.println("                Consommable : P (Potion) \n");
            String deplacement = scanner.nextLine().toUpperCase();

            // Mettre à jour la position du joueur
            int nouvelleX = joueurX;
            int nouvelleY = joueurY;

            // En fonction des touches que le joueur tape dans le terminal cela effectue une action
            switch (deplacement) {
                case "Z" -> nouvelleX = joueurX - 1; //Haut
                case "S" -> nouvelleX = joueurX + 1; //Bas
                case "Q" -> nouvelleY = joueurY - 1; //Gauche
                case "D" -> nouvelleY = joueurY + 1; //Droite

                // Permet d'utiliser une potion et de revenir au début de la boucle
                case "P" -> {
                    joueur.utiliserPotion();
                    continue;
                }
                // Permet d'afficher l'inventaire  et de revenir au début de la boucle
                case "E" -> {
                    joueur.afficherInventaire(); 
                    continue;
                }
                // Permet d'afficher le menu d'achat d'arme et de revenir au début de la boucle
                case "F" -> {
                    store.printWeapons();
                    System.out.println("Entrez le numéro de l'arme à acheter (ou -1 pour annuler) :");
                    int choix = Integer.parseInt(scanner.nextLine());
                    if (choix >= 0 && choix < store.getWeapons().size()) {
                        Weapon selectedWeapon = store.getWeapons().get(choix);
                        //Achat d'arme
                        joueur.acheterArme(selectedWeapon); 
                    } else if (choix != -1) {
                        System.out.println("Choix invalide.");
                    }
                    continue;
                }
                // Si aucune touche ne correspond
                default -> {
                    System.out.println("Commande invalide !");
                    continue;
                }
            }

            // Vérifie si la nouvelle position est valide (dans les limites et pas un mur)
            if (nouvelleX < 0 || nouvelleX >= HAUTEUR || nouvelleY < 0 || nouvelleY >= LARGEUR
                    || "X".equals(carte.obtenirCase(nouvelleX, nouvelleY))) {
                System.out.println("Vous ne pouvez pas traverser ce mur !");
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
                System.out.println("                    Un monstre surgit !");
                combatMonstre.combattreMonstre(joueur, monster, joueurX, joueurY);
            } else if (caseActuelle instanceof Boss boss) {
                System.out.println("                  Le Boss final surgit !");
                combatBoss.combattreBoss(joueur, boss, joueurX, joueurY);
            }
        }

        // Fin du jeu
        System.out.println("Félicitations ! Vous avez terminé le jeu !");
        scanner.close();
    }

    // Interaction avec les obstacles
    private void interagirAvecObstacle(Obstacle obstacle) {
        System.out.println("Voulez-vous détruire l'obstacle ? (O/N)");
        Scanner scanner = new Scanner(System.in);
        String reponse = scanner.nextLine().toUpperCase();

        // Si l'utilisateur appuie sur O
        if ("O".equals(reponse)) {
            while (obstacle.isAlive()) {
                obstacle.hit(10);
            }
            carte.viderCase(joueurX, joueurY);
            System.out.println("Obstacle détruit !");

            // 1 chance sur 3 de drop une potion de santé en cassant un obstacle
            if (Math.random() < 1.0 / 3) {
                Potion potion = new Potion();
                joueur.ajouterPotion(potion);
            }
            
        //Sinon
        } else {
            System.out.println("Vous décidez de revenir en arrière.");
            deplacerEnArriere();
        }
    }
    // Déplacement en arrière 
    private void deplacerEnArriere() {
        // Empêche le joueur de revenir dans le mur
        if (joueurX > 1) {
            joueurX--; 
        } else if (joueurY > 1) {
            joueurY--;

        }
    }
}
