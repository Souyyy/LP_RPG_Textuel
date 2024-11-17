package destructibles;

public class Boss extends Destructible {
    // Vie du boss
    private static final double LIFE = 2;
    // Dégat du boss
    private double damage = 10; 

    public Boss() {
        super(LIFE);
    }

    public double getDamage() {
        return damage;
    }

}
