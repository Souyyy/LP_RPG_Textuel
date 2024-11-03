package destructibles;

public class Destructible {

    protected double health;

    public Destructible(double h) {
        this.health = h;
    }

    public void hit(double d) {
        this.health -= d;
    }

    // Méthode pour obtenir la santé actuelle
    public double getHealth() {
        return health;
    }

    // Méthode pour vérifier si l'objet est vivant
    public boolean isAlive() {
        return health > 0;
    }
}
