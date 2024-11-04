package combats;

import destructibles.Monster;
import personnages.Personnage;
import maps.Carte; // Assurez-vous d'importer la classe Carte

import java.util.Scanner;

public class CombatMonstre {
    private final Scanner scanner = new Scanner(System.in);
    private final Attaques attaque;
    private Carte carte; // Ajout de la référence à la carte

    public CombatMonstre(Carte carte) {
        this.attaque = new Attaques();
        this.carte = carte; // Initialisation de la carte
    }

    public void combattreMonstre(Personnage joueur, Monster monstre, int joueurX, int joueurY) {
        System.out.println("Voulez-vous combattre le monstre ? (O/N)");
        String reponse = scanner.nextLine().toUpperCase();

        if ("O".equals(reponse)) {
            while (monstre.isAlive() && joueur.getVieTotale() > 0) {
                System.out.println("Choisissez votre action : C pour attaque classique, N pour attaque spéciale");
                String action = scanner.nextLine().toUpperCase();

                switch (action) {
                    case "C" -> attaque.attaqueClassique(joueur, monstre);
                    case "N" -> attaque.attaqueSpeciale(joueur, monstre);
                    default -> System.out.println("Action non reconnue !");
                }

                if (monstre.isAlive()) {
                    joueur.perdreVie(monstre.getDamage());
                    System.out.println("Le monstre riposte et vous inflige " + monstre.getDamage() + " points de dégâts.");
                }
            }

            if (!monstre.isAlive()) {
                joueur.xp += 20;
                System.out.println("Monstre vaincu ! Vous gagnez 20 points d'XP.");
                carte.viderCase(joueurX, joueurY); // Vider la case après la victoire
            }

        } else {
            System.out.println("Vous fuyez le monstre.");
        }
    }
}
