package destructibles;

public class Boss extends Destructible {

    private static final double LIFE = 2;
    private double damage = 10; // Dégâts infligés par le monstre


    public Boss() {
        super(LIFE);
    }

    public double getDamage() {
        return damage;
    }

}
