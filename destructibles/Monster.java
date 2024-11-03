package destructibles;

public class Monster extends Destructible {

    private static final double LIFE = 50;
    private double damage = 10; // Dégâts infligés par le monstre

    public Monster() {
        super(LIFE);
    }

    public double getDamage() {
        return damage;
    }

}
