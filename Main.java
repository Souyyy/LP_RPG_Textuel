
import java.util.Scanner;
import maps.Jeu;
import personnages.CreatePersonnage;
import personnages.Personnage;

public class Main {

    public static void main(String[] args) throws CloneNotSupportedException {

        System.out.println("╔═════════════════════════════════════════╗\n"
                + "|                                         |\n"
                + "|               Bienvenue sur             |\n"
                + "|                                         |\n"
                + "|    _     ______  ____________ _____     |\n"
                + "|   | |    | ___ \\ | ___ \\ ___ \\  __ \\    |\n"
                + "|   | |    | |_/ / | |_/ / |_/ / |  \\/    |\n"
                + "|   | |    |  __/  |    /|  __/| | __     |\n"
                + "|   | |____| |     | |\\ \\| |   | |_\\ \\    |\n"
                + "|   \\_____/\\_|     \\_| \\_\\_|    \\____/    |\n"
                + "|                                         |\n"
                + "|        Ce jeux RPG à été crée par       |\n"
                + "|                 Théo DISY               |\n"
                + "|                                         |\n"
                + "╚═════════════════════════════════════════╝");

        Scanner scanner = new Scanner(System.in);
        System.out.println("BLABLA INSTRUCTION");
        Personnage joueur = CreatePersonnage.creerPersonnage(scanner); // Pas de paramètre passé ici

        Jeu jeu = new Jeu(joueur);
        jeu.jouer();
    }
}
