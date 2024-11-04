package personnages;

import java.util.Scanner;

public class CreatePersonnage {

    public static Personnage creerPersonnage(Scanner scanner) { // Accepte un Scanner en paramètre
        System.out.print("Entrez le nom de votre personnage : ");
        String nom = scanner.nextLine();

        System.out.println("Choisissez votre classe :");
        System.out.println("1. Archer");
        System.out.println("2. Barbare");
        System.out.println("3. Elfe");
        System.out.println("4. Ogre");
        System.out.println("5. Sorcier");

        int choixClasse = scanner.nextInt();
        Personnage personnage;

        switch (choixClasse) {
            case 1 -> {
                personnage = new Archer(nom);
                System.out.println("Vous avez choisi : Archer");
            }
            case 2 -> {
                personnage = new Barbare(nom);
                System.out.println("Vous avez choisi : Barbare");
            }
            case 3 -> {
                personnage = new Elfe(nom);
                System.out.println("Vous avez choisi : Elfe");
            }
            case 4 -> {
                personnage = new Ogre(nom);
                System.out.println("Vous avez choisi : Ogre");
            }
            case 5 -> {
                personnage = new Sorcier(nom);
                System.out.println("Vous avez choisi : Sorcier");
            }
            default -> {
                System.out.println("Choix invalide, un Elfe est attribué par défaut.");
                personnage = new Elfe(nom);
            }
        }

        return personnage;
    }
}
