package personnages;

import weapons.Weapon;
import java.util.ArrayList;
import java.util.List;
import consommables.Potion;

// Class qui gère le personnage, sa vie, son inventaire, ect ...

public class Personnage {

    protected String nom;
    protected int coeurs;
    protected int mana;
    public int xp;
    protected int argent;
    private Weapon armeEquiper;
    private List<Potion> potions;
    private int niveau;
    private static final int XP_PAR_NIVEAU = 100;

    public Personnage(String nom, int coeurs, int mana, int xp, int argent) {
        this.nom = nom;
        this.coeurs = coeurs;
        this.mana = mana;
        this.xp = xp;
        this.argent = argent;
        this.niveau = 1;
        // Initalisation vide pour arme et piotion
        this.armeEquiper = null;
        this.potions = new ArrayList<>();
    }

    // Fonction pour vérifier et augmenter le niveau du personnage
    public void verifierNiveau() {
        int xpNecessaire = niveau * XP_PAR_NIVEAU;
        if (this.xp >= xpNecessaire) {
            this.niveau++;
            // Réinitialiser l'XP apres avoir level up
            this.xp -= xpNecessaire; 
             // Ajouter 10 points de vie a chaque nouveau niveau
            this.coeurs += 10;
            System.out.println("Félicitations ! Vous êtes maintenant au niveau " + niveau + " ! Points de vie supplémentaires : +10");
        }
    }

    public void acheterArme(Weapon nouvelleArme) {
        // Verifie si le joueur a assez d'argent
        if (this.argent >= nouvelleArme.getPrice()) {
            // Retire le montant de l'arme
            this.argent -= nouvelleArme.getPrice();
            // Equipe le joeuur de la nouvelle arme
            this.armeEquiper = nouvelleArme; 
            System.out.println("Vous avez acheté : " + nouvelleArme.toString());
        } else {
            System.out.println("Pas assez d'argent pour acheter cette arme.");
        }
    }

    public void ajouterPotion(Potion potion) {
        // Ajout de potion a l'inventaire du joueur
        potions.add(potion);
        System.out.println("Vous avez trouvé une potion de soin !");
    }

    public void utiliserPotion() {
        if (potions.isEmpty()) {
            System.out.println("Vous n'avez pas de potions.");
            return;
        }
        Potion potion = potions.remove(0);
        this.coeurs = Math.min(this.coeurs + potion.getSoin(), 100);
        System.out.println("Vous avez utilisé une potion et récupéré " + potion.getSoin()
                + " HP. Points de vie actuels : " + this.coeurs);
    }

    public void afficherInventaire() {
        System.out.println("Inventaire :");
        if (armeEquiper != null) {
            System.out.println("1. " + armeEquiper.toString());
        } else {
            System.out.println("Aucune arme dans l'inventaire.");
        }
        System.out.println("Potions : " + potions.size());
    }

    public void afficherStats() {
        System.out.println(
                " \n                " + xp + "XP | " + coeurs + "HP | " + mana + "Mana | " + argent + "$" + " \n");
    }

    // Regagner du mana après un combat
    public void regenererMana(int montant) {
        this.mana = Math.min(this.mana + montant, 1000); 
        System.out.println("Vous avez régénéré " + montant + " points de mana. Mana actuel : " + this.mana);
    }


    // Méthode pour perdre de la vie
    public void perdreVie(double degats) {
        this.coeurs -= degats;
        //  Si le joueur n'a plus de vie => fin de jeu
        if (this.coeurs <= 0) {
            System.out.println("Vous avez perdu tous vos points de vie ! Vous êtes mort...");
            System.out.println("Le jeu est terminé. Vous devez recommencer.");
            System.exit(0); 
        } else {
            // Afficher les points de vie restant
            System.out.println("Vous avez perdu " + degats + " points de vie. Points de vie restants : " + this.coeurs);
        }
    }


    // Getter
    public int getMana() {
        return this.mana;
    }

    public Weapon getArmeEquiper() {
        return armeEquiper;
    }

    public int getVieTotale() {
        return coeurs;
    }

    //Setter
    public void setMana(int mana) {
        this.mana = mana;
    }

}
