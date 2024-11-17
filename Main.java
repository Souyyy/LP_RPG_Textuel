
import java.util.Scanner;
import maps.Jeu;
import personnages.CreatePersonnage;
import personnages.Personnage;

public class Main {

    public static void main(String[] args) throws CloneNotSupportedException {

        // Affiche l'introduction du jeu avec des délais.

        try {
            System.out.println("╔═════════════════════════════════════════════════════════╗\n"
                    + "|                                                         |\n"
                    + "|                       Bienvenue sur                     |\n"
                    + "|                                                         |\n"
                    + "|            _     ______  ____________ _____             |\n"
                    + "|           | |    | ___ \\ | ___ \\ ___ \\  __ \\            |\n"
                    + "|           | |    | |_/ / | |_/ / |_/ / |  \\/            |\n"
                    + "|           | |    |  __/  |    /|  __/| | __             |\n"
                    + "|           | |____| |     | |\\ \\| |   | |_\\ \\            |\n"
                    + "|           \\_____/\\_|     \\_| \\_\\_|    \\____/            |\n"
                    + "|                                                         |\n"
                    + "|                Ce jeux RPG à été crée par               |\n"
                    + "|                         Théo DISY                       |\n"
                    + "|                                                         |\n"
                    + "╚═════════════════════════════════════════════════════════╝");

            Scanner scanner = new Scanner(System.in);
            System.out.println("\n             Salut et bienvenue, aventurier !             \n");
            Thread.sleep(1000);
            System.out.println("Tu as été capturé et te retrouves prisonnier de ce mystérieux \ndonjon. Pour t'en échapper, tu devras explorer ses sombres \ncouloirs et trouver la sortie. \n");
            Thread.sleep(1000);
            System.out.println("Mais attention ! Ce donjon est peuplé de monstres redoutables \net parsemé d'obstacles qui barreront ta route. Pas de panique, \n grâce à ton pouvoir de télépathie, tu pourras invoquer le \nmenu des armes pour t'équiper et renforcer tes chances de survie. \n\nEn détruisant les obstacles, tu auras aussi une chance de  \ntrouver des potions de vie qui te redonneront un peu d'énergie.");
            Thread.sleep(1000);
            System.out.println("\nTon objectif ultime ? Atteindre la sortie, située en bas à \ndroite de la carte, et vaincre le boss final pour retrouver \nta liberté.\n");
            Thread.sleep(1000);
            Personnage joueur = CreatePersonnage.creerPersonnage(scanner);

            Jeu jeu = new Jeu(joueur);
            jeu.jouer();
        } catch (InterruptedException e) {
            // En cas d'erreur si l'exécution est interrompue pendant les délais
            System.err.println("Une erreur est survenue lors du délai.");
            Thread.currentThread().interrupt();
        }
    }
}
