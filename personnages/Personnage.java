package personnages;

import weapons.Weapon;

public class Personnage {

    protected String nom;
    protected int coeurs;
    protected int mana;
    protected int xp;
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

    public Weapon getArmeEquiper() {
        return armeEquiper;
    }

    public int getVieTotale() {
        return coeurs;
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

    public void perdreVie(int degats) {
        int vieRestante = getVieTotale() - degats;
        coeurs = vieRestante;
        System.out.println("Vous avez perdu " + degats + " points de vie ! Nombre de cœurs restants : " + coeurs);
    }

}
