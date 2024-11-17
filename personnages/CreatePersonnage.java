package personnages;

import java.util.InputMismatchException;
import java.util.Scanner;

// Class qui gère la création d'un personnage

public class CreatePersonnage {

    public static Personnage creerPersonnage(Scanner scanner) { 
        String nom = "";
        // Utilisation d'un boucle pour forcer la saisie d'un pseudo
        while (nom.isEmpty()) {
            System.out.print("Veuillez saisir votre pseudonyme : ");
            nom = scanner.nextLine().trim();
    
            if (nom.isEmpty()) {
                System.out.println("Le pseudonyme ne peut pas être vide. Veuillez réessayer.");
            }
        }

        System.out.println("      Veuillez choisir votre classe en tapant le chiffre      ");
        System.out.println("[1] Archer - [2] Barbare - [3] Elfe - [4] Ogre - [5] Sorcier");

        Personnage personnage = null;
        
        // Utilisation d'un boucle pour forcer la saisie correcte
        while (personnage == null) {
            try {
                int choixClasse = scanner.nextInt();

                // Selon le choix, créer le personnage correspondant
                switch (choixClasse) {
                    case 1 -> {
                        personnage = new Archer(nom);
                        System.out.println("               Vous avez choisi : Archer               ");
                    }
                    case 2 -> {
                        personnage = new Barbare(nom);
                        System.out.println("               Vous avez choisi : Barbare               ");
                    }
                    case 3 -> {
                        personnage = new Elfe(nom);
                        System.out.println("               Vous avez choisi : Elfe               ");
                    }
                    case 4 -> {
                        personnage = new Ogre(nom);
                        System.out.println("               Vous avez choisi : Ogre               ");
                    }
                    case 5 -> {
                        personnage = new Sorcier(nom);
                        System.out.println("              Vous avez choisi : Sorcier              ");
                    }
                    default -> {
                        // Si le choix est pas bon, recommencer la boucle
                        System.out.println("     Choix invalide, un Elfe est attribué par défaut.     ");
                        personnage = new Elfe(nom);
                    }
                }
            } catch (InputMismatchException e) {
                // Si une exception est levée, l'utilisateur n'a pas entré un nombre
                System.out.println("                     Entrée invalide                     ");
                scanner.nextLine();
            }
        }

        return personnage;
    }
}
