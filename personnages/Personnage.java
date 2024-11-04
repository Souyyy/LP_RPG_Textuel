package personnages;

import weapons.Weapon;

public class Personnage {

    protected String nom;
    protected int coeurs;
    protected int mana;
    public int xp;
    protected int argent;
    private Weapon armeEquiper; // Field to store the equipped weapon

    public Personnage(String nom, int coeurs, int mana, int xp, int argent) {
        this.nom = nom;
        this.coeurs = coeurs;
        this.mana = mana;
        this.xp = xp;
        this.argent = argent;
        this.armeEquiper = null; // Initially no weapon equipped
    }

    public void acheterArme(Weapon nouvelleArme) {
        if (this.argent >= nouvelleArme.getPrice()) { // Check if player can afford the weapon
            this.argent -= nouvelleArme.getPrice(); // Deduct the cost
            this.armeEquiper = nouvelleArme; // Equip the new weapon
            System.out.println("Vous avez acheté : " + nouvelleArme.toString());
        } else {
            System.out.println("Pas assez d'argent pour acheter cette arme.");
        }
    }

    public void afficherInventaire() {
        System.out.println("Inventaire :");
        if (armeEquiper != null) {
            System.out.println("1. " + armeEquiper.toString());
        } else {
            System.out.println("Aucune arme dans l'inventaire.");
        }
    }

    

    public void afficherStats() {
        // System.out.println("Nom : " + nom);
        // System.out.println("Cœurs : " + coeurs + " (" + getVieTotale() + " points de
        // vie)");
        // System.out.println("Mana : " + mana);
        // System.out.println("XP : " + xp);
        // System.out.println("Argent : " + argent);
        System.out.println(
                " \n                " + xp + "XP | " + coeurs + "HP | " + mana + "Mana | " + argent + "$" + " \n");
    }

    public void regenererMana(int montant) {
        this.mana = Math.min(this.mana + montant, 100); // Recharge le mana sans dépasser 100
        System.out.println("Vous avez régénéré " + montant + " points de mana. Mana actuel : " + this.mana);
    }
    
    public void perdreVie(double degats) {
        this.coeurs -= degats;
        if (this.coeurs <= 0) {
            System.out.println("Vous avez perdu tous vos points de vie ! Vous êtes mort...");
            System.out.println("Le jeu est terminé. Vous devez recommencer.");
            System.exit(0); // Quitte le programme
        } else {
            System.out.println("Vous avez perdu " + degats + " points de vie. Points de vie restants : " + this.coeurs);
        }
    }

    public int getMana() {
        return this.mana;
    }
    
    public void setMana(int mana) {
        this.mana = mana;
    }

    public Weapon getArmeEquiper() {
        return armeEquiper;
    }

    public int getVieTotale() {
        return coeurs;
    }
}
