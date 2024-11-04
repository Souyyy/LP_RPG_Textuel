package combats;

import personnages.Personnage;
import destructibles.Boss;
import maps.Carte; // Assurez-vous d'importer la classe Carte

import java.util.Scanner;

public class CombatBoss {
    private final Scanner scanner = new Scanner(System.in);
    private final Attaques attaque;
    private Carte carte; // Ajout de la référence à la carte

    public CombatBoss(Carte carte) {
        this.attaque = new Attaques();
        this.carte = carte; // Initialisation de la carte

    }

    public void combattreBoss(Personnage joueur, Boss boss, int joueurX, int joueurY) {
        System.out.println("Voulez-vous combattre le Boss ? (O/N)");
        String reponse = scanner.nextLine().toUpperCase();

        if ("O".equals(reponse)) {
            while (boss.isAlive() && joueur.getVieTotale() > 0) {
                System.out.println("Choisissez votre action : C pour attaque classique, N pour attaque spéciale");
                String action = scanner.nextLine().toUpperCase();

                switch (action) {
                    case "C" -> attaque.attaqueClassique(joueur, boss);
                    case "N" -> attaque.attaqueSpeciale(joueur, boss);
                    default -> System.out.println("Action non reconnue !");
                }

                if (boss.isAlive()) {
                    joueur.perdreVie(boss.getDamage());
                    System.out.println("Le Boss riposte et vous inflige " + boss.getDamage() + " points de dégâts.");
                }
            }

            if (!boss.isAlive()) {
                joueur.xp += 20;
                carte.viderCase(joueurX, joueurY); // Vider la case après la victoire
                System.out.println("Boss vaincu !");
            }

        } else {
            System.out.println("Vous fuyez le Boss.");
        }
    }
}
