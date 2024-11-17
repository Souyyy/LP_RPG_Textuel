package combats;

import personnages.Personnage;
import destructibles.Boss;
import maps.Carte;
import java.util.Scanner;

// Classe qui gère le combat avec le boss.

public class CombatBoss {
    private final Scanner scanner = new Scanner(System.in);
    private final Attaques attaque;
    private Carte carte;

    public CombatBoss(Carte carte) {
        this.attaque = new Attaques();
        this.carte = carte;
    }

    public void combattreBoss(Personnage joueur, Boss boss, int joueurX, int joueurY) {
        System.out.println("Voulez-vous combattre le Boss ? (O/N)");
        String reponse = scanner.nextLine().toUpperCase();

        // Si l'utilisateur appuie sur O
        if ("O".equals(reponse)) {
            while (boss.isAlive() && joueur.getVieTotale() > 0) {
                System.out.println("Choisissez votre action : C pour attaque classique, N pour attaque spéciale, F pour fuir.");
                
                // action en fonction des touches entrée dans le terminal
                String action = scanner.nextLine().toUpperCase();
                switch (action) {
                    case "C" -> attaque.attaqueClassique(joueur, boss);
                    case "N" -> attaque.attaqueSpeciale(joueur, boss);
                    case "F" -> {
                        System.out.println("Vous fuyez le combat !");
                        return; // Quitte le combat immédiatement
                    }
                    default -> System.out.println("Action non reconnue !");
                }

                // Si le boss et toujours vivant, le boss riposte et inflige des dégats au joueur
                if (boss.isAlive()) {
                    joueur.perdreVie(boss.getDamage());
                    System.out.println("Le Boss riposte et vous inflige " + boss.getDamage() + " points de dégâts.");
                }
            }

            // Si le boss est tué le joueur gagne de l'xp et la case et vidé de son sigle B
            if (!boss.isAlive()) {
                joueur.xp += 20;
                carte.viderCase(joueurX, joueurY);
                System.out.println("Boss vaincu !");
            }

        //Sinon
        } else {
            System.out.println("Vous fuyez le Boss.");
        }
    }
}
