package combats;

import destructibles.Monster;
import personnages.Personnage;
import maps.Carte;
import java.util.Scanner;

// Classe qui gère le combat avec le monstre.

public class CombatMonstre {
    private final Scanner scanner = new Scanner(System.in);
    private final Attaques attaque;
    private Carte carte;

    public CombatMonstre(Carte carte) {
        this.attaque = new Attaques();
        this.carte = carte;
    }

    public void combattreMonstre(Personnage joueur, Monster monstre, int joueurX, int joueurY) {
        System.out.println("Voulez-vous combattre le monstre ? (O/N)");
        String reponse = scanner.nextLine().toUpperCase();

        // Si l'utilisateur appuie sur O
        if ("O".equals(reponse)) {
            while (monstre.isAlive() && joueur.getVieTotale() > 0) {
                System.out.println("Choisissez votre action : C pour attaque classique, N pour attaque spéciale, F pour fuir.");
                
                // action en fonction des touches entrée dans le terminal
                String action = scanner.nextLine().toUpperCase(); 
                switch (action) {
                    case "C" -> attaque.attaqueClassique(joueur, monstre);
                    case "N" -> attaque.attaqueSpeciale(joueur, monstre);
                    case "F" -> {
                        System.out.println("Vous fuyez le combat !");
                        return;
                    }
                    default -> System.out.println("Action non reconnue !");
                }

                // Si le monstre et toujours vivant, le monstre riposte et inflige des dégats au joueur
                if (monstre.isAlive()) {
                    joueur.perdreVie(monstre.getDamage());
                    System.out.println("Le monstre riposte et vous inflige " + monstre.getDamage() + " points de dégâts.");
                }
            }

            // Si le monstre est tué le joueur gagne de l'xp, regenere son man et la case et vidé de son sigle M
            if (!monstre.isAlive()) {
                joueur.xp += 20;
                joueur.verifierNiveau();
                joueur.regenererMana(50);
                System.out.println("Monstre vaincu ! Vous gagnez 20 points d'XP.");
                carte.viderCase(joueurX, joueurY);
            }

        //Sinon
        } else {
            System.out.println("Vous fuyez le monstre.");
        }
    }
}
