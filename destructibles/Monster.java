package destructibles;

public class Monster extends Destructible {

    // Vie du boss
    private static final double LIFE = 50;
    // Dégat du boss
    private double damage = 10;

    public Monster() {
        super(LIFE);
    }

    public double getDamage() {
        return damage;
    }

}
